package io.github.spritzsn.async

import io.github.spritzsn.libuv._

import scala.concurrent.duration.*
import scala.concurrent.{Future, Promise}

def timer(timeout: Duration): Future[Unit] =
  val promise = Promise[Unit]()

  defaultLoop.timer.start(
    t => {
      t.dispose()
      promise.success(())
    },
    timeout.toMillis,
    0,
  )
  promise.future
