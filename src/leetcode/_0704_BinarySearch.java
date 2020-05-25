package leetcode;

/*
 * 0704. Binary Search
 *
 * Given a sorted (in ascending order) integer array nums of n elements and a
 * target value, write a function to search target in nums. If target exists,
 * then return its index, otherwise return -1.
 *
 * Example 1:
 *
 * Input: nums = [-1,0,3,5,9,12], target = 9
 *
 * Output: 4
 *
 * Explanation: 9 exists in nums and its index is 4
 *
 * Example 2:
 *
 * Input: nums = [-1,0,3,5,9,12], target = 2
 *
 * Output: -1
 *
 * Explanation: 2 does not exist in nums so return -1
 *
 * Note:
 *
 * 1. You may assume that all elements in nums are unique.
 *
 * 2. n will be in the range [1, 10000].
 *
 * 3. The value of each element in nums will be in the range [-9999, 9999].
 */
public class _0704_BinarySearch {
  public static void main(String[] args) {
    System.out.println("Hello world.");
  }

  public int binarySearch(int[] nums, int target) {
    if (nums == null || nums.length <= 0) {
      return -1;
    }
    int left = 0;
    int right = nums.length - 1;
    int mid = 0;
    while (left + 1 < right) { // neighbor
      mid = left + (right - left) / 2;
      if (nums[mid] < target) {
        left = mid;
      } else if (nums[mid] > target) {
        right = mid;
      } else { // nums[mid] == target
        return mid;
      }
    }
    // post-processing
    if (nums[left] == target) {
      return left;
    }
    if (nums[right] == target) {
      return right;
    }
    return -1;
    /*
     * time: O(log n)
     *
     * space: O(1)
     */
  }

  public int binarySearch1(int[] nums, int target) {
    if (nums == null || nums.length <= 0) {
      return -1;
    }
    int left = 0;
    int right = nums.length - 1;
    int mid = 0;
    while (left <= right) { // cross (need +1 and -1)
      mid = left + (right - left) / 2;
      if (nums[mid] < target) {
        left = mid + 1;
      } else if (nums[mid] > target) {
        right = mid - 1;
      } else { // nums[mid] == target
        return mid;
      }
    }
    return -1;
    /*
     * time: O(log n)
     *
     * space: O(1)
     */
  }
}
