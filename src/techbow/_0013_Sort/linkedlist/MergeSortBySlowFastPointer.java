package techbow._0013_Sort.linkedlist;

import leetcode.ListNode;

public class MergeSortBySlowFastPointer {
  public static ListNode sort(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    // use slow-fast node pointer to get middle point (`slow.next`)
    //
    // For a linked list with 2 nodes, `slow` will be the first node.
    // So use the post-node of `slow` as the divider to avoid stack overflow.
    ListNode slow = head;
    ListNode fast = head.next;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    // disconnect `l1` and `l2` below
    ListNode post = slow.next;
    slow.next = null;
    // divide
    ListNode l1 = sort(head);
    ListNode l2 = sort(post);
    // conquer
    return Merge.merge(l1, l2);
    /*
     * time: O(n log n)
     *
     * space: O(1)
     */
  }
}
