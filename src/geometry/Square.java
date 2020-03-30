package geometry;

public final class Square extends Rectangle {
  @Override
  public String classify() {
    return Classification.SQUARE.getInformation();
  }

  public Square(double sideLength) {
    super();
    System.out.println("[constructor] Square with argument(s)");
    if (sideLength <= 0) {
      throw new IllegalArgumentException("The side length must be larger than 0.");
    }
    initialize(sideLength);
  }

  void initialize(double sideLength) {
    System.out.println("[initialize] Square");
    super.initialize(sideLength, sideLength);
  }
}
