package leetcode;

/*
 * 0092. Reverse Linked List II
 *
 * Reverse a linked list from position m to n. Do it in one-pass.
 *
 * Note: 1 ≤ m ≤ n ≤ length of list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 *
 * Output: 1->4->3->2->5->NULL
 */
public class _0092_ReverseLinkedListII {
  public static void main(String[] args) {
    System.out.println("Hello world.");
  }

  public ListNode reverseBetween(ListNode head, int m, int n) {
    ListNode pre = null;
    ListNode cur = head;
    int counter = m - 1;
    while (counter > 0) {
      pre = cur;
      cur = cur.next;
      counter -= 1;
    }
    cur = reverseList(pre, cur, n - m + 1);
    // example:
    //
    // head = node1
    // m = 1
    // n = 2
    //
    // after executing `reverseList`:
    //
    // null <==== node1 <=== node2 <=== node3
    // . | ....... | ................... |
    // pre ...... head ................ cur
    return m == 1 ? cur : head;
     /*
     * time: O(n)
     *
     * space: O(1)
     */
  }

  private ListNode reverseList(ListNode preposition, ListNode head, int length) {
    // reverse the linked-list
    //
    // - starts with `head`
    // - has `length` node(s)
    // - is linked on (preposition node is) `preposition`
    if (head == null || length <= 0) {
      throw new IllegalArgumentException();
    }
    ListNode pre = preposition;
    ListNode cur = head;
    ListNode post = null;
    int counter = length;
    // Use counter rather than null to determine the end,
    // which is differnet to the method `reverseList1`
    // in file `_0206_ReverseLinkedList`.
    while (cur != null && counter > 0) {
      post = cur.next;
      cur.next = pre;
      pre = cur;
      cur = post;
      counter -= 1;
    }
    // example:
    //
    // preposition = node1
    // head = node2
    // length = 3
    //
    // status after all loops:
    //
    // node1 ===> node2 <=== node3 <=== node4 .... node5 ===> null
    // . | ......... | ................. | ........ |
    // preposition . head ............. pre ...... post
    // ........................................... cur
    if (preposition != null) {
      preposition.next = pre;
    }
    head.next = post;
    return pre;
  }
}
