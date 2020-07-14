package unclassified.sort.array;

import java.util.Random;

public class QuickSortBySlowFastPointer {
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
    Random rand = new Random();
    int pivotIndexRand = left + rand.nextInt(right - left + 1);
    int pivotValue = array[pivotIndexRand];
    swap(array, pivotIndexRand, right);
    int slow = left;
    int fast = left;
    while (fast < right) {
      if (array[slow] < pivotValue) {
        slow += 1;
      } else if (array[fast] < pivotValue) {
        swap(array, slow, fast);
        slow += 1;
      }
      fast += 1;
    }
    // After while, `fast` is out of the right edge.
    Util.swap(array, slow, right);
    // [0, slow) < pivot
    // [slow, fast) >= pivot
    return slow;
  }

  private static void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
