# async

![Maven Central](https://img.shields.io/maven-central/v/io.github.edadma/async_native0.5_3)
[![Last Commit](https://img.shields.io/github/last-commit/spritzsn/async)](https://github.com/spritzsn/async/commits)
![GitHub](https://img.shields.io/github/license/spritzsn/async)
![Scala Version](https://img.shields.io/badge/Scala-3.8.1-blue.svg)
![Scala Native Version](https://img.shields.io/badge/Scala_Native-0.5.10-blue.svg)

Async/await for Scala Native using the libuv event loop and [dotty-cps-async](https://github.com/rssh/dotty-cps-async).

## Overview

This library provides a `Future`-based async runtime for Scala Native, powered by libuv's event loop. It includes:

- **Event loop execution context** - runs `Future` continuations on the libuv event loop
- **Timers** - async `timer(duration)` returning `Future[Unit]`
- **DNS** - async `getAddrInfo` returning `Future[(Int, List[AddrInfo])]`
- **Process spawning** - async `spawn` returning `Future[(Int, Int)]`

Combined with `dotty-cps-async`, you get `async`/`await` syntax.

## Prerequisites

- JDK 11 or higher
- sbt 1.12+
- LLVM/Clang
- libuv development library (`apt install libuv1-dev` / `brew install libuv`)

## Usage

Add to your `build.sbt`:

```scala
libraryDependencies += "io.github.edadma" %%% "async" % "0.0.14"
```

### Example: async timer

```scala
import io.github.spritzsn.async.*
import cps.*
import cps.monads.FutureAsyncMonad
import scala.concurrent.duration.*

@main def run(): Unit =
  async {
    for i <- 1 to 5 do
      println(i)
      await(timer(500.millis))
  }
```

### Example: async DNS lookup

```scala
import io.github.spritzsn.async.*
import cps.*
import cps.monads.FutureAsyncMonad

@main def run(): Unit =
  async {
    val (status, addrInfo) = await(getAddrInfo("google.com", null))
    println(s"status: $status; addrInfo: $addrInfo")
  }
```

## Building

```bash
sbt compile
sbt test
```

## License

ISC
