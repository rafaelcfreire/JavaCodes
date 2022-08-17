package algoexpert.string;

public class CeasarCipher {
    public static void main(String[] args) {
//        System.out.println(caesarCypherEncryptor("middle-Outz", 2));
        System.out.println(caesarCypherEncryptor("Hello_World!", 4));
//        System.out.println(caesarCypherEncryptor("159357lcfd", 98));
    }

    public static String caesarCypherEncryptor(String str, int key) {
        char[] newLetters = new char[str.length()];
        int newKey = key % 26;
        for (int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i);
            if (currChar >= 65 && currChar <= 90 || currChar >= 97 && currChar <= 122)
                newLetters[i] = getNewLetter(str.charAt(i), newKey);
            else
                newLetters[i] = currChar;
        }
        return new String(newLetters);
    }

    private static char getNewLetter(char letter, int key) {
        int newLetter = letter + key;
        return newLetter <= 122 ?  (char) newLetter : (char) (96 + newLetter % 122);
    }
}
