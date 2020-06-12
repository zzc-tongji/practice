package techbow;

import java.util.ArrayList;
import java.util.List;

public class _0005_SubsetsOfCharCollection {
  public static List<String> subsets(char[] array) {
    // corner case
    List<String> res = new ArrayList<>();
    if (array == null) {
      return res;
    }
    if (array.length == 0) {
      res.add("");
      return res;
    }
    // dfs
    dfs(array, 0, new StringBuilder(), res);
    return res;
    /*
     * time: O(2 ^ n) = \sum_{i=0}^{n}C_{n}^{i}
     *
     * space: O(1)
     */
  }

  private static void dfs(char[] array, int index, StringBuilder sb, List<String> res) {
    // every node as result
    res.add(sb.toString()); // [deep copy]
    // from left to right
    for (int i = index; i < array.length; i++) {
      final int cacheLength = sb.length();
      sb.append(array[i]);
      // from top to bottom
      dfs(array, i + 1, sb, res); // [i + 1]
      // [backtracking] & [remove]
      sb.setLength(cacheLength); // remove all characters after index
      // sb.deleteChatAt(sb.length() - 1); // remove character at after index
      // sb.remove(sb.length() - 1) // remove character at after index
    }
  }

  public static List<String> subsets1(char[] array) {
    // corner case
    List<String> res = new ArrayList<>();
    if (array == null) {
      return res;
    }
    if (array.length == 0) {
      res.add("");
      return res;
    }
    // dfs
    dfs1(array, 0, new StringBuilder(), res);
    return res;
    /*
     * time: O(2 ^ n) = \sum_{i=0}^{n}C_{n}^{i}
     *
     * space: O(1)
     */
  }

  private static void dfs1(char[] array, int index, StringBuilder sb, List<String> res) {
    if (index >= array.length) {
      // leaf node as result
      res.add(sb.toString());
      return;
    }
    final int cacheLength = sb.length();
    // add current character
    sb.append(array[index]);
    dfs1(array, index + 1, sb, res);
    sb.setLength(cacheLength); // backtracking
    // ignore current character
    dfs1(array, index + 1, sb, res);
  }

  // TODO: two solutions of BFS
}
