package unclassified;

public class SelectionSort {
  public static void main(String[] args) {
    System.out.println("Hello world.");
  }

  public void selectSort(int[] array) {
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

  private void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
