package geometry;

public final class Square extends Rectangle {
  @Override
  public String classify() {
    return "Square";
  }

  public Square(double sideLength) {
    super();
    if (sideLength <= 0) {
      throw new IllegalArgumentException("The side length must be larger than 0.");
    }
    initialize(sideLength);
  }

  void initialize(double sideLength) {
    super.initialize(sideLength, sideLength);
  }
}
