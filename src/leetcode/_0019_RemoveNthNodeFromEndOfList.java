/**
 * 0019. Remove Nth Node From End of List
 *
 * Given a linked list, remove the n-th node from the end of list and return its
 * head.
 *
 * Example:
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes
 * 1->2->3->5.
 *
 * Note:
 *
 * Given n will always be valid.
 *
 * Follow up:
 *
 * Could you do this in one pass?
 */
public class _0019_RemoveNthNodeFromEndOfList {
  public static void main(String[] args) {
    System.out.println("Hello world.");
  }

  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode pre = null;
    ListNode slow = head;
    ListNode fast = head;
    int counter = 0;
    while (counter < n) {
      fast = fast.next;
      counter++;
    }
    while (fast != null) {
      pre = slow;
      slow = slow.next;
      fast = fast.next;
    }
    // `slow` is the selected node, remove it.
    if (pre != null) {
      pre.next = slow.next;
      return head;
    }
    // `pre == null` means the head node should be removed (`slow == head`),
    // As a result, return `slow.next`.
    return slow.next;
    /*
     * time: O(n)
     *
     * space: O(1)
     */
  }
}
