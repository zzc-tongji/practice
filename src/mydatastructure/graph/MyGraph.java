package mydatastructure.graph;

import java.util.ArrayList;
import java.util.List;

public class MyGraph<V> {
  List<MyGraphNode<V>> componentList;

  MyGraph() {
    componentList = new ArrayList<>();
  }
}
