package leetcode;

/**
 * 0088. Merge Sorted Array
 *
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as
 * one sorted array.
 *
 * Note:
 *
 * - The number of elements initialized in nums1 and nums2 are m and n
 * respectively.
 *
 * - You may assume that nums1 has enough space (size that is greater or equal
 * to m + n) to hold additional elements from nums2.
 *
 * Example:
 *
 * Input:
 *
 * nums1 = [1,2,3,0,0,0], m = 3
 *
 * nums2 = [2,5,6], n = 3
 *
 * Output: [1,2,2,3,5,6]
 */
public class _0088_MergeSortedArray {
  public static void main(String[] args) {
    System.out.println("Hello world.");
  }

  public void merge(int[] nums1, int m, int[] nums2, int n) {
    if (nums1 == null || nums1.length <= 0) {
      return;
    }
    if (nums2 == null || nums2.length <= 0) {
      return;
    }
    // Treat c, m, n as index. Don't forget to minus 1.
    int c = m + n - 1;
    m -= 1;
    n -= 1;
    while (c >= 0 && (m >= 0 || n >= 0)) {
      if (m < 0) {
        nums1[c] = nums2[n];
        n -= 1;
        c -= 1;
      } else if (n < 0) {
        nums1[c] = nums1[m];
        m -= 1;
        c -= 1;
      } else {
        if (nums1[m] > nums2[n]) {
          nums1[c] = nums1[m];
          m -= 1;
          c -= 1;
        } else {
          nums1[c] = nums2[n];
          n -= 1;
          c -= 1;
        }
      }
    }
    /*
     * time: O(m + n)
     *
     * space: O(1)
     */
  }
}
