package leetcode;

/*
 * 0270. Closest Binary Search Tree Value
 *
 * Given a non-empty binary search tree and a target value, find the value in
 * the BST that is closest to the target.
 *
 * Note:
 *
 * Given target value is a floating point.
 *
 * You are guaranteed to have only one unique value in the BST that is closest
 * to the target.
 *
 * Example:
 *
 * Input: root = [4,2,5,1,3], target = 3.714286
 *
 *     4
 *    / \
 *   2   5
 *  / \
 * 1   3
 *
 * Output: 4
 */
public class _0270_ClosestBinarySearchTreeValue {
  public static void main(String[] args) {
    System.out.println("Hello world.");
  }

  public int closestValue(TreeNode root, double target) {
    if (root == null) {
      throw new IllegalArgumentException("It is not a tree.");
    }
    TreeNode cur = root;
    int res = root.val;
    while (cur != null) {
      if (Math.abs(cur.val - target) < Math.abs(res - target)) {
        res = cur.val;
      }
      if (isEqual(cur.val, target)) {
        return cur.val;
      }
      cur = target < cur.val ? cur.left : cur.right;
    }
    return res;
    /*
     * time: O(level)
     *
     * space: O(1)
     */
  }

  private boolean isEqual(double a, double b) {
    final double precious = 0.000001;
    return Math.abs(a - b) < precious;
  }
}
