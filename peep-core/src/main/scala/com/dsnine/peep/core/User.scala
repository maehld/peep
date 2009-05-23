package com.dsnine.peep.core

import javax.persistence._
import java.util.{List => JList, ArrayList}

@Entity
@Table{val name="p_usr"}
class User {
  
  @Id
  @GeneratedValue
  var id:Long = _
  
  var name:String = _
  
  @OneToMany{val mappedBy="author", val targetEntity=classOf[Message], val cascade = Array(CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH)}
  var messages:JList[Message] = new ArrayList[Message]()
  
  @ManyToMany{val targetEntity=classOf[User], val cascade = Array(CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH)}
	@JoinTable{val name="p_usr_follow"}
  var followers:JList[User] = new ArrayList[User]()

	override def toString() = name + ":" + id

/*
  @ManyToMany{val targetEntity=classOf[User], val cascade = Array(CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH), val mappedBy="followers"}
  var following:JList[User] = new ArrayList[User]()
*/
  
}
