package leetcode;

/*
 * 0951. Flip Equivalent Binary Trees
 *
 * For a binary tree T, we can define a flip operation as follows: choose any
 * node, and swap the left and right child subtrees.
 *
 * A binary tree X is flip equivalent to a binary tree Y if and only if we can
 * make X equal to Y after some number of flip operations.
 *
 * Write a function that determines whether two binary trees are flip
 * equivalent. The trees are given by root nodes root1 and root2.
 *
 * Example 1:
 *
 * Input:
 *
 * root1 = [1,2,3,4,5,6,null,null,null,7,8]
 *
 * root2 = [1,3,2,null,6,4,5,null,null,null,null,8,7]
 *
 * Output: true
 *
 * Explanation: We flipped at nodes with values 1, 3, and 5.
 *
 * https://assets.leetcode.com/uploads/2018/11/29/tree_ex.png
 *
 * Note:
 *
 * - Each tree will have at most 100 nodes.
 *
 * - Each value in each tree will be a unique integer in the range [0, 99].
 */
public class _0951_FlipEquivalentBinaryTrees {
  public boolean flipEquiv(TreeNode root1, TreeNode root2) { // niu a niy
    // It is the same problem as "LintCode 470. Tweaked Identical Binary Tree"
    // which also named as "niu a niu".
    //
    // check from root to leaf
    if (root1 == null && root2 == null) {
      return true;
    }
    if (root1 == null || root2 == null) {
      return false;
    }
    if (root1.val != root2.val) {
      // Don't worry here. Flipping is embodied in the `return` statement.
      return false;
    }
    // Similiar as `_0100_SameTree.java` but some difference here.
    return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right))
        || (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
    /*
     * time: O(n ^ 2), master theory
     *
     * space: O(1)
     */
  }
}
