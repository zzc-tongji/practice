package techbow._0029_GetMaxUnit;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Amazon - 2020 new graduate - OA2
 *
 * An amazon warehouse manager needs to create a shipment to fill a trunk. All
 * of the products is in the warehouse are in boxes of the same sie. Each
 * product is packed in some number of units per box.
 *
 * Given the number of boxes the trunk can hold, write an algorithm to determine
 * the maximum number of units of any mix of products that can be shipped.
 *
 * Input
 *
 * The input to the function/method consists of five arguments:
 *
 * num, an integer representing number of products;
 *
 * boxes, a list of integer representing the number of available boxes for
 * products;
 *
 * unitSize, an integer representing size of unixPerBox;
 *
 * unitPerBox, a list of integer representing the number of units packed in each
 * box;
 *
 * truckSize, an integer representing the number of boxes the truck can carry.
 *
 * Output
 *
 * Return an integer representing the maximum units that can be carried by the
 *
 * truck.
 *
 * Constraints
 *
 * 1 <= |boxes| <= 10 ^ 5
 *
 * |boxes| == |unitsPerBox|
 *
 * 1 <= boxes[i] <= 10 ^ 7
 *
 * 1 <= i < |boxes|
 *
 * 1 <= unitsPerBox[j] <= 10 ^ 5
 *
 * 1 <= j < |unitsPerBox|
 *
 * 1 <= truckSize <= 10 ^ 8
 *
 * Note
 *
 * |list name| denotes length of the list/
 */

public class Solution {
  /*
   * Note: shipping a part of boxes of a product is OK.
   *
   * 0-1 back pack by DP, maybe out of memory
   *
   * time: O(n ^ 2)
   *
   * space: O(n ^ 2)
   */

  public static long getMaxUnits(int num, ArrayList<Integer> boxes, int unitSize, ArrayList<Integer> unitsPerBox,
      long truckSize) {
    ArrayList<Integer> boxList = new ArrayList<>();
    ArrayList<Integer> unitList = new ArrayList<>();
    for (int i = 0; i < boxes.size(); i++) {
      for (int j = 0; j < boxes.get(i); j++) {
        boxList.add(1);
        unitList.add(unitsPerBox.get(i));
      }
    }
    return backPack(truckSize, boxList, unitList);
  }

  private static long backPack(long boxCapacity, ArrayList<Integer> boxList, ArrayList<Integer> unitList) {
    if (boxList == null || unitList == null || boxList.isEmpty() || unitList.isEmpty()
        || boxList.size() != unitList.size()) {
      return 0;
    }
    int length = boxList.size();
    long[][] dp = new long[length + 1][(int) boxCapacity + 1];
    for (int i = 1; i <= length; i++) {
      for (int j = 1; j <= boxCapacity; j++) {
        dp[i][j] = dp[i - 1][j];
        if (j >= boxList.get(i - 1)) {
          dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - boxList.get(i - 1)] + unitList.get(i - 1));
        }
      }
    }
    return dp[length][(int) boxCapacity];
  }

  public static void main(String[] args) {
    // 7
    ArrayList<Integer> boxes = new ArrayList<>(Arrays.asList(new Integer[] { 1, 2, 3 }));
    ArrayList<Integer> unitsPerBox = new ArrayList<>(Arrays.asList(new Integer[] { 3, 2, 1 }));
    System.out.println(getMaxUnits(boxes.size(), boxes, unitsPerBox.size(), unitsPerBox, 3L));
    // 2
    boxes = new ArrayList<>(Arrays.asList(new Integer[] { 1 }));
    unitsPerBox = new ArrayList<>(Arrays.asList(new Integer[] { 2 }));
    System.out.println(getMaxUnits(boxes.size(), boxes, unitsPerBox.size(), unitsPerBox, 1L));
    // 27
    boxes = new ArrayList<>(Arrays.asList(new Integer[] { 3, 1, 6 }));
    unitsPerBox = new ArrayList<>(Arrays.asList(new Integer[] { 2, 7, 4 }));
    System.out.println(getMaxUnits(boxes.size(), boxes, unitsPerBox.size(), unitsPerBox, 6L));
  }
}
