package lintcode._0011_SearchRangeInBinarySearchTree;

import java.util.ArrayList;
import java.util.List;
import leetcode.TreeNode;

public class Solution1 {
  /*
   * time: O(n)
   *
   * space: O(n)
   */

  public List<Integer> searchRange(TreeNode root, int k1, int k2) {
    List<Integer> answer = new ArrayList<>();
    helper(root, k1, k2, answer);
    return answer;
    /*
     * time: O(level) ~ O(n), dependes on range
     *
     * space: O(1)
     */
  }

  private void helper(TreeNode root, int k1, int k2, List<Integer> answer) {
    if (root == null) {
      return;
    }
    if (root.val > k1) {
      helper(root.left, k1, k2, answer);
    }
    if (root.val >= k1 && root.val <= k2) {
      answer.add(root.val);
    }
    if (root.val < k2) {
      helper(root.right, k1, k2, answer);
    }
  }
}
