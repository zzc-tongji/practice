package leetcode._0055_JumpGame;

/*
 * 0055. Jump Game
 *
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 *
 * Each element in the array represents your maximum jump length at that
 * position.
 *
 * Determine if you are able to reach the last index.
 *
 * Example 1:
 *
 * Input: nums = [2,3,1,1,4]
 *
 * Output: true
 *
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 * Example 2:
 *
 * Input: nums = [3,2,1,0,4]
 *
 * Output: false
 *
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 * jump length is 0, which makes it impossible to reach the last index.
 *
 * Constraints:
 *
 * 1 <= nums.length <= 3 * 10^4
 *
 * 0 <= nums[i][j] <= 10^5
 */

// @lc app=leetcode id=55 lang=java
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

  public boolean canJump(int[] nums) {
    if (nums == null || nums.length <= 0) {
      throw new IllegalArgumentException();
    }
    return dfs(nums, 0);
  }

  private boolean dfs(int[] nums, int index) {
    if (index >= nums.length - 1) {
      return true;
    }
    for (int i = nums[index]; i >= 1; i--) {
      if (dfs(nums, index + i)) {
        return true;
      }
    }
    return false;
  }
}
// @lc code=end
