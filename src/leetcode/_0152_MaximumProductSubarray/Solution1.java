package leetcode._0152_MaximumProductSubarray;

// @lc app=leetcode id=152 lang=java
// @lc code=start
public class Solution1 {
  /*
   * [me]
   *
   * time: O(n)
   *
   * space: O(n)
   */

  public int maxProduct(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    if (nums.length == 1) {
      return nums[0];
    }
    int max = nums[0];
    // `maxHelper[i]` is the max product of subarray `nums[0:i]`
    // which MUST INCLUDES `nums[i]`.
    int[] maxHelper = new int[nums.length];
    // `minHelper[i]` is the min product of subarray `nums[0:i]`
    // which MUST INCLUDES `nums[i]`.
    int[] minHelper = new int[nums.length];
    maxHelper[0] = nums[0];
    minHelper[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      maxHelper[i] = Math.max(Math.max(maxHelper[i - 1] * nums[i], minHelper[i - 1] * nums[i]), nums[i]);
      minHelper[i] = Math.min(Math.min(maxHelper[i - 1] * nums[i], minHelper[i - 1] * nums[i]), nums[i]);
      max = Math.max(maxHelper[i], max);
    }
    return max;
  }
}
// @lc code=end
