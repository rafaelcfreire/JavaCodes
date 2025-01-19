package leetcode.queue;

import java.util.Stack;

// https://leetcode.com/problems/implement-queue-using-stacks/description/
final class QueueUsingStacks {
    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        System.out.println(obj.peek());
        System.out.println(obj.pop());
        System.out.println(obj.empty());
        System.out.println(obj.peek());
    }

    static class MyQueue {
        private final Stack<Integer> enqueue;
        private final Stack<Integer> dequeue;

        public MyQueue() {
            enqueue = new Stack<>();
            dequeue = new Stack<>();
        }

        public void push(int x) {
            enqueue.add(x);
        }

        public int pop() {
            if (dequeue.empty()) {
                copyFromEnqueueToDequeue();
            }
            return dequeue.pop();
        }

        public int peek() {
            if (dequeue.empty()) {
                copyFromEnqueueToDequeue();
            }
            return dequeue.peek();
        }

        private void copyFromEnqueueToDequeue() {
            if (empty()) {
                throw new RuntimeException();
            } else {
                while (!enqueue.empty()) {
                    dequeue.add(enqueue.pop());
                }
            }
        }

        public int size() {
            return enqueue.size();
        }

        public boolean empty() {
            return dequeue.empty() && enqueue.empty();
        }
    }
}