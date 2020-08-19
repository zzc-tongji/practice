package leetcode._1102_PathWithMaximumMinimumValue;

import java.util.PriorityQueue;

/*
 * 1102. Path With Maximum Minimum Value
 *
 * Given a matrix of integers A with R rows and C columns, find the maximum
 * score of a path starting at [0,0] and ending at [R-1,C-1].
 *
 * The score of a path is the minimum value in that path. For example, the value
 * of the path 8 → 4 → 5 → 9 is 4.
 *
 * A path moves some number of times from one visited cell to any neighbouring
 * unvisited cell in one of the 4 cardinal directions (north, east, west,
 * south).
 *
 * Example 1:
 *
 * https://assets.leetcode.com/uploads/2019/04/23/1313_ex1.JPG
 *
 * Input: [[5,4,5],[1,2,6],[7,4,6]]
 *
 * Output: 4
 *
 * Explanation:
 *
 * The path with the maximum score is highlighted in yellow.
 *
 * Example 2:
 *
 * https://assets.leetcode.com/uploads/2019/04/23/1313_ex2.JPG
 *
 * Input: [[2,2,1,2,2,2],[1,2,2,2,1,2]]
 *
 * Output: 2
 *
 * Example 3:
 *
 * https://assets.leetcode.com/uploads/2019/04/23/1313_ex3.JPG
 *
 * Input:
 * [[3,4,6,3,4],[0,2,1,1,7],[8,8,3,2,7],[3,2,4,9,8],[4,1,2,0,0],[4,6,5,4,3]]
 *
 * Output: 3
 *
 * Note:
 *
 * 1 <= R, C <= 100
 *
 * 0 <= A[i][j] <= 10^9
 */

// @lc app=leetcode id=1102 lang=java
// @lc code=start
public class Solution {
  /*
   * [me]
   *
   * Amazon - 2020 new graduate - OA2
   *
   * similiar as Prim algurithm, more details:
   * https://blog.csdn.net/fuxuemingzhu/article/details/101231938
   *
   * time: O(n)
   *
   * space: O(1)
   */
  private static final int X = 0;
  private static final int Y = 1;
  private static final int MIN_VAL_SO_FAR = 2;

  public int maximumMinimumPath(int[][] A) {
    int row = A.length;
    int column = A[0].length;
    int[] current;
    boolean[][] visited = new boolean[row][column];
    int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> (b[2] - a[2]));
    maxHeap.offer(new int[] { 0, 0, A[0][0] });
    while (!maxHeap.isEmpty()) {
      current = maxHeap.poll();
      if (current[X] == row - 1 && current[Y] == column - 1) {
        // terminate
        return current[MIN_VAL_SO_FAR];
      }
      visited[current[X]][current[Y]] = true;
      for (int[] dir : directions) {
        int newX = dir[0] + current[X];
        int newY = dir[1] + current[Y];
        if (newX >= 0 && newX < row && newY >= 0 && newY < column && !visited[newX][newY]) {
          maxHeap.offer(new int[] { newX, newY, Math.min(current[MIN_VAL_SO_FAR], A[newX][newY]) });
        }
      }
    }
    return -1;
  }
}
// @lc code=end
