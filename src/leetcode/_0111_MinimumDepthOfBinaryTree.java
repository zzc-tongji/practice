package leetcode;

/*
 * 0111. Minimum Depth of Binary Tree
 *
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the
 * root node down to the nearest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *   3
 *  / \
 * 9  20
 *   /  \
 *  15   7
 *
 * return its minimum depth = 2.
 */
public class _0111_MinimumDepthOfBinaryTree {
  public static void main(String[] args) {
    System.out.println("Hello world.");
  }

  public int minDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int leftDepth = minDepth(root.left);
    int rightDepth = minDepth(root.right);
    // if (root.left == null) {
    // return rightDepth + 1;
    // }
    // if (root.right == null) {
    // return leftDepth + 1;
    // }
    // return Math.min(leftDepth, rightDepth) + 1;
    return (root.left == null || root.right == null) ? leftDepth + rightDepth + 1 : Math.min(leftDepth, rightDepth) + 1;
    /*
     * time: O(n), master theory
     *
     * space: O(1)
     */
  }
}
