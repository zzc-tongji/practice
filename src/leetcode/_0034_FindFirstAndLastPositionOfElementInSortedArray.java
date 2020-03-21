package leetcode;

/**
 * 0034. Find First and Last Position of Element in Sorted Array Medium
 * 
 * Given an array of integers nums sorted in ascending order, find the starting
 * and ending position of a given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * Example 1:
 * 
 * Input: nums = [5,7,7,8,8,10], target = 8
 * 
 * Output: [3,4] Example 2:
 * 
 * Input: nums = [5,7,7,8,8,10], target = 6
 * 
 * Output: [-1,-1]
 */
public class _0034_FindFirstAndLastPositionOfElementInSortedArray {
  public static void main(String[] args) {
    System.out.println("Hello world.");
  }

  public int[] searchRange(int[] nums, int target) {
    if (nums == null || nums.length <= 0) {
      return new int[] { -1, -1 };
    }
    int first = searchFirst(nums, target);
    int last = searchLast(nums, target);
    return new int[] { first, last };
  }

  public int searchFirst(int[] nums, int target) {
    if (nums == null || nums.length <= 0) {
      return -1;
    }
    int left = 0;
    int right = nums.length - 1;
    int mid = 0;
    while (left + 1 < right) {
      mid = left + (right - left) / 2;
      if (nums[mid] < target) {
        left = mid;
      } else {
        right = mid;
      }
      // if (nums[mid] < target) {
      // left = mid;
      // } else if (nums[mid] > target) {
      // right = mid;
      // } else { // nums[mid] == target
      // right = mid;
      // }
    }
    if (nums[left] == target) { // Target is the first one.
      return left;
    }
    if (nums[right] == target) {
      return right;
    }
    return -1; // Target is not found.
    /*
     * time: O(log n)
     * 
     * space: O(1)
     */
  }

  public int searchLast(int[] nums, int target) {
    if (nums == null || nums.length <= 0) {
      return -1;
    }
    int left = 0;
    int right = nums.length - 1;
    int mid = 0;
    while (left + 1 < right) {
      mid = left + (right - left) / 2;
      if (nums[mid] > target) {
        right = mid;
      } else {
        left = mid;
      }
      // if (nums[mid] < target) {
      // left = mid;
      // } else if (nums[mid] > target) {
      // right = mid;
      // } else { // nums[mid] == target
      // left = mid;
      // }
    }
    if (nums[right] == target) { // Target is the last one.
      return right;
    }
    if (nums[left] == target) {
      return left;
    }
    return -1; // Target is not found.
    /*
     * time: O(log n)
     * 
     * space: O(1)
     */
  }
}
