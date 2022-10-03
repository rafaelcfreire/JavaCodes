package algoexpert.recursion;

import java.util.List;

public final class ProductSum {
    public static void main(String[] args) {
        System.out.println(productSum(List.of(5, 2, List.of(7, -1), 3, List.of(6, List.of(-13, 8), 4))));
    }

    public static int productSum(List<Object> array) {
        return productSum(array, 1);
    }

    @SuppressWarnings("unchecked")
    public static int productSum(List<Object> array, int degree) {
        int sum = 0;
        for(Object object : array) {
            if(object instanceof List)
                sum += productSum((List<Object>) object, degree + 1);
            else
                sum += (Integer) object;
        }
        return sum * degree;
    }
}
