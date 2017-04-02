package io.dropwizard

abstract class ScalaApplication[T <: Configuration] extends Application[T] {
  final def main(args: Array[String]) {
    run(args:_*)
  }
}
