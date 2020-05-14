package leetcode;

/* 0101. Symmetric Tree
 *
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric
 * around its center).
 *
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 * But the following [1,2,2,null,3,null,3] is not:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * Note:
 *
 * Bonus points if you could solve it both recursively and iteratively.
 */
public class _0101_SymmetricTree {
  public static void main(String[] args) {
    System.out.println("Hello world.");
  }

  public boolean isSymmetric(TreeNode root) {
    return root == null ? true : mirror(root.left, root.right);
    /*
     * time: O(n)
     *
     * space: O(1)
     */
  }

  private boolean mirror(TreeNode leftTree, TreeNode rightTree) {
    if (leftTree == null && rightTree == null) {
      return true;
    }
    if (leftTree == null || rightTree == null) {
      return false;
    }
    if (leftTree.val != rightTree.val) {
      return false;
    }
    return mirror(leftTree.left, rightTree.right) && mirror(leftTree.right, rightTree.left);
  }
}
