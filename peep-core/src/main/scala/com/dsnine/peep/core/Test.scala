package com.dsnine.peep.core

import org.scala_libs.jpa._

object EMF extends LocalEMF("switter")

object Test {
  def main(args:Array[String]):Unit = {
    createEntities
    runQuery
    showMessages
  }

  def runQuery {
    val em = EMF.newEM
    val results = em.createQuery[Person]("from Person").findAll
    val minAge = results map(_.age) reduceLeft(_ min _)
    val maxAge = results map(_.age) reduceLeft(_ max _)
    println("Min: " + minAge + "; Max: " + maxAge)
    em.close()
  }
  
  def createEntities {
    val em = EMF.newEM
    var p = new Person()
    p.name = "Dominik"
    p.age = 28
    em.persist(p)
    
    val m1 = new Message()
    m1.text = "Hallo, wie gehts?"
    m1.author = p
    
    val m2 = new Message()
    m2.text = "Tschüssn"
    m2.author = p
    
    p.messages.add(m1)
    p.messages.add(m2)
    
    p = new Person()
    p.name = "Jan-Helmut"
    p.age = 25
    em.persist(p)
    
    p = new Person()
    p.name = "Andreas"
    p.age = 29
    em.persist(p)
    
    em.flush()
    em.close()
  }
  
  def showMessages {
    import scala.collection.jcl.Conversions._
    val em = EMF.newEM
    val allPersons = em.createQuery[Person]("from Person").findAll
    val personsWithMessages = allPersons.filter(_.messages.size() > 0)
    for (person <- personsWithMessages; message <- person.messages) {
      println(person.name + ": " + message.text)
    }
    
    allPersons.filter(_.messages.size() > 0).foreach{p => println(p.name); p.messages.foreach {m => println("  " + m.text)}}
    em.close()
  }
  
  
}
