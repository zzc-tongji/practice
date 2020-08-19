package techbow._0026_MinCost;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * Amazon - 2020 new graduate - OA2
 *
 * Your team at Amazon is overseeing the design of a new, high-efficiency data
 * center at HQ2, A power grid needs to be generated for supplying power to N
 * servers. All servers in the grid have to be connected such that they have
 * access to power. The cost of connections between different servers varies.
 *
 * Assume that there are no ties, the names of servers are unique, connections
 * are directionless, there is at most one connection between a pair of servers,
 * all costs are greater than zero, and a server does not connect to itself.
 *
 * Write an algorithm to minimize the cost of connecting all servers in the
 * power grid.
 *
 * Input
 *
 * The input to the function/method consists of two arguments
 *
 * num, an integer representing the number of connections.
 *
 * connection, representing a list of Connections where each element of the
 * list consists of two servers and the cost of connection between the servers.
 * Output
 *
 * Return a list of Connections where each element of the list consists of two
 * servers and the cost of connection between the servers such that all servers
 * are connected at the lowest total cost. If no such Connections exist, then
 * return a list with empty Connection
 *
 * Note
 *
 * The cost of connection between the servers is always greater than 0.
 */

public class Solution {
  /*
   * minimum spanning tree / union find
   *
   * time: O(n ^ 2)
   *
   * space: O(n)
   */

  private static class Connection {
    String firstTown;
    String secondTown;
    int cost;

    @Override
    public String toString() {
      return String.format("%s - %s (%d)", firstTown, secondTown, cost);
    }

    Connection(String firstTown, String secondTown, int cost) {
      this.firstTown = firstTown;
      this.secondTown = secondTown;
      this.cost = cost;
    }
  }

  private static List<Connection> minCost(int num, List<Connection> connection) {
    // corner case
    if (connection == null || connection.size() <= 0) {
      return new ArrayList<>();
    }
    // Kruskal: prepare
    Map<String, String> root = new HashMap<>(); // <server, root> - the smallest string as the root name
    Queue<Connection> queue = new PriorityQueue<>(new Comparator<Connection>() {
      @Override
      public int compare(Connection o1, Connection o2) {
        return o1.cost - o2.cost;
      }
    }); // help to get the edge as cost from small to large
    for (Connection c : connection) {
      queue.offer(c);
      root.put(c.firstTown, c.firstTown);
      root.put(c.secondTown, c.secondTown);
    }
    // Kruskal: main
    Connection edge;
    String root0;
    String root1;
    String newRoot;
    List<Connection> result = new ArrayList<>();
    while (!queue.isEmpty()) {
      edge = queue.poll();
      root0 = root.get(edge.firstTown);
      root1 = root.get(edge.secondTown);
      if (root0.equals(root1)) {
        // ignore nodes which has been in the same tree
        continue;
      }
      // prepare new root
      newRoot = root0.compareTo(root1) < 0 ? root0 : root1;
      // connect
      result.add(edge);
      // update
      root.put(edge.firstTown, newRoot);
      root.put(edge.secondTown, newRoot);
      for (Map.Entry<String, String> entry : root.entrySet()) {
        if (entry.getValue().equals(edge.firstTown)) {
          root.put(entry.getKey(), newRoot);
        }
        if (entry.getValue().equals(edge.secondTown)) {
          root.put(entry.getKey(), newRoot);
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    // A - B (1)
    // B - C (4)
    // C - E (1)
    // D - E (5)
    List<Connection> input = new ArrayList<>();
    input.add(new Connection("A", "B", 1));
    input.add(new Connection("B", "C", 4));
    input.add(new Connection("B", "D", 6));
    input.add(new Connection("D", "E", 5));
    input.add(new Connection("C", "E", 1));
    List<Connection> output = minCost(5, input);
    for (int i = 0; i < output.size(); i++) {
      System.out.println(output.get(i));
    }
    System.out.println();
  }
}
