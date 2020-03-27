package lintcode;

/**
 * 0183. Wood Cut
 *
 * Given n pieces of wood with length L[i] (integer array). Cut them into small
 * pieces to guarantee you could have equal or more than k pieces with the same
 * length. What is the longest length you can get from the n pieces of wood?
 * Given L & k, return the maximum length of the small pieces.
 *
 * You couldn't cut wood into float length.
 *
 * If you couldn't get >= k pieces, return 0.
 *
 * Example
 *
 * Example 1
 *
 * Input:
 *
 * L = [232, 124, 456]
 *
 * k = 7
 *
 * Output: 114
 *
 * Explanation: We can cut it into 7 pieces if any piece is 114cm long, however
 * we can't cut it into 7 pieces if any piece is 115cm long.
 *
 * Example 2
 *
 * Input:
 *
 * L = [1, 2, 3]
 *
 * k = 7
 *
 * Output: 0
 *
 * Explanation: It is obvious we can't make it.
 *
 * Challenge
 *
 * O(n log Len), where Len is the longest length of the wood.
 */
public class _0183_WoodCut {
  public static void main(String[] args) {
    System.out.println("Hello world.");
  }

  public int woodCut(int[] L, int k) {
    if (L == null || L.length <= 0) {
      return 0;
    }
    // get maximum piece length
    //
    // Use long rather than int, since the sum of int may cause overflow.
    long totalLength = 0;
    for (int i = 0; i < L.length; i++) {
      totalLength += L[i];
    }
    long maxPieceLength = totalLength / k;
    if (maxPieceLength <= 0) {
      return 0;
    }
    // binary search
    long left = 0;
    long right = maxPieceLength;
    long mid = 0;
    while (left + 1 < right) {
      mid = left + (right - left) / 2;
      if (isAbleToCut(L, k, mid)) {
        left = mid;
      } else {
        right = mid;
      }
    }
    if (isAbleToCut(L, k, right)) {
      return (int) right;
    }
    if (isAbleToCut(L, k, left)) {
      return (int) left;
    }
    return 0;
    /*
     * time: O(n) + O(n log n/k) = O(n log n)
     *
     * space: O(1)
     */
  }

  public boolean isAbleToCut(int[] L, int k, long pieceLength) {
    long piece = 0;
    for (int i = 0; i < L.length; i++) {
      piece += L[i] / pieceLength;
    }
    if (piece >= k) {
      return true;
    }
    return false;
  }
}
