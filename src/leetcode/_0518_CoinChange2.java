package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 0518. Coin Change 2
 *
 * You are given coins of different denominations and a total amount of money.
 * Write a function to compute the number of combinations that make up that
 * amount. You may assume that you have infinite number of each kind of coin.
 *
 * Example 1:
 *
 * Input: amount = 5, coins = [1, 2, 5]
 *
 * Output: 4
 *
 * Explanation: there are four ways to make up the amount:
 *
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 *
 * Example 2:
 *
 * Input: amount = 3, coins = [2]
 *
 * Output: 0
 *
 * Explanation: the amount of 3 cannot be made up just with coins of 2.
 *
 * Example 3:
 *
 * Input: amount = 10, coins = [10]
 *
 * Output: 1
 *
 * Note:
 *
 * You can assume that
 *
 * - 0 <= amount <= 5000
 *
 * - 1 <= coin <= 5000
 *
 * - the number of coins is less than 500
 *
 * - the answer is guaranteed to fit into signed 32-bit int
 */
public class _0518_CoinChange2 {
  public static void main(String[] args) {
    System.out.println("Hello world.");
  }

  public int change(int amount, int[] coins) {
    // LeetCode: Memory Limit Exceeded
    if (coins == null || coins.length <= 0) {
      return amount == 0 ? 1 : 0;
    }
    // dfs
    int[] solution = new int[coins.length];
    List<int[]> result = new ArrayList<>();
    dfs(coins, 0, amount, solution, result);
    return result.size();
    /*
     * time: O(solution number)
     *
     * space: O(1)
     */
  }

  private void dfs(int coins[], int level, int leftBalance, int[] solution, List<int[]> result) {
    if (leftBalance < 0) {
      // triming (1)
      return;
    }
    if (leftBalance == 0) {
      // leaf node as result
      result.add(Arrays.copyOf(solution, solution.length));
      return;
    }
    if (level >= coins.length) {
      // trimming (2)
      return;
    }
    int l = leftBalance;
    // use 0 coins[level]
    dfs(coins, level + 1, l, solution, result);
    // use 1+ coins[level]
    while (l >= 0) {
      solution[level] += 1;
      l -= coins[level];
      dfs(coins, level + 1, l, solution, result);
    }
    // triming (1)
  }

  public int change1(int amount, int[] coins) {
    // LeetCode: Memory Limit Exceeded
    //
    // Duplicate solutions are not removed,
    // like 25+25+10+10+10+10+10=100 and 10+10+10+10+10+25+25=100.
    if (coins == null || coins.length <= 0) {
      return amount == 0 ? 1 : 0;
    }
    // dfs
    List<Integer> solution = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();
    dfs1(coins, amount, solution, result);
    return result.size();
    /*
     * time: O(solution number)
     *
     * space: O(1)
     */
  }

  private void dfs1(int coins[], int leftBalance, List<Integer> solution, List<List<Integer>> result) {
    if (leftBalance < 0) {
      // triming
      return;
    }
    if (leftBalance == 0) {
      // leaf node as result
      result.add(new ArrayList<>(solution));
      return;
    }
    for (int i = 0; i < coins.length; i++) {
      solution.add(coins[i]);
      dfs1(coins, leftBalance - coins[i], solution, result);
      solution.remove(solution.size() - 1); // backtracking
    }
  }
}
