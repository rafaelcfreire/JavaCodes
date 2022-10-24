package algoexpert.string;

import java.util.HashMap;
import java.util.Map;

// https://www.algoexpert.io/questions/first-non-repeating-character
public final class FirstNonRepeatableCharacter {
    public static void main(String[] args) {
        firstNonRepeatingCharacter("abcdcaf");
    }
    public static int firstNonRepeatingCharacter(String string) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {

            if (map.containsKey(string.charAt(i)))
                map.put(string.charAt(i), map.get(string.charAt(i)) + 1);
            else
                map.put(string.charAt(i), 1);
        }

        for (int i = 0; i < string.length(); i++)
            if (map.get(string.charAt(i)) == 1)
                return i;
        return -1;
    }
}
