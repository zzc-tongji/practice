package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * 0145. Binary Tree Inorder Traversal
 *
 * Given a binary tree, return the inorder traversal of its nodes' values.
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
 * Output: [1,3,2]
 *
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class _0094_BinaryTreeInorderTraversal {
  public static void main(String[] args) {
    System.out.println("Hello world.");
  }

  private List<Integer> result = new ArrayList<>();

  public List<Integer> inorderTraversal(TreeNode root) {
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
    helper(root.left);
    result.add(root.val);
    helper(root.right);
  }

  public List<Integer> inorderTraversalIteration(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    if (root == null) {
      return ans;
    }
    Stack<TreeNode> st = new Stack<>();
    while (root != null || !st.isEmpty()) {
      if (root == null) {
        root = st.pop();
        ans.add(root.val);
        root = root.right;
      } else {
        st.push(root);
        root = root.left;
      }
    }
    // pop add right - push left
    return ans;
    /*
     * time: O(n)
     *
     * space: O(n)
     */
  }
}
