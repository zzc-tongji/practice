package lintcode;

import java.util.ArrayList;
import java.util.List;
import leetcode.TreeNode;

/*
 * 0011. Search Range in Binary Search Tree
 *
 * Description
 *
 * Given a binary search tree and a range [k1, k2], return node values within a
 * given range in ascending order.
 *
 * Example
 *
 * Example 1:
 *
 * Input：{5},6,10
 *
 * Output：[] 5
 *
 * it will be serialized {5}
 *
 * No number between 6 and 10
 *
 * Example 2:
 *
 * Input：{20,8,22,4,12},10,22
 *
 * Output：[12,20,22]
 *
 * Explanation：
 *
 *      20
 *     /  \
 *    8   22
 *   / \
 *  4   12
 *
 * it will be serialized {20,8,22,4,12}
 *
 * [12,20,22] between 10 and 22
 */
public class _0011_SearchRangeInBinarySearchTree {
  List<Integer> array;

  public List<Integer> searchRange(TreeNode root, int k1, int k2) {
    array = new ArrayList<>();
    List<Integer> res = new ArrayList<>();
    helper(root);
    for (int i = 0; i < array.size(); i++) {
      int value = array.get(i);
      if (value < k1) {
        continue;
      }
      if (value > k2) {
        break;
      }
      res.add(value);
    }
    return res;
    /*
     * time: O(n)
     *
     * space: O(n)
     */
  }

  private void helper(TreeNode root) {
    if (root == null) {
      return;
    }
    helper(root.left);
    array.add(root.val);
    helper(root.right);
  }

  public List<Integer> searchRange1(TreeNode root, int k1, int k2) {
    List<Integer> answer = new ArrayList<>();
    helper1(root, k1, k2, answer);
    return answer;
    /*
     * time: O(level) ~ O(n), dependes on range
     *
     * space: O(1)
     */
  }

  private void helper1(TreeNode root, int k1, int k2, List<Integer> answer) {
    if (root == null) {
      return;
    }
    if (root.val > k1) {
      helper1(root.left, k1, k2, answer);
    }
    if (root.val >= k1 && root.val <= k2) {
      answer.add(root.val);
    }
    if (root.val < k2) {
      helper1(root.right, k1, k2, answer);
    }
  }
}
