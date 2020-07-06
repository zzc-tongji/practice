package leetcode;

/*
 * 0070. Climbing Stairs
 *
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 *
 * Note: Given n will be a positive integer.
 *
 * Example 1:
 *
 * Input: 2
 *
 * Output: 2
 *
 * Explanation: There are two ways to climb to the top.
 *
 * 1. 1 step + 1 step
 *
 * 2. 2 steps
 *
 * Example 2:
 *
 * Input: 3
 *
 * Output: 3
 *
 * Explanation: There are three ways to climb to the top.
 *
 * 1. 1 step + 1 step + 1 step
 *
 * 2. 1 step + 2 steps
 *
 * 3. 2 steps + 1 step
 */
public class _0070_ClimbingStairs {
  public int climbStairs(int n) {
    // recursion (LeetCode: Time Limit Exceeded)
    if (n < 0) {
      return -1;
    }
    if (n == 0 || n == 1) {
      return 1;
    }
    return climbStairs2(n - 1) + climbStairs2(n - 2);
    /*
     * time: O(n ^ 2)
     *
     * space: O(1)
     */
  }

  public int climbStairs1(int n) {
    // dynamic programming (DP)
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;
    for (int i = 2; i < dp.length; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
    /*
     * time: O(n)
     *
     * space: O(n)
     */
  }

  public int climbStairs2(int n) {
    // dynamic programming (DP) - save all historical/temperary results
    //
    // Return `int` may cause overflow. Its better to return `long`.
    if (n < 0) {
      return -1;
    }
    if (n == 0 || n == 1) {
      return 1;
    }
    int pre = 1;
    int preOfPre = 1;
    int cur = 0;
    for (int i = 2; i <= n; i++) {
      cur = pre + preOfPre;
      // prepare for next calculation
      preOfPre = pre;
      pre = cur;
    }
    return cur;
    /*
     * time: O(n)
     *
     * space: O(1)
     */
  }
}
