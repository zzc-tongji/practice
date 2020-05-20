package mydatastructure;

import java.util.NoSuchElementException;

public class MyQueueByArray<E> {
  private static final int DEFAULT_INITIAL_CAPACITY = 16;

  private Object[] data;
  private int head;
  private int tail;
  private int size;

  public MyQueueByArray() {
    this(DEFAULT_INITIAL_CAPACITY);
  }

  public MyQueueByArray(int initialCapacity) {
    data = new Object[initialCapacity]; // valid in [head, tail)
    head = 1;
    tail = 1;
    size = 0;
  }

  public boolean add(E e) {
    try {
      offer(e);
    } catch (IllegalStateException exception) {
      return false;
    }
    return true;
  }

  public E element() {
    if (size <= 0) {
      throw new NoSuchElementException();
    }
    return peakHelper();
  }

  public boolean offer(E e) {
    if (size >= data.length) {
      enlargeCapacity();
    }
    data[tail] = e;
    plus(tail, 1);
    size += 1;
    return true;
  }

  public E peek() {
    if (size <= 0) {
      return null;
    }
    return peakHelper();
  }

  public E poll() {
    if (size <= 0) {
      return null;
    }
    return pollHelper();
  }

  public E remove() {
    if (size <= 0) {
      throw new NoSuchElementException();
    }
    return pollHelper();
  }

  private void enlargeCapacity() {
    Object[] newData;
    try {
      newData = new Object[data.length << 1];
    } catch (NegativeArraySizeException e) {
      throw new IllegalStateException();
    }
    for (int i = 0; i < data.length; i++) {
      newData[i] = data[plus(head, i)];
    }
    data = newData;
    head = 0;
    tail = size;
  }

  private E peakHelper() {
    return (E) data[head];
  }

  private E pollHelper() {
    E result = (E) data[head];
    head = plus(head, 1);
    size -= 1;
    return result;
  }

  private int plus(int index, int offset) {
    return (index + offset) % data.length;
  }
}
