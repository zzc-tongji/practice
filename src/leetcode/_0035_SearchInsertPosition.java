package leetcode;

/**
 * 0035. Search Insert Position
 *
 * Given a sorted array and a target value, return the index if the target is
 * found. If not, return the index where it would be if it were inserted in
 * order.
 *
 * You may assume no duplicates in the array.
 *
 * Example 1:
 *
 * Input: [1,3,5,6], 5
 *
 * Output: 2
 *
 * Example 2:
 *
 * Input: [1,3,5,6], 2
 *
 * Output: 1
 *
 * Example 3:
 *
 * Input: [1,3,5,6], 7
 *
 * Output: 4
 *
 * Example 4:
 *
 * Input: [1,3,5,6], 0
 *
 * Output: 0
 */
public class _0035_SearchInsertPosition {
  public static void main(String[] args) {
    System.out.println("Hello world.");
  }

  public int searchInsert(int[] nums, int target) {
    // find the smallest - larger or equal - position
    //
    // similiar to function `searchFirst` in file
    // `_0034_FindFirstAndLastPositionOfElementInSortedArray.java`
    if (nums == null || nums.length <= 0) {
      return -1;
    }
    int left = 0;
    int right = nums.length - 1;
    int mid = 0;
    while (left + 1 < right) {
      mid = left + (right - left) / 2;
      if (nums[mid] < target) {
        left = mid;
      } else {
        right = mid;
      }
    }
    // example: insert 4 to the following array
    if (nums[left] >= target) {
      return left;
      // 5 6 7 8
      //
      // 4 6 7 8
      //
      // l r - -
    }
    if (nums[right] >= target) {
      return right;
      // 2 3 6 7
      //
      // 2 3 4 7
      //
      // - l r -
    }
    // nums[left] < target && nums[right] < target
    return right + 1;
    // 0 1 2 3
    //
    // - - l r

    /*
     * time: O(log n)
     *
     * space: O(1)
     */
  }
}
