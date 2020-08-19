package techbow._0022_GetTimes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution1 {
  /*
   * make some difference of solution 1
   *
   * time: O(n)
   *
   * space: O(n)
   */

  private static final int IN = 0;
  private static final int OUT = 1;
  //
  private static final int ARR_TIME = 0;
  private static final int DIRECTION = 1;
  private static final int CUSTOMER = 2;

  static List<Integer> getTimes(int numCustomers, List<Integer> arrTime, List<Integer> direction) {
    List<Integer> res = new ArrayList<Integer>(numCustomers);
    for (int i = 0; i < numCustomers; i++) {
      res.add(Integer.MIN_VALUE);
    }
    Queue<int[]> queueIn = new LinkedList<>();
    Queue<int[]> queueOut = new LinkedList<>();
    for (int i = 0; i < numCustomers; i++) {
      if (direction.get(i) == 0) { // 0 is enter
        queueIn.offer(new int[] { arrTime.get(i), IN, i }); // {i-th, arrTime. direction}
      } else { // 1 is exit
        queueOut.offer(new int[] { arrTime.get(i), OUT, i });
      }
    }
    int[] in;
    int[] out;
    int realInTime;
    int realOutTime;
    int[] preStat = new int[] { Integer.MIN_VALUE, Integer.MIN_VALUE }; // {time, direction}
    while (true) {
      if (queueIn.isEmpty() && queueOut.isEmpty()) {
        break;
      }
      if (queueOut.isEmpty()) {
        in = queueIn.poll();
        realInTime = Math.max(preStat[ARR_TIME] + 1, in[ARR_TIME]);
        res.set(in[CUSTOMER], realInTime);
        //
        preStat[ARR_TIME] = realInTime;
        preStat[DIRECTION] = in[DIRECTION];
      } else if (queueIn.isEmpty()) {
        out = queueOut.poll();
        realOutTime = Math.max(preStat[ARR_TIME] + 1, out[ARR_TIME]);
        res.set(out[CUSTOMER], realOutTime);
        //
        preStat[ARR_TIME] = realOutTime;
        preStat[DIRECTION] = out[DIRECTION];
      } else { // both not empty
        in = queueIn.peek();
        out = queueOut.peek();
        // We need real time since `arrTime` may be delayed by tie.
        realInTime = Math.max(preStat[ARR_TIME] + 1, in[ARR_TIME]);
        realOutTime = Math.max(preStat[ARR_TIME] + 1, out[ARR_TIME]);
        if (realInTime < realOutTime) {
          res.set(in[CUSTOMER], realInTime);
          queueIn.poll();
          //
          preStat[ARR_TIME] = realInTime;
          preStat[DIRECTION] = in[DIRECTION];
        } else if (realInTime > realOutTime) {
          res.set(out[CUSTOMER], realOutTime);
          queueOut.poll();
          //
          preStat[ARR_TIME] = realOutTime;
          preStat[DIRECTION] = out[DIRECTION];
        } else { // realInTime == realOutTime
          if (realInTime > preStat[ARR_TIME] + 1) {
            res.set(out[CUSTOMER], realOutTime);
            queueOut.poll();
            //
            preStat[ARR_TIME] = realOutTime;
            preStat[DIRECTION] = out[DIRECTION];
          } else { // realInTime == preStat[ARR_TIME] + 1
            if (preStat[DIRECTION] == IN) {
              res.set(in[CUSTOMER], realInTime);
              queueIn.poll();
              //
              preStat[ARR_TIME] = realInTime;
              preStat[DIRECTION] = in[DIRECTION];
            } else { // preStat[DIRECTION] == OUT
              res.set(out[CUSTOMER], realOutTime);
              queueOut.poll();
              //
              preStat[ARR_TIME] = realOutTime;
              preStat[DIRECTION] = out[DIRECTION];
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
