package unclassified.datastructure.queue;

import unclassified.datastructure.linkedlist.MyLinkedListNode;

public class MyQueueByLinkedListWithoutDummyNode<E> {
  private MyLinkedListNode<E> head;
  private MyLinkedListNode<E> tail;
  private int size;

  public MyQueueByLinkedListWithoutDummyNode() {
    head = null;
    tail = null;
    size = 0;
  }

  public boolean offer(E e) {
    MyLinkedListNode<E> newNode = new MyLinkedListNode<>(e);
    if (size <= 0) {
      head = newNode;
      tail = newNode;
    } else {
      newNode.previous = tail;
      tail.next = newNode;
      tail = newNode;
    }
    size += 1;
    return true;
  }

  public E peek() {
    if (head.next == tail) {
      return null;
    }
    return head.value;
  }

  public E poll() {
    if (size <= 0) {
      return null;
    }
    MyLinkedListNode<E> result = head;
    if (size <= 1) {
      head = null;
      tail = null;
    } else {
      head = head.next;
      head.previous = null;
      result.next = null;
    }
    size -= 1;
    return result.value;
  }
}
