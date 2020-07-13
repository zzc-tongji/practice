package techbow._0018_GetSubarrayWithMaximumSum;

import java.util.Arrays;

/*
 * relate problem: leetcode._0053_MaximumSubarray
 */

public class Solution {
  /*
   * time: O(n)
   *
   * space: O(n)
   */

  public int[] getSubarray(int[] nums) {
    if (nums == null || nums.length == 0) {
      return null;
    }
    if (nums.length == 1) {
      return nums;
    }
    // `dp[i]` is the max sum subarray in subarray `nums[0:i]`
    // which MUST INCLUDES `nums[i]`.
    int[] dp = new int[nums.length];
    // `dpStart[i]` records the start index,
    // which means the sum of the subarray `nums[dpStart[i]:i]` is `dp[i]`
    int[] dpStart = new int[nums.length];
    dp[0] = nums[0];
    dpStart[0] = 0;
    int max = nums[0];
    int maxIndex = 0;
    for (int i = 1; i < dp.length; i++) {
      if (dp[i - 1] + nums[i] > nums[i]) {
        // If more subarrays has equal sum as maximum,
        // the shortest one will be chosen (use >= as the longest one).
        dp[i] = dp[i - 1] + nums[i];
        dpStart[i] = dpStart[i - 1];
      } else {
        dp[i] = nums[i];
        dpStart[i] = i;
      }
      if (dp[i] > max) {
        // If more subarrays has equal sum as maximum,
        // the most left one will be chosen (use >= as the most right one).
        max = dp[i];
        maxIndex = i;
      }
    }
    return Arrays.copyOfRange(nums, dpStart[maxIndex], maxIndex + 1);
  }
}
