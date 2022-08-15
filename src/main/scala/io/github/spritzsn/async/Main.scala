//package io.github.spritzsn.async
//
//import cps.*
//import cps.monads.FutureAsyncMonad
//
//import scala.concurrent.Future
//import scala.concurrent.duration.*
//
//@main def run(): Unit =
//  async {
//    for i <- 1 to 3 do
//      println(i)
//      await(Timer(.5 second))
//  }
