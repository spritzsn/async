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
//      await(timer(.5 second))
//  }

//  async {
//    for i <- 1 to 3 do
//      println(i)
//      println(await(spawn("/home/ed/dev-sn/test/target/scala-3.1.3/test-out", Vector("3", i.toString))))
//  }
