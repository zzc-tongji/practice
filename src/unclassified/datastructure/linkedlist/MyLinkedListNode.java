package unclassified.datastructure.linkedlist;

public class MyLinkedListNode<E> {
  public E value;
  public MyLinkedListNode<E> previous;
  public MyLinkedListNode<E> next;

  public MyLinkedListNode() {
    this(null);
  }

  public MyLinkedListNode(E v) {
    value = v;
    previous = null;
    next = null;
  }
}
