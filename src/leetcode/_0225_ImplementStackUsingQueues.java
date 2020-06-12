package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 0225. Implement Stack using Queues
 *
 * Implement the following operations of a stack using queues.
 *
 * - push(x) -- Push element x onto stack.
 *
 * - pop() -- Removes the element on top of the stack.
 *
 * - top() -- Get the top element.
 *
 * - empty() -- Return whether the stack is empty.
 *
 * ``` java
 * Example:
 *
 * MyStack stack = new MyStack();
 *
 * stack.push(1);
 * stack.push(2);
 * stack.top();   // returns 2
 * stack.pop();   // returns 2
 * stack.empty(); // returns false
 * ```
 *
 * Notes:
 *
 * - You must use only standard operations of a queue -- which means only push
 * to back, peek/pop from front, size, and is empty operations are valid.
 *
 * - Depending on your language, queue may not be supported natively. You may
 * simulate a queue by using a list or deque (double-ended queue), as long as
 * you use only standard operations of a queue.
 *
 * - You may assume that all operations are valid (for example, no pop or top
 * operations will be called on an empty stack).
 *
 * Your MyStack object will be instantiated and called as such:
 *
 * ``` java
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 * ```
 */
public class _0225_ImplementStackUsingQueues {
  public static void main(String[] args) {
    System.out.println("Hello world.");
  }

  // dual queue, offer O(1) vs. poll O(n)
  Queue<Integer> queue;
  Queue<Integer> queueEmpty;
  Integer top;

  /** Initialize your data structure here. */
  public _0225_ImplementStackUsingQueues() {
    queue = new LinkedList<>();
    queueEmpty = new LinkedList<>();
    top = null;
  }

  /** Push element x onto stack. */
  public void push(int x) {
    queue.offer(x);
    top = x;
  }

  /** Removes the element on top of the stack and returns that element. */
  public int pop() {
    while (queue.size() > 1) {
      queueEmpty.offer(queue.poll());
    }
    int res = queue.poll();
    swap();
    return res;
  }

  /** Get the top element. */
  public int top() {
    return top;
  }

  /** Returns whether the stack is empty. */
  public boolean empty() {
    return queue.isEmpty();
  }

  private void swap() {
    Queue<Integer> temp = queue;
    queue = queueEmpty;
    queueEmpty = temp;
  }
}

class _0225_ImplementStackUsingQueues1 {
  // dual queue, offer O(n) vs. poll O(1)
  Queue<Integer> queue;
  Queue<Integer> queueEmpty;

  /** Initialize your data structure here. */
  public _0225_ImplementStackUsingQueues1() {
    queue = new LinkedList<>();
    queueEmpty = new LinkedList<>();
  }

  /** Push element x onto stack. */
  public void push(int x) {
    queueEmpty.offer(x);
    while (queue.size() > 0) {
      queueEmpty.offer(queue.poll());
    }
    swap();
  }

  /** Removes the element on top of the stack and returns that element. */
  public int pop() {
    return queue.poll();
  }

  /** Get the top element. */
  public int top() {
    return queue.peek();
  }

  /** Returns whether the stack is empty. */
  public boolean empty() {
    return queue.isEmpty();
  }

  private void swap() {
    Queue<Integer> temp = queue;
    queue = queueEmpty;
    queueEmpty = temp;
  }
}

class _0225_ImplementStackUsingQueues2 {
  // single queue, offer O(1) vs. poll O(n)
  Queue<Integer> queue;
  Integer top;

  /** Initialize your data structure here. */
  public _0225_ImplementStackUsingQueues2() {
    queue = new LinkedList<>();
    top = null;
  }

  /** Push element x onto stack. */
  public void push(int x) {
    queue.offer(x);
    top = x;
  }

  /** Removes the element on top of the stack and returns that element. */
  public int pop() {
    rotate(queue.size() - 1);
    return queue.poll();
  }

  /** Get the top element. */
  public int top() {
    return top;
  }

  /** Returns whether the stack is empty. */
  public boolean empty() {
    return queue.isEmpty();
  }

  private void rotate(int n) {
    for (int i = 0; i < n; i++) {
      queue.offer(queue.poll());
    }
  }
}

class _0225_ImplementStackUsingQueues3 {
  // single queue, offer O(n) vs. poll O(1)
  Queue<Integer> queue;

  /** Initialize your data structure here. */
  public _0225_ImplementStackUsingQueues3() {
    queue = new LinkedList<>();
  }

  /** Push element x onto stack. */
  public void push(int x) {
    queue.offer(x);
    rotate(queue.size() - 1);
  }

  /** Removes the element on top of the stack and returns that element. */
  public int pop() {
    return queue.poll();
  }

  /** Get the top element. */
  public int top() {
    return queue.peek();
  }

  /** Returns whether the stack is empty. */
  public boolean empty() {
    return queue.isEmpty();
  }

  private void rotate(int n) {
    for (int i = 0; i < n; i++) {
      queue.offer(queue.poll());
    }
  }
}
