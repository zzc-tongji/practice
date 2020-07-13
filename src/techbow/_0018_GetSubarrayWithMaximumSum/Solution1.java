package techbow._0018_GetSubarrayWithMaximumSum;

import java.util.Arrays;

public class Solution1 {
  /*
   * time: O(n)
   *
   * space: O(1)
   */

  public int[] getSubarray(int[] nums) {
    if (nums == null || nums.length == 0) {
      return null;
    }
    if (nums.length == 1) {
      return nums;
    }
    int dp = nums[0];
    int dpStart = 0;
    int max = nums[0];
    int maxIndex = 0;
    for (int i = 1; i < nums.length; i++) {
      if (dp + nums[i] > nums[i]) {
        // If more subarrays has equal sum as maximum,
        // the shortest one will be chosen (use >= as the longest one).
        dp = dp + nums[i];
      } else {
        dp = nums[i];
        dpStart = i;
      }
      if (dp > max) {
        // If more subarrays has equal sum as maximum,
        // the most left one will be chosen (use >= as the most right one).
        max = dp;
        maxIndex = i;
      }
    }
    return Arrays.copyOfRange(nums, dpStart, maxIndex + 1);
  }
}
