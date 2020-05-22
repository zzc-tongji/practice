package mydatastructure.graph;

import java.util.HashMap;
import java.util.Map;

public class MyGraphNode<V> {
  final static double DEFAULT_WEIGHT = 1.0;

  public V value;
  public Map<MyGraphNode<V>, Double> neighborList;

  @Override
  @SuppressWarnings("unchecked")
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (this == obj) {
      return true;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    MyGraphNode<V> o = (MyGraphNode<V>) obj;
    return value.equals(o.value);
  }

  @Override
  public int hashCode() {
    return value.hashCode();
  }

  public MyGraphNode(V v) {
    value = v;
    neighborList = new HashMap<>();
  }

  public void addNeighbor(MyGraphNode<V> node) {
    addNeighbor(node, DEFAULT_WEIGHT);
  }

  public void addNeighbor(MyGraphNode<V> node, double weight) {
    neighborList.put(node, weight);
  }
}
