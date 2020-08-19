package techbow._0030_SquaredIndex;

import java.util.ArrayList;
import java.util.Arrays;
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
   * There is something not clear - is allows to ship a part of product?
   *
   * If the answer is NO, use the following solution.
   *
   * time: O(n ^ 2)
   *
   * space: O(n ^ 2)
   */

  public static int squaredIndex(int num, List<Integer> boxes, int unitSize, List<Integer> unitsPerBox, int truckSize) {
    List<Integer> unitList = new ArrayList<>();
    for (int i = 0; i < boxes.size(); i++) {
      unitList.add(boxes.get(i) * unitsPerBox.get(i));
    }
    return backPack(truckSize, boxes, unitList);
  }

  private static int backPack(int boxCapacity, List<Integer> boxList, List<Integer> unitList) {
    if (boxList == null || unitList == null || boxList.isEmpty() || unitList.isEmpty()
        || boxList.size() != unitList.size()) {
      return 0;
    }
    int length = boxList.size();
    int[][] dp = new int[length + 1][boxCapacity + 1];
    for (int i = 1; i <= length; i++) {
      for (int j = 1; j <= boxCapacity; j++) {
        dp[i][j] = dp[i - 1][j];
        if (j >= boxList.get(i - 1)) {
          dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - boxList.get(i - 1)] + unitList.get(i - 1));
        }
      }
    }
    return dp[length][boxCapacity];
  }

  public static void main(String[] args) {
    // 7
    List<Integer> boxes = Arrays.asList(new Integer[] { 1, 2, 3 });
    List<Integer> unitsPerBox = Arrays.asList(new Integer[] { 3, 2, 1 });
    System.out.println(squaredIndex(boxes.size(), boxes, unitsPerBox.size(), unitsPerBox, 3));
    // 4
    boxes = Arrays.asList(new Integer[] { 1, 2, 3 });
    unitsPerBox = Arrays.asList(new Integer[] { 3, 2, 1 });
    System.out.println(squaredIndex(boxes.size(), boxes, unitsPerBox.size(), unitsPerBox, 2));
    // 3
    boxes = Arrays.asList(new Integer[] { 1, 2, 3 });
    unitsPerBox = Arrays.asList(new Integer[] { 3, 6, 1 });
    System.out.println(squaredIndex(boxes.size(), boxes, unitsPerBox.size(), unitsPerBox, 1));
  }
}
