public class Main {

    public static void main(String[] args) {
        String[] testCases = {"abccbc"};

        for (String testCase : testCases) {
            String result = longestPalinSubstring(testCase);
            System.out.println("Longest Palindromic Substring: " + result);
        }
    }
    
    public static String longestPalinSubstring(String str) {
        if (str == null || str.length() < 1) {
            return "";
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < str.length(); i++) {
            int len1 = expandAroundCenter(str, i, i);
            int len2 = expandAroundCenter(str, i, i + 1);
            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return str.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}