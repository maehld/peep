package com.dsnine.peep.core

import javax.persistence._
import java.util.{List => JList, ArrayList}

@Entity
class User {
  
  @Id
  @GeneratedValue
  var id:Long = _
  
  var name:String = _
  
  var age:Int = _
  
  @OneToMany{val mappedBy="author", val targetEntity=classOf[PeepMessage], val cascade = Array(CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH)}
  var messages:JList[PeepMessage] = new ArrayList[PeepMessage]()
  
  @ManyToMany{val targetEntity=classOf[User], val cascade = Array(CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH)}
  var followers:JList[PeepUser] = new ArrayList[PeepUser]()
  
  @ManyToMany{val targetEntity=classOf[User], val cascade = Array(CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH), val mappedBy="followers"}
  var isFollowing:JList[PeepUser] = new ArrayList[PeepUser]()
  
}
