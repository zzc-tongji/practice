package leetcode._0135_Candy;

/*
 * 0135. Candy
 *
 * There are N children standing in a line. Each child is assigned a rating
 * value.
 *
 * You are giving candies to these children subjected to the following
 * requirements:
 *
 * Each child must have at least one candy. Children with a higher rating get
 * more candies than their neighbors.
 *
 * What is the minimum candies you must give?
 *
 * Example 1:
 *
 * Input: [1,0,2]
 *
 * Output: 5
 *
 * Explanation: You can allocate to the first, second and third child with 2, 1,
 * 2 candies respectively.
 *
 * Example 2:
 *
 * Input: [1,2,2]
 *
 * Output: 4
 *
 * Explanation: You can allocate to the first, second and third child with 1, 2,
 * 1 candies respectively. The third child gets 1 candy because it satisfies the
 * above two conditions.
 */

// @lc app=leetcode id=135 lang=java
// @lc code=start
public class Solution {
  public int candy(int[] ratings) {
    if (ratings == null || ratings.length == 0) {
      return 0;
    }
    if (ratings.length == 1) {
      return 1;
    }
    int[] candy = new int[ratings.length];
    candy[0] = 1;
    // watch from left to right
    for (int i = 1; i < ratings.length; i++) {
      if (ratings[i] > ratings[i - 1]) { // use `>` based on description
        candy[i] = candy[i - 1] + 1;
      } else {
        candy[i] = 1;
      }
    }
    // watch from right to left, note that `candy[i]` cannot decrease
    int sum = candy[candy.length - 1];
    for (int i = candy.length - 1 - 1; i >= 0; i--) {
      if (ratings[i] > ratings[i + 1]) { // use `>` based on description
        candy[i] = Math.max(candy[i + 1] + 1, candy[i]); // attention
      }
      sum += candy[i];
    }
    return sum;
  }
}
// @lc code=end
