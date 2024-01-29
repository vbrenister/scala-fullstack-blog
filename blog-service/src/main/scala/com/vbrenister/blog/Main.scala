package com.vbrenister.blog

import zio._
import zio.json._
import zio.http._

import com.vbrenister.blog.domain.blog.Post

object Main extends ZIOAppDefault {

  val app: HttpApp[Any] =
    Routes(Method.GET / "text" -> handler(Response.json(Post(1, "title", "content").toJson))).toHttpApp

  override val run =
    Server.serve(app).provide(Server.default)

}
