package io.github.spritzsn

package object async:
  implicit val loop: EventLoop.type = EventLoop
