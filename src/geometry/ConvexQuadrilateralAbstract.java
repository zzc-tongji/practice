package geometry;

public abstract class ConvexQuadrilateralAbstract implements TwoDimensionalGeometry {
  public abstract String classify();

  private final int vertexNumber = 4;

  @Override
  public int edgeNumber() {
    return 4;
  }

  public ConvexQuadrilateralAbstract() {
    System.out.println("[constructor] ConvexQuadrilateralAbstract");
  }

  /**
   * @return the vertexNumber
   */
  public int getVertexNumber() {
    return vertexNumber;
  }
}
