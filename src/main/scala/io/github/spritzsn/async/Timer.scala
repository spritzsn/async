//package io.github.spritzsn.async
//
//import scala.Option
//import scala.collection.mutable
//import scala.concurrent.duration.*
//import scala.concurrent.{ExecutionContext, ExecutionContextExecutor, Future, Promise}
//import scala.scalanative.libc.stdlib
//import scala.scalanative.unsafe.*
//import scala.util.{Success, Try}
//
//object Timer:
//
//  var serial = 0L
//  var timers: mutable.Map[Long, Promise[Unit]] = mutable.HashMap[Long, Promise[Unit]]()
//
//  def apply(dur: Duration): Future[Unit] =
//    val promise = Promise[Unit]()
//
//    serial += 1
//
//    val timer_id = serial
//
//    timers(timer_id) = promise
//
//    val millis = dur.toMillis
//    val timer_handle = stdlib.malloc(uv_handle_size(UV_TIMER_T))
//
//    uv_timer_init(EventLoop.loop, timer_handle)
//
//    val timer_data = timer_handle.asInstanceOf[Ptr[Long]]
//
//    !timer_data = timer_id
//    uv_timer_start(timer_handle, timerCB, millis, 0)
//    promise.future
//
//  val timerCB: TimerCB =
//    (handle: TimerHandle) =>
//      val timer_data = handle.asInstanceOf[Ptr[Long]]
//      val timer_id: Long = !timer_data
//      val timer_promise = timers(timer_id)
//
//      timers.remove(timer_id)
//      timer_promise.success(())
//      ()
