package leetcode;

/*
 * 0075. Sort Colors
 *
 * Given an array with n objects colored red, white or blue, sort them in-place
 * so that objects of the same color are adjacent, with the colors in the order
 * red, white and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white,
 * and blue respectively.
 *
 * Note: You are not suppose to use the library's sort function for this
 * problem.
 *
 * Example:
 *
 * Input: [2,0,2,1,1,0]
 *
 * Output: [0,0,1,1,2,2]
 *
 * Follow up:
 *
 * - A rather straight forward solution is a two-pass algorithm using counting
 * sort.
 *
 * - First, iterate the array counting number of 0's, 1's, and 2's, then
 * overwrite array with total number of 0's, then 1's and followed by 2's.
 *
 * - Could you come up with a one-pass algorithm using only constant space?
 */
public class _0075_SortColors {
  public static void main(String[] args) {
    System.out.println("Hello world.");

    _0075_SortColors test = new _0075_SortColors();
    test.sortColors1(new int[] { 2, 0, 2, 1, 1, 0 });
  }

  public void sortColors(int[] nums) {
    // count sort
    if (nums == null || nums.length <= 0) {
      return;
    }
    int enumeration = 3;
    int[] counter = new int[enumeration];
    // Don't worry. A default value of 0 for arrays of integral types is guaranteed
    // by the language spec:
    //
    // Each class variable, instance variable, or array component is initialized
    // with a default value when it is created (§15.9, §15.10) [...] For type int,
    // the default value is zero, that is, 0.
    //
    // If you want to initialize an one-dimensional array to a different value, you
    // can use java.util.Arrays.fill() (which will of course use a loop internally).
    //
    // https://stackoverflow.com/a/2154340
    for (int i = 0; i < nums.length; i++) {
      counter[valueToPointer(nums[i])] += 1; // nums[i]
    }
    int pointer = 0;
    for (int i = 0; i < nums.length; i++) {
      // Use while rather than if to skip all empty counters.
      while (counter[pointer] <= 0) {
        pointer += 1;
      }
      nums[i] = pointerToValue(pointer); // pointer
      counter[pointer] -= 1;
    }
    /*
     * time: O(n)
     *
     * space: O(n)
     */
  }

  private int pointerToValue(int pointer) {
    return pointer;
  }

  private int valueToPointer(int value) {
    return value;
  }

  public void sortColors1(int[] nums) {
    // pivot selection in quick sort
    if (nums == null || nums.length <= 0) {
      return;
    }
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      if (nums[left] < 1) {
        left += 1;
      } else if (nums[right] >= 1) {
        right -= 1;
      } else {
        swap(nums, left, right);
        left += 1;
        right -= 1;
      }
    }
    /*
     * time: O(n)
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
