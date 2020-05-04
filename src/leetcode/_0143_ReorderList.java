package leetcode;

/**
 * 0143. Reorder List
 *
 * Given a singly linked list L: L_{0} → L_{1} → ... → L_{n-1} → L_{n}, reorder
 * it to: L_{0} → L_{n} → L_{1} → L_{n-1} → L_{2} → L_{n-2} → ...
 *
 * You may not modify the values in the list's nodes, only nodes itself may be
 * changed.
 *
 * Example 1:
 *
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 *
 * Example 2:
 *
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 */
public class _0143_ReorderList {
  public static void main(String[] args) {
    System.out.println("Hello world.");
  }

  public void reorderList(ListNode head) {
    // corner case: less or equal to 2 nodes
    if (head == null || head.next == null || head.next.next == null) {
      return;
    }
    // use slow-fast distance pointer to split the linked list
    ListNode pre = head;
    ListNode left = head.next;
    ListNode slow = left;
    ListNode fast = slow;
    while (fast != null && fast.next != null) {
      pre = slow;
      slow = slow.next;
      fast = fast.next.next;
    }
    pre.next = null;
    // reverse the right part
    ListNode right = reverseList(slow);
    // merge
    ListNode cur = head;
    slow = left;
    fast = right;
    while (true) {
      // first right then left, one by one
      if (fast != null) {
        cur.next = fast;
        cur = cur.next;
        fast = fast.next;
      }
      if (slow != null) {
        cur.next = slow;
        cur = cur.next;
        slow = slow.next;
      }
      if (slow == null && fast == null) {
        return;
      }
    }
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
