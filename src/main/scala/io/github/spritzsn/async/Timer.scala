package io.github.spritzsn.async

import io.github.spritzsn.libuv._

import scala.concurrent.duration.*
import scala.concurrent.{Future, Promise}

object Timer:

  def apply(timeout: Duration, repeat: Duration = 0.second): Future[Unit] =
    val promise = Promise[Unit]()

    defaultLoop.timer.start(
      t => {
        t.dispose()
        promise.success(())
      },
      timeout.toMillis,
      repeat.toMillis,
    )
    promise.future
