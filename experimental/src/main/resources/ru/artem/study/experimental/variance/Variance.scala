package ru.artem.study.experimental.variance

abstract class Variance[A]{
    def test(a: A): String
}

class Invariance[A] extends Variance[A] {
    override def test(a: A) = ""
}

class Covariance[+A] {
    def test[B >: A](a: B) = ""
}

class Contrvariance[-A] {
    def test[B <: A](a: B) = ""
}

class C[-A] {
    def test(a: A) = ""
}

abstract class Cat[-T, +U] {
    def meow[W](volume: T, listener: Cat[U, T]): Cat[Cat[U,T],U]
}