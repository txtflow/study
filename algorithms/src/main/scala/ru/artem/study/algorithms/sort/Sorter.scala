package ru.artem.study.algorithms.sort

import util.Random
import SortUtils._
import ru.artem.study.algorithms.sorting.JDKSort
import ru.artem.study.algorithms.utils.{Utils, SimpleGenerator}

trait Sorter{
  def sort(array: Array[Int]): Array[Int]
}

//todo generic types
object QuickSort extends Sorter{
  private val random = new Random()

  def sort(array: Array[Int]) = sort(array, 0 , array.length)

  private def sort(array: Array[Int], low: Int, high: Int): Array[Int] = {
    if(low < high){
      val pivot = partition(array, low, high)
      sort(array, low, pivot)
      sort(array, pivot+1, high)
    }
    array
  }

  def partition(array: Array[Int], low: Int, high: Int) = {
    val pivotIndex = low + random.nextInt(high - low)
    val pivot = array(pivotIndex)
    swap(array, pivotIndex, high-1) // move pivot to the end

    var storeIndex = low
    for(i <- low until high-1){
      if(array(i) < pivot){
        swap(array, i, storeIndex)
        storeIndex += 1
      }
    }

    swap(array, storeIndex, high-1) // move pivot to its position
    storeIndex
  }
}

object SortUtils{
  def swap[A <: Any](a: Array[A], i: Int, j: Int){
    if(i != j){
      val tmp = a(i)
      a(i) = a(j)
      a(j) = tmp
    }
  }
}

object SortChecker{
  def main(args: Array[String]){
    val a = SimpleGenerator.getRandomArray(20, 100)
    val sortedArray = (new JDKSort).test(a.clone())
    Utils.printArray(sortedArray)
    val sa = a.clone()
    QuickSort.sort(sa)
    Utils.printArray(sa)
    println("Result - " + Utils.equals(sortedArray, sa))
  }
}