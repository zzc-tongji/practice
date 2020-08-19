package techbow._0028_ClosestStraightCity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Amazon - 2020 new graduate - OA2
 *
 * Amazon has Fulfillment Centers in multiple cities within a large geographic
 * region. Tho cities are arranged on a graph that has been divided up like an
 * ordinary Cartesian plane. Each city is located at an integral (x, y)
 * coordinate intersection. City names and locations are given in the form of
 * three arrays: c, x, and y, which are aligned by the index to provide the city
 * queryName (c[i]) and its coordinates, (x(i), y(i)).
 *
 * Write an algorithm to determine the queryName of the nearest city that shares
 * either an x or a y coordinate with the queried city. If no other cities share
 * an x or y coordinate, return NONE. If two cities have the same distance to
 * the queried city, q[i], consider the one with an alphabetically smaller queryName
 * (i.e. 'ab' < 'aba' < 'abb.) as the closest choice.
 *
 * The distance is denoted on a Euclidean plane: the difference in x plus the
 * difference in y.
 *
 * Input
 *
 * The input to the function/method consists of six arguments:
 *
 * numOfCities, an integer representing the number of cities;
 *
 * cities, a list of strings representing the names of each city[i];
 *
 * xCoordinates, a list of integers representing the X coordinates of each
 * city[i];
 *
 * - yCoordinates, a list of integers representing the Y coordinates of each
 * city[i];
 *
 * numOfQueries, an integer representing the number of queries;
 *
 * queries, a list of strings representing the names of the queried cities.
 *
 * Output
 *
 * Return a list of strings representing the queryName of the nearest city that
 * shares either an x or a y coordinate with the queried city.
 *
 * Constraints
 *
 * 1 <= numOfCities <= 10 ^ 5
 *
 * 1 <= xCoordinates, yCoordinates <= 10 ^ 9
 *
 * 1 <= length of queries[i] and city[i] <= 10
 *
 * Note
 *
 * Each character of all c[i] and q[i] is in the range ascii[a-z, 0-9, -].
 *
 * All city queryName values, c[i], are unique. All cities have unique coordinates.
 */

public class Solution {
  /*
   * HIT, CORRECT
   *
   * time: O(n ^ 2)
   *
   * space: O(n)
   */

  private static List<String> closestStraightCity(int numOfCities, List<String> cities, List<Integer> xCoordinates,
      List<Integer> yCoordinates, int numOfQueries, List<String> queries) {
    Map<String, Integer> nameToCityIndex = new HashMap<>();
    Map<Integer, List<Integer>> xToCityIndexList = new HashMap<>();
    Map<Integer, List<Integer>> yToCityIndexList = new HashMap<>();
    int x;
    int y;
    for (int i = 0; i < cities.size(); i++) {
      nameToCityIndex.put(cities.get(i), i);
      x = xCoordinates.get(i);
      y = yCoordinates.get(i);
      if (xToCityIndexList.get(x) == null) {
        xToCityIndexList.put(x, new ArrayList<>());
      }
      xToCityIndexList.get(x).add(i);
      if (yToCityIndexList.get(y) == null) {
        yToCityIndexList.put(y, new ArrayList<>());
      }
      yToCityIndexList.get(y).add(i);
    }
    List<String> result = new ArrayList<>();
    int index;
    String queryResult;
    int distance = Integer.MAX_VALUE;
    int delta;
    List<Integer> emptyList = new ArrayList<>();
    for (String queryName : queries) {
      index = nameToCityIndex.getOrDefault(queryName, -1);
      if (index == -1) {
        result.add("NONE");
        continue;
      }
      x = xCoordinates.get(index);
      y = yCoordinates.get(index);
      queryResult = "NONE";
      distance = Integer.MAX_VALUE;
      // same x
      for (int idx : xToCityIndexList.getOrDefault(x, emptyList)) {
        if (idx == index) {
          // skip itself
          continue;
        }
        delta = Math.abs(yCoordinates.get(idx) - yCoordinates.get(index));
        if (delta < distance) {
          queryResult = cities.get(idx);
          distance = delta;
        } else if (delta == distance) {
          if (cities.get(idx).compareTo(queryResult) < 0) {
            queryResult = cities.get(idx);
          }
        }
      }
      // same y
      for (int idx : yToCityIndexList.getOrDefault(y, emptyList)) {
        if (idx == index) {
          // skip itself
          continue;
        }
        delta = Math.abs(xCoordinates.get(idx) - xCoordinates.get(index));
        if (delta < distance) {
          queryResult = cities.get(idx);
          distance = delta;
        } else if (delta == distance) {
          if (cities.get(idx).compareTo(queryResult) < 0) {
            queryResult = cities.get(idx);
          }
        }
      }
      result.add(queryResult);
    }
    return result;
  }

  public static void main(String[] args) {
    // c3, NONE, c1
    List<String> citis = Arrays.asList(new String[] { "c1", "c2", "c3" });
    List<Integer> x = Arrays.asList(new Integer[] { 3, 2, 1 });
    List<Integer> y = Arrays.asList(new Integer[] { 3, 2, 3 });
    List<String> queries = Arrays.asList(new String[] { "c1", "c2", "c3" });
    List<String> result = closestStraightCity(citis.size(), citis, x, y, queries.size(), queries);
    for (int i = 0; i < result.size(); i++) {
      System.out.print(result.get(i));
      System.out.print(", ");
    }
    System.out.println("");
    // NONE, NONE, NONE, NONE, NONE
    citis = Arrays.asList(new String[] { "green", "red", "blue", "yellow", "pink" });
    x = Arrays.asList(new Integer[] { 100,200,300,400,500 });
    y = Arrays.asList(new Integer[] { 100,200,300,400,500 });
    queries = Arrays.asList(new String[] { "green", "red", "blue", "yellow", "pink"  });
    result = closestStraightCity(citis.size(), citis, x, y, queries.size(), queries);
    for (int i = 0; i < result.size(); i++) {
      System.out.print(result.get(i));
      System.out.print(", ");
    }
    System.out.println("");
    // bigbanana, fastcity, bigbanana
    citis = Arrays.asList(new String[] { "fastcity", "bigbanana", "xyz" });
    x = Arrays.asList(new Integer[] { 23, 23, 23 });
    y = Arrays.asList(new Integer[] { 1, 10, 20 });
    queries = Arrays.asList(new String[] { "fastcity", "bigbanana", "xyz" });
    result = closestStraightCity(citis.size(), citis, x, y, queries.size(), queries);
    for (int i = 0; i < result.size(); i++) {
      System.out.print(result.get(i));
      System.out.print(", ");
    }
    System.out.println("");
    // NONE, hackerland, warsaw
    citis = Arrays.asList(new String[] { "london", "warsaw", "hackerland" });
    x = Arrays.asList(new Integer[] { 1, 10, 20 });
    y = Arrays.asList(new Integer[] { 1, 10, 10 });
    queries = Arrays.asList(new String[] { "london", "warsaw", "hackerland" });
    result = closestStraightCity(citis.size(), citis, x, y, queries.size(), queries);
    for (int i = 0; i < result.size(); i++) {
      System.out.print(result.get(i));
      System.out.print(", ");
    }
    System.out.println("");
  }
}
