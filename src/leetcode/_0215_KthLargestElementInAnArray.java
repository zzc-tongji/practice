package leetcode;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/*
 * 0215. Kth Largest Element in an Array
 *
 * Find the kth largest element in an unsorted array. Note that it is the kth
 * largest element in the sorted order, not the kth distinct element.
 *
 * Example 1:
 *
 * Input: [3,2,1,5,6,4] and k = 2
 *
 * Output: 5
 *
 * Example 2:
 *
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 *
 * Output: 4
 *
 * Note:
 *
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
public class _0215_KthLargestElementInAnArray {
  public static void main(String[] args) {
    System.out.println("Hello world.");
  }

  public int findKthLargest(int[] nums, int k) {
    // quick selection
    if (nums == null || nums.length <= 0 || k < 1 || k > nums.length) {
      throw new IllegalArgumentException();
    }
    if (nums.length <= 1) {
      return nums[0];
    }
    // For a non-duplicate array,
    // The `k` largest element is the `nums.length + 1 - k` smallest element,
    // which is the `nums.length - k` th item in the array.
    int k_ = nums.length - k;
    Random rand = new Random();
    // binary search
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) { // cross
      int pivotI = left + rand.nextInt(right - left + 1);
      pivotI = getPivotIndex(nums, left, right, pivotI);
      if (pivotI < k_) {
        left = pivotI + 1;
      } else if (pivotI > k_) {
        right = pivotI - 1;
      } else { // pivotLocation > k_
        return nums[pivotI];
      }
    }
    throw new IllegalArgumentException();
    /*
     * time: best = average = O(n), worse = O(n ^ 2)
     *
     * space: O(1)
     */
  }

  private int getPivotIndex(int[] nums, int left, int right, int pivotI) {
    int pivotV = nums[pivotI];
    swap(nums, pivotI, right);
    int leftI = left;
    int rightI = right - 1;
    while (leftI <= rightI) {
      if (nums[leftI] < pivotV) {
        leftI += 1;
      } else if (nums[rightI] >= pivotV) {
        rightI -= 1;
      } else {
        swap(nums, leftI, rightI);
        leftI += 1;
        rightI -= 1;
      }
    }
    swap(nums, leftI, right);
    return leftI;
  }

  private void swap(int nums[], int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  public int findKthLargest1(int[] nums, int k) {
    // sort with heap
    if (nums == null || nums.length <= 0 || k < 1 || k > nums.length) {
      throw new IllegalArgumentException();
    }
    if (nums.length <= 1) {
      return nums[0];
    }
    Queue<Integer> maxHeap = new PriorityQueue<>((Integer o1, Integer o2) -> {
      return o2 - o1;
    });
    for (int i = 0; i < nums.length; i++) {
      maxHeap.add(nums[i]);
    }
    int res = nums[0];
    for (int i = 0; i < k; i++) {
      res = maxHeap.remove();
    }
    return res;
    /*
     * time: average = O(n + k log n), worst = O(n log n + k log n)
     *
     * space: O(n)
     */
  }

  public int findKthLargest2(int[] nums, int k) {
    // heapify
    if (nums == null || nums.length <= 0 || k < 1 || k > nums.length) {
      throw new IllegalArgumentException();
    }
    if (nums.length <= 1) {
      return nums[0];
    }
    // Array `nums` will be changed!
    heapifyMaximum(nums, nums.length);
    // remove element from heap
    int res = nums[0];
    int validLength = nums.length;
    for (int i = 0; i < k; i++) {
      res = nums[0];
      swap(nums, 0, validLength - 1);
      validLength -= 1;
      siftDownMaximum(nums, 0, validLength);
    }
    return res;
    /*
     * time: average = worse = O(n + k log n)
     *
     * space: O(1)
     */
  }

  private void heapifyMaximum(int[] A, int validLength) {
    if (A == null || validLength <= 1) {
      return;
    }
    // The node with index `validLength / 2 - 1` is the largest one with child.
    for (int i = validLength / 2 - 1; i >= 0; i--) { // `int i = validLength - 1` is also OK.
      siftDownMaximum(A, i, validLength);
    }
  }

  private void siftDownMaximum(int[] A, int k, int validLength) {
    int child = k * 2 + 1;
    int i = k;
    while (i * 2 + 1 < validLength) {
      child = i * 2 + 1; // left child
      if (i * 2 + 2 < validLength && A[child] < A[i * 2 + 2]) {
        child = i * 2 + 2; // right child
      }
      // max-value child
      if (A[child] < A[i]) {
        break;
      }
      swap(A, i, child);
      i = child;
    }
  }

  public int findKthLargest3(int[] nums, int k) {
    // sort with heap
    if (nums == null || nums.length <= 0 || k < 1 || k > nums.length) {
      throw new IllegalArgumentException();
    }
    if (nums.length <= 1) {
      return nums[0];
    }
    // create a heap sized `k`
    Queue<Integer> minHeap = new PriorityQueue<>();
    for (int i = 0; i < k; i++) {
      minHeap.add(nums[i]);
    }
    for (int i = k; i < nums.length; i++) {
      if (nums[i] > minHeap.peek()) {
        minHeap.remove();
        minHeap.add(nums[i]);
      }
      // After each loop,
      // the heap root is the `n - i + 1`th minimum value of `nums[0, k+i]`.
    }
    // After the whole loop,
    // the heap root is the `n - k + 1`th minimum value of `nums`,
    // which is the `k`th maximum of `nums`.
    return minHeap.peek();
    /*
     * time:
     *
     * - average = O(k + ((n - k) / 2) * (1 + log k)) = O(k + (n - k) log k)
     *
     * - worse = O(k log k + (n - k) * (log k + log k)) = O(k log k + (n - k) log k)
     *
     * space: O(k)
     */
  }

  public int findKthLargest4(int[] nums, int k) {
    // heapify
    if (nums == null || nums.length <= 0 || k < 1 || k > nums.length) {
      throw new IllegalArgumentException();
    }
    if (nums.length <= 1) {
      return nums[0];
    }
    // Array `nums` will be changed!
    heapifyMinimum(nums, k);
    for (int i = k; i < nums.length; i++) {
      if (nums[i] > nums[0]) {
        swap(nums, i, 0);
        siftDownMinimum(nums, 0, k);
      }
      // After each loop,
      // the heap root is the `n - i + 1`th minimum value of `nums[0, k+i]`.
    }
    // After the whole loop,
    // the heap root is the `n - k + 1`th minimum value of `nums`,
    // which is the `k`th maximum of `nums`.
    return nums[0];
    /*
     * time:
     *
     * - average = O(k + ((n - k) / 2) * (1 + log k)) = O(k + (n - k) log k)
     *
     * - worse = O(k + (n - k) * (log k + log k)) = O(k + (n - k) log k)
     *
     * space: O(1)
     */
  }

  private void heapifyMinimum(int[] A, int validLength) {
    if (A == null || validLength <= 1) {
      return;
    }
    // The node with index `validLength / 2 - 1` is the largest one with child.
    for (int i = validLength / 2 - 1; i >= 0; i--) { // `int i = validLength - 1` is also OK.
      siftDownMinimum(A, i, validLength);
    }
  }

  private void siftDownMinimum(int[] A, int k, int validLength) {
    int child = k * 2 + 1;
    int i = k;
    while (i * 2 + 1 < validLength) {
      child = i * 2 + 1; // left child
      if (i * 2 + 2 < validLength && A[child] > A[i * 2 + 2]) {
        child = i * 2 + 2; // right child
      }
      // min-value child
      if (A[child] > A[i]) {
        break;
      }
      swap(A, i, child);
      i = child;
    }
  }
}
