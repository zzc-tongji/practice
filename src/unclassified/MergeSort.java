package unclassified;

import java.util.ArrayList;

public class MergeSort {
  public static void main(String[] args) {
    System.out.println("Hello world.");
  }

  /* int[] */

  public void mergeSort(int[] array) {
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

  private void divide(int[] array, int[] helper, int left, int right) {
    if (left == right) {
      return;
    }
    int mid = left + (right - left) / 2;
    divide(array, helper, left, mid);
    // Feel free to use `mid + 1`. Don't worry about `IndexOutOfRangeException`.
    divide(array, helper, mid + 1, right);
    merge(array, helper, left, mid, right);
  }

  private void merge(int[] array, int[] helper, int left, int mid, int right) {
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

  /* ArrayList */

  public ArrayList<Integer> mergeSort(ArrayList<Integer> array) {
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

  private ArrayList<Integer> divide(ArrayList<Integer> array, int left, int right) {
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

  private ArrayList<Integer> merge(ArrayList<Integer> leftResult, ArrayList<Integer> rightResult) {
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
