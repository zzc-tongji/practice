package geometry;

public class Rectangle extends Parallelogram {
  @Override
  public String classify() {
    return "Rectangle";
  }

  @Override
  public double calculateArea() {
    return edgeList[0] * edgeList[1];
  }

  Rectangle() {

  }

  public Rectangle(double width, double height) {
    super();
    if (width <= 0 || height <= 0) {
      throw new IllegalArgumentException("The width and height must be larger than 0.");
    }
    initialize(width, height);
  }

  void initialize(double width, double height) {
    super.initialize(new double[] { width, height }, Math.PI / 2);
  }
}
