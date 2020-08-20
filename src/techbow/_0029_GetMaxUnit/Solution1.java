package techbow._0029_GetMaxUnit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution1 {
  /*
   * Note: shipping a part of boxes of a product is OK.
   *
   * greedy
   *
   * time: O(n)
   *
   * space: O(n)
   */

  private static class Item implements Comparable<Item> {
    public int number;
    public int unitsPerBox;

    @Override
    public int compareTo(Item o) {
      return Integer.compare(o.unitsPerBox, unitsPerBox);
    }

    public Item(int number, int unitsPerBox) {
      this.number = number;
      this.unitsPerBox = unitsPerBox;
    }
  }

  public static long getMaxUnits(int num, ArrayList<Integer> boxes, int unitSize, ArrayList<Integer> unitsPerBox,
      long truckSize) {
    Queue<Item> queue = new PriorityQueue<>();
    for (int i = 0; i < boxes.size(); i++) {
      queue.add(new Item(boxes.get(i), unitsPerBox.get(i)));
    }
    long result = 0;
    Item temp;
    for (long i = 0; i < truckSize; i++) {
      while (queue.peek().number <= 0) {
        queue.poll();
      }
      temp = queue.peek();
      //
      result += temp.unitsPerBox;
      temp.number -= 1;
    }
    return result;
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
