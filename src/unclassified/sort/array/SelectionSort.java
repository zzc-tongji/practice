package unclassified.sort.array;

public class SelectionSort {
  public static void sort(int[] array) {
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
      Util.swap(array, i, minIndex);
    }
    /*
     * time: O(n ^ 2)
     *
     * space: O(1)
     */
  }
}
