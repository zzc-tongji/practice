package techbow._0019_MaximumProductCutting;

/*
 * https://www.geeksforgeeks.org/maximum-product-cutting-dp-36/
 *
 * Given a rope of length n meters, cut the rope in different parts of integer
 * lengths in a way that maximizes product of lengths of all parts. You must
 * make at least one cut. Assume that the length of rope is more than 2 meters.
 *
 * Examples:
 *
 * Input: n = 2
 *
 * Output: 1 (Maximum obtainable product is 1*1)
 *
 * Input: n = 3
 *
 * Output: 2 (Maximum obtainable product is 1*2)
 *
 * Input: n = 4
 *
 * Output: 4 (Maximum obtainable product is 2*2)
 *
 * Input: n = 5
 *
 * Output: 6 (Maximum obtainable product is 2*3)
 *
 * Input: n = 10
 *
 * Output: 36 (Maximum obtainable product is 3*3*4)
 */

public class Solution {
  /*
   * dfs: for every posible cut point, decide cut or not
   *
   * time: O(2 ^ n)
   *
   * space: O(1)
   */

  static int maxProd(int n) {
    if (n < 2) {
      throw new IllegalArgumentException("The length must be larger than or equal to 2.");
    }
    return dfs(n, 0, 1, 1);
  }

  static int dfs(int n, int prevCut, int cut, int productBeforePrevCut) {
    if (cut >= n) {
      if (prevCut == 0) {
        // discard the result without any cut
        return -1;
      }
      return productBeforePrevCut * (cut - prevCut);
    }
    // at the length of `cut`
    //
    // cut
    int c = dfs(n, cut, cut + 1, productBeforePrevCut * (cut - prevCut));
    // not cut
    int nc = dfs(n, prevCut, cut + 1, productBeforePrevCut);
    return Math.max(c, nc);
  }

  public static void main(String[] args) {
    System.out.println(maxProd(2)); // 1
    System.out.println(maxProd(3)); // 2
    System.out.println(maxProd(4)); // 4
    System.out.println(maxProd(5)); // 6
    System.out.println(maxProd(10)); // 36
  }
}
