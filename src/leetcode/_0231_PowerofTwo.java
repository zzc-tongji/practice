package leetcode;

/**
 * 0231. Power of Two
 *
 * Given an integer, write a function to determine if it is a power of two.
 *
 * Example 1:
 *
 * Input: 1
 *
 * Output: true
 *
 * Explanation: 2^0 = 1
 *
 * Example 2:
 *
 * Input: 16
 *
 * Output: true
 *
 * Explanation: 2^4 = 16
 *
 * Example 3:
 *
 * Input: 218
 *
 * Output: false
 */
public class _0231_PowerofTwo {
  public static void main(String[] args) {
    System.out.println("Hello world.");
  }

  public boolean isPowerOfTwo(int n) {
    // large => small
    if (n <= 0) {
      return false;
    }
    if (n == 1) {
      return true;
    }
    if (n % 2 != 0) {
      return false;
    }
    return isPowerOfTwo(n / 2);
    /*
     * time: O(n log n)
     *
     * space: O(1)
     */
  }

  public boolean isPowerOfTwo1(int n) {
    // small => large
    if (n <= 0) {
      return false;
    }
    // use long to avoid int overflow
    long temp = 1;
    while (temp <= n) {
      if ((temp ^ n) == 0) { // temp == n
        return true;
      }
      temp <<= 1; // temp *= 2
    }
    return false;
    /*
     * time: O(n log n)
     *
     * space: O(1)
     */
  }

  public boolean isPowerOfTwo2(int n) {
    // hamming weight == 1
    if (n <= 0) {
      return false;
    }
    int counter = 0;
    for (int i = 0; i < 32; i++) {
      if (n == 0) {
        break;
      }
      if ((n & 1) != 0) {
        counter += 1;
      }
      n >>>= 1;
    }
    return (counter == 1);
    /*
     * time: O(1)
     *
     * space: O(1)
     */
  }

  public boolean isPowerOfTwo3(int n) {
    // m <= n are both powers of two <==> n % m == 0
    if (n <= 0) {
      return false;
    }
    return ((1 << 30) % n) == 0;
    /*
     * time: O(1)
     *
     * space: O(1)
     */
  }

  public boolean isPowerOfTwo4(int n) {
    // hamming weight == 1 <==> (n & (n - 1)) == 0
    //
    // Niubility!!!
    return n > 0 && (n & (n - 1)) == 0;
    /*
     * time: O(1)
     *
     * space: O(1)
     */
  }
}
