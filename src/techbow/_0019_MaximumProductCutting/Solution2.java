package techbow._0019_MaximumProductCutting;

public class Solution2 {
  /*
   * DP
   *
   * time: O(n ^ 2)
   *
   * space: O(1)
   */

  static int maxProd(int n) {
    if (n < 2) {
      throw new IllegalArgumentException("The length must be larger than or equal to 2.");
    }
    // `dp[i]` is the maximum product of two parts
    // when handling the rope of i length with just one cut.
    int[] dp = new int[n + 1];
    dp[1] = 1;
    int left;
    int right;
    for (int i = 2; i <= n; i++) {
      for (int j = 1; j <= i / 2; j++) {
        left = Math.max(dp[j], j); // cut vs. not cut
        right = Math.max(dp[i - j], i - j);
        dp[i] = Math.max(left * right, dp[i]);
      }
    }
    return dp[n];
  }

  public static void main(String[] args) {
    System.out.println(maxProd(2)); // 1
    System.out.println(maxProd(3)); // 2
    System.out.println(maxProd(4)); // 4
    System.out.println(maxProd(5)); // 6
    System.out.println(maxProd(10)); // 36
  }
}
