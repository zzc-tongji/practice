package leetcode;

import java.security.InvalidParameterException;
import java.util.Random;

/**
 * 0215. Kth Largest Element in an Array
 * 
 * Find the kth largest element in an unsorted array. Note that it is the kth
 * largest element in the sorted order, not the kth distinct element.
 * 
 * Example 1:
 * 
 * Input: [3,2,1,5,6,4] and k = 2
 * 
 * Output: 5
 * 
 * Example 2:
 * 
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * 
 * Output: 4
 * 
 * Note:
 * 
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
public class _0215_KthLargestElementInAnArray {
  public static void main(String[] args) {
    System.out.println("Hello world.");
  }

  public int findKthLargest(int[] nums, int k) {
    if (nums == null || nums.length <= 0 || k < 1 || k > nums.length) {
      throw new InvalidParameterException();
    }
    if (nums.length == 1) {
      return nums[0];
    }
    // For a non-duplicate array,
    // The `k` largest element is the `nums.length + 1 - k` smallest element,
    // which is the `nums.length - k` th item in the array.
    //
    // quick selection
    int k_ = nums.length - k;
    Random rand = new Random();
    // binary search
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) { // cross
      int pivotI = left + rand.nextInt(right - left + 1);
      pivotI = getPivotIndex(nums, left, right, pivotI);
      if (pivotI < k_) {
        left = pivotI + 1;
      } else if (pivotI > k_) {
        right = pivotI - 1;
      } else { // pivotLocation > k_
        return nums[pivotI];
      }
    }
    throw new InvalidParameterException();
    /*
     * time: O(n log n)
     * 
     * space: O(1)
     */
  }

  private int getPivotIndex(int[] nums, int left, int right, int pivotI) {
    int pivotV = nums[pivotI];
    swap(nums, pivotI, right);
    int leftI = left;
    int rightI = right - 1;
    while (leftI <= rightI) {
      if (nums[leftI] < pivotV) {
        leftI += 1;
      } else if (nums[rightI] >= pivotV) {
        rightI -= 1;
      } else {
        swap(nums, leftI, rightI);
        leftI += 1;
        rightI -= 1;
      }
    }
    swap(nums, leftI, right);
    return leftI;
  }

  private void swap(int nums[], int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
