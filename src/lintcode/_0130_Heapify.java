package lintcode;

/*
 * 0130. Heapify
 *
 * Description
 *
 * Given an integer array, heapify it into a min-heap array.
 *
 * For a heap array A, A[0] is the root of heap, and for each A[i], A[i * 2 + 1]
 * is the left child of A[i] and A[i * 2 + 2] is the right child of A[i].
 *
 * Clarification
 *
 * What is heap? What is heapify? What if there is a lot of solutions?
 *
 * - Heap is a data structure, which usually have three methods: push, pop and
 * top. where "push" add a new element the heap, "pop" delete the
 * minimum/maximum element in the heap, "top" return the minimum/maximum
 * element.
 *
 * - Convert an unordered integer array into a heap array. If it is min-heap,
 * for each element A[i], we will get A[i * 2 + 1] >= A[i] and A[i * 2 + 2] >=
 * A[i].
 *
 * - Return any of them.
 *
 * Example
 *
 * Example 1
 *
 * Input : [3,2,1,4,5]
 *
 * Output : [1,2,3,4,5]
 *
 * Explanation : return any one of the legitimate heap arrays
 *
 * Challenge
 *
 * O(n) time complexity
 */
public class _0130_Heapify {
  public void heapify(int[] A) {
    if (A == null || A.length <= 1) {
      return;
    }
    // The root could be ignored.
    for (int i = 1; i < A.length; i++) { // `int i = 0` is also OK.
      siftUp(A, i);
    }
    /*
     * time: average = O(n), worst = O(n log n)
     *
     * space: O(1)
     */
  }

  private void siftUp(int[] A, int k) {
    int parent = (k - 1) / 2;
    int i = k;
    while (i > 0) {
      parent = (i - 1) / 2;
      if (A[i] > A[parent]) {
        break;
      }
      swap(A, i, parent);
      i = parent;
    }
  }

  public void heapify1(int[] A) {
    if (A == null || A.length <= 1) {
      return;
    }
    // The node with index `A.length / 2 - 1` is the largest one with child.
    for (int i = A.length / 2 - 1; i >= 0; i--) { // `int i = A.length - 1` is also OK.
      siftDown(A, i);
    }
    /*
     * time: average = worst = O(n)
     *
     * space: O(1)
     */
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
