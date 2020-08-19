package techbow._0025_GetBusiestNode;

import java.util.ArrayList;
import java.util.List;

/*
 * Amazon - 2020 new graduate - OA2
 *
 * Imagine that an employment tree represents the formal employee hierarchy at
 * Amazon. Manager nodes have child nodes for each employee that reports to
 * them; each of these employees can, in turn, have child nodes representing
 * their respective reporters. Each node in the tree contains an integer
 * representing the number of months the employee has spent at the company. Team
 * tenure is computed as the average tenure of the manager and all the company
 * employees working below the manager. The oldest team has the highest team
 * tenure.
 *
 * Write an algorithm to find the manager of the team with the highest tenure.
 * An employee must have child nodes to be a manager.
 *
 * Input
 *
 * The input to the function/method consists of an argument
 *
 * - president, a node representing the root node of the employee hierarchy.
 *
 * Output
 *
 * Return the node which has the oldest team.
 *
 * Note
 *
 * There will be at least one child node in the tree and there will be no ties.
 */

public class Solution {
  /*
   * HIT, CORRECT
   *
   * time: O(n)
   *
   * space: O(n)
   */

  private static class EmployeeNode {
    public int value;
    public List<EmployeeNode> subEmployeeNode;

    @SuppressWarnings("unused")
    public EmployeeNode() {
      subEmployeeNode = new ArrayList<>();
    }

    public EmployeeNode(int value) {
      this.value = value;
      subEmployeeNode = new ArrayList<>();
    }
  }

  private static double maxAverageTenure = Double.MIN_VALUE;
  private static EmployeeNode maxAverageTenureTeam = null;

  private static EmployeeNode getBusiestNode(EmployeeNode president) {
    helper(president);
    return maxAverageTenureTeam;
  }

  private static double[] helper(EmployeeNode employee) {
    // corner case
    if (employee == null) {
      return new double[] { 0, 0 };
    }
    // calculate
    boolean leaf = employee.subEmployeeNode == null || employee.subEmployeeNode.isEmpty();
    double employeeNumber = 0;
    double tenureSum = 0;
    double[] temp;
    if (!leaf) {
      for (EmployeeNode node : employee.subEmployeeNode) {
        temp = helper(node);
        employeeNumber += temp[0];
        tenureSum += temp[1];
      }
    }
    employeeNumber += 1;
    tenureSum += employee.value;
    // average
    if (!leaf) {
      double average = tenureSum / employeeNumber;
      if (average > maxAverageTenure) {
        if (!leaf) {
          maxAverageTenure = average;
          maxAverageTenureTeam = employee;
        }
      }
    }
    // return
    return new double[] { employeeNumber, tenureSum };
  }

  public static void main(String[] args) {
    // 18
    EmployeeNode president = new EmployeeNode(20);
    president.subEmployeeNode = new ArrayList<>();
    president.subEmployeeNode.add(new EmployeeNode(12));
    president.subEmployeeNode.add(new EmployeeNode(18));
    president.subEmployeeNode.get(0).subEmployeeNode = new ArrayList<>();
    president.subEmployeeNode.get(0).subEmployeeNode.add(new EmployeeNode(11));
    president.subEmployeeNode.get(0).subEmployeeNode.add(new EmployeeNode(2));
    president.subEmployeeNode.get(0).subEmployeeNode.add(new EmployeeNode(3));
    president.subEmployeeNode.get(1).subEmployeeNode = new ArrayList<>();
    president.subEmployeeNode.get(1).subEmployeeNode.add(new EmployeeNode(15));
    president.subEmployeeNode.get(1).subEmployeeNode.add(new EmployeeNode(8));
    System.out.println(getBusiestNode(president).value);
  }
}
