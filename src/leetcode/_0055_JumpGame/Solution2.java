package leetcode._0055_JumpGame;

// @lc app=leetcode id=55 lang=java
// @lc code=start
public class Solution2 {
  /*
   * greedy
   *
   * time: O(n)
   *
   * space: O(n)
   */

  public boolean canJump(int[] nums) {
    if (nums == null || nums.length <= 0) {
      throw new IllegalArgumentException();
    }
    if (nums.length == 1) {
      return true;
    }
    int maxRange = 0;
    for (int i = 0; i <= maxRange; i++) { // `maxRange` is always changed.
      maxRange = Math.max(maxRange, i + nums[i]);
      if (maxRange >= nums.length - 1) {
        return true;
      }
    }
    return false;
  }
}
// @lc code=end
