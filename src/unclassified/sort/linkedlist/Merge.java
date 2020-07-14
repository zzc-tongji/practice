package unclassified.sort.linkedlist;

import leetcode.ListNode;

class Merge {
  public static ListNode merge(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    ListNode l1p = l1;
    ListNode l2p = l2;
    while (l1p != null && l2p != null) {
      if (l1p.val < l2p.val) {
        cur.next = l1p;
        l1p = l1p.next;
      } else {
        cur.next = l2p;
        l2p = l2p.next;
      }
      cur = cur.next;
    }
    cur.next = l1p != null ? l1p : l2p;
    return dummy.next;
    /*
     * time: O(n)
     *
     * space: O(1)
     */
  }

  public ListNode mergeWithoutDummyNode(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    }
    if (l2 == null) {
      return l1;
    }
    ListNode res;
    ListNode l1p = l1;
    ListNode l2p = l2;
    if (l1.val < l2.val) {
      res = l1;
      l1p = l1.next;
      l2p = l2;
    } else {
      res = l2;
      l1p = l1;
      l2p = l2.next;
    }
    ListNode cur = res;
    while (l1p != null && l2p != null) {
      if (l1p.val < l2p.val) {
        cur.next = l1p;
        l1p = l1p.next;
      } else {
        cur.next = l2p;
        l2p = l2p.next;
      }
      cur = cur.next;
    }
    cur.next = l1p != null ? l1p : l2p;
    return res;
    /*
     * time: O(n)
     *
     * space: O(1)
     */
  }

  public ListNode mergeByRecursion(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    }
    if (l2 == null) {
      return l1;
    }
    if (l1.val < l2.val) {
      l1.next = mergeByRecursion(l1.next, l2);
      return l1;
    } else {
      l2.next = mergeByRecursion(l1, l2.next);
      return l2;
    }
    /*
     * time: O(n)
     *
     * space: O(1)
     */
  }
}
