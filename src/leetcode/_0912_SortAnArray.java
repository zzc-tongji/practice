package leetcode;

import java.util.Random;

/*
 * 0912. Sort an Array
 *
 * Given an array of integers nums, sort the array in ascending order.
 *
 * Example 1:
 *
 * Input: nums = [5,2,3,1]
 *
 * Output: [1,2,3,5]
 *
 * Example 2:
 *
 * Input: nums = [5,1,1,2,0,0]
 *
 * Output: [0,0,1,1,2,5]
 */

public class _0912_SortAnArray {
  public int[] sortArray(int[] nums) {
    // inplace operation
    if (nums == null || nums.length <= 1) {
      return nums;
    }
    helper(nums, 0, nums.length - 1);
    return nums;
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
    int pivotIndex = getPivotIndex(array, left, right);
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
    int pivotIndexRand = left + rand.nextInt(right - left + 1);
    int pivotValue = array[pivotIndexRand];
    // swap the pivot to the end
    swap(array, pivotIndexRand, right);
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

  private void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}

// More way to sort an array:
// see `unclassified.sort.array`.
