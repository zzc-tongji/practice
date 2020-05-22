package mydatastructure.heap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyHeap<E extends Comparable<E>> {
  private List<E> data;
  private Set<E> dataSet;

  public MyHeap() {
    data = new ArrayList<>();
    dataSet = new HashSet<>();
  }

  public boolean contains(E e) {
    return dataSet.contains(e);
  }

  public boolean offer(E e) {
    if (dataSet.contains(e)) {
      return false;
    }
    data.add(e);
    siftUp(data.size() - 1);
    dataSet.add(e);
    return true;
  }

  public E peek() {
    if (data.isEmpty()) {
      return null;
    }
    return data.get(0);
  }

  public E poll() {
    if (data.isEmpty()) {
      return null;
    }
    E result = data.get(0);
    swap(0, data.size() - 1);
    data.remove(data.size() - 1);
    siftDown(0);
    dataSet.remove(result);
    return result;
  }

  public boolean update(E e) {
    if (contains(e)) {
      int index = data.indexOf(e);
      swap(index, data.size() - 1);
      data.remove(data.size() - 1);
      siftDown(index);
      dataSet.remove(index);
    }
    return offer(e);
  }

  private void siftUp(int k) {
    int parent = (k - 1) / 2;
    int i = k;
    while (i > 0) {
      parent = (i - 1) / 2;
      if (data.get(i).compareTo(data.get(parent)) > 0) {
        break;
      }
      swap(i, parent);
      i = parent;
    }
  }

  private void siftDown(int k) {
    int child = k * 2 + 1;
    int i = k;
    while (i * 2 + 1 < data.size()) {
      child = i * 2 + 1; // left child
      if (i * 2 + 2 < data.size() && data.get(child).compareTo(data.get(i * 2 + 2)) > 0) {
        child = i * 2 + 2; // right child
      }
      // min-value child
      if (data.get(child).compareTo(data.get(i)) > 0) {
        break;
      }
      swap(i, child);
      i = child;
    }
  }

  private void swap(int i, int j) {
    E temp = data.get(i);
    data.set(i, data.get(j));
    data.set(j, temp);
  }
}
