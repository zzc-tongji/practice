package leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 * 0205. Isomorphic Strings
 *
 * Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 *
 * All occurrences of a character must be replaced with another character while
 * preserving the order of characters. No two characters may map to the same
 * character but a character may map to itself.
 *
 * Example 1:
 *
 * Input: s = "egg", t = "add"
 *
 * Output: true
 *
 * Example 2:
 *
 * Input: s = "foo", t = "bar"
 *
 * Output: false
 *
 * Example 3:
 *
 * Input: s = "paper", t = "title"
 *
 * Output: true
 *
 * Note:
 *
 * You may assume both s and t have the same length.
 */
public class _0205_IsomorphicStrings {
  public boolean isIsomorphic(String s, String t) {
    // corner case
    if (s == null || t == null) {
      return false;
    }
    if (s.length() != t.length()) {
      return false;
    }
    if (s.length() == 1) {
      return true;
    }
    // Use two hashmaps to define one-one mapping.
    Map<Character, Character> s2t = new HashMap<>();
    Map<Character, Character> t2s = new HashMap<>();
    char sc = 0;
    char tc = 0;
    for (int i = 0; i < s.length(); i++) {
      sc = s.charAt(i);
      tc = t.charAt(i);
      if (s2t.containsKey(sc)) {
        if (!s2t.get(sc).equals(tc)) {
          return false;
        }
      } else {
        s2t.put(sc, tc);
      }
      if (t2s.containsKey(tc)) {
        if (!t2s.get(tc).equals(sc)) {
          return false;
        }
      } else {
        t2s.put(tc, sc);
      }
    }
    return true;
  }

  public boolean isIsomorphic1(String s, String t) {
    // corner case
    if (s == null || t == null) {
      return false;
    }
    if (s.length() != t.length()) {
      return false;
    }
    if (s.length() == 1) {
      return true;
    }
    // last appearance index
    Map<Character, Integer> sL = new HashMap<>();
    Map<Character, Integer> tL = new HashMap<>();
    char sc = 0;
    char tc = 0;
    for (int i = 0; i < s.length(); i++) {
      sc = s.charAt(i);
      tc = t.charAt(i);
      if (!sL.containsKey(sc) && !tL.containsKey(tc)) {
        sL.put(sc, i);
        tL.put(tc, i);
      } else if (sL.containsKey(sc) && tL.containsKey(tc)) {
        if (!sL.get(sc).equals(tL.get(tc))) {
          return false;
        }
        sL.put(sc, i);
        tL.put(tc, i);
      } else {
        return false;
      }
    }
    return true;
  }
}
