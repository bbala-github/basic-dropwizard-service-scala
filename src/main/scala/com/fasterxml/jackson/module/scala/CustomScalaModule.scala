package com.fasterxml.jackson.module.scala

import com.fasterxml.jackson.module.scala.deser.{ScalaNumberDeserializersModule, UntypedObjectDeserializerModule}

class CustomScalaModule
  extends JacksonModule
    with IteratorModule
    with EnumerationModule
    with OptionModule
    with SeqModule
    with IterableModule
    with TupleModule
    with MapModule
    with SetModule
    with ScalaNumberDeserializersModule
    with CustomScalaAnnotationIntrospectorModule
    with UntypedObjectDeserializerModule
    with EitherModule {
  override def getModuleName = "CustomScalaModule"
}
