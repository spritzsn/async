package io.github.spritzsn.async

import io.github.spritzsn.libuv.*

import scala.annotation.tailrec
import scala.collection.mutable
import scala.concurrent.{ExecutionContext, ExecutionContextExecutor, Future}

object EventLoop extends ExecutionContextExecutor:

  private val taskQueue = new mutable.Queue[Runnable]
  private val handle = defaultLoop.prepare

  val prepareCallback: Prepare => Unit =
    (handle: Prepare) =>
      while taskQueue.nonEmpty do
        val runnable = taskQueue.dequeue

        try runnable.run()
        catch case t: Throwable => reportFailure(t)

      if taskQueue.isEmpty then handle.stop

  def execute(runnable: Runnable): Unit =
    taskQueue enqueue runnable
    handle start prepareCallback

  def reportFailure(t: Throwable): Unit = t.printStackTrace()

  @tailrec
  def run(): Unit =
    if defaultLoop.run() != 0 then run()

  private val bootstrapFuture =
    if !defaultLoop.isAlive then Future(run())(ExecutionContext.global)
