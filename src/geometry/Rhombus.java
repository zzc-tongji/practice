package geometry;

public final class Rhombus extends Parallelogram {
  @Override
  public String classify() {
    return Classification.RHOMBUS.getInformation();
  }

  public Rhombus(double sideLength, double angleInRadian) {
    super();
    System.out.println("[constructor] Rhombus with argument(s)");
    if (sideLength <= 0) {
      throw new IllegalArgumentException("The side length must be larger than 0.");
    }
    if (angleInRadian <= 0 || angleInRadian > Math.PI / 2) {
      throw new IllegalArgumentException("The angle must be in the range of (0, PI/2].");
    }
    initialize(sideLength, angleInRadian);
  }

  void initialize(double sideLength, double angleInRadian) {
    System.out.println("[initialize] Rhombus");
    super.initialize(new double[] { sideLength, sideLength }, angleInRadian);
  }
}
