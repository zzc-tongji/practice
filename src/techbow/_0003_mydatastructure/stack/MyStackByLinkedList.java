package techbow._0003_mydatastructure.stack;

import java.util.EmptyStackException;

import techbow._0003_mydatastructure.linkedlist.MyLinkedListNode;

public class MyStackByLinkedList<E> {
  private MyLinkedListNode<E> head;

  public MyStackByLinkedList() {
    head = new MyLinkedListNode<E>(null);
    head.next = null;
  }

  public boolean empty() {
    return head.next == null;
  }

  public E peak() {
    if (empty()) {
      throw new EmptyStackException();
    }
    return head.next.value;
  }

  public E pop() {
    if (empty()) {
      throw new EmptyStackException();
    }
    MyLinkedListNode<E> result = head.next;
    head.next = result.next;
    result.next = null;
    return result.value;
  }

  public E push(E item) {
    MyLinkedListNode<E> newNode = new MyLinkedListNode<E>(item);
    newNode.next = head.next;
    head.next = newNode;
    return item;
  }

  @SuppressWarnings("unchecked")
  public int search(Object o) {
    MyLinkedListNode<E> cur = head.next;
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
