package algoexpert.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class BalancedBrackets {
    public static void main(String[] args) {
        System.out.println(balancedBrackets("(141[])(){waga}((51afaw))()hh()"));
    }

    public static boolean balancedBrackets(String str) {
        Deque<String> deque = new ArrayDeque<>();
        for(char current : str.toCharArray()) {
            if (current == '(')
                deque.addFirst(")");
            else if (current == '[')
                deque.addFirst("]");
            else if (current == '{')
                deque.addFirst("}");
            else if (current == ')' || current == ']' || current == '}')
                if (deque.size() == 0 || deque.pop().toCharArray()[0] != current)
                    return false;
        }
        if(deque.size() == 0)
            return true;
        else
            return false;
    }
}
