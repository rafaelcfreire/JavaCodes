package leetcode.queue;

import leetcode.queue.QueueUsingStacks.MyQueue;

import java.util.ArrayList;
import java.util.List;

final class StackUsingQueues {
    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(1);
        obj.push(2);
        System.out.println(obj.top());
        System.out.println(obj.pop());
        System.out.println(obj.empty());
    }

    static class MyStack {
        private final MyQueue enqueue;
        private final MyQueue temporaryCache;

        public MyStack() {
            enqueue = new MyQueue();
            temporaryCache = new MyQueue();
        }

        public void push(int x) {
            if (empty()) {
                temporaryCache.push(x);
            } else {
                enqueue.push(x);
            }
        }

        public int pop() {
            int size;
            int counter = 0;

            if (temporaryCache.empty()) {
                size = enqueue.size();

                while (counter < size - 1) {
                    temporaryCache.push(enqueue.pop());
                    counter++;
                }
                return enqueue.pop();
            } else {
                size = temporaryCache.size();
                while (counter < size - 1) {
                    enqueue.push(temporaryCache.pop());
                    counter++;
                }
                return temporaryCache.pop();
            }
        }

        public int top() {
            int size;
            int counter = 0;

            if (temporaryCache.empty()) {
                size = enqueue.size();

                while (counter < size - 1) {
                    temporaryCache.push(enqueue.pop());
                    counter++;
                }
                return enqueue.peek();
            } else {
                size = temporaryCache.size();
                while (counter < size - 1) {
                    enqueue.push(temporaryCache.pop());
                    counter++;
                }
                return temporaryCache.peek();
            }
        }

        public boolean empty() {
            return enqueue.empty() && temporaryCache.empty();
        }
    }
}