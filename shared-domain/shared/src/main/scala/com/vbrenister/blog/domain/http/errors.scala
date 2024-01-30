package com.vbrenister.blog.domain.http

import zio.json._

object errors {
  case class HttpError(message: String)

  object HttpError {
    implicit val decoder: JsonDecoder[HttpError] = DeriveJsonDecoder.gen[HttpError]
    implicit val encoder: JsonEncoder[HttpError] = DeriveJsonEncoder.gen[HttpError]
  }
}
