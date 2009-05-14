package com.dsnine.peep.core

import javax.persistence._
import java.util.{List => JList, ArrayList}

object PersonRepository {
  def getAllPersons():List[Person] = {
    val em = EMF.newEM
    em.createQuery[Person]("from Person").findAll.toList
  }
}

@Entity
class Person {
  
  @Id
  @GeneratedValue
  var id:Long = _
  var name:String = _
  var age:Int = _
  @OneToMany{val mappedBy="author", val targetEntity=classOf[Message], val cascade = Array(CascadeType.ALL)}
  var messages:JList[Message] = new ArrayList[Message]()
  
}
