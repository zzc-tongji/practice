package leetcode;

/**
 * 0024. Swap Nodes in Pairs
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * You may not modify the values in the list's nodes, only nodes itself may be
 * changed.
 *
 * Example:
 *
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 */
public class _0024_SwapNodesInPairs {
  public static void main(String[] args) {
    System.out.println("Hello world.");
  }

  public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode subHead = swapPairs(head.next.next);
    head.next.next = head;
    ListNode newHead = head.next;
    head.next = subHead;
    return newHead;
    /*
     * time: O(n ^ 2)
     *
     * space: O(1)
     */
  }
}
