package leetcode._0674_LongestContinuousIncreasingSubsequence;

// @lc app=leetcode id=674 lang=java
// @lc code=start
public class Solution1 {
  /*
   * time: O(n)
   *
   * space: O(1)
   */

  public int findLengthOfLCIS(int[] nums) {
    if (nums == null || nums.length <= 0) {
      return 0;
    }
    if (nums.length == 1) {
      return nums[0];
    }
    int dp = 1;
    int max = dp;
    for (int i = 1; i < nums.length; i++) {
      // Based on LeetCode test case, use ">" rather than ">=".
      if (nums[i] > nums[i - 1]) {
        dp += 1;
      } else {
        dp = 1;
      }
      max = Math.max(max, dp);
    }
    return max;
  }
}
// @lc code=end
