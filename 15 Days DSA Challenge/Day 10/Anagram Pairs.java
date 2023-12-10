import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String input1Str1 = "rasp";
        String input1Str2 = "spar";
        System.out.println(isAnagram(input1Str1, input1Str2));

        String input2Str1 = "rasp";
        String input2Str2 = "spaz";
        System.out.println(isAnagram(input2Str1, input2Str2));
    }

    public static boolean isAnagram(String str1, String str2) {
        //Your code goes here
        str1 = str1.replaceAll("\\s", "").toLowerCase();
        str2 = str2.replaceAll("\\s", "").toLowerCase();

        if (str1.length() != str2.length()) {
            return false;
        }

        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();

        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        return Arrays.equals(charArray1, charArray2);
    }

}
