package com.dsnine.switter.core

import org.scala_libs.jpa._

object EMF extends LocalEMF("switter")

object Test {
  def main(args:Array[String]):Unit = {
    createEntities
    runQuery
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
  
}
