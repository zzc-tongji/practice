package leetcode._0055_JumpGame;

// @lc app=leetcode id=55 lang=java
// @lc code=start
public class Solution1 {
  /*
   * dp
   *
   * time: O(k * n)
   *
   * - let k as the naximum value in array `nums`
   *
   * - let n as the length of `num`
   *
   * space: O(n)
   */

  public boolean canJump(int[] nums) {
    if (nums == null || nums.length <= 0) {
      throw new IllegalArgumentException();
    }
    // `dp[i]` means whether we can jump from `nums[i]` to the last element
    boolean[] dp = new boolean[nums.length];
    dp[dp.length - 1] = true;
    for (int i = dp.length - 1 - 1; i >= 0; i--) {
      for (int j = nums[i]; j >= 1; j--) {
        if (i + j > dp.length - 1) {
          dp[i] = true;
        } else {
          dp[i] = dp[i + j];
        }
        if (dp[i]) {
          break;
        }
      }
    }
    return dp[0];
  }
}
// @lc code=end
