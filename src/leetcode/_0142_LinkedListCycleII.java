package leetcode;

/*
 * 0142. Linked List Cycle II
 *
 * Given a linked list, return the node where the cycle begins. If there is no
 * cycle, return null.
 *
 * To represent a cycle in the given linked list, we use an integer pos which
 * represents the position (0-indexed) in the linked list where tail connects
 * to. If pos is -1, then there is no cycle in the linked list.
 *
 * Note: Do not modify the linked list.
 *
 * Example 1:
 *
 * Input: head = [3,2,0,-4], pos = 1
 *
 * Output: tail connects to node index 1
 *
 * Explanation: There is a cycle in the linked list, where tail connects to the
 * second node.
 *
 * https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist.png
 *
 * Example 2:
 *
 * Input: head = [1,2], pos = 0
 *
 * Output: tail connects to node index 0
 *
 * Explanation: There is a cycle in the linked list, where tail connects to the
 * first node.
 *
 * https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist_test2.png
 *
 * Example 3:
 *
 * Input: head = [1], pos = -1
 *
 * Output: no cycle
 *
 * Explanation: There is no cycle in the linked list.
 *
 * https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist_test3.png
 *
 * Follow-up:
 *
 * Can you solve it without using extra space?
 */
public class _0142_LinkedListCycleII {
  public static void main(String[] args) {
    System.out.println("Hello world.");
  }

  public ListNode detectCycle(ListNode head) {
    if (head == null || head.next == null) {
      return null;
    }
    // As file `_0141_LinkedListCycle.java`, select a node on cycle.
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        // A node on cycle is selected.
        //
        // Based on mathmatical proof,
        // set `slow` as head, then iterate both `slow` and `fast` at the same speed,
        // when `slow` and `fast` meet again, the node will be entry.
        slow = head;
        while (slow != fast) {
          slow = slow.next;
          fast = fast.next;
        }
        return slow;
      }
    }
    return null;
  }
}
