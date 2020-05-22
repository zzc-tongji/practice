package mydatastructure.queue;

import java.util.NoSuchElementException;
import mydatastructure.linkedlist.MyLinkedListNode;

public class MyQueueByLinkedList<E> {
  private MyLinkedListNode<E> head;
  private MyLinkedListNode<E> tail;

  public MyQueueByLinkedList() {
    head = new MyLinkedListNode<E>(null);
    tail = new MyLinkedListNode<E>(null);
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
    MyLinkedListNode<E> newNode = new MyLinkedListNode<>(e);
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
    MyLinkedListNode<E> result = head.next;
    result.next.previous = head;
    head.next = result.next;
    result.previous = null;
    result.next = null;
    return result.value;
  }
}
