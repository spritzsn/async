package io.github.spritzsn.async

import io.github.spritzsn.libuv._

import scala.Option
import scala.collection.mutable
import scala.concurrent.duration.*
import scala.concurrent.{Future, Promise}
import scala.util.{Success, Try}

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
