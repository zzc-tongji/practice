package leetcode;

/*
 * 0226. Invert Binary Tree
 *
 * Invert a binary tree.
 *
 * Example:
 *
 * Input:
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 *
 * Output:
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * Trivia:
 *
 * This problem was inspired by this original tweet by Max Howell:
 *
 * Google: 90% of our engineers use the software you wrote (Homebrew), but you
 * can’t invert a binary tree on a whiteboard so fuck off.
 */
public class _0226_InvertBinaryTree {
  public static void main(String[] args) {
    System.out.println("Hello world.");
  }

  public TreeNode invertTree(TreeNode root) {
    // revert from leaf to root
    if (root == null) {
      return null;
    }
    // Use temporary variables to cache the result.
    // Do not directly assign.
    TreeNode left = invertTree(root.left);
    TreeNode right = invertTree(root.right);
    root.left = right;
    root.right = left;
    return root;
    /*
     * time: O(n)
     *
     * space: O(1)
     */
  }

  public TreeNode invertTree1(TreeNode root) {
    // revert from root to leaf
    if (root == null) {
      return null;
    }
    // Use temporary variables to cache the result.
    // Do not directly assign.
    TreeNode temp = root.left;
    root.left = root.right;
    root.right = temp;
    invertTree1(root.left);
    invertTree1(root.right);
    return root;
    /*
     * time: O(n)
     *
     * space: O(1)
     */
  }
}
