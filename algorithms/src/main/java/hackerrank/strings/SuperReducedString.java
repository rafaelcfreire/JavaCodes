package hackerrank.strings;

public final class SuperReducedString {

    public static void main(String[] args) {
        System.out.println(superReducedString("baab"));
        System.out.println(superReducedString("aaabccddd"));
    }

    public static String superReducedString(String s) {
        boolean isReady = false;
        StringBuilder sb = new StringBuilder(s);

        while (!isReady) {
            int numOfChanges = 0;

            int size = sb.length();
            for (int i = 1; i < size; i++)
                if (sb.charAt(i) == sb.charAt(i - 1)) {
                    sb.delete(i - 1, i + 1);
                    size -= 2;
                    numOfChanges += 1;
                }
                if (numOfChanges == 0)
                    isReady = true;
        }
        return sb.toString();
    }
}
