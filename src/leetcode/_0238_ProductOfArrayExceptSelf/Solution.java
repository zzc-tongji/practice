package leetcode._0238_ProductOfArrayExceptSelf;
/*
 * 0238. Product of Array Except Self
 *
 * Given an array nums of n integers where n > 1,  return an array output such
 * that output[i] is equal to the product of all the elements of nums except
 * nums[i].
 *
 * Example:
 *
 * Input: [1,2,3,4]
 *
 * Output: [24,12,8,6]
 *
 * Constraint: It's guaranteed that the product of the elements of any prefix or
 * suffix of the array (including the whole array) fits in a 32 bit integer.
 *
 * Note: Please solve it without division and in O(n).
 *
 * Follow up:
 *
 * Could you solve it with constant space complexity? (The output array does not
 * count as extra space for the purpose of space complexity analysis.)
 */

// @lc app=leetcode id=238 lang=java
// @lc code=start
public class Solution {
  public int[] productExceptSelf(int[] nums) {
    /*
     * time: O(n)
     *
     * space: O(n)
     */

    if (nums == null || nums.length <= 1) {
      return null;
    }
    // `dpLeft[i]`: the product of elements which are left to `i` (exclusive)
    int[] dpLeft = new int[nums.length];
    // `dpRight[i]`: the product of elements which are right to `i` (exclusive)
    int[] dpRight = new int[nums.length];
    //
    dpLeft[0] = 1;
    for (int i = 1; i < dpLeft.length; i++) {
      dpLeft[i] = dpLeft[i - 1] * nums[i - 1];
    }
    dpRight[dpRight.length - 1] = 1;
    for (int i = dpRight.length - 1 - 1; i >= 0; i--) {
      dpRight[i] = dpRight[i + 1] * nums[i + 1];
    }
    int[] res = new int[nums.length];
    for (int i = 0; i < res.length; i++) {
      res[i] = dpLeft[i] * dpRight[i];
    }
    return res;
  }
}
// @lc code=end
