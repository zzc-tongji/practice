package techbow._0019_MaximumProductCutting;

public class Solution1 {
  /*
   * recursion
   *
   * time: O(2 ^ n)
   *
   * space: O(1)
   */

  static int maxProd(int n) {
    if (n < 2) {
      throw new IllegalArgumentException("The length must be larger than or equal to 2.");
    }
    return helper(n);
  }

  static int helper(int n) {
    if (n == 1) {
      return 1;
    }
    int left;
    int right;
    int max = 1;
    // Optimize `for (int i = 1; i <= n - 1; i++)` as the following
    // because of symmetry.
    for (int i = 1; i <= n / 2; i++) {
      // `i` is the length of the left rope.
      left = Math.max(helper(i), i); // cut vs. not cut
      right = Math.max(helper(n - i), n - i);
      max = Math.max(left * right, max);
    }
    return max;
  }

  public static void main(String[] args) {
    System.out.println(maxProd(2)); // 1
    System.out.println(maxProd(3)); // 2
    System.out.println(maxProd(4)); // 4
    System.out.println(maxProd(5)); // 6
    System.out.println(maxProd(10)); // 36
  }
}
