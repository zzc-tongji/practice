package techbow;

import java.util.Arrays;
import java.util.Random;

/*
 * Find the element of index `k` in ascending sorted `array` and return value.
 *
 * In other word, find the (k+1)-th smallest element and return value.
 */
public class _0014_QuickSelection {
  public static int select(int[] array, int k) {
    if (array == null || array.length <= 0 || k < 0 || k > array.length - 1) {
      throw new IllegalArgumentException();
    }
    int[] arr = Arrays.copyOf(array, array.length);
    return selectHelper(arr, k);
    /*
     * time: best = average = O(n), worse = O(n ^ 2)
     *
     * space: O(1)
     */
  }

  public static int selectHelper(int[] arr, int k) {
    Random rand = new Random();
    int left = 0;
    int right = arr.length - 1;
    while (left <= right) {
      int pivotI = left + rand.nextInt(right - left + 1);
      pivotI = relocate(arr, left, right, pivotI);
      if (pivotI < k) {
        left = pivotI + 1;
      } else if (pivotI > k) {
        right = pivotI - 1;
      } else { // pivotI == k
        return arr[pivotI];
      }
    }
    throw new IllegalArgumentException();
  }

  private static int relocate(int[] arr, int left, int right, int pivotI) {
    int pivotV = arr[pivotI];
    swap(arr, pivotI, right);
    int leftI = left;
    int rightI = right - 1;
    while (leftI <= rightI) {
      if (arr[leftI] < pivotV) {
        leftI += 1;
      } else if (arr[rightI] > pivotV) {
        rightI -= 1;
      } else {
        swap(arr, leftI, rightI);
        leftI += 1;
        rightI -= 1;
      }
    }
    swap(arr, leftI, right);
    return leftI;
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static int selectAdvance(int[] array, int k) {
    // [me]
    if (array == null || array.length <= 0 || k < 0 || k > array.length - 1) {
      throw new IllegalArgumentException();
    }
    int[] arr = Arrays.copyOf(array, array.length);
    return selectAdvanceHelper(arr, k);
    /*
     * time: best = average = worse = O(n)
     *
     * space: O(1)
     */
  }

  private static int selectAdvanceHelper(int[] arr, int k) {
    int left = 0;
    int right = arr.length - 1;
    while (left <= right) {
      int pivotI = relocateAdvance(arr, left, right);
      if (pivotI < k) {
        left = pivotI + 1;
      } else if (pivotI > k) {
        right = pivotI - 1;
      } else { // pivotI == k
        return arr[pivotI];
      }
    }
    throw new IllegalArgumentException();
  }

  public static int relocateAdvance(int[] arr, int left, int right) {
    // [me]
    int pivotV = getPivotValue(arr, left, right);
    int pivotI = searchPivotIndex(arr, pivotV);
    return relocate(arr, left, right, pivotI);
  }

  private static int getPivotValue(int[] arr, int left, int right) {
    // Split `arr[left:right]` to sub-arrays of 5 elements.
    // Assume that each sub-arrays are sorted - every middle item acts as "median".
    int length = right - left + 1;
    if (length < 5) {
      return arr[left + (right - left) / 2];
    }
    // Place these middle items in a new array.
    // Use quick selection to get the "median", use it as pivot value.
    int[] medianArray = new int[length / 5];
    for (int i = 0; i < medianArray.length; i++) {
      medianArray[i] = arr[left + 2 + 5 * i];
    }
    return selectAdvanceHelper(medianArray, (medianArray.length - 1) / 2);
  }

  private static int searchPivotIndex(int[] arr, int pivotV) {
    int pivotI = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == pivotV) {
        pivotI = i;
        break;
      }
    }
    return pivotI;
  }
}
