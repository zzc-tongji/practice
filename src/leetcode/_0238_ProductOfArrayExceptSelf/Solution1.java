package leetcode._0238_ProductOfArrayExceptSelf;

// @lc app=leetcode id=238 lang=java
// @lc code=start
public class Solution1 {
  public int[] productExceptSelf(int[] nums) {
    /*
     * time: O(n)
     *
     * space: O(1)
     */

    if (nums == null || nums.length <= 1) {
      return null;
    }
    int zeroCount = 0;
    int product = 1;
    for (int i = 0; i < nums.length; i++) {
      product *= nums[i];
      if (nums[i] == 0) {
        zeroCount += 1;
      }
    }
    // Initial values in `res[]` are 0.
    int[] res = new int[nums.length];
    if (zeroCount == 0) {
      // no zero
      for (int i = 0; i < res.length; i++) {
        res[i] = product / nums[i];
      }
    } else if (zeroCount == 1) {
      // just one zero
      for (int i = 0; i < res.length; i++) {
        if (nums[i] == 0) {
          res[i] = 1;
          for (int j = 0; j < res.length; j++) {
            if (j == i) {
              continue;
            }
            res[i] *= nums[j];
          }
        }
      }
    } else { // zeroCount >= 2
      // more than one zero
      //
      // do nothing
    }
    return res;
  }
}
// @lc code=end
