package leetcode;

import java.util.ArrayList;
import java.util.Random;

/**
 * 0912. Sort an Array
 *
 * Given an array of integers nums, sort the array in ascending order.
 *
 * Example 1:
 *
 * Input: nums = [5,2,3,1]
 *
 * Output: [1,2,3,5]
 *
 * Example 2:
 *
 * Input: nums = [5,1,1,2,0,0]
 *
 * Output: [0,0,1,1,2,5]
 */
public class _0912_SortAnArray {
  public static void main(String[] args) {
    System.out.println("Hello world.");
  }

  private static class SelectionSort {
    private static void sort(int[] array) {
      if (array == null || array.length <= 1) {
        return;
      }
      int minIndex = 0;
      for (int i = 0; i < array.length - 1; i++) {
        // It is not necessary to move `i` to the right edge.
        minIndex = i;
        for (int j = i + 1; j < array.length; j++) {
          if (array[j] < array[minIndex]) {
            minIndex = j;
          }
        }
        swap(array, i, minIndex);
      }
      /*
       * time: O(n ^ 2)
       *
       * space: O(1)
       */
    }

    private static void swap(int[] array, int i, int j) {
      int temp = array[i];
      array[i] = array[j];
      array[j] = temp;
    }
  }

  private static class MergeSort {
    private static void sort(int[] array) {
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
      // similiar as file `_0088_MergeSortedArray.java`
      //
      // copy
      for (int i = left; i < right; i++) {
        helper[i] = array[i];
      }
      int leftI = left;
      int rightI = mid + 1;
      while (leftI <= mid && rightI <= right) {
        if (helper[leftI] < helper[rightI]) {
          // `left` is passed by value and not needed to be used in the future. So just
          // use it as insertion counter.
          array[left] = helper[leftI];
          left += 1;
          leftI += 1;
        } else {
          array[leftI] = helper[rightI];
          left += 1;
          rightI += 1;
        }
      }
      // Don't worry about the sequence, since only one "while" will be executed.
      while (leftI <= mid) {
        array[left] = helper[leftI];
        left += 1;
        leftI += 1;
      }
      while (rightI <= right) {
        array[leftI] = helper[rightI];
        left += 1;
        rightI += 1;
      }
    }

    private static ArrayList<Integer> sort(ArrayList<Integer> array) {
      if (array == null || array.size() <= 1) {
        return array;
      }
      return divide(array, 0, array.size() - 1);
      /*
       * time: O(n log n)
       *
       * space: O(n)
       */
    }

    private static ArrayList<Integer> divide(ArrayList<Integer> array, int left, int right) {
      ArrayList<Integer> result = new ArrayList<Integer>();
      if (left == right) {
        result.add(array.get(left));
        return result;
      }
      int mid = left + (right - left) / 2;
      ArrayList<Integer> leftResult = divide(array, left, mid);
      // Feel free to use `mid + 1`. Don't worry about `IndexOutOfRangeException`.
      ArrayList<Integer> rightResult = divide(array, mid + 1, right);
      return merge(leftResult, rightResult);
    }

    private static ArrayList<Integer> merge(ArrayList<Integer> leftResult, ArrayList<Integer> rightResult) {
      ArrayList<Integer> result = new ArrayList<>();
      int leftI = 0;
      int rightI = 0;
      int leftV = 0;
      int rightV = 0;
      while (leftI < leftResult.size() && rightI < rightResult.size()) {
        leftV = leftResult.get(leftI);
        rightV = rightResult.get(rightI);
        if (leftV < rightV) {
          result.add(leftV);
          leftI += 1;
        } else {
          result.add(rightV);
          rightV += 1;
        }
      }
      // Don't worry about the sequence, since only one "while" will be executed.
      while (leftI < leftResult.size()) {
        result.add(leftV);
        leftI += 1;
      }
      while (rightI < rightResult.size()) {
        result.add(rightV);
        rightV += 1;
      }
      return result;
    }
  }

  private static class QuickSort {
    private static boolean slowFastEnabled = false;

    private static void sort(int[] array) {
      if (array == null || array.length <= 1) {
        return;
      }
      helper(array, 0, array.length - 1);
      /*
       * time: O(n log n)
       *
       * space: O(1)
       */
    }

    private static void helper(int[] array, int left, int right) {
      // Use ">=" rather than "=="
      // to cover the situation that the pivot is already at edge
      // (`pivotIndex +- 1` might be out of range).
      if (left >= right) {
        return;
      }
      int pivotIndex = slowFastEnabled ? getPivotIndexSlowFast(array, left, right) : getPivotIndex(array, left, right);
      helper(array, left, pivotIndex - 1);
      helper(array, pivotIndex + 1, right);
    }

    private static int getPivotIndex(int[] array, int left, int right) {
      // It can deal with arrays with duplicate values.
      //
      // Since rand.nextInt(x) will return an int in [0, x),
      // to ensure the posibility to hit `right`,
      // there is an `+ 1` at the end.
      Random rand = new Random();
      int pivotRandIndex = left + rand.nextInt(right - left + 1);
      int pivotValue = array[pivotRandIndex];
      // swap the pivot to the end
      swap(array, pivotRandIndex, right);
      int leftI = left;
      int rightI = right - 1;
      while (leftI <= rightI) {
        if (array[leftI] < pivotValue) {
          leftI += 1;
        } else if (array[rightI] >= pivotValue) {
          rightI -= 1;
        } else {
          swap(array, leftI, rightI);
          leftI += 1;
          rightI -= 1;
        }
      }
      // After while, `leftI` and `rightI` is crossed,
      // which means `array[leftI] >= pivotValue`.
      //
      // swap the pivot to the correct position
      swap(array, leftI, right);
      // [0, leftI) < pivot
      // (leftI, right] >= pivot
      return leftI;
    }

    private static int getPivotIndexSlowFast(int[] array, int left, int right) {
      // It can deal with arrays with duplicate values.
      Random rand = new Random();
      int pivotRandIndex = left + rand.nextInt(right - left + 1);
      int pivotValue = array[pivotRandIndex];
      swap(array, pivotRandIndex, right);
      int slow = left;
      int fast = left;
      while (fast < right) {
        if (array[slow] < pivotValue) {
          slow += 1;
        } else if (array[fast] < pivotValue) {
          swap(array, slow, fast);
          slow += 1;
        }
        fast += 1;
      }
      // After while, `fast` is out of the right edge.
      swap(array, slow, right);
      // [0, slow) < pivot
      // [slow, fast) >= pivot
      return slow;
    }

    private static void swap(int[] array, int i, int j) {
      int temp = array[i];
      array[i] = array[j];
      array[j] = temp;
    }
  }

  private enum Method {
    SELECTION_SORT, MERGE_SORT, QUICK_SORT,
  }

  Method method = Method.QUICK_SORT;

  public int[] sortArray(int[] nums) {
    switch (method) {
      case SELECTION_SORT:
        SelectionSort.sort(nums);
        break;
      case MERGE_SORT:
        MergeSort.sort(nums);
        break;
      default: // QUICK_SORT
        QuickSort.sort(nums);
        break;
    }
    return nums;
  }

  public ArrayList<Integer> sortArray(ArrayList<Integer> nums) {
    switch (method) {
      case SELECTION_SORT:
        // SelectionSort.sort(nums);
        break;
      case MERGE_SORT:
        MergeSort.sort(nums);
        break;
      default: // QUICK_SORT
        // QuickSort.sort(nums);
        break;
    }
    return nums;
  }
}
