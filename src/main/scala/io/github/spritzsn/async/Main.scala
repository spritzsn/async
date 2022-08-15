//package io.github.spritzsn.async
//
//import cps.*
//import cps.monads.FutureAsyncMonad
//
//import scala.concurrent.Future
//import scala.concurrent.duration.*
//import scala.util.{Failure, Success}
//
//@main def run(): Unit =
//  async {
//    for i <- 1 to 6 do
//      println(i)
//      await(timer(.5 second))
//  }
//
//  async {
//    for i <- 1 to 3 do
//      println(i)
//      println(await(spawn("sleep", Vector("1"))))
//  }
