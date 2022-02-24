package leetcode.recursion;
//https://youtu.be/WPSeyjX1-4s?t=1299
public class TowerOfHanoi {

    public static void main(String[] args) {
        towersOfHanoi(3, 'A', 'C', 'B');
    }

    public static void towersOfHanoi(int n, char fromPeg, char toPeg, char auxPeg) {
        if (n == 1) {
            System.out.println(String.format("Move disk 1 from %s to %s", fromPeg, toPeg));
            return;
        }

        towersOfHanoi(n - 1, fromPeg, auxPeg, toPeg);

        System.out.println(String.format("Move disk %d from %s to %s", n, fromPeg, toPeg));

        towersOfHanoi(n - 1, auxPeg, toPeg, fromPeg);
    }
}




//        if (n == 1) {
//                System.out.println(String.format("Move disk 1 from %s to %s", fromPeg, toPeg));
//                return;
//                }
//                towersOfHanoi(n - 1, fromPeg, auxPeg, toPeg);
//
//                System.out.println(String.format("Move disk %d from %s to %s", n, fromPeg, toPeg));
//
//                towersOfHanoi(n - 1, auxPeg, toPeg, fromPeg);
