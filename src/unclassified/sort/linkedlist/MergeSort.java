package unclassified.sort.linkedlist;

import leetcode.ListNode;

public class MergeSort {
  public static ListNode sort(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    // use slow-fast distance pointer to get middle point (`slow`)
    //
    // For a linked list with 2 nodes, `slow` will be the last node.
    // So use the pre-node of `slow` as the divider to avoid stack overflow.
    ListNode pre = null;
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      pre = slow;
      slow = slow.next;
      fast = fast.next.next;
    }
    // disconnect `l1` and `l2` below
    pre.next = null;
    // divide
    ListNode l1 = sort(head);
    ListNode l2 = sort(slow);
    // conquer
    return Merge.merge(l1, l2);
    /*
     * time: O(n log n)
     *
     * space: O(1)
     */
  }
}
