package techbow;

import java.util.HashMap;
import java.util.Map;

public class _0008_PositionalNotationConvertor {
  public static void main(String[] args) {
    System.out.println("Hello world.");
  }

  public static int toDecimal(String input, int notation) {
    if (notation != 2 && notation != 8 && notation != 10 && notation != 16) {
      throw new IllegalArgumentException("Parameter `notation` should be 2, 8, 10 or 16.");
    }
    return toDecimal(input, notation, null);
  }

  public static int toDecimal(String input, int notation, char[] alphabet) {
    // corner case
    if (input == null || input.length() <= 0) {
      throw new IllegalArgumentException("Parameter `input` is empty.");
    }
    char[] a = validate(notation, alphabet);
    // generate hashmap
    Map<Character, Integer> m = new HashMap<>();
    for (int i = 0; i < a.length; i++) {
      m.put(a[i], i);
    }
    // main
    int result = 0;
    Integer current = 0;
    for (char c : input.toCharArray()) {
      if (result < 0) {
        throw new IllegalArgumentException("Parameter `input` is too large to convert to int.");
      }
      current = m.get(c);
      if (current == null) {
        throw new IllegalArgumentException(
            "Parameter `input` contains characters which are not in included by parameter `alphabet`.");
      }
      result += result * notation + m.get(c);
    }
    return result;
  }

  public static String toNotation(int input, int notation) {
    if (notation != 2 && notation != 8 && notation != 10 && notation != 16) {
      throw new IllegalArgumentException("Parameter `notation` should be 2, 8, 10 or 16.");
    }
    return toNotation(input, notation, null);
  }

  public static String toNotation(int input, int notation, char[] alphabet) {
    // corner case & edge case
    if (input < 0) {
      throw new IllegalArgumentException("Parameter `input` should be >= 0.");
    }
    if (input == 0) {
      return "0";
    }
    char[] a = validate(notation, alphabet);
    // main
    StringBuilder sb = new StringBuilder();
    while (input != 0) {
      sb.append(a[input % notation]);
      input /= notation;
    }
    return sb.reverse().toString();
  }

  public static String fromNotationtoNotation(String input, int fromN, int toN) {
    if (fromN != 2 && fromN != 8 && fromN != 10 && fromN != 16 && toN != 2 && toN != 8 && toN != 10 && toN != 16) {
      throw new IllegalArgumentException("Parameter `fromN` and `toN` should be 2, 8, 10 or 16.");
    }
    return fromNotationtoNotation(input, fromN, null, toN, null);
  }

  public static String fromNotationtoNotation(String input, int fromN, char[] fromA, int toN, char[] toA) {
    return toNotation(toDecimal(input, fromN, fromA), toN, toA);
  }

  private static char[] validate(int notation, char[] alphabet) {
    char[] res = alphabet;
    switch (notation) {
      case 2:
        if (alphabet == null || alphabet.length != 2) {
          res = new char[] { '0', '1' };
        }
        break;
      case 8:
        if (alphabet == null || alphabet.length != 8) {
          res = new char[] { '0', '1', '2', '3', '4', '5', '6', '7' };
        }
        break;
      case 10:
        if (alphabet == null || alphabet.length != 8) {
          res = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        }
        break;
      case 16:
        if (alphabet == null || alphabet.length != 16) {
          res = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        }
        break;
      default:
        if (notation <= 1) {
          throw new IllegalArgumentException("Parameter `notation` shoule be >= 2.");
        }
        break;
    }
    if (res == null || res.length != notation) {
      throw new IllegalArgumentException("The length of parameter `alphabet` is not equal to parameter `notation`.");
    }
    return res;
  }
}
