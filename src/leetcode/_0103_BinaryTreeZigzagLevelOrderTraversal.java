package leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/*
 * 0103. Binary Tree Zigzag Level Order Traversal
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes'
 * values. (ie, from left to right, then right to left for the next level and
 * alternate between).
 *
 * For example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *    3
 *   / \
 *  9  20
 *    /  \
 *   15   7
 * return its zigzag level order traversal as:
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
public class _0103_BinaryTreeZigzagLevelOrderTraversal {
  public static void main(String[] args) {
    System.out.println("Hello world.");
  }

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    // count size & reverse
    if (root == null) {
      return new LinkedList<>();
    }
    Queue<TreeNode> q = new LinkedList<>();
    LinkedList<Integer> cursor = null;
    List<List<Integer>> result = new LinkedList<>();
    int size = 0;
    TreeNode cur = null;
    int levelIndex = 0;
    //
    q.offer(root);
    while (!q.isEmpty()) {
      cursor = new LinkedList<>();
      result.add(cursor);
      size = q.size();
      for (int i = 0; i < size; i++) {
        // poll
        cur = q.poll();
        // visit: zig-zag
        if (levelIndex % 2 == 0) {
          cursor.add(cur.val); // normal
        } else {
          cursor.addFirst(cur.val); // reverse
        }
        // offer
        if (cur.left != null) {
          q.offer(cur.left);
        }
        if (cur.right != null) {
          q.offer(cur.right);
        }
      }
      // zig-zag
      levelIndex += 1;
    }
    return result;
    /*
     * time: O(n)
     *
     * space: O(n)
     */
  }

  public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
    // dual stack
    if (root == null) {
      return new LinkedList<>();
    }
    List<Stack<TreeNode>> stackList = new Stack<>();
    stackList.add(new Stack<>());
    stackList.add(new Stack<>());
    int selector = 0;
    List<Integer> cursor = null;
    List<List<Integer>> result = new LinkedList<>();
    TreeNode cur = null;
    //
    stackList.get(selector).add(root);
    while (!stackList.get(0).isEmpty() || !stackList.get(1).isEmpty()) {
      // add level
      cursor = new LinkedList<>();
      result.add(cursor);
      while (!stackList.get(selector).isEmpty()) {
        // poll
        cur = stackList.get(selector).pop();
        // visit
        cursor.add(cur.val);
        // offer
        if (selector % 2 == 0) {
          // even level index - first left then right
          if (cur.left != null) {
            stackList.get((selector + 1) % 2).push(cur.left);
          }
          if (cur.right != null) {
            stackList.get((selector + 1) % 2).push(cur.right);
          }
        } else {
          // odd level index - first right then left
          if (cur.right != null) {
            stackList.get((selector + 1) % 2).push(cur.right);
          }
          if (cur.left != null) {
            stackList.get((selector + 1) % 2).push(cur.left);
          }
        }
      }
      // switch stack
      selector = (selector + 1) % 2;
    }
    return result;
    /*
     * time: O(n)
     *
     * space: O(n)
     */
  }

  public List<List<Integer>> zigzagLevelOrder3(TreeNode root) {
    // count size & deque
    if (root == null) {
      return new LinkedList<>();
    }
    Deque<TreeNode> q = new LinkedList<>();
    List<Integer> cursor = null;
    List<List<Integer>> result = new LinkedList<>();
    int size = 0;
    TreeNode cur = null;
    int levelIndex = 0;
    //
    q.offerLast(root);
    while (!q.isEmpty()) {
      cursor = new LinkedList<>();
      result.add(cursor);
      size = q.size();
      for (int i = 0; i < size; i++) {
        if (levelIndex % 2 == 0) {
          // even level index - normal
          //
          // poll
          cur = q.pollLast();
          // visit
          cursor.add(cur.val);
          // offer
          if (cur.left != null) {
            q.offerFirst(cur.left);
          }
          if (cur.right != null) {
            q.offerFirst(cur.right);
          }
        } else {
          // odd level index - reverse
          //
          // poll
          cur = q.pollFirst();
          // visit
          cursor.add(cur.val);
          // offer
          if (cur.right != null) {
            q.offerLast(cur.right);
          }
          if (cur.left != null) {
            q.offerLast(cur.left);
          }
        }
      }
      // zig-zag
      levelIndex += 1;
    }
    return result;
    /*
     * time: O(n)
     *
     * space: O(n)
     */
  }
}
