package com.vbrenister.blog.http

import com.vbrenister.blog.http.BlogController
import com.vbrenister.blog.http.BlogEndpoints
import sttp.tapir.server.ziohttp.ZioHttpInterpreter
import sttp.tapir.swagger.bundle.SwaggerInterpreter
import sttp.tapir.swagger.SwaggerUIOptions
import zio._
import zio.json._
import zio.http._

object BlogApp {
  val layer = ZLayer.fromZIO {
    ZIO
      .serviceWith[BlogController](_.all)
      .map(posts =>
        ZioHttpInterpreter()
          .toHttp(
            posts ++ SwaggerInterpreter(swaggerUIOptions = SwaggerUIOptions.default.pathPrefix(List("swagger")))
              .fromEndpoints(BlogEndpoints.allEndpoints, "Blog Service", "1.0")
          )
      )
  }
}
