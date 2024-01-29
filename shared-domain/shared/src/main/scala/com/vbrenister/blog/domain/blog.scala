package com.vbrenister.blog.domain

import zio.json._

object blog {
  final case class Post(id: Int, title: String, content: String)

  object Post {
    implicit val decoder: JsonDecoder[Post] = DeriveJsonDecoder.gen[Post]
    implicit val encoder: JsonEncoder[Post] = DeriveJsonEncoder.gen[Post]
  }
}
