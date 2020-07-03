package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/*
 * 0049. Group Anagrams
 *
 * Given an array of strings, group anagrams together.
 *
 * Example:
 *
 *
 * Output:
 *
 * [
 * ⁠ ["ate","eat","tea"],
 * ⁠ ["nat","tan"],
 * ⁠ ["bat"]
 * ]
 *
 * Note:
 *
 * All inputs will be in lowercase.
 *
 * The order of your output does not matter.
 */
public class _0049_GroupAnagrams {
  private int[] PRIME_NUMBER_LIST = new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67,
      71, 73, 79, 83, 89, 97, 101 };

  public List<List<String>> groupAnagrams(String[] strs) {
    // corner case
    if (strs == null || strs.length == 0) {
      return new ArrayList<>();
    }
    // build
    Map<String, List<String>> map = new HashMap<>();
    List<String> list = null;
    String s = null;
    for (int i = 0; i < strs.length; i++) {
      s = sort(strs[i]);
      if (map.containsKey(s)) {
        list = map.get(s);
        list.add(strs[i]);
      } else {
        list = new ArrayList<>();
        list.add(strs[i]);
        map.put(s, list);
      }
    }
    // result
    List<List<String>> result = new ArrayList<>();
    for (Entry<String, List<String>> entry : map.entrySet()) {
      result.add(entry.getValue());
    }
    return result;
    /*
     * time: O(n)
     *
     * space: O(the group number of the result)
     */
  }

  private String sort(String s) {
    char[] array = s.toCharArray();
    Arrays.sort(array);
    return new String(array);
  }

  public List<List<String>> groupAnagrams1(String[] strs) {
    // corner case
    if (strs == null || strs.length == 0) {
      return new ArrayList<>();
    }
    // build
    Map<Integer, List<String>> map = new HashMap<>();
    List<String> list = null;
    int hash = 0;
    for (int i = 0; i < strs.length; i++) {
      hash = anagramHash(strs[i]);
      if (map.containsKey(hash)) {
        list = map.get(hash);
        list.add(strs[i]);
      } else {
        list = new ArrayList<>();
        list.add(strs[i]);
        map.put(hash, list);
      }
    }
    // result
    List<List<String>> result = new ArrayList<>();
    for (Entry<Integer, List<String>> entry : map.entrySet()) {
      result.add(entry.getValue());
    }
    return result;
    /*
     * time: O(n)
     *
     * space: O(the group number of the result)
     */
  }

  private int anagramHash(String s) {
    int checksum = 1;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      checksum *= PRIME_NUMBER_LIST[c - 'a'];
    }
    return checksum;
  }
}
