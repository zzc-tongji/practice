package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 0958. Check Completeness of a Binary Tree
 *
 * Given a binary tree, determine if it is a complete binary tree.
 *
 * Definition of a complete binary tree from Wikipedia:
 *
 * In a complete binary tree every level, except possibly the last, is
 * completely filled, and all nodes in the last level are as far left as
 * possible. It can have between 1 and 2h nodes inclusive at the last level h.
 *
 * Example 1:
 *
 * https://assets.leetcode.com/uploads/2018/12/15/complete-binary-tree-1.png
 *
 * Input: [1,2,3,4,5,6]
 *
 * Output: true
 *
 * Explanation: Every level before the last is full (ie. levels with node-values
 * {1} and {2, 3}), and all nodes in the last level ({4, 5, 6}) are as far left
 * as possible.
 *
 * Example 2:
 *
 * https://assets.leetcode.com/uploads/2018/12/15/complete-binary-tree-2.png
 *
 * Input: [1,2,3,4,5,null,7]
 *
 * Output: false
 *
 * Explanation: The node with value 7 isn't as far left as possible.
 *
 * Note:
 *
 * The tree will have between 1 and 100 nodes.
 */
public class _0958_CheckCompletenessOfABinaryTree {
  public static void main(String[] args) {
    System.out.println("Hello world.");
  }

  public boolean isCompleteTree(TreeNode root) {
    if (root == null) {
      throw new IllegalArgumentException("It is not a tree.");
    }
    Queue<TreeNode> q = new LinkedList<>();
    TreeNode cur = null;
    boolean nullAppear = false;
    //
    q.offer(root);
    while (!q.isEmpty()) {
      // poll
      cur = q.poll();
      // offer
      if (cur != null) {
        if (nullAppear) {
          // If there is a non-null node after a `null`,
          // the tree is not a complete binary tree.
          return false;
        }
        q.offer(cur.left);
        q.offer(cur.right);
      } else {
        nullAppear = true;
      }
      // visit
    }
    return true;
    /*
     * time: O(n)
     *
     * space: O(1)
     */
  }

  public boolean isCompleteTree1(TreeNode root) {
    if (root == null) {
      throw new IllegalArgumentException("It is not a tree.");
    }
    Queue<TreeNode> q = new LinkedList<>();
    TreeNode cur = null;
    boolean nullAppear = false;
    //
    q.offer(root);
    while (!q.isEmpty()) {
      // poll
      cur = q.poll();
      // offer
      if (cur.left != null) {
        if (nullAppear) {
          // If there is a non-null node after a `null`,
          // the tree is not a complete binary tree.
          return false;
        }
        q.offer(cur.left);
      } else {
        nullAppear = true;
      }
      if (cur.right != null) {
        if (nullAppear) {
          // If there is a non-null node after a `null`,
          // the tree is not a complete binary tree.
          return false;
        }
        q.offer(cur.right);
      } else {
        nullAppear = true;
      }
      // visit
    }
    return true;
    /*
     * time: O(n)
     *
     * space: O(1)
     */
  }
}
