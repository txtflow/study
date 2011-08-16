package ru.artem.study.algorithms.sort

import util.Random
import ru.artem.study.algorithms.utils.SimpleGenerator
import ru.artem.study.algorithms.utils.Utils._
import ru.artem.study.algorithms.sorting.JDKSort

trait Sorter{
  def sort(array: Array[Int]): Array[Int]
}

//todo generic types
object QuickSort extends Sorter{
  private val random = new Random()

  def quickSort(array: Array[Int]) = {
    val pivot = random.nextInt(array.length - 1)
    val (less, moreOrEq) = array.partition( _ < array(pivot))

  }

  def sort(array: Array[Int]) = sort(array, 0 , array.length)

  private def sort(array: Array[Int], low: Int, high: Int): Array[Int] = {
    if(low < high){
      val pivot = partition(array, low, high)
      printArray(array)
      println("Pivot - " + array(pivot))
      sort(array, low, pivot)
      sort(array, pivot+1, high)
    }
    array
  }

  def partition(array: Array[Int], low: Int, high: Int) = {
//    val pivotIndex = if((high - low) < 2) 0 else random.nextInt(high - low - 1)
    val pivotIndex = high - 1
    val pivot = array(pivotIndex)
//    swap(array, pivotIndex, high-1) // move pivot to the end

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

object SortChecker{
  def main(args: Array[String]){
    val a = SimpleGenerator.getRandomArray(20, 100)
    val sortedArray = (new JDKSort).test(a.clone())
    printArray(sortedArray)
    val sa = a.clone()
    QuickSort.sort(sa)
    printArray(sa)
    println("Result - " + equals(sortedArray, sa))
  }
}