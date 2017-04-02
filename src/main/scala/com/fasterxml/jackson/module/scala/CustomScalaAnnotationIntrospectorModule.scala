package com.fasterxml.jackson.module.scala

import com.fasterxml.jackson.module.scala.introspect.ScalaAnnotationIntrospector

/*
 * Disabling ParanamerAnnotationIntrospector as it does not work with the latest dropwizard version
 * Details: https://github.com/FasterXML/jackson-module-scala/issues/229
 */
trait CustomScalaAnnotationIntrospectorModule extends JacksonModule {
  //this += { _.appendAnnotationIntrospector(new ParanamerAnnotationIntrospector()) }
  this += { _.appendAnnotationIntrospector(ScalaAnnotationIntrospector) }
}
