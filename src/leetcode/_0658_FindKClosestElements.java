package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 0658. Find K Closest Elements
 *
 * Given a sorted array, two integers k and x, find the k closest elements to x
 * in the array. The result should also be sorted in ascending order. If there
 * is a tie, the smaller elements are always preferred.
 *
 * Example 1:
 *
 * Input: [1,2,3,4,5], k=4, x=3
 *
 * Output: [1,2,3,4]
 *
 * Example 2:
 *
 * Input: [1,2,3,4,5], k=4, x=-1
 *
 * Output: [1,2,3,4]
 *
 * Note:
 *
 * 1. The value k is positive and will always be smaller than the length of the
 * sorted array.
 *
 * 2. Length of the given array is positive and will not exceed 104
 *
 * 3. Absolute value of elements in the array and x will not exceed 104
 *
 * UPDATE (2017/9/19):
 *
 * The arr parameter had been changed to an array of integers (instead of a list
 * of integers). Please reload the code definition to get the latest changes.
 */
public class _0658_FindKClosestElements {
  public static void main(String[] args) {
    System.out.println("Hello world.");
  }

  public List<Integer> findClosestElements(int[] arr, int k, int x) {
    if (arr == null || arr.length <= 0) {
      return null;
    }
    int index = findClosestIndex(arr, x);
    List<Integer> res = new ArrayList<>();
    res.add(arr[index]);
    k -= 1;
    int left = index - 1;
    int right = index + 1;
    while (k > 0) {
      if (left < 0) {
        res.add(arr[right]);
        right += 1;
      } else if (right >= arr.length) {
        res.add(0, arr[left]); // prepend left inorder to "sorted result"
        left -= 1;
      } else {
        // Both left and right are in the range.
        //
        // The situation of both out is excluded by the problem discription ("The value
        // k is positive and will always be smaller than the length of the sorted
        // array".)
        if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) { // left preferred
          res.add(0, arr[left]); // prepend left inorder to "sorted result"
          left -= 1;
        } else {
          res.add(arr[right]);
          right += 1;
        }
      }
      k -= 1;
    }
    return res;
  }

  private int findClosestIndex(int[] arr, int x) {
    // find the closest item and return index, left preferred
    if (arr == null || arr.length <= 0) {
      return -1;
    }
    int left = 0;
    int right = arr.length - 1;
    int mid;
    while (left + 1 < right) {
      mid = left + (right - left) / 2;
      if (arr[mid] < x) {
        left = mid;
      } else if (arr[mid] > x) {
        right = mid;
      } else { // arr[mid] == x
        return mid;
      }
    }
    // left preferred
    return Math.abs(arr[left] - x) <= Math.abs(arr[right] - x) ? left : right;
  }
}
