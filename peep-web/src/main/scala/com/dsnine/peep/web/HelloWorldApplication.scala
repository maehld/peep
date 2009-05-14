package com.dsnine.peep.web

import org.apache.wicket.protocol.http.WebApplication

class HelloWorldApplication extends WebApplication {
  com.dsnine.peep.core.Test.createEntities
  
  def getHomePage() = classOf[HelloWorld]
}
