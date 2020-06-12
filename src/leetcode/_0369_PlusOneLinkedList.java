package leetcode;

/*
 * 369. Plus One Linked List
 *
 * Given a non-negative integer represented as non-empty a singly linked list of
 * digits, plus one to the integer.
 *
 * You may assume the integer do not contain any leading zero, except the number
 * 0 itself.
 *
 * The digits are stored such that the most significant digit is at the head of
 * the list.
 *
 * Example :
 *
 * Input: [1,2,3]
 *
 * Output: [1,2,4]
 */
public class _0369_PlusOneLinkedList {
  public ListNode plusOne(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode headReverse = reverseList(head);
    ListNode pre = null;
    ListNode cur = headReverse;
    int carry = 0;
    // 10^{0}
    cur.val = cur.val + 1;
    if (cur.val >= 10) {
      cur.val -= 10;
      carry = 1;
    }
    pre = cur;
    cur = cur.next;
    // 10^{n}, n > 0
    while (cur != null) {
      cur.val = cur.val + carry;
      carry = 0;
      if (cur.val >= 10) {
        cur.val -= 10;
        carry = 1;
      }
      pre = cur;
      cur = cur.next;
    }
    // add carry to the hightest bit
    if (carry == 1) {
      pre.next = new ListNode(1);
    }
    return reverseList(headReverse);
    /*
     * time: O(n)
     *
     * space: O(1)
     */
  }

  private ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode newHead = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return newHead;
  }
}
