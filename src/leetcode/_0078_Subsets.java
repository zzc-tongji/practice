package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * 0078. Subsets
 *
 * Given a set of distinct integers, nums, return all possible subsets (the
 * power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 * Input: nums = [1,2,3]
 *
 * Output:
 *
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class _0078_Subsets {
  public static void main(String[] args) {
    System.out.println("Hello world.");
  }

  public List<List<Integer>> subsets(int[] nums) {
    // corner case
    List<List<Integer>> res = new ArrayList<>();
    if (nums == null) {
      return res;
    }
    if (nums.length == 0) {
      res.add(new ArrayList<Integer>());
      return res;
    }
    // dfs
    dfs(nums, 0, new ArrayList<Integer>(), res);
    return res;
    /*
     * time: O(2 ^ n) = \sum_{i=0}^{n}C_{n}^{i}
     *
     * space: O(1)
     */
  }

  private void dfs(int[] nums, int index, ArrayList<Integer> subset, List<List<Integer>> res) {
    res.add(new ArrayList<>(subset));
    for (int i = index; i < nums.length; i++) {
      subset.add(nums[i]);
      dfs(nums, i + 1, subset, res);
      subset.remove(subset.size() - 1);
    }
  }

  public List<List<Integer>> subsets1(int[] nums) {
    // corner case
    List<List<Integer>> res = new ArrayList<>();
    if (nums == null) {
      return res;
    }
    if (nums.length == 0) {
      res.add(new ArrayList<Integer>());
      return res;
    }
    // dfs
    dfs1(nums, 0, new ArrayList<Integer>(), res);
    return res;
    /*
     * time: O(2 ^ n) = \sum_{i=0}^{n}C_{n}^{i}
     *
     * space: O(1)
     */
  }

  private void dfs1(int[] nums, int index, ArrayList<Integer> subset, List<List<Integer>> res) {
    if (index >= nums.length) {
      res.add(new ArrayList<>(subset));
      return;
    }
    //
    subset.add(nums[index]);
    dfs1(nums, index + 1, subset, res);
    subset.remove(subset.size() - 1);
    //
    dfs1(nums, index + 1, subset, res);
  }
}
