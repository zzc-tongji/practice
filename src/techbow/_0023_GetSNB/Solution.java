package techbow._0023_GetSNB;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Amazon - 2020 new graduate - OA2
 *
 * Amazon is working on a new application for recording internal debts across
 * teams. This program can be used to create groups that show all records of
 * debts between the group members. Given the group debt records observed for
 * this team (including the borrower name, lender name, and debit amount), who
 * in the group has the smallest negative balance?
 *
 * Note: -10 is smaller than -1. If multiple people have the smallest negative
 * balance, return the least in alphabetical order. If nobody has a negative
 * balance, return the list consisting of string "Nobody has a negative
 * balance".
 *
 * Write an algorithm to find who in the group has the smallest negative
 * balance.
 *
 * Input
 *
 * The input to the function/method consists of three arguments:
 *
 * - numRows, an integer representing the number of debt records.
 *
 * - numsCols, an integer representing the number of elements in debt records. It is always 3.
 *
 * - debts, a list of triplets representing debtRecord consisting of a string borrower, a string lender, and an integer amount, representing the debt record.
 *
 * Output
 *
 * return a list of strings representing an alphabetically ordered list of members with the smallest negative balance. If no team member has a negative balance then return a list containing the string "Nobody has a negative balance".
 *
 * Constrains
 *
 * 1 <= numsRows <= a * 10 ^ 5
 *
 * 1 <= amount in debts <= 1000
 *
 * 1 <= length of borrower and leader in debts <= 20
 */

public class Solution {
  /*
   * original solution by Liu
   *
   * time: O(n)
   *
   * space: O(n)
   */

  private static class debtRecord {
    String borrower = "";
    String lender = "";
    int amount = 0;

    @SuppressWarnings("unused")
    debtRecord() {
    }

    debtRecord(String borrower, String lender, int amount) {
      this.borrower = borrower;
      this.lender = lender;
      this.amount = amount;
    }
  }

  static List<String> getSNB(int numRows, int numCols, List<debtRecord> debts) {
    // corner case
    // ...
    // use `HashMap` to calculate the balance
    Map<String, Integer> mapNameBalance = new HashMap<>();
    for (debtRecord debtRecord : debts) {
      String bname = debtRecord.borrower;
      String lname = debtRecord.lender;
      int amount = debtRecord.amount;
      mapNameBalance.put(bname, mapNameBalance.getOrDefault(bname, 0) + amount);
      mapNameBalance.put(lname, mapNameBalance.getOrDefault(lname, 0) - amount);
    }
    // use `HashMap` for inverted index (map-reduce), use `minAmount` to keep the
    // min balance
    Map<Integer, List<String>> mapBalanceName = new HashMap<>();
    int minAmount = 0;
    for (Map.Entry<String, Integer> entry : mapNameBalance.entrySet()) {
      int amount = entry.getValue();
      String name = entry.getKey();
      minAmount = Math.min(minAmount, amount);
      if (!mapBalanceName.containsKey(amount)) {
        mapBalanceName.put(amount, new ArrayList<String>());
      }
      mapBalanceName.get(amount).add(name);
    }
    if (minAmount >= 0) {
      List<String> res = new ArrayList<>();
      res.add("Nobody has a negative balance");
      return res;
    } else {
      return mapBalanceName.get(minAmount);
    }
  }

  public static void main(String[] args) {
    List<debtRecord> debts = new ArrayList<>();
    List<String> res;
    //
    debts.add(new debtRecord("Alex", "Blake", 2));
    debts.add(new debtRecord("Blake", "Alex", 2));
    debts.add(new debtRecord("Casey", "Alex", 5));
    debts.add(new debtRecord("Blake", "Casey", 7));
    debts.add(new debtRecord("Alex", "Blake", 4));
    debts.add(new debtRecord("Alex", "Casey", 4));
    res = getSNB(5, 3, debts);
    for (int i = 0; i < res.size(); i++) {
      System.out.print(res.get(i));
      System.out.print(", ");
    }
    System.out.println("");
    //
    debts.clear();
    debts.add(new debtRecord("Alex", "Blake", 2));
    debts.add(new debtRecord("Blake", "Casey", 2));
    debts.add(new debtRecord("Casey", "Alex", 2));
    res = getSNB(3, 3, debts);
    for (int i = 0; i < res.size(); i++) {
      System.out.print(res.get(i));
      System.out.print(", ");
    }
    System.out.println("");
  }
}
