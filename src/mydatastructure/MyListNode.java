package mydatastructure;

class MyListNode<E> {
  E value;
  MyListNode<E> previous;
  MyListNode<E> next;

  public MyListNode(final E v) {
    value = v;
    previous = null;
    next = null;
  }
}
