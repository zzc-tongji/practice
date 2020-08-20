package leetcode._0239_SlidingWindowMaximum;

/*
 * 0239. Sliding Window Maximum
 *
 * Given an array nums, there is a sliding window of size k which is moving
 * from the very left of the array to the very right. You can only see the k
 * numbers in the window. Each time the sliding window moves right by one
 * position. Return the max sliding window.
 *
 * Follow up:
 *
 * Could you solve it in linear time?
 *
 * Example:
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 *
 * Output: [3,3,5,5,6,7]
 *
 * Explanation:
 *
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * ⁠1 [3  -1  -3] 5  3  6  7        3
 * ⁠1  3 [-1  -3  5] 3  6  7        5
 * ⁠1  3  -1 [-3  5  3] 6  7        5
 * ⁠1  3  -1  -3 [5  3  6] 7        6
 * ⁠1  3  -1  -3  5 [3  6  7]       7
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10^5
 *
 * -10^4 <= nums[i] <= 10^4
 *
 * 1 <= k <= nums.length
 */

// @lc app=leetcode id=239 lang=java
// @lc code=start
public class Solution {
  public int[] maxSlidingWindow(int[] nums, int k) {
    // corner case
    if (nums == null || nums.length < 0) {
      return nums;
    }
    if (k <= 0) {
      return new int[] {};
    }
    // TODO
    return null;
  }
}
// @lc code=end
