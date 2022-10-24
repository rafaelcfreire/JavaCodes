package algoexpert.stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class MinMaxStackClass {
    static class MinMaxStack {
        List<Integer> stack = new ArrayList<>();
        List<Map<String, Integer>> minMaxStack = new ArrayList<>();

        public int peek() {
            return stack.get(stack.size() - 1);
        }

        public int pop() {
            minMaxStack.remove(minMaxStack.size() - 1);
            return stack.get(stack.size() - 1);
        }

        public void push(int number) {
            Map<String, Integer> newMinMax = new HashMap<>();
            newMinMax.put("min", number);
            newMinMax.put("max", number);

            if (minMaxStack.size() > 0) {
                Map<String, Integer> lastMinMax = new HashMap<>(minMaxStack.get(minMaxStack.size() - 1));
                newMinMax.replace("min", Math.min(newMinMax.get("min"), lastMinMax.get("min")));
                newMinMax.replace("max", Math.min(newMinMax.get("max"), lastMinMax.get("max")));
            }
            minMaxStack.add(newMinMax);
            stack.add(number);
        }

        public int getMin() {
            return minMaxStack.get(minMaxStack.size() - 1).get("min");
        }

        public int getMax() {
            return minMaxStack.get(minMaxStack.size() - 1).get("max");
        }
    }
}
