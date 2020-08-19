package techbow._0024_Candidate;

/*
 * Amazon - 2020 new graduate - OA2
 *
 * An Amazon Area Manager is trying to assemble a specialized team from a roster
 * of available associates. There is a minimum number of associates to be
 * involved, and each associate needs to have a skill rating within a certain
 * range. Given a list of associates' skill levels with desired upper and lower
 * bounds, determine how many teams can be created from the list.
 *
 * Write an algorithm to find the number of teams that can be created fulfilling
 * the criteria.
 *
 * Input
 *
 * The input to the function/method consists of five arguments:
 *
 * num, an integer representing the number of associates;
 *
 * skills, a list of integers representing the skill levels of associates;
 *
 * minAssociates, an integer representing the minimum number of team members
 * required;
 *
 * minLevel, an integer representing the lower limit for skill level,
 * inclusive;
 *
 * maxLevel, an integer representing the upper limit for skill level,
 * inclusive.
 *
 * Output
 *
 * Return an integer representing the total number of teams that can be
 * formed per the criteria.
 *
 * Constraints
 *
 * 1 <= num <= 20
 *
 * 1 <= minAssociates <= num
 *
 * 1 <= minLevel <= maxLevel <= 1000
 *
 * 1 <= skills[i] <= 1000
 *
 * 0 <= i < num
 */

public class Solution {
  /*
   * time: O(n)
   *
   * space: O(n)
   */

  private static int candidate(int num, int minAssociates, int minLevel, int maxLevel, int[] skills) {
    // corner case
    if (skills == null || skills.length <= 0) {
      return 0;
    }
    // filter
    int available = 0;
    for (int i = 0; i < skills.length; i++) {
      if (skills[i] >= minLevel && skills[i] <= maxLevel) {
        available += 1;
      }
    }
    if (available < minAssociates) {
      return 0;
    }
    // sum
    long result = 0;
    for (int i = minAssociates; i <= available; i++) {
      result += combination(i, available);
    }
    return (int) result;
  }

  private static long combination(long up, long down) {
    if (up > down) {
      return 0;
    }
    if (up > down / 2) {
      up = down - up;
    }
    long a = 1; // max value: 20 * 19 * 18 * ... * 11, not overflow as long
    long b = 1;
    for (int i = 0; i < up; i++) {
      a *= (down - i);
      b *= (i + 1);
    }
    return a / b;
  }

  public static void main(String[] args) {
    // 5
    int result = candidate(6, 3, 4, 10, new int[] { 12, 4, 6, 13, 5, 10 });
    System.out.println(result);
  }
}
