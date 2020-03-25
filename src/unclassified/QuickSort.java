package unclassified;

import java.util.Random;

public class QuickSort {
  private boolean slowFastEnabled = false;

  public static void main(String[] args) {
    System.out.println("Hello world.");
  }

  public void quickSort(int[] array) {
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

  private void helper(int[] array, int left, int right) {
    // Use ">=" rather than "=="
    // to cover the situation that the pivot is already at edge
    // (`pivotIndex +- 1` might be out of range).
    if (left >= right) {
      return;
    }
    int pivotIndex = slowFastEnabled ? getPivotIndexSlowFast(array, left, right) : getPivotIndex(array, left, right);
    helper(array, left, pivotIndex - 1);
    helper(array, pivotIndex + 1, right);
  }

  private int getPivotIndex(int[] array, int left, int right) {
    // It can deal with arrays with duplicate values.
    //
    // Since rand.nextInt(x) will return an int in [0, x),
    // to ensure the posibility to hit `right`,
    // there is an `+ 1` at the end.
    Random rand = new Random();
    int pivotRandIndex = left + rand.nextInt(right - left + 1);
    int pivotValue = array[pivotRandIndex];
    // swap the pivot to the end
    swap(array, pivotRandIndex, right);
    int leftI = left;
    int rightI = right - 1;
    while (leftI <= rightI) {
      if (array[leftI] < pivotValue) {
        leftI += 1;
      } else if (array[rightI] >= pivotValue) {
        rightI -= 1;
      } else {
        swap(array, leftI, rightI);
        leftI += 1;
        rightI -= 1;
      }
    }
    // After while, `leftI` and `rightI` is crossed,
    // which means `array[leftI] >= pivotValue`.
    //
    // swap the pivot to the correct position
    swap(array, leftI, right);
    // [0, leftI) < pivot
    // (leftI, right] >= pivot
    return leftI;
  }

  private int getPivotIndexSlowFast(int[] array, int left, int right) {
    // It can deal with arrays with duplicate values.
    Random rand = new Random();
    int pivotRandIndex = left + rand.nextInt(right - left + 1);
    int pivotValue = array[pivotRandIndex];
    swap(array, pivotRandIndex, right);
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
    swap(array, slow, right);
    // [0, slow) < pivot
    // [slow, fast) >= pivot
    return slow;
  }

  private void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
