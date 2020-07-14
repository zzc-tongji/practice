package leetcode;

/*
 * 0021. Merge Two Sorted Lists
 *
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 *
 * Example:
 *
 * Input: 1->2->4, 1->3->4
 *
 * Output: 1->1->2->3->4->4
 */
public class _0021_MergeTwoSortedLists {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
}

// More way to merge two sorted linked list:
// see `unclassified.sort.linkedlist.Merge`.
