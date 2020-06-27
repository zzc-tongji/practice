package techbow._0013_Sort.array;

public class MergeSort {
  public static void main(String[] args) {
    int[] array = new int[] { 9, 7, 5, 3, 1 };
    sort(array);
    return;
  }

  public static void sort(int[] array) {
    if (array == null || array.length <= 1) {
      return;
    }
    int[] helper = new int[array.length];
    divide(array, helper, 0, array.length - 1);
    /*
     * time: O(n log n)
     *
     * space: O(n)
     */
  }

  private static void divide(int[] array, int[] helper, int left, int right) {
    if (left == right) {
      return;
    }
    int mid = left + (right - left) / 2;
    divide(array, helper, left, mid);
    // Feel free to use `mid + 1`. Don't worry about `IndexOutOfRangeException`.
    divide(array, helper, mid + 1, right);
    merge(array, helper, left, mid, right);
  }

  private static void merge(int[] array, int[] helper, int left, int mid, int right) {
    // copy
    for (int i = left; i <= right; i++) {
      helper[i] = array[i];
    }
    int leftI = left;
    int rightI = mid + 1;
    int offset = left;
    while (leftI <= mid && rightI <= right) {
      if (helper[leftI] <= helper[rightI]) {
        // `left` is passed by value and not needed to be used in the future. So just
        // use it as insertion counter.
        array[offset] = helper[leftI];
        offset += 1;
        leftI += 1;
      } else {
        array[offset] = helper[rightI];
        offset += 1;
        rightI += 1;
      }
    }
    // Don't worry about the sequence, since only one "while" will be executed.
    while (leftI <= mid) {
      array[offset] = helper[leftI];
      offset += 1;
      leftI += 1;
    }
    while (rightI <= right) {
      array[offset] = helper[rightI];
      offset += 1;
      rightI += 1;
    }
  }
}

// Merge of two sorted array can also be inplaced.
// However, it is not suitable for recursive merge sort.
// See `leetcode._0088_MergeSortedArray` for details.
