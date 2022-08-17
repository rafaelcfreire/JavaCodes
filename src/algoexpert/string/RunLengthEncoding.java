package algoexpert.string;

public class RunLengthEncoding {
    public static void main(String[] args) {
         System.out.println(runLengthEncoding("AAAAAAAAAAAAABBCCCCDD"));
    }

    public static String runLengthEncoding(String string) {
        StringBuilder encodedString = new StringBuilder();
        int currentLength = 1;

        for (int i = 1; i < string.length(); i++) {
            char current = string.charAt(i);
            if (current != string.charAt(i - 1) || currentLength == 9) {
                encodedString.append(currentLength);
                encodedString.append(string.charAt(i - 1));
                currentLength = 0;
            }
            currentLength += 1;
        }
        return encodedString.toString();
    }
}
