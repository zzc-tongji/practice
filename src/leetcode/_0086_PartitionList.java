package leetcode;

/*
 * 0086. Partition List
 *
 * Given a linked list and a value x, partition it such that all nodes less than
 * x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 *
 * Example:
 *
 * Input: head = 1->4->3->2->5->2, x = 3
 *
 * Output: 1->2->2->4->3->5
 */
public class _0086_PartitionList {
  public ListNode partition(ListNode head, int x) {
    if (head == null) {
      return head;
    }
    // add node to two linked list `smallDummy` and `largeDummy`
    ListNode smallDummy = new ListNode(0);
    ListNode largeDummy = new ListNode(0);
    ListNode small = smallDummy;
    ListNode large = largeDummy;
    ListNode cur = head;
    while (cur != null) {
      if (cur.val < x) {
        small.next = cur;
        small = small.next;
      } else {
        large.next = cur;
        large = large.next;
      }
      cur = cur.next;
    }
    // connect
    //
    // small.next = null;
    large.next = null;
    small.next = largeDummy.next;
    return smallDummy.next;
    /*
     * time: O(n)
     *
     * space: O(1)
     */
  }
}

// It is a part of quick sort of linked list.
// See `techbow._0013_Sort.linkedlist.QuickSort` for detail.
