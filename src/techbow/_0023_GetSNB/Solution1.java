package techbow._0023_GetSNB;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1 {
  /*
   * make some difference of solution 1, also:
   *
   * - add corner case
   *
   * - fix a bug about result sequence
   *
   * time: O(n)
   *
   * space: O(n)
   */

  private static class debtRecord {
    String borrower = "";
    String lender = "";
    int amount = 0;

    debtRecord(String borrower, String lender, int amount) {
      this.borrower = borrower;
      this.lender = lender;
      this.amount = amount;
    }
  }

  static List<String> getSNB(int numRows, int numCols, List<debtRecord> debts) {
    // corner case
    List<String> emptyResult = new ArrayList<>();
    emptyResult.add("Nobody has a negative balance");
    if (debts == null || debts.size() == 0) {
      return emptyResult;
    }
    // use `HashMap` to calculate the balance
    Map<String, Integer> mapNameBalance = new HashMap<>();
    for (debtRecord debtRecord : debts) {
      mapNameBalance.put(debtRecord.borrower, mapNameBalance.getOrDefault(debtRecord.borrower, 0) + debtRecord.amount);
      mapNameBalance.put(debtRecord.lender, mapNameBalance.getOrDefault(debtRecord.lender, 0) - debtRecord.amount);
    }
    // use `HashMap` for inverted index (map-reduce)
    Map<Integer, List<String>> mapBalanceName = new HashMap<>();
    // use `minAmount` to keep the min balance
    int minAmount = 0;
    int amount;
    String name;
    for (Map.Entry<String, Integer> entry : mapNameBalance.entrySet()) {
      amount = entry.getValue();
      name = entry.getKey();
      minAmount = Math.min(minAmount, amount);
      if (!mapBalanceName.containsKey(amount)) {
        mapBalanceName.put(amount, new ArrayList<>());
      }
      mapBalanceName.get(amount).add(name);
    }
    if (minAmount >= 0) {
      return emptyResult;
    }
    List<String> result = mapBalanceName.get(minAmount);
    Collections.sort(result);
    return result;
  }

  public static void main(String[] args) {
    List<debtRecord> debts = new ArrayList<>();
    List<String> res;
    // Casey
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
    // Nobody has a negative balance
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
    // Blake, David, Frank
    debts.clear();
    debts.add(new debtRecord("Alex", "Blake", 20));
    debts.add(new debtRecord("Casey", "David", 20));
    debts.add(new debtRecord("Ella", "Frank", 20));
    res = getSNB(3, 3, debts);
    for (int i = 0; i < res.size(); i++) {
      System.out.print(res.get(i));
      System.out.print(", ");
    }
    System.out.println("");
  }
}
