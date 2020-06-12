package leetcode;

/*
 * 0374. Guess Number Higher or Lower Easy
 *
 * We are playing the Guess Game. The game is as follows:
 *
 * I pick a number from 1 to n. You have to guess which number I picked.
 *
 * Every time you guess wrong, I'll tell you whether the number is higher or
 * lower.
 *
 * You call a pre-defined API guess(int num) which returns 3 possible results
 * (-1, 1, or 0):
 *
 * -1 : My number is lower
 *
 * 1 : My number is higher
 *
 * 0 : Congrats! You got it!
 *
 * Example :
 *
 * Input: n = 10, pick = 6
 *
 * Output: 6
 */
public class _0374_GuessNumberHigherOrLower extends GuessGame {
  public int guessNumber(int n) {
    if (n <= 0) {
      return -1;
    }
    int left = 1;
    int right = n;
    int mid = 0;
    int guessResult = 0;
    while (left <= right) {
      mid = left + (right - left) / 2;
      guessResult = guess(mid);
      if (guessResult == -1) {
        right = mid - 1;
      } else if (guessResult == 1) {
        left = mid + 1;
      } else { // guessResult == 0
        return mid;
      }
    }
    return -1;
    /*
     * time: O(log n)
     *
     * space: O(1)
     */
  }
}

class GuessGame {
  public int guess(int num) {
    int target = 100;
    if (num < target) {
      return 1;
    }
    if (num > target) {
      return -1;
    }
    return 0;
  }
}
