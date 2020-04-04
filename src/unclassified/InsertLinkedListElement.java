package unclassified;

import leetcode.ListNode;

public class InsertLinkedListElement {
  public ListNode insertElement(ListNode head, int val) {
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
  }

  // Using a dummy node?
  //
  // See method `insert` in file `_0147_InsertionSortList.java`.
}
