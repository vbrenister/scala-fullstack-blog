import sbt.*

object Dependencies {
  val zio                = "dev.zio"                     %% "zio"                     % "2.0.21"
  val zioJson            = "dev.zio"                     %% "zio-json"                % "0.6.2"
  val zioHttp            = "dev.zio"                     %% "zio-http"                % "3.0.0-RC4"
  val tapir              = "com.softwaremill.sttp.tapir" %% "tapir-core"              % "1.9.8"
  val tapirZioJson       = "com.softwaremill.sttp.tapir" %% "tapir-json-zio"          % "1.9.8"
  val tapirZioHttpServer = "com.softwaremill.sttp.tapir" %% "tapir-zio-http-server"   % "1.9.8"
  val tapirSwaggerUI     = "com.softwaremill.sttp.tapir" %% "tapir-swagger-ui-bundle" % "1.9.8"
}
