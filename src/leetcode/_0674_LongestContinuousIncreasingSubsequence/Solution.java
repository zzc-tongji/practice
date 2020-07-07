package leetcode._0674_LongestContinuousIncreasingSubsequence;

/*
 * 0674. Longest Continuous Increasing Subsequence
 *
 * Given an unsorted array of integers, find the length of longest continuous
 * increasing subsequence (subarray).
 *
 * Example 1:
 *
 * Input: [1,3,5,4,7]
 *
 * Output: 3
 *
 * Explanation: The longest continuous increasing subsequence is [1,3,5], its
 * length is 3.
 *
 * Even though [1,3,5,7] is also an increasing subsequence, it's not a
 * continuous one where 5 and 7 are separated by 4.
 *
 * Example 2:
 *
 * Input: [2,2,2,2,2]
 *
 * Output: 1
 *
 * Explanation: The longest continuous increasing subsequence is [2], its length
 * is 1.
 *
 * Note:
 *
 * Length of the array will not exceed 10,000.
 */

// @lc app=leetcode id=674 lang=java
// @lc code=start
public class Solution {
  /*
   * time: O(n)
   *
   * space: O(n)
   */

  public int findLengthOfLCIS(int[] nums) {
    if (nums == null || nums.length <= 0) {
      return 0;
    }
    if (nums.length == 1) {
      return nums[0];
    }
    int[] dp = new int[nums.length];
    dp[0] = 1;
    int max = dp[0];
    for (int i = 1; i < nums.length; i++) {
      // Based on LeetCode test case, use ">" rather than ">=".
      if (nums[i] > nums[i - 1]) {
        dp[i] = dp[i - 1] + 1;
      } else {
        dp[i] = 1;
      }
      max = Math.max(max, dp[i]);
    }
    return max;
  }
}
// @lc code=end
