package techbow;

public class _0008_CheckUnique {
  public static void main(String[] args) {
    System.out.println("Hello world.");
  }

  public boolean checkUnique(char[] chars) {
    if (chars == null || chars.length <= 0) {
      return true;
    }
    int[] bitmap = new int[8];
    int row = 0;
    int column = 0;
    for (int i = 0; i < chars.length; i++) {
      row = chars[i] / 32;
      column = chars[i] % 32;
      if ((bitmap[row] & (1 << column)) != 0) {
        return false;
      } else {
        bitmap[row] |= (1 << column);
      }
    }
    return true;
  }
}
