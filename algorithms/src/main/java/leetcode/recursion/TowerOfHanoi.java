package leetcode.recursion;

import java.util.Stack;

//https://youtu.be/WPSeyjX1-4s?t=1299
public final class TowerOfHanoi {

    public static void main(String[] args) {
        towersOfHanoi(3, 'A', 'C', 'B');

        Stack<Integer> fromStack = new Stack<>();
        fromStack.add(1);
        fromStack.add(2);
        fromStack.add(3);
        towersOfHanoiStack(3, fromStack, new Stack<>(), new Stack<>());
    }

    public static void towersOfHanoi(int n, char fromPeg, char toPeg, char auxPeg) {
        if (n == 1) {
            System.out.println(String.format("Move %d from %s to %s", n, fromPeg, toPeg));
            return;
        }
        towersOfHanoi(n - 1, fromPeg, auxPeg, toPeg);

        System.out.println(String.format("Move %d from %s to %s", n, fromPeg, toPeg));

        towersOfHanoi(n - 1, auxPeg, toPeg, fromPeg);
    }

    public static void towersOfHanoiStack(int n, Stack<Integer> from, Stack<Integer> to, Stack<Integer> aux) {
        if (n == 1) {
            moveDisk(from, to);
            return;
        }
        towersOfHanoiStack(n - 1, from, aux, to);

        moveDisk(from, to);

        towersOfHanoiStack(n - 1, aux, to, from);
    }

    private static void moveDisk(Stack<Integer> from, Stack<Integer> to) {
        Integer temp = from.pop();
        to.add(temp);
    }
}




