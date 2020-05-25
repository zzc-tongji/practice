package leetcode;

/*
 * 0206. Reverse Linked List
 *
 * Reverse a singly linked list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL
 *
 * Output: 5->4->3->2->1->NULL
 *
 * Follow up:
 *
 * A linked list can be reversed either iteratively or recursively. Could you
 * implement both?
 */
public class _0206_ReverseLinkedList {
  public static void main(String[] args) {
    System.out.println("Hello world.");
  }

  public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode newHead = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return newHead;
    /*
     * time: O(n)
     *
     * space: O(1)
     */
  }

  public ListNode reverseList1(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode pre = null;
    ListNode cur = head;
    ListNode post = null;
    while (cur != null) {
      post = cur.next;
      cur.next = pre;
      pre = cur;
      cur = post;
    }
    // status after one loop:
    //
    // null <=== node1 .... node2 ===> node3 ===> node4 ===> null
    // .......... | ........ |
    // ......... pre ...... post
    // .........  ........... cur
    //
    // status after all loops:
    //
    // null <=== node1 <=== node2 <=== node3 <=== node4 .... null
    // ........................................... | ........ |
    // .......................................... pre ...... post
    // ..................................................... cur
    return pre;
    /*
     * time: O(n)
     *
     * space: O(1)
     */
  }

  public ListNode reverseList2(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode dummy = new ListNode(0);
    ListNode cur = head;
    ListNode post = null;
    while (cur != null) {
      post = cur.next;
      cur.next = dummy.next;
      dummy.next = cur;
      cur = post;
    }
    return dummy.next;
    /*
     * time: O(n)
     *
     * space: O(1)
     */
  }

  public void templateFunction() {
    System.out.println("Template");
    /*
     * time: O(1)
     *
     * space: O(1)
     */
  }
}
