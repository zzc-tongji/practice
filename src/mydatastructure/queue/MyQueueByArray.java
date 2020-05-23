package mydatastructure.queue;

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

  public boolean offer(E e) {
    if (size >= data.length) {
      try {
        enlargeCapacity();
      } catch (IllegalStateException exception) {
        return false;
      }
    }
    data[tail] = e;
    plus(tail, 1);
    size += 1;
    return true;
  }

  @SuppressWarnings("unchecked")
  public E peek() {
    if (size <= 0) {
      return null;
    }
    return (E) data[head];
  }

  @SuppressWarnings("unchecked")
  public E poll() {
    if (size <= 0) {
      return null;
    }
    E result = (E) data[head];
    head = plus(head, 1);
    size -= 1;
    return result;
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

  private int plus(int index, int offset) {
    return (index + offset) % data.length;
  }
}
