package leetcode;

import java.util.Stack;

/*
 * 0155. Min Stack
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 *
 * - push(x) -- Push element x onto stack.
 *
 * - pop() -- Removes the element on top of the stack.
 *
 * - top() -- Get the top element.
 *
 * - getMin() -- Retrieve the minimum element in the stack.
 *
 * Example 1:
 *
 * Input
 *
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 *
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * Output
 *
 * [null,null,null,null,-3,null,0,-2]
 *
 * Explanation
 *
 * ``` java
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin(); // return -3
 * minStack.pop();
 * minStack.top();    // return 0
 * minStack.getMin(); // return -2
 * ```
 *
 * Constraints:
 *
 * Methods pop, top and getMin operations will always be called on non-empty
 * stacks.
 *
 * Your MinStack object will be instantiated and called as such:
 *
 * ``` java
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 * ```
 */
public class _0155_MinStack {
  private Stack<Integer> s;
  private Stack<Integer> sMin;

  /** initialize your data structure here. */
  public _0155_MinStack() {
    s = new Stack<>();
    sMin = new Stack<>();
  }

  public void push(int x) {
    s.push(x);
    int min = sMin.isEmpty() ? Integer.MAX_VALUE : sMin.peek();
    sMin.push(x < min ? x : min);
  }

  public void pop() {
    s.pop();
    sMin.pop();
  }

  public int top() {
    return s.peek();
  }

  public int getMin() {
    return sMin.peek();
  }
}

class _0155_MinStack1 {
  private static class Node {
    public Integer val;
    public Integer min;

    public Node(Integer val, Integer min) {
      this.val = val;
      this.min = min;
    }
  }

  private Stack<Node> s;

  /** initialize your data structure here. */
  public _0155_MinStack1() {
    s = new Stack<>();
  }

  public void push(int x) {
    int min = s.isEmpty() ? Integer.MAX_VALUE : s.peek().min;
    s.push(new Node(x, x < min ? x : min));
  }

  public void pop() {
    s.pop();
  }

  public int top() {
    return s.peek().val;
  }

  public int getMin() {
    return s.peek().min;
  }
}

class _0155_MinStack2 {
  private Stack<Integer> s;
  private Stack<Integer> sMin;

  /** initialize your data structure here. */
  public _0155_MinStack2() {
    s = new Stack<>();
    sMin = new Stack<>();
  }

  public void push(int x) {
    s.push(x);
    int min = sMin.isEmpty() ? Integer.MAX_VALUE : sMin.peek();
    if (x <= min) {
      sMin.push(x);
    }
  }

  public void pop() {
    if (s.pop() <= sMin.peek()) {
      sMin.pop();
    }
  }

  public int top() {
    return s.peek();
  }

  public int getMin() {
    return sMin.peek();
  }
}
