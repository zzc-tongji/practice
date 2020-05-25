package leetcode;

/*
 * 0702. Search in a Sorted Array of Unknown Size
 *
 * Given an integer array sorted in ascending order, write a function to search
 * target in nums. If target exists, then return its index, otherwise return -1.
 * However, the array size is unknown to you. You may only access the array
 * using an ArrayReader interface, where ArrayReader.get(k) returns the element
 * of the array at index k (0-indexed).
 *
 * You may assume all integers in the array are less than 10000, and if you
 * access the array out of bounds, ArrayReader.get will return 2147483647.
 *
 * Example 1:
 *
 * Input: array = [-1,0,3,5,9,12], target = 9
 *
 * Output: 4
 *
 * Explanation: 9 exists in nums and its index is 4
 *
 * Example 2:
 *
 * Input: array = [-1,0,3,5,9,12], target = 2
 *
 * Output: -1
 *
 * Explanation: 2 does not exist in nums so return -1
 *
 * Note:
 *
 * 1. You may assume that all elements in the array are unique.
 *
 * 2. The value of each element in the array will be in the range [-9999, 9999].
 */
public class _0702_SearchInASortedArrayOfUnknownSize {
  public static void main(String[] args) {
    System.out.println("Hello world.");
  }

  public int search(ArrayReader reader, int target) {
    // corner case
    if (reader == null) {
      return -1;
    }
    if (reader.get(0) == Integer.MAX_VALUE) {
      return -1;
    }
    // determine range
    int left = 0;
    int right = 1;
    while ( /* endValue != Integer.MAX_VALUE && */ reader.get(right) < target) {
      left = right;
      right <<= 1;
    }
    // binary search
    int mid = 0;
    int midValue = 0;
    while (left <= right) {
      mid = left + (right - left) / 2;
      midValue = reader.get(mid);
      if ( /* midValue != Integer.MAX_VALUE && */ midValue == target) {
        return mid;
      } else if ( /* midValue != Integer.MAX_VALUE && */ midValue < target) {
        left = mid + 1;
      } else { // midValue == Integer.MAX_VALUE || midValue > target
        right = mid - 1;
      }
    }
    return -1;
    /*
     * time: O(log n)
     *
     * space: O(1)
     */
  }
}

class ArrayReader {
  private int[] nums;

  public ArrayReader(int[] nums) {
    this.nums = nums;
  }

  public int get(int index) {
    if (nums == null || index < 0 || index >= nums.length) {
      return Integer.MAX_VALUE;
    }
    return nums[index];
  }
}
