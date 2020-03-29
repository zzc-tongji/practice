package geometry;

public abstract class ConvexQuadrilateralAbstract implements TwoDimensionalGeometry {
  public abstract String classify();

  final double inaccuracy = 0.001;

  @Override
  public int edgeNumber() {
    return 4;
  }

  /**
   * @return the inaccuracy
   */
  public double getInaccuracy() {
    return inaccuracy;
  }
}
