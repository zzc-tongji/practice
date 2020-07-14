package techbow._0002_PartTreeOfAnotherTree;

import leetcode.TreeNode;

public class Solution {
  public boolean isParttree(TreeNode largeTree, TreeNode smallTree) {
    // Check whether `smallTree` is a part of `largeTree`.
    //
    // check from root to leaf
    if (largeTree == null) {
      return false;
    }
    if (helper(largeTree, smallTree)) {
      return true;
    }
    return isParttree(largeTree.left, smallTree) || isParttree(largeTree.right, smallTree);
    /*
     * time: O(n log n), master theory
     *
     * space: O(1)
     */
  }

  private boolean helper(TreeNode largeTree, TreeNode smallTree) {
    // Check whether `smallTree` is a part of `largeTree`.
    if (largeTree == null && smallTree == null) {
      return true;
    }
    // Similiar as `_0572_SubtreeOfAnotherTree.java` but some difference here.
    if (largeTree != null && smallTree == null) {
      return true;
    }
    if (largeTree == null && smallTree != null) {
      return false;
    }
    if (largeTree.val != smallTree.val) {
      return false;
    }
    return helper(largeTree.left, smallTree.left) && helper(largeTree.right, smallTree.right);
  }
}
