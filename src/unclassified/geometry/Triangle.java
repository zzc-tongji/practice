package unclassified.geometry;

public final class Triangle implements TwoDimensionalGeometry {
  private double angleA;
  private double angleB;
  private double angleC;
  private double edgeAB;
  private double edgeBC;
  private double edgeCA;

  @Override
  public int edgeNumber() {
    return 3;
  }

  @Override
  public double calculatePerimeter() {
    return edgeAB + edgeBC + edgeCA;
  }

  @Override
  public double calculateArea() {
    // Heron's formula
    double p = (edgeAB + edgeBC + edgeCA) / 2;
    return Math.sqrt(p * (p - edgeAB) * (p - edgeBC) * (p - edgeCA));
  }

  public Triangle(double edgeAB, double edgeBC, double edgeCA) {
    System.out.println("[constructor] Triangle with argument(s)");
    double halfSum = (edgeAB + edgeBC + edgeCA) / 2;
    if (edgeAB >= halfSum || edgeBC > halfSum || edgeCA > halfSum) {
      throw new IllegalArgumentException(
          "The length of each edge must emaller than the total length of other 2 edges.");
    }
    this.edgeAB = edgeAB;
    this.edgeBC = edgeBC;
    this.edgeCA = edgeCA;
    this.angleA = Math.acos((edgeCA * edgeCA + edgeAB * edgeAB - edgeBC * edgeBC) / (2 * edgeCA * edgeAB));
    this.angleB = Math.acos((edgeAB * edgeAB + edgeBC * edgeBC - edgeCA * edgeCA) / (2 * edgeAB * edgeBC));
    this.angleC = Math.acos((edgeBC * edgeBC + edgeCA * edgeCA - edgeAB * edgeAB) / (2 * edgeBC * edgeCA));
  }

  public void draw() {
    StringBuilder sb = new StringBuilder("");
    sb.append(String.format("A (%.3f deg) - ", Math.toDegrees(angleA)));
    sb.append(String.format("%.3f - ", edgeAB));
    sb.append(String.format("B (%.3f deg) - ", Math.toDegrees(angleB)));
    sb.append(String.format("%.3f - ", edgeBC));
    sb.append(String.format("C (%.3f deg) - ", Math.toDegrees(angleC)));
    sb.append(String.format("%.3f - A", edgeCA));
    System.out.println(sb);
  }
}
