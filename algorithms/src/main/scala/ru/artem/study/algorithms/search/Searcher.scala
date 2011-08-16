package ru.artem.study.algorithms.search

import java.util.Arrays
import ru.artem.study.algorithms.utils.{Utils, SimpleGenerator}

trait Searcher[T]{
  def find(array: Array[T], key: T): Option[T]
}

object BinarySearch extends Searcher[Int]{
  override def find(array: Array[Int], key: Int): Option[Int] = {
    var low = 0
    var high = array.length

    while(low <= high){
      (low + high) >> 1 match {
        case mid if key < array(mid) => high = mid - 1
        case mid if key > array(mid) => low = mid + 1
        case mid                     => return Some(mid)
      }
    }

    None
  }
}

object BinarySearchRecursive extends Searcher[Int]{
  override def find(array: Array[Int], key: Int) = None
}

object SearchTester{
  def main(args: Array[String]){
    val length = 20
    val array = SimpleGenerator.getRandomArray(length, 50)
    Arrays.sort(array)
    Utils.printArray(array)
    System.out.println("---------------------------------------------------")

    val find = array(SimpleGenerator.getRandomInt(length-1))
    System.out.println(find)
    System.out.println("---------------------------------------------------")
    System.out.println("standart - " + Arrays.binarySearch(array, find))
    System.out.println("my iter - " + BinarySearch.find(array, find))
  }
}