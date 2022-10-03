package leetcode.recursion;

public final class PascalTriangle {
    public static void main(String[] args) {
        System.out.println(calculateElement(2, 1));
    }

    public static int calculateElement(int line, int column) {
        if(column == 0 || column == line)
            return 1;
        return calculateElement(line - 1, column - 1) + calculateElement(line - 1, column);
    }
}
