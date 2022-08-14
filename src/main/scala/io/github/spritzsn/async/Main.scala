package io.github.spritzsn.async

import cps.*
import cps.monads.FutureAsyncMonad

import scala.concurrent.Future

@main def run(): Unit =
  async {
    for i <- 1 to 3 do await(Future(println(i)))
  }
