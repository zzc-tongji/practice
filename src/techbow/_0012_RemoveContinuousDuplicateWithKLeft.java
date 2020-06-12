package techbow;

public class _0012_RemoveContinuousDuplicateWithKLeft {
  public static String removeDuplicates(String S, int k) {
    // range:
    //
    // - [0, s) ⇒ solution so far
    // - [s, f) ⇒ explored / will be updated or assigned / don’t care
    // - [f, length - 1] ⇒ unknown to explore
    if (S == null || S.length() <= k) {
      return S;
    }
    int slow = k;
    int fast = slow;
    char[] array = S.toCharArray();
    while (fast < array.length) {
      if (array[slow - k] == array[fast]) {
        // skip
      } else {
        array[slow] = array[fast];
        slow += 1;
      }
      fast += 1;
    }
    return new String(array, 0, slow);
    /*
     * time: O(n - k)
     *
     * space: O(n)
     */
  }

  public static String removeDuplicates1(String S, int k) {
    // range:
    //
    // - [0, s] ⇒ solution so far
    // - (s, f) ⇒ explored / will be updated or assigned / don’t care
    // - [f, length - 1] ⇒ unknown to explore
    //
    // (repeat `slow` in aforementioned method as `slow + 1`)
    if (S == null || S.length() <= k) {
      return S;
    }
    int slow = k - 1;
    int fast = slow + 1;
    char[] array = S.toCharArray();
    while (fast < array.length) {
      if (array[slow - k + 1] == array[fast]) {
        // skip
      } else {
        slow += 1;
        array[slow] = array[fast];
      }
      fast += 1;
    }
    return new String(array, 0, slow + 1);
    /*
     * time: O(n - k)
     *
     * space: O(n)
     */
  }
}
