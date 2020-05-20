package mydatastructure;

import java.util.NoSuchElementException;

public class MyQueueByLinkedList<E> {
  private MyListNode<E> head;
  private MyListNode<E> tail;

  public MyQueueByLinkedList() {
    head = new MyListNode<E>(null);
    tail = new MyListNode<E>(null);
    head.next = tail;
    tail.previous = head;
  }

  public boolean add(E e) {
    return offer(e);
  }

  public E element() {
    if (head.next == tail) {
      throw new NoSuchElementException();
    }
    return peakHelper();
  }

  public boolean offer(E e) {
    MyListNode<E> newNode = new MyListNode<>(e);
    newNode.previous = tail.previous;
    newNode.next = tail;
    tail.previous = newNode;
    return true;
  }

  public E peek() {
    if (head.next == tail) {
      return null;
    }
    return peakHelper();
  }

  public E poll() {
    if (head.next == tail) {
      return null;
    }
    return pollHelper();
  }

  public E remove() {
    if (head.next == tail) {
      throw new NoSuchElementException();
    }
    return pollHelper();
  }

  private E peakHelper() {
    return head.next.value;
  }

  private E pollHelper() {
    MyListNode<E> result = head.next;
    result.next.previous = head;
    head.next = result.next;
    result.previous = null;
    result.next = null;
    return result.value;
  }
}
