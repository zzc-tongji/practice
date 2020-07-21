package techbow._0021_MinimumCostToMergeStoneWithoutRequirementOfConsecutive;

import java.util.PriorityQueue;
import java.util.Queue;

/*
 * It is similiar as techbow._0020_MinimumCostToMergeStoneWithTwoConsecutivePiles.
 *
 * There is no requirement of consecutive.
 */

public class Solution {
  /*
   * time: O(n)
   *
   * space: O(n)
   */

  public static int mergeStones(int[] stones) {
    if (stones == null || stones.length == 0) {
      throw new IllegalArgumentException("input not valid");
    }
    if (stones.length == 1) {
      return 0;
    }
    Queue<Integer> q = new PriorityQueue<>();
    for (int i = 0; i < stones.length; i++) {
      q.add(stones[i]);
    }
    int current;
    int cost = 0;
    while (q.size() > 1) {
      current = q.remove() + q.remove();
      cost += current;
      q.add(current);
    }
    return cost;
  }
}
