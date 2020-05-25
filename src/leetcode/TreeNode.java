package leetcode;

/*
 * Definition for a binary tree node.
 *
 * Convert a binary tree to an array:
 *
 * 1. Use `null` supplement the tree to a complete binary tree.
 *
 * 2. Treat the complete binary tree as a binary heap, and write down its array
 * form.
 *
 * 3. Remove all continuous `null` will in the end.
 *
 * 4. Remove all continuous two `null` in the middle.
 *
 * Convert an array to an array:
 *
 * - Execute inorder traverse to generate the binary tree.
 *
 * - When `null` appears, jump to the right subtree.
 *
 * Mode details:
 *
 * https://support.leetcode.com/hc/en-us/articles/360011883654-What-does-1-null-2-3-mean-in-binary-tree-representation-
 *
 * The binary search tree (BST) does NOT include binary trees with duplicate
 * (value) node.
 */
public class TreeNode {
  public int val;
  public TreeNode parent;
  public TreeNode left;
  public TreeNode right;

  TreeNode() {
    this(0, null, null, null);
  }

  TreeNode(int val) {
    this(val, null, null, null);
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this(val, left, right, null);
  }

  TreeNode(int val, TreeNode left, TreeNode right, TreeNode parent) {
    this.val = val;
    this.left = left;
    this.right = right;
    this.parent = parent;
  }
}
