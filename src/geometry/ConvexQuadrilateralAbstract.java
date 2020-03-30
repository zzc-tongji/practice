package geometry;

public abstract class ConvexQuadrilateralAbstract implements TwoDimensionalGeometry {
  public abstract String classify();

  private static final int EDGE_NUMBER = 4;
  private final int vertexNumber = 4;

  @Override
  public int edgeNumber() {
    return EDGE_NUMBER;
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
