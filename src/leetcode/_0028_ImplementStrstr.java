package leetcode;

/*
 * 0028. Implement strStr()
 *
 * Implement strStr().
 *
 * Return the index of the first occurrence of needle in haystack, or -1 if
 * needle is not part of haystack.
 *
 * Example 1:
 *
 * Input: haystack = "hello", needle = "ll"
 *
 * Output: 2
 *
 * Example 2:
 *
 * Input: haystack = "aaaaa", needle = "bba"
 *
 * Output: -1
 *
 * Clarification:
 *
 * What should we return when needle is an empty string? This is a great
 * question to ask during an interview.
 *
 * For the purpose of this problem, we will return 0 when needle is an empty
 * string. This is consistent to C's strstr() and Java's indexOf().
 */
public class _0028_ImplementStrstr {
  public static void main(String[] args) {
    (new _0028_ImplementStrstr()).strStr1("mississippi", "issi");
    return;
  }

  public int strStr(String haystack, String needle) {
    // corner case
    if (haystack == null || needle == null) {
      return -1;
    }
    if (needle.length() == 0) {
      return 0;
    }
    if (haystack.length() < needle.length()) {
      return -1;
    }
    // main
    int n = haystack.length();
    int m = needle.length();
    boolean found = false;
    for (int i = 0; i < n - m + 1; i++) { // i < n - m + 1
      found = true;
      for (int j = 0; j < m; j++) {
        if (haystack.charAt(i + j) != needle.charAt(j)) {
          found = false;
          break;
        }
      }
      if (found) {
        return i;
      }
    }
    return -1;
    /*
     * time: O(n * m)
     *
     * space: O(1)
     */
  }

  private static final long BASE = 256;

  public int strStr1(String haystack, String needle) {
    // Assume that all character is chosen from extended-ASCII (BASE == 256)
    // and hash code will not overflow.
    //
    // Note: set `BASE` as `26` to avoid hash code overflow in LeetCode.
    //
    // corner case
    if (haystack == null || needle == null) {
      return -1;
    }
    if (needle.length() == 0) {
      return 0;
    }
    if (haystack.length() < needle.length()) {
      return -1;
    }
    // main
    int n = haystack.length();
    int m = needle.length();
    long highBit = 1;
    for (int i = 1; i < m; i++) {
      highBit *= BASE;
    }
    long needleHash = hash(needle);
    // pre
    long h = hash(haystack.substring(0, m));
    if (needleHash == h) {
      return 0;
    }
    int i = 0;
    while (i + m < n) {
      h = slide(h, highBit, haystack.charAt(i), haystack.charAt(i + m));
      if (needleHash == h) {
        return i + 1;
      }
      i += 1;
    }
    return -1;
    /*
     * time: O(n * m)
     *
     * space: O(1)
     */
  }

  private long hash(String s) {
    long res = 0;
    for (int i = 0; i < s.length(); i++) {
      res = res * BASE + s.charAt(i);
    }
    return res;
  }

  private long slide(long hash, long highBit, char out, char in) {
    return (hash - out * highBit) * BASE + in;
  }
}
