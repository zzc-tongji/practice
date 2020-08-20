package techbow._0030_ClosestSquaredDistance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * Amazon - 2020 new graduate - OA2
 *
 * The year is 2125 and Amazon has built a galactic-scale warehouse on the edge
 * of the Orion Spur of the Milky Way Galaxy. The warehouse is a single story
 * space station measuring 1E9 meters in length and width (1 billion meters, or
 * approximately 3.3 light seconds). The warehouse runs a fleet of up to 10,000
 * autonomous robots which magnetically attach to the floor of the station,
 * eliminating the need for artificial gravity. Amazon has asked you to find the
 * squared distance between the two closest robots
 *
 * Given the position of n robots in the warehouse, write an algorithm to find
 * the squared shortest distance between them.
 *
 * Input
 *
 * The function/method consists of three arguments:
 *
 * numRobots, an integer representing the number of robots (n);
 *
 * posirionX, a list of integers representing the x coordinates of the robot's
 * position, in meters;
 *
 * positionY: a list of integers representing the y coordinates of the robot's
 * position, in meters.
 *
 * Output
 *
 * Return an integer representing the squared shortest distance between the
 * pairs of robots.
 *
 * Constraints
 *
 * 2 <= numRobots <= 10 ^ 5
 *
 * 0 <= positionX[i], positionY[i] < 10 ^ 9
 *
 * Note
 *
 * The squared distance between a pair of robots with xy coordinates of
 * positions (X1,Y1) and (X2,Y2) is calculated using the formula
 * (X1-X2)^2+(Y1-Y2)^2.
 *
 * If the squared distance is 0 between a pair of robots the robots are present
 * at the same position and the distance will not be considered.
 */

public class Solution {
  /*
   * CORRECT
   *
   * tips: brute force method cost O(n ^ 2) time may cause "time limit exceeded".
   *
   * time: best = average = O(n log n), worst = O(n ^ 2)
   *
   * - average: Points destribute as random uniform, which means the number points
   * near the "middle" points ("NEAR") is approximately constant. As a result,
   * T(n) = O(n log n) + U(n) and U(n) = 2 * U(n / 2) + O(1). Based on the master
   * theorem, T(n) = O(n log n).
   *
   * - worst: Almost all points accumulates near all "middle" points, which means
   * almost all points need to be compared. As a result, T(n) = O(n ^ 2).
   *
   * space: O(n)
   */

  public static class Coordinate {
    public long x;
    public long y;

    public Coordinate(long x, long y) {
      this.x = x;
      this.y = y;
    }
  }

  public static long closestSquaredDistance(int numRobots, List<Integer> positionX, List<Integer> positionY) {
    List<Coordinate> pointList = new ArrayList<>();
    for (int i = 0; i < numRobots; i++) {
      pointList.add(new Coordinate(positionX.get(i), positionY.get(i)));
    }
    // sort based on x
    Collections.sort(pointList, (o1, o2) -> {
      return Long.compare(o1.x, o2.x);
    });
    // divide and conquer
    return divide(0, numRobots - 1, pointList);
  }

  private static long divide(int left, int right, List<Coordinate> pointList) {
    // The function returns the minimum square distance of points in `pointList`
    // from index `left` to `right` (inclusive).
    long minSquareDistance = Long.MAX_VALUE;
    // 1 point
    if (left == right) {
      return minSquareDistance;
    }
    // 2 points
    if (left + 1 == right) {
      return calculateSquareDistance(pointList.get(left), pointList.get(right));
    }
    // Divide points into two parts. Calculate the minimum square distance of each
    // part.
    int middle = left + (right - left) / 2;
    long leftMinSquareDistance = divide(left, middle, pointList);
    long rightMinSquareDistance = divide(middle, right, pointList);
    // The minimum square of all part is the minumum of the following:
    //
    // (I) the minimum square distance of the left part; (II) which of the right
    // part;
    minSquareDistance = Math.min(leftMinSquareDistance, rightMinSquareDistance);
    // (III) which of points "NEAR" the divider (middle point)
    //
    // First, add all points "NEAR" as a candidate.
    List<Integer> ListOfCandidatePointBesideMiddleDivider = new ArrayList<>();
    for (int i = left; i <= right; i++) {
      // FILTER_1
      if (square(pointList.get(middle).x - pointList.get(i).x) <= minSquareDistance) {
        // "NEAR" is defined as the square of x-difference is not larger than,
        // the current minimum square.
        ListOfCandidatePointBesideMiddleDivider.add(i);
      }
    }
    // compare each pair of nodes in "NEAR"
    long squareDistance;
    for (int i = 0; i < ListOfCandidatePointBesideMiddleDivider.size() - 1; i++) {
      for (int j = i + 1; j < ListOfCandidatePointBesideMiddleDivider.size(); j++) {
        // FILTER_2
        if (square(pointList.get(ListOfCandidatePointBesideMiddleDivider.get(i)).y
            - pointList.get(ListOfCandidatePointBesideMiddleDivider.get(j)).y) > minSquareDistance) {
          // If the square of y-difference exceeds the current minimum square,
          // it is imposible to get a smaller value. Ignore it to save time.
          continue;
        }
        // calculate square distance and update
        squareDistance = calculateSquareDistance(pointList.get(ListOfCandidatePointBesideMiddleDivider.get(i)),
            pointList.get(ListOfCandidatePointBesideMiddleDivider.get(j)));
        minSquareDistance = Math.min(squareDistance, minSquareDistance);
      }
    }
    return minSquareDistance;
  }

  private static long calculateSquareDistance(Coordinate coordinate1, Coordinate coordinate2) {
    return square(coordinate1.x - coordinate2.x) + square(coordinate1.y - coordinate2.y);
  }

  private static long square(long x) {
    return x * x;
  }

  public static void main(String[] args) {
    // 2
    System.out.println(closestSquaredDistance(3, Arrays.asList(0, 1, 2), Arrays.asList(0, 1, 4)));
    // 125
    System.out.println(closestSquaredDistance(3, Arrays.asList(0, 10, 15), Arrays.asList(0, 10, 20)));
    // 250064
    System.out
        .println(closestSquaredDistance(4, Arrays.asList(77, 1000, 992, 1000000), Arrays.asList(10, 1000, 500, 0)));
  }
}
