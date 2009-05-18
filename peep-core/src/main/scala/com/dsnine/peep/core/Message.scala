package com.dsnine.peep.core

import javax.persistence._

import java.util.{List => JList, ArrayList}

@Entity
class Message {

  @Id @GeneratedValue
  var id:Long = _
  
  @ManyToOne {val cascade = Array(CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH)}
  var author:User = _
  
  @OneToMany{val mappedBy="parent", val targetEntity=classOf[Message], val cascade = Array(CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH)}
  var replies:JList[Message] = new ArrayList[Message]
  
  @OneToOne{val cascade = Array(CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH)}
  var parent:Message = _
  
  @Lob
  var text:String = _
}
