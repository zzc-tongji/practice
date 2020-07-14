package leetcode._0045_JumpGameII;

/*
 * 0045. Jump Game II
 *
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 *
 * Each element in the array represents your maximum jump length at that
 * position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * Example:
 *
 * Input: [2,3,1,1,4]
 *
 * Output: 2
 *
 * Explanation: The minimum number of jumps to reach the last index is 2. ⁠ Jump
 * 1 step from index 0 to 1, then 3 steps to the last index.
 *
 * Note:
 *
 * You can assume that you can always reach the last index.
 */

// @lc app=leetcode id=45 lang=java
// @lc code=start
public class Solution {
  /*
   * dfs
   *
   * LeetCode: Time Limit Exceeded
   *
   * time: O(x ^ (n - 1))
   *
   * - let x as the naximum value in array `nums`
   *
   * - let n as the length of `num`
   *
   * space: O(1)
   */

  public int jump(int[] nums) {
    if (nums == null || nums.length <= 0) {
      throw new IllegalArgumentException("invalid input");
    }
    int res = dfs(nums, 0);
    if (res == Integer.MAX_VALUE) {
      throw new IllegalArgumentException("cannot reach the last index");
    }
    return res;
  }

  private int dfs(int[] nums, int index) {
    if (index >= nums.length - 1) {
      return 0;
    }
    int temp;
    int min = Integer.MAX_VALUE;
    for (int i = nums[index]; i >= 1; i--) {
      temp = dfs(nums, index + i);
      if (temp == Integer.MAX_VALUE) {
        continue;
      }
      min = Math.min(temp, min);
    }
    return min == Integer.MAX_VALUE ? min : min + 1;
  }
}
// @lc code=end
