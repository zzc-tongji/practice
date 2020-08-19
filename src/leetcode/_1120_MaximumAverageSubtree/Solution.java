package leetcode._1120_MaximumAverageSubtree;

import leetcode.TreeNode;

/*
 * 1120. Maximum Average Subtree
 *
 * Given the root of a binary tree, find the maximum average value of any
 * subtree of that tree.
 *
 * (A subtree of a tree is any node of that tree plus all its descendants. The
 * average value of a tree is the sum of its values, divided by the number of
 * nodes.)
 *
 * Example 1:
 *
 * https://assets.leetcode.com/uploads/2019/04/09/1308_example_1.png
 *
 * Input: [5,6,1]
 *
 * Output: 6.00000
 *
 * Explanation:
 *
 * For the node with value = 5 we have an average of (5 + 6 + 1) / 3 = 4.
 *
 * For the node with value = 6 we have an average of 6 / 1 = 6.
 *
 * For the node with value = 1 we have an average of 1 / 1 = 1.
 *
 * So the answer is 6 which is the maximum.
 *
 * Note:
 *
 * 1. The number of nodes in the tree is between 1 and 5000.
 *
 * 2. Each node will have a value between 0 and 100000.
 *
 * 3. Answers will be accepted as correct if they are within 10^-5 of the
 * correct answer.
 */

// @lc app=leetcode id=1120 lang=java
// @lc code=start
public class Solution {
  /*
   * [me]
   *
   * Amazon - 2020 new graduate - OA2
   *
   * time: O(n)
   *
   * space: O(1)
   */
  private double result;

  public double maximumAverageSubtree(TreeNode root) {
    result = Double.MIN_VALUE;
    helper(root);
    return result;
  }

  private double[] helper(TreeNode root) {
    if (root == null) {
      return new double[] { 0, 0 };
    }
    double[] left = helper(root.left);
    double[] right = helper(root.right);
    double elementNumber = left[0] + right[0] + 1;
    double sum = left[1] + right[1] + root.val;
    //
    result = Math.max(result, sum / elementNumber);
    //
    return new double[] { elementNumber, sum };
  }
}
// @lc code=end
