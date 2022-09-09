//package io.github.spritzsn.async
//
//import cps.*
//import cps.monads.FutureAsyncMonad
//
//import scala.concurrent.Future
//import scala.concurrent.duration.*
//import scala.io.Codec
//import scala.util.{Failure, Success}
//
//@main def run(): Unit =
//  async {
//    fs.readFile("asdf", Codec.UTF8) onComplete {
//      case Success(value)     => println(value)
//      case Failure(exception) => println(exception.getMessage)
//    }
//  }

//package io.github.spritzsn.async
//
//import cps.*
//import cps.monads.FutureAsyncMonad
//
//import scala.concurrent.Future
//
//@main def run(): Unit =
//  async {
//    val (status, addrInfo) = await(getAddrInfo("google.com", null))
//
//    println(s"status: $status; addrInfo: $addrInfo")
//  }

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
