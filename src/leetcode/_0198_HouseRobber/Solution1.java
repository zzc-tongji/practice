package leetcode._0198_HouseRobber;

// @lc app=leetcode id=198 lang=java
// @lc code=start
public class Solution1 {
  /*
   * [me]
   *
   * time: O(1)
   *
   * space: O(n)
   */

  public int rob(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    if (nums.length == 1) {
      return nums[0];
    }
    if (nums.length == 2) {
      return Math.max(nums[0], nums[1]);
    }
    int res = 0;
    int prePre = nums[0];
    int pre = Math.max(nums[0], nums[1]);
    for (int i = 2; i < nums.length; i++) {
      res = Math.max(pre, prePre + nums[i]);
      // prepare
      prePre = pre;
      pre = res;
    }
    return res;
  }
}
// @lc code=end
