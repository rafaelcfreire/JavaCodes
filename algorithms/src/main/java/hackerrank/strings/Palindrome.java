package hackerrank.strings;

public final class Palindrome {
    public static void main(String[] args) {
        System.out.println(palindromeIndex("aaab"));
        System.out.println(palindromeIndex("baa"));
        System.out.println(palindromeIndex("aaa"));
        System.out.println(palindromeIndex("aabaa"));
        System.out.println(palindromeIndex("hgygsvlfcwnswtuhmyaljkqlqjjqlqkjlaymhutwsnwcwflvsgygh"));
    }

    public static int palindromeIndex(String s) {
        int startIndex = 0, endIndex = s.length() - 1;
        while (startIndex < endIndex) {
            if (s.charAt(startIndex) != s.charAt(endIndex)) {
                if (isPalindrome(s.substring(0, startIndex) + s.substring(startIndex + 1)))
                    return startIndex;
                if (isPalindrome(s.substring(0, endIndex) + s.substring(endIndex + 1)))
                    return endIndex;
                break;
            }
            startIndex++;
            endIndex--;
        }
        return -1;
    }

    private static boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j))
                return false;
        }
        return true;
    }
}


//    public static int palindromeIndex(String s) {
//        int size = s.length();
//        boolean isOdd = size % 2 != 0;
//
//        int startIndex = (size / 2) - 1;
//        int endIndex = startIndex + 1;
//        int returnIndex = -1;
//
//        while (startIndex >= 0 || endIndex < size) {
//            if (isOdd && (startIndex == -1 && endIndex == size - 1) || (startIndex == 0 && endIndex == size))
//                break;
//            if (s.charAt(startIndex) != s.charAt(endIndex)) {
//                if (isOdd) {
//                    returnIndex = (size - 1) - endIndex > startIndex ? endIndex : startIndex;
//                } else {
//                    if (s.charAt(startIndex + 1) == s.charAt(endIndex))
//                        returnIndex = startIndex;
//                    else if (s.charAt(endIndex - 1) == s.charAt(startIndex))
//                        returnIndex = endIndex;
//                }
//                break;
//            }
//            startIndex--;
//            endIndex++;
//        }
//
//        return returnIndex;
//    }
