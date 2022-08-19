package io.github.spritzsn.async

import scala.concurrent.ExecutionContext

implicit val loop: ExecutionContext = EventLoopExecutionContext
