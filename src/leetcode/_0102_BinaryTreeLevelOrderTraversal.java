package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * 0102. Binary Tree Level Order Traversal
 *
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
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
 * return its level order traversal as:
 *
 * [
 *  [3],
 *  [9,20],
 *  [15,7]
 * ]
 */
public class _0102_BinaryTreeLevelOrderTraversal {
  public static void main(String[] args) {
    System.out.println("Hello world.");
  }

  public List<List<Integer>> levelOrder(TreeNode root) {
    // find the first node of each level
    if (root == null) {
      return new LinkedList<>();
    }
    Queue<TreeNode> q = new LinkedList<>();
    TreeNode cur = null;
    boolean markNextAsFindStart = false;
    TreeNode findStart = null;
    TreeNode headOfLevel = root;
    List<Integer> cursor = null;
    List<List<Integer>> result = new LinkedList<>();
    //
    q.add(root);
    while (!q.isEmpty()) {
      // poll
      cur = q.poll();
      if (markNextAsFindStart) {
        // mark the head of the next level (II)
        findStart = cur;
        markNextAsFindStart = false;
      }
      if (headOfLevel == cur) {
        // add level
        cursor = new LinkedList<>();
        result.add(cursor);
      }
      if (headOfLevel == cur || findStart == cur) {
        // mark the head of the next level (I)
        if (cur.left != null) {
          headOfLevel = cur.left;
        } else if (cur.right != null) {
          headOfLevel = cur.right;
        } else {
          markNextAsFindStart = true;
        }
      }
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
    return result;
    /*
     * time: O(n)
     *
     * space: O(n)
     */
  }

  public List<List<Integer>> levelOrder1(TreeNode root) {
    // dual queue
    if (root == null) {
      return new LinkedList<>();
    }
    List<Queue<TreeNode>> queueList = new ArrayList<>();
    queueList.add(new LinkedList<>());
    queueList.add(new LinkedList<>());
    int selector = 0;
    List<Integer> cursor = null;
    List<List<Integer>> result = new LinkedList<>();
    TreeNode cur = null;
    //
    queueList.get(selector).add(root);
    while (!queueList.get(0).isEmpty() || !queueList.get(1).isEmpty()) {
      // add level
      cursor = new LinkedList<>();
      result.add(cursor);
      while (!queueList.get(selector).isEmpty()) {
        // poll
        cur = queueList.get(selector).poll();
        // visit
        cursor.add(cur.val);
        // offer
        if (cur.left != null) {
          queueList.get((selector + 1) % 2).offer(cur.left);
        }
        if (cur.right != null) {
          queueList.get((selector + 1) % 2).offer(cur.right);
        }
      }
      // switch queue
      selector = (selector + 1) % 2;
    }
    return result;
    /*
     * time: O(n)
     *
     * space: O(n)
     */
  }

  public List<List<Integer>> levelOrder2(TreeNode root) {
    // count size
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
    return result;
    /*
     * time: O(n)
     *
     * space: O(n)
     */
  }

  public List<List<Integer>> levelOrder3(TreeNode root) {
    // DFS
    if (root == null) {
      return new LinkedList<>();
    }
    List<List<Integer>> result = new LinkedList<>();
    dfs(root, result, 0);
    return result;
    /*
     * time: O(n)
     *
     * space: O(1)
     */
  }

  private void dfs(TreeNode node, List<List<Integer>> result, int depth) {
    if (node == null) {
      return;
    }
    if (result.size() < depth + 1) {
      result.add(new LinkedList<>());
    }
    result.get(depth).add(node.val);
    dfs(node.left, result, depth + 1);
    dfs(node.right, result, depth + 1);
  }

}
