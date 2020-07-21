package techbow._0019_MaximumProductCutting;

public class Solution3 {
  /*
   * math
   *
   * time: O(n)
   *
   * space: O(1)
   */

  static int maxProd(int n) {
    if (n < 2) {
      throw new IllegalArgumentException("The length must be larger than or equal to 2.");
    }
    if (n == 2) {
      return 1;
    }
    if (n == 3) {
      return 2;
    }
    if (n == 4) {
      return 4;
    }
    int div = n / 3;
    int mod = n % 3;
    switch (mod) {
      case 0:
        return pow(3, div);
      case 1:
        return pow(3, div - 1) * 4;
      default: // 2
        return pow(3, div) * 2;
    }
  }

  private static int pow(int a, int b) {
    int res = 1;
    for (int i = 0; i < b; i++) {
      res *= a;
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println(maxProd(2)); // 1
    System.out.println(maxProd(3)); // 2
    System.out.println(maxProd(4)); // 4
    System.out.println(maxProd(5)); // 6
    System.out.println(maxProd(10)); // 36
  }
}
