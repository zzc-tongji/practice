package leetcode;

/*
 * 0273. Integer to English Words
 *
 * Convert a non-negative integer to its english words representation. Given
 * input is guaranteed to be less than 2^31 - 1.
 *
 * Example 1:
 *
 * Input: 123
 *
 * Output: "One Hundred Twenty Three"
 *
 * Example 2:
 *
 * Input: 12345
 *
 * Output: "Twelve Thousand Three Hundred Forty Five"
 *
 * Example 3:
 *
 * Input: 1234567
 *
 * Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty
 * Seven"
 *
 * Example 4:
 *
 * Input: 1234567891
 *
 * Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven
 * Thousand Eight Hundred Ninety One"
 */
class _0273_IntegerToEnglishWords {
  // good usage of constant pool
  private final String[] LESS_THAN_20 = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
      "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
  private final String[] TENS = { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
      "Ninety" };
  private final String[] THOUSANDS = { "", "Thousand", "Million", "Billion" };

  public String numberToWords(int num) {
    // corner case
    if (num == 0) {
      return "Zero";
    }
    int i = 0;
    StringBuilder word = new StringBuilder();
    while (num > 0) {
      // segment by thousand (since the convertion method within thousand is same)
      if (num % 1000 != 0) {
        // insert at begin
        word.insert(0, helper(num % 1000).append(THOUSANDS[i]).append(" "));
      }
      num /= 1000;
      i++;
    }
    // Don't forget to trim.
    return word.toString().trim();

  }

  private StringBuilder helper(int num) {
    // generate string of a number less than 1000
    //
    // excellent usage of recursion
    StringBuilder word = new StringBuilder();
    if (num == 0) {
      return word; // ""
    } else if (num < 20) {
      return word.append(LESS_THAN_20[num]).append(" ");
    } else if (num < 100) {
      return word.append(TENS[num / 10]).append(" ").append(helper(num % 10));
    } else { // 100 <= num <= 999
      return word.append(LESS_THAN_20[num / 100]).append(" Hundred ").append(helper(num % 100));
    }
  }
}
