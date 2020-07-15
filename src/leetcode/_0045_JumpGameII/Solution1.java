package leetcode._0045_JumpGameII;

import java.util.Arrays;

// @lc app=leetcode id=45 lang=java
// @lc code=start
public class Solution1 {
  /*
   * DP
   *
   * time: O(k * n)
   *
   * - let k as the naximum value in array `nums`
   *
   * - let n as the length of `num`
   *
   * space: O(n)
   */

  public int jump(int[] nums) {
    if (nums == null || nums.length <= 0) {
      throw new IllegalArgumentException("invalid input");
    }
    // `dp[i]` means the minimun step we can jump from `nums[i]` to the last element
    int[] dp = new int[nums.length];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[dp.length - 1] = 0;
    //
    int temp;
    int min;
    //
    for (int i = dp.length - 1 - 1; i >= 0; i--) {
      min = Integer.MAX_VALUE;
      for (int j = nums[i]; j >= 1; j--) {
        if (i + j > dp.length - 1) {
          temp = 1;
        } else {
          temp = dp[i + j];
        }
        min = Math.min(temp, min);
      }
      dp[i] = min == Integer.MAX_VALUE ? min : min + 1;
    }
    if (dp[0] == Integer.MAX_VALUE) {
      throw new IllegalArgumentException("cannot reach the last index");
    }
    return dp[0];
  }
}
// @lc code=end
