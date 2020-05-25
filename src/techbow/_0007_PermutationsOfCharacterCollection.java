package techbow;

import java.util.ArrayList;
import java.util.List;

/*
 * It is similiar as LeetCode 78 but use string char rather than int.
 */
public class _0007_PermutationsOfCharacterCollection {
  public List<String> permute(char[] array) {
    if (array == null || array.length <= 0) {
      return new ArrayList<>();
    }
    List<String> result = new ArrayList<>();
    dfs(array, 0, result);
    return result;
  }

  private static void dfs(char[] array, int level, List<String> result) {
    if (level == array.length - 1) {
      // leaf node as result
      result.add(String.valueOf(array));
      return;
    }
    // not swap
    dfs(array, level + 1, result);
    // swap
    for (int i = level + 1; i < array.length; i++) {
      swap(array, level, i);
      dfs(array, level + 1, result);
      swap(array, i, level); // backtracking
    }
    /*
     * time: O(solution number)
     *
     * space: O(1)
     */
  }

  private static void swap(char[] array, int i, int j) {
    char temp = array[j];
    array[j] = array[i];
    array[i] = temp;
  }
}
