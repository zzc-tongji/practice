package techbow._0013_Sort.array;

import techbow._0014_QuickSelection;

public class QuickSortAdvance {
  public static void sort(int[] array) {
    // [own]
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
    int pivotIndex = _0014_QuickSelection.relocateAdvance(array, left, right);
    helper(array, left, pivotIndex - 1);
    helper(array, pivotIndex + 1, right);
  }
}
