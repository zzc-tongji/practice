package mydatastructure.graph;

import java.util.HashMap;
import java.util.Map;

public class MyGraphNode<V> {
  final static double DEFAULT_WEIGHT = 1.0;

  public V value;
  public Map<MyGraphNode<V>, Double> neighborList;

  public MyGraphNode(V x) {
    value = x;
    neighborList = new HashMap<>();
  }

  public void addNeighbor(MyGraphNode<V> node) {
    addNeighbor(node, DEFAULT_WEIGHT);
  }

  public void addNeighbor(MyGraphNode<V> node, double weight) {
    neighborList.put(node, weight);
  }
}
