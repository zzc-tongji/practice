package leetcode;

/*
 * 0160. Intersection of Two Linked Lists
 *
 * Write a program to find the node at which the intersection of two singly
 * linked lists begins.
 *
 * For example, the following two linked lists:
 *
 * https://assets.leetcode.com/uploads/2018/12/13/160_statement.png
 *
 * begin to intersect at node c1.
 *
 * Example 1:
 *
 * https://assets.leetcode.com/uploads/2018/12/13/160_example_1.png
 *
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA =
 * 2, skipB = 3
 *
 * Output: Reference of the node with value = 8
 *
 * Input Explanation: The intersected node's value is 8 (note that this must not
 * be 0 if the two lists intersect). From the head of A, it reads as
 * [4,1,8,4,5]. From the head of B, it reads as [5,0,1,8,4,5]. There are 2 nodes
 * before the intersected node in A; There are 3 nodes before the intersected
 * node in B.
 *
 * Example 2:
 *
 * https://assets.leetcode.com/uploads/2018/12/13/160_example_2.png
 *
 * Input: intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3,
 * skipB = 1
 *
 * Output: Reference of the node with value = 2
 *
 * Input Explanation: The intersected node's value is 2 (note that this must not
 * be 0 if the two lists intersect). From the head of A, it reads as
 * [0,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes
 * before the intersected node in A; There are 1 node before the intersected
 * node in B.
 *
 * Example 3:
 *
 * https://assets.leetcode.com/uploads/2018/12/13/160_example_3.png
 *
 * Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 *
 * Output: null
 *
 * Input Explanation: From the head of A, it reads as [2,6,4]. From the head of
 * B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must
 * be 0, while skipA and skipB can be arbitrary values.
 *
 * Explanation: The two lists do not intersect, so return null.
 *
 * Notes:
 *
 * - If the two linked lists have no intersection at all, return null.
 *
 * - The linked lists must retain their original structure after the function
 * returns.
 *
 * - You may assume there are no cycles anywhere in the entire linked structure.
 *
 * - Your code should preferably run in O(n) time and use only O(1) memory.
 */
public class _0160_IntersectionOfTwoLinkedLists {
  public static void main(String[] args) {
    System.out.println("Hello world.");
  }

  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    // Iterate `headA` and `headB` by `a` and `b` at the same time.
    //
    // When the first time reaching `null`, let `a = headB` and `b = headA`,
    // continue to iterate.
    //
    // Doing aformentioned steps until ONE of following statements is satisfied.
    //
    // - `a == b` ==> intersection node is `a`
    // - `a == null` or `b == null` at the second time ==> non-exist
    if (headA == null || headB == null) {
      return null;
    }
    ListNode a = headA;
    ListNode b = headB;
    boolean secondEndA = false;
    boolean secondEndB = false;
    while (true) {
      if (a == b) {
        return a;
      }
      if ((secondEndA && a == null) || (secondEndB && b == null)) {
        return null;
      }
      if (a == null) {
        a = headB;
        secondEndA = true;
        //
        b = b.next;
      } else if (b == null) {
        b = headA;
        secondEndB = true;
        //
        a = a.next;
      } else {
        a = a.next;
        b = b.next;
      }
    }
    /*
     * time: O(n)
     *
     * space: O(1)
     */
  }

  public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) {
      return null;
    }
    ListNode a = headA;
    ListNode b = headB;
    int lengthA = 0;
    int lengthB = 0;
    // Get length of `headA` and `headB`.
    while (a.next != null || b.next != null) {
      if (a.next != null) {
        a = a.next;
        lengthA += 1;
      }
      if (b.next != null) {
        b = b.next;
        lengthB += 1;
      }
    }
    // Set starting points for the second time iteration.
    a = headA;
    b = headB;
    int diff = 0;
    if (lengthA > lengthB) {
      // If `headA` is longer,
      // choose the `diff`-th node of `headA` and `headB` as starting points.
      diff = lengthA - lengthB;
      while (diff > 0) {
        a = a.next;
        diff -= 1;
      }
    } else {
      // If `headB` is longer,
      // choose the `diff`-th node of `headB` and `headA` as starting points.
      diff = lengthB - lengthA;
      while (diff > 0) {
        b = b.next;
        diff -= 1;
      }
    }
    // Iterate again.
    //
    // End up with equal nodes (intersection node) or `null` (non-exist).
    while (a != null && b != null) {
      if (a == b) {
        return a;
      }
      a = a.next;
      b = b.next;
    }
    return null;
    /*
     * time: O(n)
     *
     * space: O(1)
     */
  }
}
