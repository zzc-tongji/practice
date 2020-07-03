package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/*
 * 0242. Valid Anagram
 *
 * Given two strings s and t , write a function to determine if t is an anagram
 * of s.
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 *
 * Output: true
 *
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 *
 * Output: false
 *
 * Note:
 *
 * You may assume the string contains only lowercase alphabets.
 *
 * Follow up:
 *
 * What if the inputs contain unicode characters? How would you adapt your
 * solution to such case?
 *
 */
class _0242_ValidAnagram {
  private static int[] PRIME_NUMBER_LIST = new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59,
      61, 67, 71, 73, 79, 83, 89, 97, 101 };

  public boolean isAnagram(String s, String t) {
    // corner case
    if (s == null || t == null) {
      return false;
    }
    if (s.length() == 0 && t.length() == 0) {
      return true;
    }
    if (s.length() != t.length()) {
      return false;
    }
    // build
    Map<Character, Integer> mapS = new HashMap<>();
    Map<Character, Integer> mapT = new HashMap<>();
    Character c = null;
    for (int i = 0; i < s.length(); i++) {
      c = s.charAt(i);
      if (mapS.containsKey(c)) {
        mapS.put(c, mapS.get(c) + 1);
      } else {
        mapS.put(c, 1);
      }
    }
    for (int i = 0; i < t.length(); i++) {
      c = t.charAt(i);
      if (mapT.containsKey(c)) {
        mapT.put(c, mapT.get(c) + 1);
      } else {
        mapT.put(c, 1);
      }
    }
    // compare
    if (mapS.size() != mapT.size()) {
      return false;
    }
    // How to iterate `Map` or `HashMap`?
    for (Entry<Character, Integer> entry : mapS.entrySet()) {
      // IMPORTANT: Use `equals()` rather than `==` to compare two `Integer`.
      if (!entry.getValue().equals(mapT.get(entry.getKey()))) {
        return false;
      }
    }
    return true;
    // return mapS.equals(mapT);
    /*
     * time: O(length)
     *
     * space: O(the number of different characters)
     */
  }

  public boolean isAnagram1(String s, String t) {
    // corner case
    if (s == null || t == null) {
      return false;
    }
    if (s.length() == 0 && t.length() == 0) {
      return true;
    }
    if (s.length() != t.length()) {
      return false;
    }
    // build
    Map<Character, Integer> mapS = new HashMap<>();
    Character c = null;
    for (int i = 0; i < s.length(); i++) {
      c = s.charAt(i);
      if (mapS.containsKey(c)) {
        mapS.put(c, mapS.get(c) + 1);
      } else {
        mapS.put(c, 1);
      }
    }
    // destroy
    for (int i = 0; i < t.length(); i++) {
      c = t.charAt(i);
      if (!mapS.containsKey(c)) {
        return false;
      }
      mapS.put(c, mapS.get(c) - 1);
      if (mapS.get(c) <= 0) {
        mapS.remove(c);
      }
    }
    if (!mapS.isEmpty()) {
      return false;
    }
    return true;
    /*
     * time: O(length)
     *
     * space: O(the number of different characters)
     */
  }

  public boolean isAnagram2(String s, String t) {
    // corner case
    if (s == null || t == null) {
      return false;
    }
    if (s.length() == 0 && t.length() == 0) {
      return true;
    }
    if (s.length() != t.length()) {
      return false;
    }
    char[] arrayS = s.toCharArray();
    char[] arrayT = t.toCharArray();
    Arrays.sort(arrayS);
    Arrays.sort(arrayT);
    for (int i = 0; i < s.length(); i++) {
      if (arrayS[i] != arrayT[i]) {
        return false;
      }
    }
    return true;
    // Use `equals()` rather than `==`.
    // return (new String(arrayS)).equals(new String(arrayT));
    /*
     * time: let n as length, O(n log n)
     *
     * space: O(the number of different characters)
     */
  }

  public boolean isAnagram3(String s, String t) {
    return getChecksum(s) == getChecksum(t);
  }

  private int getChecksum(String s) {
    int checksum = 1;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      checksum *= PRIME_NUMBER_LIST[c - 'a'];
    }
    return checksum;
  }
}
