package techbow;

import leetcode.ListNode;

public class _0001_InsertLinkedListElement {
  public static ListNode insertElement(ListNode head, int val) {
    // without using dummy node
    //
    // main
    ListNode newNode = new ListNode(val);
    if (head == null || head.val >= val) {
      newNode.next = head;
      head = newNode;
      return head;
    }
    ListNode pre = head;
    while (pre.next != null && pre.val < val) {
      pre = pre.next;
    }
    newNode.next = pre.next;
    pre.next = newNode;
    return head;
    /*
     * time: O(n)
     *
     * space: O(1)
     */
  }

  // Using a dummy node?
  //
  // See method `insert` in file `_0147_InsertionSortList.java`.
}
