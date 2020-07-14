package leetcode;

/*
 * 0148. Sort List
 *
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * Example 1:
 *
 * Input: 4->2->1->3
 *
 * Output: 1->2->3->4
 *
 * Example 2:
 *
 * Input: -1->5->3->4->0
 *
 * Output: -1->0->3->4->5
 */
public class _0148_SortList {
  public ListNode sortList(ListNode head) {
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
    ListNode l1 = sortList(head);
    ListNode l2 = sortList(slow);
    // conquer
    return merge(l1, l2);
    /*
     * time: O(n log n)
     *
     * space: O(1)
     */
  }

  private ListNode merge(ListNode l1, ListNode l2) {
    // similiar as file `_0021_MergeTwoSortedLists`
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
  }
}

// More way to sort an linked list:
// see `unclassified.sort.linkedlist`.
