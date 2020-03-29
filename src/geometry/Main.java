package geometry;

public class Main {
  public static void main(String[] args) {
    // error: cannot instantiate abstract class
    // TwoDimensionalGeometry shape0 = new ConvexQuadrilateralAbstract();
    System.out.println();

    double[] edgeList = new double[] { 176, 154, 159, 78 };
    double[] angleListInRadian = new double[] { Math.toRadians(71), Math.toRadians(104) };
    ConvexQuadrilateralAbstract shape1 = new ConvexQuadrilateral(edgeList, angleListInRadian);
    // Even the following line contains an error, it still works fine.
    // TwoDimensionalGeometry shape1 = new ConvexQuadrilateral(edgeList,
    // angleListInRadian);
    System.out.println("------------------------------");
    System.out.println("Classify:  " + shape1.classify());
    System.out.println("Perimeter: " + shape1.calculatePerimeter());
    System.out.println("Area:      " + shape1.calculateArea());
    System.out.println();

    edgeList = new double[] { 176, 154 };
    double angleInRadian = Math.PI / 3;
    ConvexQuadrilateralAbstract shape2 = new Parallelogram(edgeList, angleInRadian);
    System.out.println("------------------------------");
    System.out.println("Classify:  " + shape2.classify());
    System.out.println("Perimeter: " + shape2.calculatePerimeter());
    System.out.println("Area:      " + shape2.calculateArea());
    System.out.println();

    ConvexQuadrilateralAbstract shape3 = new Rhombus(176, Math.PI / 6);
    System.out.println("------------------------------");
    System.out.println("Classify:  " + shape3.classify());
    System.out.println("Perimeter: " + shape3.calculatePerimeter());
    System.out.println("Area:      " + shape3.calculateArea());
    System.out.println();

    ConvexQuadrilateralAbstract shape4 = new Rectangle(176, 154);
    System.out.println("------------------------------");
    System.out.println("Classify:  " + shape4.classify());
    System.out.println("Perimeter: " + shape4.calculatePerimeter());
    System.out.println("Area:      " + shape4.calculateArea());
    System.out.println();

    ConvexQuadrilateralAbstract shape5 = new Square(176);
    System.out.println("------------------------------");
    System.out.println("Classify:  " + shape5.classify());
    System.out.println("Perimeter: " + shape5.calculatePerimeter());
    System.out.println("Area:      " + shape5.calculateArea());
    System.out.println();

    Triangle shape6 = new Triangle(7, 11, 13);
    System.out.println("------------------------------");
    System.out.print("Draw:      ");
    shape6.draw();
    System.out.println("Perimeter: " + shape6.calculatePerimeter());
    System.out.println("Area:      " + shape6.calculateArea());
    System.out.println();
    System.out.println("------------------------------");
    TwoDimensionalGeometry shape7 = new Triangle(3, 4, 5);
    System.out.print("Draw:      ");
    ((Triangle) shape7).draw();
    System.out.println("Perimeter: " + shape7.calculatePerimeter());
    System.out.println("Area:      " + shape7.calculateArea());
    System.out.println();
  }
}
