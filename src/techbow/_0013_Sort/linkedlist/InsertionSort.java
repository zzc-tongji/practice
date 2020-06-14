package techbow._0013_Sort.linkedlist;

import leetcode.ListNode;

public class InsertionSort {
  public static ListNode sort(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    // We need a "demmy node" (fake node) to point to the actual node `head`.
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    //
    ListNode cur = head.next;
    ListNode pre = head;
    while (cur != null) {
      if (pre.val > cur.val) { // use `>` to keep sort stability
        ListNode temp = pickOff(pre, cur);
        insert(dummy, temp);
        cur = pre;
      }
      pre = cur;
      cur = cur.next;
    }
    return dummy.next;
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

  public static void insert(ListNode dummy, ListNode node) {
    // find insertion point
    //
    // No null check needed since it is guaranteed by caller.
    ListNode pre = dummy;
    ListNode cur = dummy.next;
    while (cur.val <= node.val) { // use `<=` to keep sort stability
      pre = cur;
      cur = cur.next;
    }
    // insert before `cur`
    node.next = cur;
    pre.next = node;
    /*
     * time: O(n)
     *
     * space: O(1)
     */
  }
}
