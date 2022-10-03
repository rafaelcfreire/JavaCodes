package hackerrank;

public final class AppendAndDelete {
    public static void main(String[] args) {
        System.out.println(appendAndDelete("hackerhappy", "hackerrank", 9));
        System.out.println(appendAndDelete("aba", "aba", 7));
        System.out.println(appendAndDelete("aaaaaaaaaa", "aaaaa", 7));
        System.out.println(appendAndDelete("zzzzz", "zzzzzzz", 4));
        System.out.println(appendAndDelete("qwerasdf", "qwerbsdf", 6));
        System.out.println(appendAndDelete("qwerty", "zxcvbn", 100));
        System.out.println(appendAndDelete("ashley", "ash", 2));
        System.out.println(appendAndDelete("y", "yu", 2));
        System.out.println(appendAndDelete("abcd", "abcdert", 10));
    }

    public static String appendAndDelete(String s, String t, int k) {
        if(k > s.length() + t.length())
            return "Yes";

        int counter = 0;
        for(int currentIndex = 0;currentIndex < Math.min(s.length(), t.length()); currentIndex++){
            if(s.charAt(currentIndex) == t.charAt(currentIndex))
                counter++;
            else
                break;
        }
        int difference = (s.length() - counter ) + (t.length() - counter);
        if(k >= difference) {
            if(difference % 2 == 0 && k % 2 == 0)
                return "Yes";
            if(difference % 2 != 0 && k % 2 != 0)
                return "Yes";
        }
        return "No";
    }
}
