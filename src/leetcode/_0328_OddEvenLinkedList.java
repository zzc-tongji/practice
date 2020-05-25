package leetcode;

/*
 * 0328. Odd Even Linked List
 *
 * Given a singly linked list, group all odd nodes together followed by the even
 * nodes. Please note here we are talking about the node number and not the
 * value in the nodes.
 *
 * You should try to do it in place. The program should run in O(1) space
 * complexity and O(nodes) time complexity.
 *
 * Example 1:
 *
 * Input: 1->2->3->4->5->NULL
 *
 * Output: 1->3->5->2->4->NULL
 *
 * Example 2:
 *
 * Input: 2->1->3->5->6->4->7->NULL
 *
 * Output: 2->3->6->7->1->5->4->NULL
 *
 * Note:
 *
 * - The relative order inside both the even and odd groups should remain as it
 * was in the input.
 *
 * - The first node is considered odd, the second node even and so on ...
 */
public class _0328_OddEvenLinkedList {
  public static void main(String[] args) {
    System.out.println("Hello world.");
  }

  public ListNode oddEvenList(ListNode head) {
    // corner case: less or equal to 2 nodes
    if (head == null || head.next == null || head.next.next == null) {
      return head;
    }
    // add node to two linked list `oddDummy` and `evenDummy`
    //
    // Don't worry, `cur` will come to the correct location
    // before the point `next` is changed.
    ListNode oddDummy = new ListNode(0);
    ListNode evenDummy = new ListNode(0);
    ListNode odd = oddDummy;
    ListNode even = evenDummy;
    ListNode cur = head;
    while (cur != null) {
      odd.next = cur;
      odd = odd.next;
      cur = cur.next;
      if (cur == null) {
        break;
      }
      even.next = cur;
      even = even.next;
      cur = cur.next;
    }
    // connect
    //
    // odd.next = null
    even.next = null;
    odd.next = evenDummy.next;
    return oddDummy.next;
    /*
     * time: O(n)
     *
     * space: O(1)
     */
  }

  public ListNode oddEvenListNoDummy(ListNode head) {
    // corner case: less or equal to 2 nodes
    if (head == null || head.next == null || head.next.next == null) {
      return head;
    }
    // add node to two linked list `oddDummy` and `evenDummy`
    //
    // Don't worry, `cur` will come to the correct location
    // before the point `next` is changed.
    ListNode evenList = head.next;
    ListNode odd = head;
    ListNode even = evenList;
    ListNode cur = head.next.next;
    while (cur != null) {
      odd.next = cur;
      odd = odd.next;
      cur = cur.next;
      if (cur == null) {
        break;
      }
      even.next = cur;
      even = even.next;
      cur = cur.next;
    }
    // connect
    //
    // odd.next = null
    even.next = null;
    odd.next = evenList;
    return head;
    /*
     * time: O(n)
     *
     * space: O(1)
     */
  }
}
