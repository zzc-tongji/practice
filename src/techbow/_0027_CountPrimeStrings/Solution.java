package techbow._0027_CountPrimeStrings;

import java.util.ArrayList;
import java.util.List;

/*
 * Amazon - 2020 new graduate - OA2
 *
 * Amazon's operations team needs an algorithm that can break out a list of
 * products for a given order. The products in the order are listed as a string
 * and the order items are represented as prime numbers. Given a string
 * consisting of digits [0-9]. count the number of ways the given string can be
 * split into prime numbers, which represent unique items in the order. The
 * digits must remain in the order given and the entire string must be used
 *
 * Write an algorithm to find the number of ways the given string can be split
 * into unique prime numbers using the entire string. Input
 *
 * The input to the function/method consists of an argument:
 *
 * inputString, a string representing the input string
 *
 * Output
 *
 * Return an integer representing the number of ways the given string can be
 * split into unique primes using the entire string.
 *
 * Note
 *
 * The inputString does not contain leading zeros.
 *
 * Each number split of the given number must be in the range 2 to 10 ^ 6
 * inclusive.
 *
 * Since the answer can be large, return the answer modulo (1000000007)
 *
 * Constraints
 *
 * 1 <= length of inputString <= 10 ^ 5
 */

public class Solution {
  /*
   * Use DFS to get all results and then count.
   *
   * time: O(n ^ 3)
   *
   * space: O(n)
   */

  private static int countPrimeStrings(String inputString) {
    // validate
    Long.parseLong(inputString);
    // main
    List<String> temp = new ArrayList<>();
    List<List<String>> result = new ArrayList<>();
    dfs(inputString, 0, inputString.length() - 1, temp, result);
    return result.size() % 1000000007;
  }

  private static void dfs(String s, int beginIndex, int endIndex, List<String> temp, List<List<String>> result) {
    if (beginIndex > endIndex) {
      result.add(new ArrayList<>(temp));
      temp = new ArrayList<>();
      return;
    }
    for (int i = beginIndex; i <= endIndex; i++) {
      if (isPrime(s, beginIndex, i)) {
        temp.add(s.substring(beginIndex, i + 1));
        dfs(s, i + 1, endIndex, temp, result);
        temp.remove(temp.size() - 1);
      }
    }
  }

  private static boolean isPrime(String s, int beginIndex, int endIndex) {
    long number = Long.parseLong(s.substring(beginIndex, endIndex + 1));
    if (number <= 1) {
      return false;
    }
    if (number == 2) {
      return true;
    }
    for (long i = 2; i * i <= number; i++) {
      if (number % i == 0) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    // 6
    //
    // (11, 3, 7, 3)
    // (113, 7, 3)
    // (11, 3, 73)
    // (11, 37, 3)
    // (113, 73)
    // (11, 373)
    System.out.println(countPrimeStrings("11373"));
  }
}
