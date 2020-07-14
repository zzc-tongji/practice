package unclassified.datastructure.arraylist;

import java.util.Arrays;

public class MyArrayList<E> {
  private static final int DEFAULT_INITIAL_CAPACITY = 16;

  private Object[] data;
  private int size;

  public MyArrayList() {
    this(DEFAULT_INITIAL_CAPACITY);
  }

  public MyArrayList(int initialCapacity) {
    data = new Object[initialCapacity];
    size = 0;
  }

  public boolean add(E element) {
    if (size == data.length) {
      enlargeCapacity();
    }
    data[size] = element;
    size += 1;
    return true;
  }

  public void add(int index, E element) {
    if (index == size) {
      add(element);
    }
    verifyIndex(index);
    if (size == data.length) {
      enlargeCapacity();
    }
    // right shift
    for (int i = size - 1; i > index; i--) {
      data[i + 1] = data[i];
    }
    data[index] = element;
    size += 1;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  @SuppressWarnings("unchecked")
  public E get(int index) {
    verifyIndex(index);
    return (E) data[index];
  }

  public E set(int index, E element) {
    verifyIndex(index);
    data[index] = element;
    return element;
  }

  public E remove(int index) {
    E res = get(index);
    // left shift
    for (int i = index; i < size; i++) {
      data[i] = data[i + 1];
    }
    size -= 1;
    return res;
  }

  public int size() {
    return size;
  }

  private void enlargeCapacity() {
    data = Arrays.copyOf(data, data.length << 1);
  }

  private void verifyIndex(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
  }
}
