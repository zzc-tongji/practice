package leetcode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * 0107. Binary Tree Level Order Traversal II
 *
 * Given a binary tree, return the bottom-up level order traversal of its nodes'
 * values. (ie, from left to right, level by level from leaf to root).
 *
 * For example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *   3
 *  / \
 * 9  20
 *   /  \
 *  15   7
 *
 * return its bottom-up level order traversal as:
 *
 * [
 *  [15,7],
 *  [9,20],
 *  [3]
 * ]
 */
public class _0107_BinaryTreeLevelOrderTraversalII {
  public static void main(String[] args) {
    System.out.println("Hello world.");
  }

  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    // just output
    if (root == null) {
      return new LinkedList<>();
    }
    Queue<TreeNode> q = new LinkedList<>();
    List<Integer> cursor = null;
    List<List<Integer>> result = new LinkedList<>();
    int size = 0;
    TreeNode cur = null;
    //
    q.offer(root);
    while (!q.isEmpty()) {
      cursor = new LinkedList<>();
      result.add(cursor);
      size = q.size();
      for (int i = 0; i < size; i++) {
        // poll
        cur = q.poll();
        // visit
        cursor.add(cur.val);
        // offer
        if (cur.left != null) {
          q.offer(cur.left);
        }
        if (cur.right != null) {
          q.offer(cur.right);
        }
      }
    }
    // reverse
    Collections.reverse(result);
    return result;
    /*
     * time: O(n)
     *
     * space: O(n)
     */
  }

  public List<List<Integer>> levelOrderBottom1(TreeNode root) {
    /*
     * time: O(n)
     *
     * space: O(n)
     */
    return null;
  }
}
