package com.dsnine.switter.core

import javax.persistence._

@Entity
class Message {
  @Id @GeneratedValue
  var id:Long = _
  @ManyToOne{val targetEntity=classOf[Person], val cascade = Array(CascadeType.ALL)}
  var author:Person = _
  var text:String = _
}
