package mydatastructure.queue;

import java.util.NoSuchElementException;
import mydatastructure.linkedlist.MyLinkedListNode;

public class MyQueueByLinkedListWithoutDummyNode<E> {
  private MyLinkedListNode<E> head;
  private MyLinkedListNode<E> tail;
  private int size;

  public MyQueueByLinkedListWithoutDummyNode() {
    head = null;
    tail = null;
    size = 0;
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

  private E peakHelper() {
    return head.value;
  }

  private E pollHelper() {
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
