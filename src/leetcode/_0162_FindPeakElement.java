package leetcode;

/*
 * 0162. Find Peak Element
 *
 * A peak element is an element that is greater than its neighbors.
 *
 * Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and
 * return its index.
 *
 * The array may contain multiple peaks, in that case return the index to any
 * one of the peaks is fine.
 *
 * You may imagine that nums[-1] = nums[n] = -∞.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 *
 * Output: 2
 *
 * Explanation: 3 is a peak element and your function should return the index
 * number 2.
 *
 * Example 2:
 *
 * Input: nums = [1,2,1,3,5,6,4]
 *
 * Output: 1 or 5
 *
 * Explanation: Your function can return either index number 1 where the peak
 * element is 2, or index number 5 where the peak element is 6.
 *
 * Note:
 *
 * Your solution should be in logarithmic complexity.
 */
public class _0162_FindPeakElement {
  public static void main(String[] args) {
    System.out.println("Hello world.");
  }

  public int findPeakElement(int[] nums) {
    if (nums == null || nums.length < 0) {
      return -1;
    }
    int left = 0;
    int right = nums.length - 1;
    int mid = 0;
    while (left + 1 < right) {
      mid = left + (right - left) / 2;
      if (getValue(nums, mid - 1) < getValue(nums, mid)) {
        left = mid;
      } else {
        right = mid;
      }
    }
    if (nums[left] > nums[right]) {
      return left;
    } else {
      return right;
    }
    /*
     * time: O(log n)
     *
     * space: O(1)
     */
  }

  private int getValue(int nums[], int index) {
    if (nums == null || index < 0 || index >= nums.length) {
      // nums[-1] = nums[n] = -∞.
      return Integer.MIN_VALUE;
    }
    return nums[index];
  }
}
