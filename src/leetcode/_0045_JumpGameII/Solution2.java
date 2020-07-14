package leetcode._0045_JumpGameII;

// @lc app=leetcode id=45 lang=java
// @lc code=start
public class Solution2 {
  /*
   * greedy
   *
   * time: O(n)
   *
   * space: O(n)
   */

  public int jump(int[] nums) {
    if (nums == null || nums.length <= 0) {
      throw new IllegalArgumentException("invalid input");
    }
    if (nums.length == 1) {
      return 0;
    }
    int max = 0;
    int preMax = 0;
    int step = 0;
    for (int i = 0; i < nums.length; i++) {
      if (i > preMax) {
        preMax = max;
        step += 1;
      }
      if (i > max) {
        throw new IllegalArgumentException("cannot reach the last index");
      }
      max = Math.max(i + nums[i], max);
    }
    return step;
  }
}
// @lc code=end
