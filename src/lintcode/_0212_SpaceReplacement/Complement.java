package lintcode._0212_SpaceReplacement;

public class Complement {
  /*
   * time: O(n)
   *
   * space: O(1)
   */

  public int replaceShorter(char[] string) {
    // replace "%20" by " "
    if (string == null || string.length <= 0) {
      return 0;
    }
    // replace
    int slow = 0;
    int fast = slow;
    while (fast < string.length) {
      if (fast + 2 < string.length && string[fast] == '%' && string[fast + 1] == '2' && string[fast + 2] == '0') {
        string[slow] = ' ';
        slow += 1;
        // length of "%20"
        fast += 3;
      } else {
        string[slow] = string[fast];
        slow += 1;
        fast += 1;
      }
    }
    return slow;
  }

  public static void main(String[] args) {
    System.out.println("Hello world.");
    //
    Complement test = new Complement();
    //
    char[] input = "\"Mr%20John%20Smith\"".toCharArray();
    int output = test.replaceShorter(input);
    System.out.println(output);
    //
    return;
  }
}
