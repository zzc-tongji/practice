package leetcode;

/*
 * 83. Remove Duplicates from Sorted List
 *
 * Given a sorted linked list, delete all duplicates such that each element
 * appear only once.
 *
 * Example 1:
 *
 * Input: 1->1->2
 *
 * Output: 1->2
 *
 * Example 2:
 *
 * Input: 1->1->2->3->3
 *
 * Output: 1->2->3
 */
public class _0083_RemoveDuplicatesFromSortedList {
  public static void main(String[] args) {
    System.out.println("Hello world.");
  }

  public ListNode deleteDuplicates(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode slow = head;
    ListNode fast = head.next;
    while (slow != null) {
      fast = slow.next;
      while (fast != null && fast.val == slow.val) {
        fast = fast.next;
      }
      slow.next = fast;
      slow = slow.next;
    }
    return head;
    /*
     * time: O(n)
     *
     * space: O(1)
     */
  }
}
