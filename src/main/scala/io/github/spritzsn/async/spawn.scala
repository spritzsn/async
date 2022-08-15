package io.github.spritzsn.async

import io.github.spritzsn.libuv.*

import scala.concurrent.{Future, Promise}

def spawn(program: String, args: IndexedSeq[String]): Future[(Int, Int)] =
  val promise = Promise[(Int, Int)]()

  defaultLoop.spawn(
    program,
    args,
    (exitStatus, termSignal) => {
      promise.success((exitStatus, termSignal))
    },
  )
  promise.future
