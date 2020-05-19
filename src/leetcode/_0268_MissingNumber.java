package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 0268. Missing Number
 *
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find
 * the one that is missing from the array.
 *
 * Example 1:
 *
 * Input: [3,0,1]
 *
 * Output: 2
 *
 * Example 2:
 *
 * Input: [9,6,4,2,3,5,7,0,1]
 *
 * Output: 8
 *
 * Note:
 *
 * Your algorithm should run in linear runtime complexity. Could you implement
 * it using only constant extra space complexity?
 */
public class _0268_MissingNumber {
  public static void main(String[] args) {
    System.out.println("Hello world.");
  }

  public int missingNumber(int[] nums) {
    if (nums == null || nums.length == 0) {
      throw new IllegalArgumentException("The array is empty.");
    }
    Set<Integer> s = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      s.add(nums[i]);
    }
    for (int i = 0; i < nums.length + 1; i++) {
      if (!s.contains(i)) {
        return i;
      }
    }
    throw new IllegalArgumentException("There is no missing number.");
    /*
     * time: O(n)
     *
     * space: O(1)
     */
  }

  public int missingNumber1(int[] nums) {
    if (nums == null || nums.length == 0) {
      throw new IllegalArgumentException("The array is empty.");
    }
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
    }
    return (0 + nums.length) * (nums.length + 1) / 2 - sum;
    /*
     * time: O(n)
     *
     * space: O(1)
     */
  }

  public int missingNumber2(int[] nums) {
    if (nums == null || nums.length == 0) {
      throw new IllegalArgumentException("The array is empty.");
    }
    int res = 0;
    for (int i = 0; i < nums.length; i++) {
      res ^= nums[i];
    }
    for (int i = 0; i < nums.length + 1; i++) {
      res ^= i;
    }
    return res;
    /*
     * time: O(n)
     *
     * space: O(1)
     */
  }
}
