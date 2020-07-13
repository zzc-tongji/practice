package leetcode._0055_JumpGame;

// @lc app=leetcode id=55 lang=java
// @lc code=start
public class Solution3 {
  /*
   * greedy
   *
   * the same idea of solution 2, a comprehensible expression by myself
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
    int slow = -1;
    int fast = -1;
    boolean res;
    while (true) {
      slow += 1;
      fast = Math.max(slow + nums[slow], fast);
      // `slow` is always less than to `fast` (or it will break the loop)
      // and fast is always in-bound (or it will break the loop),
      // so `slow` is always in-bound and `nums[slow]` does not cause exception.
      res = (fast >= nums.length - 1);
      if (slow >= fast || res) {
        break;
      }
    }
    return res;
  }
}
// @lc code=end
