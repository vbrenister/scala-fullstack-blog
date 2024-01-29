package com.vbrenister.blog

import zio._
import zio.json._
import com.vbrenister.blog.domain.blog.Post

object Main extends ZIOAppDefault {

  override def run: ZIO[Any, Any, Any] =
    ZIO.succeed(Post(1, "title", "content").toJsonPretty).debug

}
