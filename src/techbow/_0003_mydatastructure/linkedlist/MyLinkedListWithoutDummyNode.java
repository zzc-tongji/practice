package techbow._0003_mydatastructure.linkedlist;

public class MyLinkedListWithoutDummyNode<E> {
  private MyLinkedListNode<E> head;
  private MyLinkedListNode<E> tail;
  private int size;

  public MyLinkedListWithoutDummyNode() {
    head = null;
    tail = null;
    size = 0;
  }

  public boolean add(E element) {
    MyLinkedListNode<E> newNode = new MyLinkedListNode<>(element);
    if (size == 0) {
      head = newNode;
      tail = newNode;
    } else {
      tail.next = newNode;
      newNode.previous = tail;
      tail = newNode;
    }
    size += 1;
    return true;
  }

  public void add(int index, E element) {
    if (index == size) {
      add(element);
      return;
    }
    MyLinkedListNode<E> insertPoint = locate(index);
    MyLinkedListNode<E> newNode = new MyLinkedListNode<>(element);
    newNode.next = insertPoint.next;
    newNode.previous = insertPoint;
    insertPoint.next.previous = newNode;
    insertPoint.next = newNode;
    size += 1;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public E get(int index) {
    return locate(index).value;
  }

  public E set(int index, E element) {
    locate(index).value = element;
    return element;
  }

  public E remove(int index) {
    MyLinkedListNode<E> removedNode;
    if (size == 1) {
      removedNode = head;
      head = null;
      tail = null;
    } else {
      removedNode = locate(index);
      removedNode.previous.next = removedNode.next;
      removedNode.next.previous = removedNode.previous;
    }
    size -= 1;
    return removedNode.value;
  }

  public int size() {
    return size;
  }

  private MyLinkedListNode<E> locate(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
    MyLinkedListNode<E> location;
    if (index < (size - 1) / 2) {
      location = head;
      for (int i = 0; i < index; i++) {
        location = location.next;
      }
    } else {
      location = tail;
      for (int i = size - 1; i > index; i--) {
        location = location.previous;
      }
    }
    return location;
  }
}
