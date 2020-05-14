package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * 0144. Binary Tree Preorder Traversal
 *
 * Given a binary tree, return the preorder traversal of its nodes' values.
 *
 * Example:
 *
 * Input: [1,null,2,3]
 *
 * 1
 *  \
 *   2
 *  /
 * 3
 *
 * Output: [1,2,3]
 */
public class _0144_BinaryTreePreorderTraversal {
  public static void main(String[] args) {
    System.out.println("Hello world.");
  }

  private List<Integer> result = new ArrayList<>();

  public List<Integer> preorderTraversal(TreeNode root) {
    helper(root);
    return result;
    /*
     * time: O(n)
     *
     * space: O(1)
     */
  }

  private void helper(TreeNode root) {
    if (root == null) {
      return;
    }
    result.add(root.val);
    helper(root.left);
    helper(root.right);
  }

  public List<Integer> preorderTraversalIteration(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    if (root == null) {
      return ans;
    }
    Stack<TreeNode> st = new Stack<>();
    while (root != null || !st.isEmpty()) {
      if (root == null) {
        root = st.pop();
        root = root.right;
      } else {
        st.push(root);
        ans.add(root.val);
        root = root.left;
      }
    }
    // pop right - push add left
    return ans;
    /*
     * time: O(n)
     *
     * space: O(n)
     */
  }
}
