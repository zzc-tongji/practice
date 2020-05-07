package leetcode;

/**
 * 0147. Insertion Sort List
 *
 * Sort a linked list using insertion sort.
 *
 * https://upload.wikimedia.org/wikipedia/commons/0/0f/Insertion-sort-example-300px.gif
 *
 * A graphical example of insertion sort. The partial sorted list (black)
 * initially contains only the first element in the list.
 *
 * With each iteration one element (red) is removed from the input data and
 * inserted in-place into the sorted list
 *
 * Algorithm of Insertion Sort:
 *
 * 1. Insertion sort iterates, consuming one input element each repetition, and
 * growing a sorted output list.
 *
 * 2. At each iteration, insertion sort removes one element from the input data,
 * finds the location it belongs within the sorted list, and inserts it there.
 *
 * 3. It repeats until no input elements remain.
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
public class _0147_InsertionSortList {
  public static void main(String[] args) {
    System.out.println("Hello world.");
  }

  public ListNode insertionSortList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    // We need a "demmy node" (fake node) to point to the actual node `head`.
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode cur = head.next;
    ListNode pre = head;
    while (cur != null) {
      if (pre.val > cur.val) {
        ListNode temp = pickOff(pre, cur);
        insert(dummy, temp);
        cur = pre;
      }
      pre = cur;
      cur = cur.next;
    }
    return dummy.next;
    /*
     * time: O(n ^ 2)
     *
     * space: O(1)
     */
  }

  private ListNode pickOff(ListNode pre, ListNode node) {
    // pick off
    pre.next = node.next;
    node.next = null;
    return node;
  }

  public void insert(ListNode dummy, ListNode node) {
    ListNode pre = dummy;
    ListNode cur = dummy.next;
    while (cur.val < node.val) {
      pre = cur;
      cur = cur.next;
    }
    // cur.val >= node.val
    node.next = cur;
    pre.next = node;
  }
}
