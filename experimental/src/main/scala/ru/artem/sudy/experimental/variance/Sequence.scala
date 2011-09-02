package ru.artem.sudy.experimental.variance

abstract class Sequence[+A] {
  def append[T >: A](sqe: Sequence[T]): Sequence[T]
}