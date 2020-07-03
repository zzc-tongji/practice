package techbow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _0017_PermutationsOfCharacterCollectionWithDuplicate {
  private static void swap(char[] array, int i, int j) {
    char temp = array[j];
    array[j] = array[i];
    array[i] = temp;
  }

  public static List<String> permute(char[] array) {
    if (array == null || array.length <= 0) {
      return new ArrayList<>();
    }
    List<String> result = new ArrayList<>();
    dfs(array, 0, result);
    return result;
    /*
     * time: O(solution number)
     *
     * space: O(1)
     */
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
    Set<Character> set = new HashSet<>();
    set.add(array[level]);
    for (int i = level + 1; i < array.length; i++) {
      // prune: only swap with first character of duplicate
      if (set.add(array[i])) {
        swap(array, level, i);
        dfs(array, level + 1, result);
        swap(array, i, level); // backtracking
      }
    }
  }

  public static List<String> permute1(char[] array) {
    // [own]
    if (array == null || array.length <= 0) {
      return new ArrayList<>();
    }
    Set<String> result = new HashSet<>();
    dfs1(array, 0, result);
    return new ArrayList<>(result);
    /*
     * time: O(solution number)
     *
     * space: O(1)
     */
  }

  private static void dfs1(char[] array, int level, Set<String> result) {
    if (level == array.length - 1) {
      // leaf node as result
      result.add(String.valueOf(array));
      return;
    }
    // not swap
    dfs1(array, level + 1, result);
    // swap
    for (int i = level + 1; i < array.length; i++) {
      swap(array, level, i);
      dfs1(array, level + 1, result);
      swap(array, i, level); // backtracking
    }
  }
}
