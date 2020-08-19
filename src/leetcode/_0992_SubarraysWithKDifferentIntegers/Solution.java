package leetcode._0992_SubarraysWithKDifferentIntegers;

import java.util.HashMap;
import java.util.Map;

/*
 * 0992. Subarrays with K Different Integers
 *
 * Given an array A of positive integers, call a (contiguous, not necessarily
 * distinct) subarray of A good if the number of different integers in that
 * subarray is exactly K.
 *
 * (For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.)
 *
 * Return the number of good subarrays of A.
 *
 * Example 1:
 *
 * Input: A = [1,2,1,2,3], K = 2
 *
 * Output: 7
 *
 * Explanation: Subarrays formed with exactly 2 different integers: [1,2],
 * [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].
 *
 * Example 2:
 *
 * Input: A = [1,2,1,3,4], K = 3
 *
 * Output: 3
 *
 * Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3],
 * [2,1,3], [1,3,4].
 *
 * Note:
 *
 * - 1 <= A.length <= 20000
 *
 * - 1 <= A[endIndex] <= A.length
 *
 * - 1 <= K <= A.length
 */

// @lc app=leetcode id=992 lang=java
// @lc code=start
public class Solution {
  /*
   * [me]
   *
   * Amazon - 2020 new graduate - OA2
   *
   * time: O(n)
   *
   * space: O(1)
   */
  public int subarraysWithKDistinct(int[] A, int K) {
    return subarraysWithAtMostKDistinct(A, K) - subarraysWithAtMostKDistinct(A, K - 1);
  }

  int subarraysWithAtMostKDistinct(int[] A, int K) {
    Map<Integer, Integer> numberAppearance = new HashMap<>();
    int count = 0;
    int result = 0;
    int beginIndex = 0;
    for (int endIndex = 0; endIndex < A.length; endIndex++) {
      if (numberAppearance.getOrDefault(A[endIndex], 0) == 0) {
        count += 1;
      }
      numberAppearance.put(A[endIndex], numberAppearance.getOrDefault(A[endIndex], 0) + 1);
      result += endIndex - beginIndex + 1;
      while (count > K) {
        numberAppearance.put(A[beginIndex], numberAppearance.get(A[beginIndex]) - 1);
        if (numberAppearance.get(A[beginIndex]) == 0) {
          count -= 1;
        }
        beginIndex++;
        result -= 1;
      }
    }
    return result;
  }
}
// @lc code=end
