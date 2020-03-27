package leetcode;

/**
 * 0153. Find Minimum in Rotated Sorted Array
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * Find the minimum element.
 *
 * You may assume no duplicate exists in the array.
 *
 * Example 1:
 *
 * Input: [3,4,5,1,2]
 *
 * Output: 1
 *
 * Example 2:
 *
 * Input: [4,5,6,7,0,1,2]
 *
 * Output: 0
 */
public class _0153_FindMinimumInRotatedSortedArray {
  public static void main(String[] args) {
    System.out.println("Hello world.");
  }

  public int findMin(int[] nums) {
    if (nums == null || nums.length <= 0) {
      return -1;
    }
    int left = 0;
    int right = nums.length - 1;
    int mid = 0;
    while (left + 1 < right) {
      mid = left + (right - left) / 2;
      // Use `nums[right]` as target.
      //
      // Why? Draw a zig-zag array map to see details.
      if (nums[mid] < nums[right]) {
        right = mid;
      } else {
        left = mid;
      }
    }
    return nums[left] < nums[right] ? nums[left] : nums[right];
    /*
     * time: O(log n)
     *
     * space: O(1)
     */
  }
}
