package recursive.book.chp3;

public class ReverseString {
    public static void main(String[] args) {
        System.out.println(rev("CARRO"));
    }

    public static String rev(String value) {
        if (value.length() == 0 || value.length() == 1)
            return value;
        else {
            String head = value.substring(0, 1);
            String tail = value.substring(1);
            return rev(tail) + head;
        }
    }
}
