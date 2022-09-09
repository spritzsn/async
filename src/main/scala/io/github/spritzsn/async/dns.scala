package io.github.spritzsn.async

import cps.*
import cps.monads.FutureAsyncMonad
import io.github.spritzsn.libuv.{AddrInfo, defaultLoop}

import scala.concurrent.{Future, Promise}
import scala.scalanative.posix.sys.socket.AF_INET

def getAddrInfo(node: String, service: String, family: Int = AF_INET): Future[(Int, List[AddrInfo])] =
  val promise = Promise[(Int, List[AddrInfo])]()

  def callback(status: Int, addrInfo: List[AddrInfo]): Unit = promise.success((status, addrInfo))

  defaultLoop.getAddrInfo(callback, "google.com", null, family)
  promise.future
