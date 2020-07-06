package lintcode._0130_Heapify;

public class Solution1 {
  /*
   * time: average = worst = O(n)
   *
   * space: O(1)
   */

  public void heapify(int[] A) {
    if (A == null || A.length <= 1) {
      return;
    }
    // The node with index `A.length / 2 - 1` is the largest one with child.
    for (int i = A.length / 2 - 1; i >= 0; i--) { // `int i = A.length - 1` is also OK.
      siftDown(A, i);
    }
  }

  private void siftDown(int[] A, int k) {
    int child = k * 2 + 1;
    int i = k;
    while (i * 2 + 1 < A.length) {
      child = i * 2 + 1; // left child
      if (i * 2 + 2 < A.length && A[child] > A[i * 2 + 2]) {
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

  private void swap(int[] A, int i, int j) {
    int temp = A[j];
    A[j] = A[i];
    A[i] = temp;
  }
}
