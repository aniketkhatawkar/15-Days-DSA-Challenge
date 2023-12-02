public class Main {
    public static void main(String[] args) {
        String[] inputs = {"aDcadhc", "AabBcC"};

        for (String input : inputs) {
            char result = firstNonRepeatingCharacter(input);
            System.out.println(result);
        }
    }

    public static char firstNonRepeatingCharacter(String str) {
        int[] charCount = new int[256];

        for (char c : str.toCharArray()) {
            charCount[c]++;
        }

        for (char c : str.toCharArray()) {
            if (charCount[c] == 1) {
                return c;
            }
        }

        return str.charAt(0);
    }
}
