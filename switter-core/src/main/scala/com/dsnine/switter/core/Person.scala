package com.dsnine.switter.core

import javax.persistence._

@Entity
class Person {
  
  @Id
  @GeneratedValue
  var id:Long = _
  var name:String = _
  var age:Int = _
  
}
