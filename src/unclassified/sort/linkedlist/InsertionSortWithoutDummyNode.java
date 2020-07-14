package unclassified.sort.linkedlist;

import leetcode.ListNode;

public class InsertionSortWithoutDummyNode {
  public static ListNode sort(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode cur = head.next;
    ListNode pre = head;
    while (cur != null) {
      if (pre.val > cur.val) { // use `>` to keep sort stability
        ListNode temp = pickOff(pre, cur);
        head = insert(head, temp);
        cur = pre;
      }
      pre = cur;
      cur = cur.next;
    }
    return head;
    /*
     * time: O(n ^ 2)
     *
     * space: O(1)
     */
  }

  private static ListNode pickOff(ListNode pre, ListNode node) {
    // pick off `node`
    pre.next = node.next;
    node.next = null;
    return node;
  }

  public static ListNode insert(ListNode head, ListNode node) {
    // find insertion point
    //
    // No null check needed since it is guaranteed by caller.
    //
    // `node` as the first one
    if (node.val < head.val) {
      node.next = head;
      return node;
    }
    //
    ListNode pre = head;
    ListNode cur = head.next;
    while (cur.val <= node.val) { // use `<=` to keep sort stability
      pre = cur;
      cur = cur.next;
    }
    // insert before `cur`
    node.next = cur;
    pre.next = node;
    return head;
    /*
     * time: O(n)
     *
     * space: O(1)
     */
  }
}
