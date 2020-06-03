package techbow._0003_mydatastructure.linkedlist;

public class MyLinkedList<E> {
  private MyLinkedListNode<E> head;
  private MyLinkedListNode<E> tail;
  private int size;

  public MyLinkedList() {
    head = new MyLinkedListNode<E>(null);
    tail = new MyLinkedListNode<E>(null);
    head.next = tail;
    tail.previous = head;
    size = 0;
  }

  public boolean add(E element) {
    MyLinkedListNode<E> insertPoint = tail.previous;
    MyLinkedListNode<E> newNode = new MyLinkedListNode<>(element);
    newNode.next = tail;
    newNode.previous = insertPoint;
    insertPoint.next = newNode;
    tail.previous = newNode;
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
    MyLinkedListNode<E> removedNode = locate(index);
    removedNode.previous.next = removedNode.next;
    removedNode.next.previous = removedNode.previous;
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
      location = head.next;
      for (int i = 0; i < index; i++) {
        location = location.next;
      }
    } else {
      location = tail.previous;
      for (int i = size - 1; i > index; i--) {
        location = location.previous;
      }
    }
    return location;
  }
}
