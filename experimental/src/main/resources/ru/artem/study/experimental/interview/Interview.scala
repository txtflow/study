package ru.artem.study.experimental.interview

object Interview {

  /**
   * Write a function f(a, b) which takes two strings a, b and returns a string
   * containing only the characters found in both strings in the order of a.
   * Write a version which is order N-squared and one which is order N
   */
  def intersection(a: String, b: String): String = {
    val bSet = b.toSet
    (for(c <- a if bSet.contains(c)) yield c).toString
  }


  def main(args: String*) {

  }
}