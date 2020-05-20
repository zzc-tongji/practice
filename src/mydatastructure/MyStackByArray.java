package mydatastructure;

import java.util.Arrays;
import java.util.EmptyStackException;

public class MyStackByArray<E> {
  private static final int DEFAULT_INITIAL_CAPACITY = 16;

  private Object[] data;
  private int top;

  public MyStackByArray() {
    this(DEFAULT_INITIAL_CAPACITY);
  }

  public MyStackByArray(int initialCapacity) {
    data = new Object[initialCapacity]; // valid in [0, top)
    top = 0;
  }

  public boolean empty() {
    return top <= 0;
  }

  public E peak() {
    if (empty()) {
      throw new EmptyStackException();
    }
    return (E) data[top - 1];
  }

  public E pop() {
    if (empty()) {
      throw new EmptyStackException();
    }
    E result = (E) data[top - 1];
    top -= 1;
    return result;
  }

  public E push(E item) {
    if (top >= data.length) {
      enlargeCapacity();
    }
    data[top] = item;
    top += 1;
    return item;
  }

  public int search(Object o) {
    for (int i = 0; i < top; i++) {
      if (((E) data[i]).equals((E) o)) {
        return i + 1;
      }
    }
    return -1;
  }

  private void enlargeCapacity() {
    try {
      data = Arrays.copyOf(data, data.length << 1);
    } catch (NegativeArraySizeException e) {
      throw new IllegalStateException();
    }
  }
}
