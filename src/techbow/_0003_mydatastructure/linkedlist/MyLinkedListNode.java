package techbow._0003_mydatastructure.linkedlist;

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
