package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * 0046. Permutations
 *
 * Given a collection of distinct integers, return all possible permutations.
 *
 * Example:
 *
 * Input: [1,2,3]
 *
 * Output:
 *
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 */
public class _0046_Permutations {
  public List<List<Integer>> permute(int[] nums) {
    if (nums == null || nums.length <= 0) {
      return new ArrayList<>();
    }
    List<List<Integer>> result = new ArrayList<>();
    dfs(nums, 0, result);
    return result;
    /*
     * time: O(solution number)
     *
     * space: O(1)
     */
  }

  private void dfs(int[] nums, int level, List<List<Integer>> result) {
    if (level == nums.length - 1) {
      // leaf node as result
      List<Integer> r = new ArrayList<>();
      for (int i : nums) {
        r.add(i);
      }
      result.add(r);
      return;
    }
    // not swap
    dfs(nums, level + 1, result);
    // swap
    for (int i = level + 1; i < nums.length; i++) {
      swap(nums, level, i);
      dfs(nums, level + 1, result);
      swap(nums, i, level); // backtracking
    }
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[j];
    nums[j] = nums[i];
    nums[i] = temp;
  }
}
