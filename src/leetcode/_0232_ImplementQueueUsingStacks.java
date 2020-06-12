package leetcode;

import java.util.NoSuchElementException;
import java.util.Stack;

/*
 * 0232. Implement Queue using Stacks
 *
 * Implement the following operations of a queue using stacks.
 *
 * - push(x) -- Push element x to the back of queue.
 *
 * - pop() -- Removes the element from in front of queue.
 *
 * - peek() -- Get the front element.
 *
 * - empty() -- Return whether the queue is empty.
 *
 * Example:
 *
 * ``` java
 * MyQueue queue = new MyQueue();
 *
 * queue.push(1);
 * queue.push(2);
 * queue.peek(); // returns 1
 * queue.pop(); // returns 1
 * queue.empty(); // returns false
 * ```
 *
 * Notes:
 *
 * - You must use only standard operations of a stack -- which means only push
 * to top, peek/pop from top, size, and is empty operations are valid.
 *
 * - Depending on your language, stack may not be supported natively. You may
 * simulate a stack by using a list or deque (double-ended queue), as long as
 * you use only standard operations of a stack.
 *
 * - You may assume that all operations are valid (for example, no pop or peek
 * operations will be called on an empty queue).
 *
 * Others:
 *
 * Your MyQueue object will be instantiated and called as such:
 *
 * ``` java
 * _0232_ImplementQueueUsingStacks obj = new _0232_ImplementQueueUsingStacks();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 * ```
 */
public class _0232_ImplementQueueUsingStacks {
  private Stack<Integer> stackIn;
  private Stack<Integer> stackOut;

  /** Initialize your data structure here. */
  public _0232_ImplementQueueUsingStacks() {
    stackIn = new Stack<>();
    stackOut = new Stack<>();
  }

  /** Push element x to the back of queue. */
  public void push(int x) {
    stackIn.push(x);
  }

  /** Removes the element from in front of queue and returns that element. */
  public int pop() {
    shift();
    return stackOut.pop();
  }

  /** Get the front element. */
  public int peek() {
    shift();
    return stackOut.peek();
  }

  /** Returns whether the queue is empty. */
  public boolean empty() {
    return stackIn.isEmpty() && stackOut.isEmpty();
  }

  private void shift() {
    if (stackOut.isEmpty()) {
      // The follow if-block could be omit.
      if (stackIn.isEmpty()) {
        throw new NoSuchElementException();
      }
      while (!stackIn.isEmpty()) {
        stackOut.push(stackIn.pop());
      }
    }
  }
}
