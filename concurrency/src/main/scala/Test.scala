package com.griddynamics.genesis.dev

import Utils._
import scala.collection._
import scala.math._

object Test {
  def main(args: Array[String]) {

    for(n <- (1 to 10)){
      println(fib(n))
    }

    var results: Set[(Int,Int,Int)] = mutable.Set();

    for(
      a <- (1 to 36);
      b <- (1 to 36);
      c <- (1 to 36);
      if(a*b*c == 36);
      if(juniorExist(a,b,c))
    ){
      val ar = Array[Int](a,b,c).sorted
      val tuple = (ar(0), ar(1), ar(2))
      results += tuple
    }

    results foreach {case t@(a,b,c) => println(t + " - " + (a+b+c))}


  }
}

object Utils{
  def juniorExist(a: Int, b: Int, c: Int): Boolean =
    (a<b && a<c) ||
    (b<a && b<c) ||
    (c<b && c<a)

  def fib(n: Int) =
    (pow((1+sqrt(5))/2, n) - pow((1-sqrt(5))/2, n))/sqrt(5)
}