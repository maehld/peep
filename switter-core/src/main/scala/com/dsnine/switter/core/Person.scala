package com.dsnine.switter.core

import javax.persistence._
import java.util.{List, ArrayList}

@Entity
class Person {
  
  @Id
  @GeneratedValue
  var id:Long = _
  var name:String = _
  var age:Int = _
  @OneToMany{val mappedBy="author", val targetEntity=classOf[Message], val cascade = Array(CascadeType.ALL)}
  var messages:List[Message] = new ArrayList[Message]()
  
}
