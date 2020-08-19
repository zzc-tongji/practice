package techbow._0022_GetTimes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Amazon - 2020 new graduate - OA2
 *
 * Imagine a small Amazon Go store that has exactly one turnstile. It can be
 * used by customers either as an entrance or an exit. Sometimes multiple
 * customers want to pass through the turnstile and their directions can be
 * different. The ith customer comes to the turnstile at time N and wants to
 * either exit the store if direction[iJ =1 or enter the store if direction[i] =
 * O. Customers form 2 queues, one to exit and one to enter. They are ordered by
 * the time when they came to the turnstile and. if the times are equal, by
 * their indices.
 *
 * If one customer wants to enter the store and another customer wants to exit
 * at the same moment, there are three cases:
 *
 * 1. If in the previous second the turnstile was not used (maybe it was used
 * before, but not at the previous second), then the customer who wants to exit
 * goes first.
 *
 * 2. If in the previous second the turnstile was used as an exit, then the
 * customer who wants to leave goes first
 *
 * 3. If in the previous second the turnstile was used as an entrance, then the
 * customer who wants to enter goes first.
 *
 * Passing through the turnstile takes 1 second.
 *
 * Write an algorithm to find the time for each customer when they will pass
 * through the turnstile.
 *
 * Input
 *
 * The function/method consists of three arguments:
 *
 * numCustomers, an integer representing the number of customers (n);
 *
 * arrTime, a list of integers where the value at index i is the time in
 * seconds when the ith customer will come to the turnstile;
 *
 * direction, a list of integers where the value at index i is the direction
 * of the ith customer.
 *
 * Output
 *
 * Return a list of integers where the value at index i is the time when the ith
 * customer will pass
 */

public class Solution {
  /*
   * original solution by Liu
   *
   * time: O(n)
   *
   * space: O(n)
   */

  static List<Integer> getTimes(int numCustomers, List<Integer> arrTime, List<Integer> direction) {
    List<Integer> res = new ArrayList<Integer>(numCustomers);
    for (int i = 0; i < numCustomers; i++) {
      res.add(Integer.MIN_VALUE);
    }
    Queue<int[]> queueEnter = new LinkedList<>();
    Queue<int[]> queueExit = new LinkedList<>();
    for (int i = 0; i < numCustomers; i++) {
      if (direction.get(i) == 0) { // 0 is enter
        queueEnter.offer(new int[] { i, arrTime.get(i), 0 }); // {i-th, arrTime. direction}
      } else { // 1 is exit
        queueExit.offer(new int[] { i, arrTime.get(i), 1 });
      }
    }
    int[] preStatus = new int[] { -2, -1 }; // {time, direction}
    while (!queueEnter.isEmpty() || !queueExit.isEmpty()) {
      int[] peekEnter;
      int[] peekExit;
      int realEnterTime;
      int realExitTime;
      if (queueExit.isEmpty()) {
        peekEnter = queueEnter.poll();
        realEnterTime = Math.max(preStatus[0] + 1, peekEnter[1]);
        res.set(peekEnter[0], realEnterTime);
        preStatus = new int[] { realEnterTime, peekEnter[2] };
      } else if (queueEnter.isEmpty()) {
        peekExit = queueExit.poll();
        realExitTime = Math.max(preStatus[0] + 1, peekExit[1]);
        res.set(peekExit[0], realExitTime);
        preStatus = new int[] { realExitTime, peekExit[2] };
      } else { // both not empty
        peekEnter = queueEnter.peek();
        peekExit = queueExit.peek();
        // We need real time since `arrTime` may be delayed by tie.
        realEnterTime = Math.max(preStatus[0] + 1, peekEnter[1]);
        realExitTime = Math.max(preStatus[0] + 1, peekExit[1]);
        if (realEnterTime < realExitTime) {
          res.set(peekEnter[0], realEnterTime);
          queueEnter.poll();
          preStatus = new int[] { realEnterTime, peekEnter[2] };
        }
        if (realEnterTime > realExitTime) {
          res.set(peekExit[0], realExitTime);
          queueExit.poll();
          preStatus = new int[] { realExitTime, peekExit[2] };
        }
        if (realEnterTime == realExitTime) {
          if (realEnterTime > preStatus[0] + 1) {
            res.set(peekExit[0], realExitTime);
            queueExit.poll();
            preStatus = new int[] { realExitTime, peekExit[2] };
          }
          if (realEnterTime == preStatus[0] + 1) {
            if (preStatus[1] == 0) {
              res.set(peekEnter[0], realEnterTime);
              queueEnter.poll();
              preStatus = new int[] { realEnterTime, peekEnter[2] };
            }
            if (preStatus[1] == 1) {
              res.set(peekExit[0], realExitTime);
              queueExit.poll();
              preStatus = new int[] { realExitTime, peekExit[2] };
            }
          }
        }
      }
    }
    return res;
  }

  public static void main(String[] args) {
    // [2, 0, 1, 5]
    List<Integer> res = getTimes(4, Arrays.asList(0, 0, 1, 5), Arrays.asList(0, 1, 1, 0));
    for (int i = 0; i < res.size(); i++) {
      System.out.print(res.get(i));
      System.out.print(", ");
    }
    System.out.println("");
    // [4, 0, 5, 1, 6, 2, 7, 3, 10, 22, 20, 21]
    res = getTimes(12, Arrays.asList(0, 0, 1, 1, 2, 2, 3, 3, 10, 20, 20, 21),
        Arrays.asList(0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 1));
    for (int i = 0; i < res.size(); i++) {
      System.out.print(res.get(i));
      System.out.print(", ");
    }
    System.out.println("");
    // [0, 2, 1, 4, 3]
    res = getTimes(5, Arrays.asList(0, 1, 1, 3, 3), Arrays.asList(0, 1, 0, 0, 1));
    for (int i = 0; i < res.size(); i++) {
      System.out.print(res.get(i));
      System.out.print(", ");
    }
    System.out.println("");
    // [4, 5, 0, 1, 2, 6, 3]
    res = getTimes(7, Arrays.asList(0, 0, 0, 0, 1, 1, 3), Arrays.asList(0, 0, 1, 1, 1, 0, 1));
    for (int i = 0; i < res.size(); i++) {
      System.out.print(res.get(i));
      System.out.print(", ");
    }
    System.out.println("");
    // [3, 4, 0, 1, 2, 5, 6]
    res = getTimes(7, Arrays.asList(0, 0, 0, 0, 1, 1, 4), Arrays.asList(0, 0, 1, 1, 1, 0, 1));
    for (int i = 0; i < res.size(); i++) {
      System.out.print(res.get(i));
      System.out.print(", ");
    }
    System.out.println("");
  }
}
