package leetcode;

/*
 * 0110. Balanced Binary Tree
 *
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as:
 *
 * a binary tree in which the depth of the two subtrees of every node never
 * differ by more than 1.
 *
  * Example 1:
 *
 * Given the following tree [3,9,20,null,null,15,7]:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * Return true.
 *
 * Example 2:
 *
 * Given the following tree [1,2,2,3,3,null,null,4,4]:
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 *
 * Return false.
 */
public class _0110_BalancedBinaryTree {
  public static void main(String[] args) {
    System.out.println("Hello world.");
  }

  public boolean isBalanced(TreeNode root) {
    if (root == null) {
      // LeetCode: Accept
      return true;
      // It is better to throw exception.
      // throw new IllegalArgumentException("It is not a tree.");
    }
    if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1) {
      return false;
    }
    return isBalanced(root.left) && isBalanced(root.right);
    /*
     * time: O(n log n), master theory
     *
     * space: O(1)
     */
  }

  private int getHeight(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
  }

  public boolean isBalanced1(TreeNode root) {
    if (root == null) {
      // LeetCode: Accept
      return true;
      // It is better to throw exception.
      // throw new IllegalArgumentException("It is not a tree.");
    }
    if (getHeight1(root.left) == -1 || getHeight1(root.right) == -1) {
      return false;
    }
    return isBalanced1(root.left) && isBalanced1(root.right);
    /*
     * time: O(n), master theory
     *
     * space: O(1)
     */
  }

  private int getHeight1(TreeNode root) {
    // modified method to get height
    if (root == null) {
      return 0;
    }
    int leftHeight = getHeight1(root.left);
    int rightHeight = getHeight1(root.right);
    if (Math.abs(leftHeight - rightHeight) > 1) {
      // If not balenced, return -1.
      return -1;
    }
    return Math.max(leftHeight, rightHeight) + 1;
  }
}
