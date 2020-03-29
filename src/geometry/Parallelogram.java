package geometry;

public class Parallelogram extends ConvexQuadrilateral {
  @Override
  public String classify() {
    return "Parallelogram";
  }

  @Override
  public double calculateArea() {
    return edgeList[0] * edgeList[1] * Math.sin(angleListInRadian[0]);
  }

  Parallelogram() {

  }

  public Parallelogram(double[] edgeList, double angleInRadian) {
    super();
    if (edgeList == null || edgeList.length != 2) {
      throw new IllegalArgumentException("There must be 2 edge.");
    }
    if (angleInRadian <= 0 || angleInRadian > Math.PI / 2) {
      throw new IllegalArgumentException("The angle must be in the range of (0, PI/2].");
    }
    initialize(edgeList, angleInRadian);
  }

  void initialize(double[] edgeList, double angleInRadian) {
    super.initialize(new double[] { edgeList[0], edgeList[1], edgeList[0], edgeList[1] },
        new double[] { angleInRadian, angleInRadian });
  }
}
