package com.vbrenister.blog

import zio._
import zio.json._
import zio.http._

import com.vbrenister.blog.domain.blog.Post
import com.vbrenister.blog.http.BlogController
import com.vbrenister.blog.http.BlogEndpoints
import com.vbrenister.blog.http.BlogApp
import sttp.tapir.server.ziohttp.ZioHttpInterpreter
import sttp.tapir.swagger.bundle.SwaggerInterpreter
import sttp.tapir.swagger.SwaggerUIOptions
import com.vbrenister.blog.http.BlogApp

object Main extends ZIOAppDefault {

  val program =
    ZIO
      .service[HttpApp[Any]]
      .flatMap(Server.serve)

  override val run =
    program.provide(Server.default, BlogApp.layer, BlogController.layer)

}
