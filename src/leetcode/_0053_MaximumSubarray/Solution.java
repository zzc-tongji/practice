package leetcode._0053_MaximumSubarray;

/*
 * 0053. Maximum Subarray
 *
 * Given an integer array nums, find the contiguous subarray (containing at
 * least one number) which has the largest sum and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 *
 * Output: 6
 *
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 *
 * Follow up:
 *
 * If you have figured out the O(n) solution, try coding another solution using
 * the divide and conquer approach, which is more subtle.
 */

// @lc app=leetcode id=53 lang=java
// @lc code=start
public class Solution {
  /*
   * time: O(n)
   *
   * space: O(n)
   */

  public int maxSubArray(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    if (nums.length == 1) {
      return nums[0];
    }
    // `dp[i]` is the max sum subarray in subarray `nums[0:i]`
    // which MUST INCLUDES `nums[i]`.
    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    int max = nums[0];
    for (int i = 1; i < dp.length; i++) {
      dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
      max = Math.max(dp[i], max);
    }
    return max;
  }
}
// @lc code=end
