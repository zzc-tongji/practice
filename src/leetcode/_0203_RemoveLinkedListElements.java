package leetcode;

/*
 * 0203. Remove Linked List Elements
 *
 * Remove all elements from a linked list of integers that have value val.
 *
 * Example:
 *
 * Input: 1->2->6->3->4->5->6, val = 6 Output: 1->2->3->4->5
 */
public class _0203_RemoveLinkedListElements {
  public ListNode removeElements(ListNode head, int val) {
    if (head == null) {
      return null;
    }
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode pre = dummy;
    ListNode cur = head;
    while (cur != null) {
      if (cur.val == val) {
        // deleted cur
        pre.next = cur.next;
      } else {
        // retained cur
        pre = cur;
      }
      cur = cur.next;
    }
    return dummy.next;
    /*
     * time: O(n)
     *
     * space: O(1)
     */
  }

  public ListNode removeElementsNoDummy(ListNode head, int val) {
    if (head == null) {
      return null;
    }
    ListNode pre = null;
    ListNode cur = head;
    ListNode res = head;
    while (cur != null) {
      if (cur.val == val) {
        // deleted cur
        if (pre != null) {
          // middle cur
          pre.next = cur.next;
        } else {
          // head cur
          res = cur.next;
          pre = null;
        }
      } else {
        // retained cur
        pre = cur;
      }
      cur = cur.next;
    }
    return res;
    /*
     * time: O(n)
     *
     * space: O(1)
     */
  }
}
