package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 0098. Validate Binary Search Tree
 *
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's
 * key. The right subtree of a node contains only nodes with keys greater than
 * the node's key. Both the left and right subtrees must also be binary search
 * trees.
 *
 * Example 1:
 *
 *     2
 *    / \
 *   1   3
 *
 * Input: [2,1,3]
 *
 * Output: true
 *
 * Example 2:
 *
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 *
 * Input: [5,1,4,null,null,3,6]
 *
 * Output: false
 *
 * Explanation: The root node's value is 5 but its right child's value is 4.
 */
public class _0098_ValidateBinarySearchTree {
  public static void main(String[] args) {
    System.out.println("Hello world.");
  }

  List<Integer> array;
  long prev;

  public boolean isValidBST(TreeNode root) {
    // from root to leaf
    if (root == null) {
      // LeetCode: Accept
      return true;
      // It is better to throw exception.
      // throw new IllegalArgumentException("It is not a tree.");
    }
    return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    /*
     * time: O(n)
     *
     * space: O(1)
     */
  }

  private boolean helper(TreeNode node, long floor, long cell) { // long
    // from root to leaf
    //
    // Use type `long` rather than int
    // to cover conercase `Integer.MIN_VALUE` and `Interger.MAX_VALUE`.
    if (node == null) {
      return true;
    }
    if (node.val <= floor || node.val >= cell) {
      return false;
    }
    return helper(node.left, floor, (long) node.val) && helper(node.right, (long) node.val, cell);
  }

  public boolean isValidBST1(TreeNode root) {
    // from root to leaf
    if (root == null) {
      // LeetCode: Accept
      return true;
      // It is better to throw exception.
      // throw new IllegalArgumentException("It is not a tree.");
    }
    return helper1(root, null, null);
    /*
     * time: O(n)
     *
     * space: O(1)
     */
  }

  private boolean helper1(TreeNode node, Integer floor, Integer cell) { // Integer
    // from root to leaf
    //
    // Use Integer instead of long.
    if (node == null) {
      return true;
    }
    // Use type `integer` rather than type `int`.
    //
    // If `null` is parsed, `<=` and `>=` will always false
    // and range check will be skipped.
    if (node.val <= floor || node.val >= cell) {
      return false;
    }
    return helper1(node.left, floor, node.val) && helper1(node.right, node.val, cell);
  }

  public boolean isValidBST2(TreeNode root) {
    // from leaf to root
    if (root == null) {
      // LeetCode: Accept
      return true;
      // It is better to throw exception.
      // throw new IllegalArgumentException("It is not a tree.");
    }
    return helper2(root) != null;
    /*
     * time: O(n)
     *
     * space: O(1)
     */
  }

  private List<Integer> helper2(TreeNode node) {
    // from leaf to root
    //
    // possible returns:
    //
    // - null = the tree is not a BST
    // - [null, null] = null node
    // - [a, b] = the range of tree value is [a, b]
    if (node == null) {
      // null node ==> return [null, null]
      return new ArrayList<>(Arrays.asList(null, null));
    }
    List<Integer> leftRange = helper2(node.left);
    List<Integer> rightRange = helper2(node.right);
    if (leftRange == null || rightRange == null) {
      // skip
      return null;
    }
    if (leftRange.get(0) == null && rightRange.get(0) == null) {
      // leaf
      return new ArrayList<>(Arrays.asList(node.val, node.val));
    }
    if (leftRange.get(0) == null) {
      // empty left subtree
      if (node.val < rightRange.get(0)) {
        return new ArrayList<>(Arrays.asList(node.val, rightRange.get(1)));
      }
      return null;
    }
    if (rightRange.get(0) == null) {
      // empty right subtree
      if (node.val > leftRange.get(1)) {
        return new ArrayList<>(Arrays.asList(leftRange.get(0), node.val));
      }
      return null;
    }
    // non-empty subtrees
    if (node.val > leftRange.get(1) && node.val < rightRange.get(0)) {
      return new ArrayList<>(Arrays.asList(leftRange.get(0), rightRange.get(1)));
    }
    return null;
  }

  public boolean isValidBST3(TreeNode root) {
    // from leaf to root
    if (root == null) {
      // LeetCode: Accept
      return true;
      // It is better to throw exception.
      // throw new IllegalArgumentException("It is not a tree.");
    }
    return helper3(root) != null;
    /*
     * time: O(n)
     *
     * space: O(1)
     */
  }

  private Integer[] helper3(TreeNode node) {
    // from leaf to root
    //
    // Use Array instead of ArrayList to make faster.
    //
    // possible returns:
    //
    // - null = the tree is not a BST
    // - [null, null] = null node
    // - [a, b] = the range of tree value is [a, b]
    if (node == null) {
      // null node ==> return [null, null]
      return new Integer[] { null, null };
    }
    Integer[] leftRange = helper3(node.left);
    Integer[] rightRange = helper3(node.right);
    if (leftRange == null || rightRange == null) {
      // skip
      return null;
    }
    if (leftRange[0] == null && rightRange[0] == null) {
      // leaf
      return new Integer[] { node.val, node.val };
    }
    if (leftRange[0] == null) {
      // empty left subtree
      if (node.val < rightRange[0]) {
        return new Integer[] { node.val, rightRange[1] };
      }
      return null;
    }
    if (rightRange[0] == null) {
      // empty right subtree
      if (node.val > leftRange[1]) {
        return new Integer[] { leftRange[0], node.val };
      }
      return null;
    }
    // non-empty subtrees
    if (node.val > leftRange[1] && node.val < rightRange[0]) {
      return new Integer[] { leftRange[0], rightRange[1] };
    }
    return null;
  }

  public boolean isValidBST4(TreeNode root) {
    // inorder ascending property
    if (root == null) {
      // LeetCode: Accept
      return true;
      // It is better to throw exception.
      // throw new IllegalArgumentException("It is not a tree.");
    }
    array = new ArrayList<>();
    helper4(root);
    if (array.size() <= 1) {
      return true;
    }
    // check ascending
    for (int i = 1; i < array.size(); i++) {
      if (array.get(i) <= array.get(i - 1)) {
        return false;
      }
    }
    return true;
    /*
     * time: O(n)
     *
     * space: O(n)
     */
  }

  private void helper4(TreeNode node) {
    // inorder ascending property
    if (node == null) {
      return;
    }
    helper4(node.left);
    array.add(node.val);
    helper4(node.right);
  }

  public boolean isValidBST5(TreeNode root) {
    // inorder ascending property
    //
    // Use realtime comparing to save some space (maybe some time).
    if (root == null) {
      // LeetCode: Accept
      return true;
      // It is better to throw exception.
      // throw new IllegalArgumentException("It is not a tree.");
    }
    prev = Long.MIN_VALUE;
    return helper5(root);
    /*
     * time: O(n)
     *
     * space: O(1)
     */
  }

  private boolean helper5(TreeNode node) {
    // inorder ascending property
    if (node == null) {
      return true;
    }
    //
    boolean isLeftBst = helper5(node.left);
    if (!isLeftBst) {
      return false;
    }
    //
    if (node.val <= prev) {
      return false;
    }
    prev = node.val;
    //
    boolean isRightBst = helper5(node.right);
    if (!isRightBst) {
      return false;
    }
    return true;
  }
}
