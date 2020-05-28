package leetcode;

/**
 * 0007. Reverse Integer
 *
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1:
 *
 * Input: 123
 *
 * Output: 321 Example 2:
 *
 * Input: -123
 *
 * Output: -321
 *
 * Example 3:
 *
 * Input: 120
 *
 * Output: 21
 *
 * Note:
 *
 * Assume we are dealing with an environment which could only store integers
 * within the 32-bit signed integer range: [−231, 231 − 1]. For the purpose of
 * this problem, assume that your function returns 0 when the reversed integer
 * overflows.
 */
public class _0007_ReverseInteger {
  public static void main(String[] args) {
    System.out.println("Hello world.");
  }

  public int reverse(int x) {
    if (x >= -9 && x <= 9) {
      return x;
    }
    long temp = x;
    boolean sign = temp < 0;
    temp = Math.abs(temp);
    // deal with overflow
    long res = 0;
    while (temp != 0) {
      res = res * 10 + temp % 10;
      temp /= 10;
    }
    res = sign ? -res : res;
    if (res >= Integer.MIN_VALUE && res <= Integer.MAX_VALUE) {
      return (int) res;
    }
    // overflow
    return 0;
    /*
     * time: O(decimal bit of n) = O(log(abs(n)))
     *
     * space: O(1)
     */
  }
}
