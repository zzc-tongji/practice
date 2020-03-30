package geometry;

public class ConvexQuadrilateral extends ConvexQuadrilateralAbstract {
  double[] edgeList;
  // [0], [1], [2], [3] ===> a, b, c, d
  double[] angleListInRadian;
  // [0] ===> angle between a and b
  // [1] ===> angle between c and d
  //
  // Note: [0] and [1] might not be actual angles.
  // In fact, the sum of [0] and [1] is used to calculate the area.

  @Override
  public double calculatePerimeter() {
    return calculatePerimeterHelper(edgeList);
  }

  @Override
  public double calculateArea() {
    // Heron's formula for convex quadrilateral
    double p = (edgeList[0] + edgeList[1] + edgeList[2] + edgeList[3]) / 2;
    return Math
        .sqrt((p - edgeList[0]) * (p - edgeList[1]) * (p - edgeList[2]) * (p - edgeList[3]) - edgeList[0] * edgeList[1]
            * edgeList[2] * edgeList[3] * Math.pow(Math.cos((angleListInRadian[0] + angleListInRadian[1]) / 2), 2));
  }

  @Override
  public String classify() {
    return "Convex Quadrilateral";
  }

  ConvexQuadrilateral() {
    System.out.println("[constructor] ConvexQuadrilateral");
  }

  public ConvexQuadrilateral(double[] edgeList, double[] angleListInRadian) {
    super();
    System.out.println("[constructor] ConvexQuadrilateral with argument(s)");
    setEdgeList(edgeList);
    setAngleListInRadian(angleListInRadian);
  }

  /**
   * @return the edgeList
   */
  public double[] getEdgeList() {
    double[] edgeList = new double[this.edgeList.length];
    for (int i = 0; i < this.edgeList.length; i++) {
      edgeList[i] = this.edgeList[i];
    }
    return edgeList;
  }

  /**
   * @param edgeList the edgeList to set
   */
  public void setEdgeList(double[] edgeList) {
    if (edgeList == null || edgeList.length != 4) {
      throw new IllegalArgumentException("There must be 4 edges.");
    }
    double halfSum = calculatePerimeterHelper(edgeList) / 2;
    this.edgeList = new double[edgeList.length];
    for (int i = 0; i < edgeList.length; i++) {
      if (edgeList[i] >= halfSum) {
        throw new IllegalArgumentException(
            "The length of each edge must emaller than the total length of other 3 edges.");
      }
      this.edgeList[i] = edgeList[i];
    }
  }

  /**
   * @return the angleListInRadian
   */
  public double[] getAngleListInRadian() {
    double[] angleListInRadian = new double[this.angleListInRadian.length];
    for (int i = 0; i < this.angleListInRadian.length; i++) {
      angleListInRadian[i] = this.angleListInRadian[i];
    }
    return angleListInRadian;
  }

  /**
   * @param angleListInRadian the angleListInRadian to set
   */
  public void setAngleListInRadian(double[] angleListInRadian) {
    if (angleListInRadian == null || angleListInRadian.length != 2) {
      throw new IllegalArgumentException("There must be 2 angles to set");
    }
    this.angleListInRadian = new double[angleListInRadian.length];
    for (int i = 0; i < angleListInRadian.length; i++) {
      if (angleListInRadian[i] >= Math.PI) {
        throw new IllegalArgumentException("Each angles be must emaller than PI.");
      }
      this.angleListInRadian[i] = angleListInRadian[i];
    }
  }

  void initialize(double[] edgeList, double[] angleListInRadian) {
    System.out.println("[initialize] ConvexQuadrilateral");
    this.edgeList = edgeList;
    this.angleListInRadian = angleListInRadian;
  }

  private double calculatePerimeterHelper(double[] edgeList) {
    double sum = 0;
    for (int i = 0; i < edgeList.length; i++) {
      sum += edgeList[i];
    }
    return sum;
  }
}
