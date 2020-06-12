package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/*
 * 0145. Binary Tree Postorder Traversal
 *
 * Given a binary tree, return the postorder traversal of its nodes' values.
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
 * Output: [3,2,1]
 *
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class _0145_BinaryTreePostorderTraversal {
  private List<Integer> result = new ArrayList<>();

  public List<Integer> postorderTraversal(TreeNode root) {
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
    helper(root.right);
    result.add(root.val);
  }

  public List<Integer> postorderTraversalIteration(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    if (root == null) {
      return ans;
    }
    Stack<TreeNode> st = new Stack<>();
    while (root != null || !st.isEmpty()) {
      if (root == null) {
        root = st.pop();
        root = root.left;
      } else {
        ans.add(root.val);
        st.push(root);
        root = root.right;
      }
    }
    Collections.reverse(ans);
    // pop left - add push right - reverse
    return ans;
    /*
     * time: O(n)
     *
     * space: O(n)
     */
  }
}
