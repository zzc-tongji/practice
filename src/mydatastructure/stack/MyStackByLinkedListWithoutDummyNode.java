package mydatastructure.stack;

import java.util.EmptyStackException;
import mydatastructure.linkedlist.MyLinkedListNode;

public class MyStackByLinkedListWithoutDummyNode<E> {
  private MyLinkedListNode<E> head;

  public MyStackByLinkedListWithoutDummyNode() {
    head = null;
  }

  public boolean empty() {
    return head == null;
  }

  public E peak() {
    if (empty()) {
      throw new EmptyStackException();
    }
    return head.value;
  }

  public E pop() {
    if (empty()) {
      throw new EmptyStackException();
    }
    MyLinkedListNode<E> result = head;
    head = head.next;
    result.next = null;
    return result.value;
  }

  public E push(E item) {
    MyLinkedListNode<E> newNode = new MyLinkedListNode<E>(item);
    if (empty()) {
      head = newNode;
    } else {
      newNode.next = head.next;
      head.next = newNode;
    }
    return item;
  }

  @SuppressWarnings("unchecked")
  public int search(Object o) {
    MyLinkedListNode<E> cur = head;
    int counter = 1;
    while (cur != null) {
      if (cur.value.equals((E) o)) {
        return counter;
      }
      cur = cur.next;
      counter += 1;
    }
    return -1;
  }
}
