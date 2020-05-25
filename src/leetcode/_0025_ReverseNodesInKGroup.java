package leetcode;

/*
 * 0025. Reverse Nodes in k-Group
 *
 * Given a linked list, reverse the nodes of a linked list k at a time and
 * return its modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked
 * list. If the number of nodes is not a multiple of k then left-out nodes in
 * the end should remain as it is.
 *
 * Example:
 *
 * Given this linked list: 1->2->3->4->5
 *
 * For k = 2, you should return: 2->1->4->3->5
 *
 * For k = 3, you should return: 3->2->1->4->5
 *
 * Note:
 *
 * - Only constant extra memory is allowed.
 *
 * - You may not alter the values in the list's nodes, only nodes itself may be
 * changed.
 */
public class _0025_ReverseNodesInKGroup {
  public static void main(final String[] args) {
    System.out.println("Hello world.");
  }

  public ListNode reverseKGroup(ListNode head, int k) {
    ListNode pre = head;
    int count = 0;
    while (pre != null && count < k) {
      pre = pre.next;
      count += 1;
    }
    if (count < k) {
      return head;
    }
    pre = reverseKGroup(pre, k);
    // example:
    //
    // k = 3
    //
    // status:
    //
    // ............................. ===================>
    // n1 => n2 => n3 => n4 => n5 => n6 .. n9 => n8 => n7 => null
    // ................. | ............... |
    // ................. head ............ pre
    ListNode cur = head;
    ListNode post = null;
    while (count > 0) {
      post = cur.next;
      cur.next = pre;
      pre = cur;
      cur = post;
      count -= 1;
    }
    // status:
    //
    // ................. ===================>
    // n1 => n2 => n3 => n4 <= n5 <= n6 .. n9 => n8 => n7 => null
    // ................. | ......... | ............... |
    // ................. head ...... pre ............. post
    // ............................................... cur
    return pre;
    /*
     * time: O(n ^ 2)
     *
     * space: O(1)
     */
  }
}
