package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
 * 0314. Binary Tree Vertical Order Traversal
 *
 * Given a binary tree, return the vertical order traversal of its nodes'
 * values. (ie, from top to bottom, column by column).
 *
 * If two nodes are in the same row and column, the order should be from left to
 * right.
 *
 * Examples 1:
 *
 * Input: [3,9,20,null,null,15,7]
 *
 *   3
 *  /\
 * /  \
 * 9  20
 *    /\
 *   /  \
 *  15   7
 *
 * Output:
 *
 * [
 *  [9],
 *  [3,15],
 *  [20],
 *  [7]
 * ]
 *
 * Examples 2:
 *
 * Input: [3,9,8,4,0,1,7]
 *
 *     3
 *    /\
 *   /  \
 *   9   8
 *  /\  /\
 * /  \/  \
 * 4  01   7
 *
 * Output:
 *
 * [
 *   [4],
 *   [9],
 *   [3,0,1],
 *   [8],
 *   [7]
 * ]
 *
 * Examples 3:
 *
 * Input: [3,9,8,4,0,1,7,null,null,null,2,5]
 *
 * (0's right child is 2 and 1's left child is 5)
 *
 *      3
 *     /\
 *    /  \
 *    9   8
 *   /\  /\
 *  /  \/  \
 *  4  01   7
 *     /\
 *    /  \
 *    5   2
 *
 * Output:
 *
 * [
 *   [4],
 *   [9,5],
 *   [3,0,1],
 *   [8,2],
 *   [7]
 * ]
 */
public class _0314_BinaryTreeVerticalOrderTraversal {
  public List<List<Integer>> verticalOrder(TreeNode root) {
    if (root == null) {
      return new LinkedList<>();
    }
    Queue<TreeNode> q = new LinkedList<>();
    Map<TreeNode, Integer> column = new HashMap<>();
    int c = 0;
    int minColumn = 0;
    int maxColumn = 0;
    List<Integer> cursor = null;
    Map<Integer, List<Integer>> resultTemp = new HashMap<>();
    TreeNode cur = null;
    //
    q.offer(root);
    column.put(root, 0);
    while (!q.isEmpty()) {
      // poll
      cur = q.poll();
      // visit
      c = column.get(cur);
      minColumn = Math.min(minColumn, c);
      maxColumn = Math.max(maxColumn, c);
      cursor = resultTemp.get(c);
      if (cursor == null) {
        cursor = new LinkedList<>();
        resultTemp.put(c, cursor);
      }
      cursor.add(cur.val);
      // offer
      if (cur.left != null) {
        q.offer(cur.left);
        column.put(cur.left, column.get(cur) - 1);
      }
      if (cur.right != null) {
        q.offer(cur.right);
        column.put(cur.right, column.get(cur) + 1);
      }
    }
    //
    List<List<Integer>> result = new LinkedList<>();
    for (int i = minColumn; i <= maxColumn; i++) {
      cursor = new LinkedList<>();
      for (int j : resultTemp.get(i)) {
        cursor.add(j);
      }
      result.add(cursor);
    }
    return result;
    /*
     * time: O(n)
     *
     * space: O(n)
     */
  }
}
