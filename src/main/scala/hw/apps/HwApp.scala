package hw.apps

import com.fasterxml.jackson.annotation.JsonInclude.Include
import com.fasterxml.jackson.module.scala.CustomScalaModule
import hw.resources.HwResource
import io.dropwizard.setup.{Bootstrap, Environment}
import io.dropwizard.{Configuration, ScalaApplication}

object HwApp extends ScalaApplication[Configuration] {
  override def getName = getClass.getName

  override def initialize(bootstrap: Bootstrap[Configuration]) {
    bootstrap.getObjectMapper.registerModule(new CustomScalaModule)
    bootstrap.getObjectMapper.setSerializationInclusion(Include.NON_EMPTY)
  }

  override def run(conf: Configuration, env: Environment) {
    env.jersey().register(new HwResource())
  }
}
