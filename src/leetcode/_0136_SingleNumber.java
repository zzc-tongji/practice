package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * 0136. Single Number
 *
 * Given a non-empty array of integers, every element appears twice except for
 * one. Find that single one.
 *
 * Note:
 *
 * Your algorithm should have a linear runtime complexity. Could you implement
 * it without using extra memory?
 *
 * Example 1:
 *
 * Input: [2,2,1]
 *
 * Output: 1
 *
 * Example 2:
 *
 * Input: [4,1,2,1,2]
 *
 * Output: 4
 */
public class _0136_SingleNumber {
  public static void main(String[] args) {
    System.out.println("Hello world.");
  }

  public int singleNumber(int[] nums) {
    // sort and iterate
    if (nums == null || nums.length <= 0) {
      throw new IllegalArgumentException("Input is empty.");
    }
    if (nums.length == 1) {
      return nums[0];
    }
    // Input is changed.
    Arrays.sort(nums);
    int i = 1;
    while (i < nums.length) {
      if (nums[i] != nums[i - 1]) {
        return nums[i - 1];
      }
      i += 2;
    }
    try {
      return nums[i - 1];
    } catch (IndexOutOfBoundsException e) {
      throw new IllegalArgumentException("No single number is found.");
    }
  }

  public int singleNumber1(int[] nums) {
    // HashMap
    if (nums == null || nums.length < 3) {
      throw new IllegalArgumentException("Input is not valid.");
    }
    Map<Integer, Integer> m = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (m.containsKey(nums[i])) {
        m.put(nums[i], m.get(nums[i]) + 1);
      } else {
        m.put(nums[i], 1);
      }
    }
    for (int i = 0; i < nums.length; i++) {
      if (m.get(nums[i]) == 1) {
        return nums[i];
      }
    }
    throw new IllegalArgumentException("No single number is found.");
    /*
     * time: O(n)
     *
     * space: O(n)
     */
  }

  public int singleNumber2(int[] nums) {
    // HashSet
    if (nums == null || nums.length < 3) {
      throw new IllegalArgumentException("Input is not valid.");
    }
    Set<Integer> h = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      if (!h.add(nums[i])) {
        h.remove(nums[i]);
      }
    }
    try {
      return h.toArray(new Integer[0])[0];
    } catch (IndexOutOfBoundsException e) {
      throw new IllegalArgumentException("No single number is found.");
    }
    /*
     * time: O(n)
     *
     * space: O(n)
     */
  }

  public int singleNumber3(int[] nums) {
    // bit
    if (nums == null || nums.length < 3) {
      throw new IllegalArgumentException("Input is not valid.");
    }
    int res = 0;
    for (int i = 0; i < nums.length; i++) {
      res ^= nums[i];
    }
    return res;
  }
}
