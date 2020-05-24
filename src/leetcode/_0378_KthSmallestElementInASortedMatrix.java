package leetcode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/*
 * 0378. Kth Smallest Element in a Sorted Matrix
 *
 * Given a n x n matrix where each of the rows and columns are sorted in
 * ascending order, find the kth smallest element in the matrix.
 *
 * Note that it is the kth smallest element in the sorted order, not the kth
 * distinct element.
 *
 * Example:
 *
 * matrix = [
 *    [ 1,  5,  9],
 *    [10, 11, 13],
 *    [12, 13, 15]
 * ],
 *
 * k = 8,
 *
 * return 13.
 *
 * Note:
 *
 * You may assume k is always valid, 1 ≤ k ≤ n ^ 2.
 */
public class _0378_KthSmallestElementInASortedMatrix {
  public static void main(String[] args) {
    System.out.println("Hello world.");
  }

  public int kthSmallest(int[][] matrix, int k) {
    int n = matrix.length;
    if (n <= 0 || k > n * n) {
      throw new IllegalArgumentException("`k` is out of range.");
    }
    Queue<int[]> heap = new PriorityQueue<>((int[] o1, int[] o2) -> {
      return matrix[o1[0]][o1[1]] - matrix[o2[0]][o2[1]];
    });
    Set<Integer> visit = new HashSet<>();
    int counter = 0;
    int[] cur = null;
    //
    heap.offer(new int[] { 0, 0 });
    // Note: set as visited when element is added to queue!
    visit.add(getIndex(0, 0, n));
    while (!heap.isEmpty() && counter < k) {
      // poll
      cur = heap.poll();
      // offer
      if (isValid(cur[0] + 1, cur[1], n, visit)) {
        heap.offer(new int[] { cur[0] + 1, cur[1] });
        visit.add(getIndex(cur[0] + 1, cur[1], n));
      }
      if (isValid(cur[0], cur[1] + 1, n, visit)) {
        heap.offer(new int[] { cur[0], cur[1] + 1 });
        visit.add(getIndex(cur[0], cur[1] + 1, n));
      }
      // counter
      counter += 1;
    }
    return matrix[cur[0]][cur[1]];
    /*
     * time: O(k log k)
     *
     * space: O(k)
     */
  }

  private boolean isValid(int i, int j, int n, Set<Integer> visit) {
    return (i >= 0) && (i < n) && (j >= 0) && (j < n) && !visit.contains(getIndex(i, j, n));
  }

  private int getIndex(int i, int j, int n) {
    return n * i + j;
  }
}
