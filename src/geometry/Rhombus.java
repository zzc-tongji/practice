package geometry;

public final class Rhombus extends Parallelogram {
  @Override
  public String classify() {
    return "Rhombus";
  }

  public Rhombus(double sideLength, double angleInRadian) {
    super();
    if (sideLength <= 0) {
      throw new IllegalArgumentException("The side length must be larger than 0.");
    }
    if (angleInRadian <= 0 || angleInRadian > Math.PI / 2) {
      throw new IllegalArgumentException("The angle must be in the range of (0, PI/2].");
    }
    initialize(sideLength, angleInRadian);
  }

  public void initialize(double sideLength, double angleInRadian) {
    super.initialize(new double[] { sideLength, sideLength }, angleInRadian);
  }
}
