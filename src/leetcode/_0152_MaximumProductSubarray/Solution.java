package leetcode._0152_MaximumProductSubarray;

/**
 * 0152. Maximum Product Subarray
 *
 * Given an integer array nums, find the contiguous subarray within an array
 * (containing at least one number) which has the largest product.
 *
 * Example 1:
 *
 * Input: [2,3,-2,4]
 *
 * Output: 6
 *
 * Explanation: [2,3] has the largest product 6.
 *
 * Example 2:
 *
 * Input: [-2,0,-1]
 *
 * Output: 0
 *
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */

// @lc app=leetcode id=152 lang=java
// @lc code=start
public class Solution {
  /*
   * [me]
   *
   * LeetCode: Time Limit Exceeded
   *
   * time: O(n ^ 2)
   *
   * space: O(n ^ 2)
   */

  public int maxProduct(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    if (nums.length == 1) {
      return nums[0];
    }
    int max = nums[0];
    int[][] product = new int[nums.length][nums.length];
    for (int i = 0; i < product.length; i++) {
      for (int j = i; j < product[i].length; j++) {
        if (j == i) {
          product[i][j] = nums[j];
        } else {
          product[i][j] = product[i][j - 1] * nums[j];
        }
        max = Math.max(product[i][j], max);
      }
    }
    return max;
  }
}
// @lc code=end
