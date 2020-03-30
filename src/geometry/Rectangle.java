package geometry;

public class Rectangle extends Parallelogram {
  @Override
  public double calculateArea() {
    return edgeList[0] * edgeList[1];
  }

  @Override
  public String classify() {
    return "Rectangle";
  }

  Rectangle() {
    System.out.println("[constructor] Rectangle");
  }

  public Rectangle(double width, double height) {
    super();
    System.out.println("[constructor] Rectangle with argument(s)");
    if (width <= 0 || height <= 0) {
      throw new IllegalArgumentException("The width and height must be larger than 0.");
    }
    initialize(width, height);
  }

  void initialize(double width, double height) {
    System.out.println("[initialize] Rectangle");
    super.initialize(new double[] { width, height }, Math.PI / 2);
  }
}
