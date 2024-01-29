package com.vbrenister.blog

import scala.scalajs.js
import scala.scalajs.js.annotation.*

import org.scalajs.dom

object App {
  def main(args: Array[String]): Unit = {
    dom.document.querySelector("#app").innerHTML = s"""
    <div>
      <h1>Live Chart</h1>
    </div>
  """
  }
}
