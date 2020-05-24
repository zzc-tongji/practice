package unclassified.geometry;

public class Parallelogram extends ConvexQuadrilateral {
  @Override
  public double calculateArea() {
    return edgeList[0] * edgeList[1] * Math.sin(angleListInRadian[0]);
  }

  @Override
  public String classify() {
    return Classification.PARALLELOGRAM.getInformation();
  }

  Parallelogram() {
    System.out.println("[constructor] Parallelogram");
  }

  public Parallelogram(double[] edgeList, double angleInRadian) {
    super();
    System.out.println("[constructor] Parallelogram with argument(s)");
    if (edgeList == null || edgeList.length != 2) {
      throw new IllegalArgumentException("There must be 2 edge.");
    }
    if (angleInRadian <= 0 || angleInRadian > Math.PI / 2) {
      throw new IllegalArgumentException("The angle must be in the range of (0, PI/2].");
    }
    initialize(edgeList, angleInRadian);
  }

  void initialize(double[] edgeList, double angleInRadian) {
    System.out.println("[initialize] Parallelogram");
    super.initialize(new double[] { edgeList[0], edgeList[1], edgeList[0], edgeList[1] },
        new double[] { angleInRadian, angleInRadian });
  }
}
