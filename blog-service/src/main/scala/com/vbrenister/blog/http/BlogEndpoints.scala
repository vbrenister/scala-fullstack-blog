package com.vbrenister.blog.http

import sttp.tapir._
import sttp.tapir.model.UsernamePassword
import sttp.tapir.json.zio._
import sttp.tapir.generic.auto._

import com.vbrenister.blog.domain.blog._
import com.vbrenister.blog.domain.http.errors._
import sttp.model.StatusCode

object BlogEndpoints {
  private val baseAPIEndpoint =
    endpoint.in("api" / "v1").securityIn(auth.basic[UsernamePassword]())

  val allPostsEndpoint: Endpoint[UsernamePassword, Unit, HttpError, List[Post], Any] =
    baseAPIEndpoint.get
      .in("blogs")
      .out(jsonBody[List[Post]])
      .errorOut(
        oneOf[HttpError](
          oneOfVariant(statusCode(StatusCode.Unauthorized).and(jsonBody[HttpError].description("Unauthorized"))),
          oneOfVariant(
            statusCode(StatusCode.InternalServerError).and(jsonBody[HttpError].description("Internal Server Error"))
          )
        )
      )

  val allEndpoints = List(allPostsEndpoint)
}
