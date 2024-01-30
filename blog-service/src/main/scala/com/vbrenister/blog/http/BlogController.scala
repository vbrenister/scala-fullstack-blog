package com.vbrenister.blog.http

import sttp.tapir.ztapir._
import sttp.tapir.model.UsernamePassword
import zio.ZIO
import com.vbrenister.blog.domain.http.errors.HttpError
import com.vbrenister.blog.domain.blog.Post
import sttp.tapir.server.ziohttp.ZioHttpInterpreter
import zio.ZLayer
import zio.RIO
import sttp.tapir.server.ServerEndpoint

class BlogController {

  val allPosts =
    BlogEndpoints.allPostsEndpoint
      .zServerSecurityLogic[Any, Unit] { (user: UsernamePassword) =>
        ZIO
          .when(user.username != "user" || !user.password.contains("password"))(ZIO.fail(HttpError("Unauthorized")))
          .unit
      }
      .serverLogic[Any](_ => _ => ZIO.succeed(List(Post(1, "title", "body"))))

  val all = List(allPosts)

}

object BlogController {
  val layer = ZLayer.succeed(new BlogController)
}
