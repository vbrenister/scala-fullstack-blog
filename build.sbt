import org.scalajs.linker.interface.ModuleSplitStyle

ThisBuild / organization := "com.vbrenister"
ThisBuild / scalaVersion := "3.3.1"
ThisBuild / version      := "0.1.0-SNAPSHOT"

lazy val blogService = project
  .in(file("blog-service"))
  .settings(
    name := "blog-service",
    libraryDependencies ++= Seq(
      Dependencies.zio,
      Dependencies.zioHttp,
      Dependencies.tapir,
      Dependencies.tapirZioJson,
      Dependencies.tapirZioHttpServer,
      Dependencies.tapirSwaggerUI
    )
  )
  .dependsOn(sharedDomain.jvm)

lazy val blogUI = project
  .in(file("blog-ui"))
  .enablePlugins(ScalaJSPlugin)
  .settings(
    name                                   := "blog-ui",
    version                                := "0.1.0-SNAPSHOT",
    scalaJSUseMainModuleInitializer        := true,
    scalaJSLinkerConfig ~= {
      _.withModuleKind(ModuleKind.ESModule)
        .withModuleSplitStyle(ModuleSplitStyle.SmallModulesFor(List("blog-ui")))
    },
    libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "2.4.0"
  )
  .dependsOn(sharedDomain.js)

lazy val sharedDomain = crossProject(JVMPlatform, JSPlatform)
  .in(file("shared-domain"))
  .settings(libraryDependencies ++= Seq(Dependencies.zioJson))
