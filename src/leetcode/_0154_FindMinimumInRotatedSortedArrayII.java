package leetcode;

/**
 * 0154. Find Minimum in Rotated Sorted Array II
 * 
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * 
 * Find the minimum element.
 * 
 * The array may contain duplicates.
 * 
 * Example 1:
 * 
 * Input: [1,3,5]
 * 
 * Output: 1
 * 
 * Example 2:
 * 
 * Input: [2,2,2,0,1]
 * 
 * Output: 0
 * 
 * Note:
 * 
 * - This is a follow up problem to Find Minimum in Rotated Sorted Array.
 * 
 * - Would allow duplicates affect the run-time complexity? How and why?
 */
public class _0154_FindMinimumInRotatedSortedArrayII {
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
      if (nums[mid] < nums[right]) {
        right = mid;
      } else if (nums[mid] > nums[right]) {
        left = mid;
      } else { // nums[mid] == nums[right]
        // different to `_0153_FindMinimumInRotatedSortedArray.java`
        //
        // When "equal" happens, slightly move `right` to a potential smaller item.
        //
        // Don't worry about "minimum as equal". When `left` and `right` are
        // neighborhoods, loop comes to an end.
        right -= 1;
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
