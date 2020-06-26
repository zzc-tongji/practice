package techbow._0013_Sort.arraylist;

import java.util.ArrayList;

public class MergeSort {
  public static ArrayList<Integer> sort(ArrayList<Integer> array) {
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
      if (leftV <= rightV) {
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
