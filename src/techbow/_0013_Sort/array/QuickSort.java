package techbow._0013_Sort.array;

import java.util.Random;

public class QuickSort {
  public static void sort(int[] array) {
    if (array == null || array.length <= 1) {
      return;
    }
    helper(array, 0, array.length - 1);
    /*
     * time: O(n log n)
     *
     * space: O(1)
     */
  }

  private static void helper(int[] array, int left, int right) {
    // Use ">=" rather than "=="
    // to cover the situation that the pivot is already at edge
    // (`pivotIndex +- 1` might be out of range).
    if (left >= right) {
      return;
    }
    int pivotIndex = getPivotIndex(array, left, right);
    helper(array, left, pivotIndex - 1);
    helper(array, pivotIndex + 1, right);
  }

  private static int getPivotIndex(int[] array, int left, int right) {
    // It can deal with arrays with duplicate values.
    //
    // Since rand.nextInt(x) will return an int in [0, x),
    // to ensure the posibility to hit `right`,
    // there is an `+ 1` at the end.
    Random rand = new Random();
    int pivotIndexRand = left + rand.nextInt(right - left + 1);
    int pivotValue = array[pivotIndexRand];
    // swap the pivot to the end
    Util.swap(array, pivotIndexRand, right);
    int leftI = left;
    int rightI = right - 1;
    while (leftI <= rightI) {
      if (array[leftI] < pivotValue) {
        leftI += 1;
      } else if (array[rightI] >= pivotValue) {
        rightI -= 1;
      } else {
        Util.swap(array, leftI, rightI);
        leftI += 1;
        rightI -= 1;
      }
    }
    // After while, `leftI` and `rightI` is crossed,
    // which means `array[leftI] >= pivotValue`.
    //
    // swap the pivot to the correct position
    Util.swap(array, leftI, right);
    // [0, leftI) < pivot
    // (leftI, right] >= pivot
    return leftI;
  }
}
