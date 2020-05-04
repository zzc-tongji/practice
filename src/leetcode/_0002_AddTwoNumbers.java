package leetcode;

/**
 * 2. Add Two Numbers
 *
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 *
 * Output: 7 -> 0 -> 8
 *
 * Explanation: 342 + 465 = 807.
 */
public class _0002_AddTwoNumbers {
  public static void main(String[] args) {
    System.out.println("Hello world.");
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode l1p = l1;
    ListNode l2p = l2;
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    int carry = 0;
    // add each bit with carry
    while (l1p != null || l2p != null) {
      cur.next = new ListNode(0);
      cur.next.val += l1p != null ? l1p.val : 0;
      cur.next.val += l2p != null ? l2p.val : 0;
      cur.next.val += carry;
      carry = 0;
      if (cur.next.val >= 10) {
        cur.next.val -= 10;
        carry = 1;
      }
      if (l1p != null) {
        l1p = l1p.next;
      }
      if (l2p != null) {
        l2p = l2p.next;
      }
      cur = cur.next;
    }
    // add carry to the hightest bit
    if (carry == 1) {
      cur.next = new ListNode(1);
    }
    return dummy.next;
    /*
     * time: O(n)
     *
     * space: O(1)
     */
  }
}
