package com.dsnine.peep.web

import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.markup.html.basic.Label

import com.dsnine.peep.core._

import java.util.Date
import java.text.DateFormat

class HelloWorld extends WebPage {
  add(new Label("message", "Hallo Welt, es ist " + DateFormat.getDateTimeInstance().format(new Date()) + "! Personen im Repository: " + PersonRepository.getAllPersons().size))
}
