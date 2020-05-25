package leetcode;

/*
 * 0050. Pow(x, n)
 *
 * Implement pow(x, n), which calculates x raised to the power n (x ^ n).
 *
 * Example 1:
 *
 * Input: 2.00000, 10
 *
 * Output: 1024.00000
 *
 * Example 2:
 *
 * Input: 2.10000, 3
 *
 * Output: 9.26100
 *
 * Example 3:
 *
 * Input: 2.00000, -2
 *
 * Output: 0.25000
 *
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 *
 * Note:
 *
 * - -100.0 < x < 100.0
 *
 * - n is a 32-bit signed integer, within the range [− 2 ^ 31, 2 ^ 31 − 1]
 */
public class _0050_PowXN {
  public static void main(String[] args) {
    System.out.println("Hello world.");
  }

  public double myPow(double x, int n) {
    // If `n` is `Integer.MIN_VALUE`, `-n` will overflow.
    // So it is necessary to convert `n` from `int` to `long`.
    return helper(x, (long) n);
  }

  private double helper(double x, long n) {
    // corner case
    if (x == 0 && n == 0) {
      return 1;
    }
    if (x == 0) {
      return 0;
    }
    if (x == 1) {
      return 1;
    }
    if (x == -1) {
      return n % 2 == 1 ? -1 : 1;
    }
    if (n == 0) {
      return 1;
    }
    if (n == 1) {
      return x;
    }
    if (n == -1) {
      return 1 / x;
    }
    // recursion
    if (n < 0) {
      return 1 / helper(x, -n);
    }
    double temp = helper(x, n / 2);
    if (n % 2 == 1) {
      return temp * temp * x;
    }
    return temp * temp;
    /*
     * time: O(log n)
     *
     * space: O(1)
     */
  }

  public double myPow1(double x, int n) {
    return helper1(x, (long) n);
  }

  private double helper1(double x, long n) {
    // LeetCode: Time Limit Exceeded
    //
    // corner case
    if (x == 0 && n == 0) {
      return 1;
    }
    if (x == 0) {
      return 0;
    }
    if (x == 1) {
      return 1;
    }
    if (x == -1) {
      return n % 2 == 1 ? -1 : 1;
    }
    if (n == 0) {
      return 1;
    }
    if (n == 1) {
      return x;
    }
    if (n == -1) {
      return 1 / x;
    }
    // recursion
    if (n < 0) {
      return 1 / helper1(x, -n);
    }
    if (n % 2 == 1) {
      return helper1(x, n / 2) * helper1(x, n / 2) * x;
    }
    return helper1(x, n / 2) * helper1(x, n / 2);
    /*
     * time: O(log n)
     *
     * space: O(1)
     */
  }

  public double myPow2(double x, int n) {
    return helper2(x, (long) n);
  }

  private double helper2(double x, long n) {
    // LeetCode: Time Limit Exceeded
    //
    // corner case
    if (x == 0 && n == 0) {
      return 1;
    }
    if (x == 0) {
      return 0;
    }
    if (x == 1) {
      return 1;
    }
    if (x == -1) {
      return n % 2 == 1 ? -1 : 1;
    }
    if (n == 0) {
      return 1;
    }
    if (n == 1) {
      return x;
    }
    if (n == -1) {
      return 1 / x;
    }
    // iteration
    boolean minus = n < 0;
    long n_ = minus ? -n : n;
    double res = 1;
    for (long i = 0; i < n_; i++) {
      res *= x;
    }
    return minus ? 1 / res : res;
    /*
     * time: O(n)
     *
     * space: O(1)
     */
  }
}
