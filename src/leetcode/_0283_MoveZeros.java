package leetcode;

/**
 * 0283. Move Zeroes
 *
 * Given an array nums, write a function to move all 0's to the end of it while
 * maintaining the relative order of the non-zero elements.
 *
 * Example:
 *
 * Input: [0,1,0,3,12]
 *
 * Output: [1,3,12,0,0]
 *
 * Note:
 *
 * You must do this in-place without making a copy of the array.
 *
 * Minimize the total number of operations.
 */
public class _0283_MoveZeros {
  public static void main(String[] args) {
    System.out.println("Hello world.");
  }

  public void moveZeroes(int[] nums) {
    if (nums == null || nums.length <= 1) {
      return;
    }
    int zeroI = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        swap(nums, zeroI, i);
        zeroI += 1;
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
