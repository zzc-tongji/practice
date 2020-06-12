package lintcode;

import leetcode.ListNode;

/*
 * 0228. Middle of Linked List
 *
 * Description
 *
 * Find the middle node of a linked list.
 *
 * Example
 *
 * Example 1:
 *
 * Input: 1->2->3
 *
 * Output: 2
 *
 * Explanation: return the value of the middle node.
 *
 * Example 2:
 *
 * Input: 1->2
 *
 * Output: 1
 *
 * Explanation: If the length of list is even return the value of center left
 * one.
 *
 * Challenge
 *
 * If the linked list is in a data stream, can you find the middle without
 * iterating the linked list again?
 */
public class _0228_MiddleOfLinkedList {
  public ListNode middleNode(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    // Use slow-fast node pointer to solve the problem.
    ListNode slow = head;
    ListNode fast = head.next;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
    /*
     * time: O(n)
     *
     * space: O(1)
     */
  }
}
