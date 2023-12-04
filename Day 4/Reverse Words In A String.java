public class Main {
     public static void main(String[] args) {
         String input = "m rs   x       JmkL       ";
 
         System.out.println("Input:");
         System.out.println(input);
 
         String reversed = reverseString(input);
 
         System.out.println("\nOutput:");
         System.out.println(reversed);
     }
 
     public static String reverseString(String str) {
         String[] lines = str.split("\n");
 
         StringBuilder result = new StringBuilder();
         for (String line : lines) {
             String[] words = line.trim().split("\\s+");
 
             int left = 0, right = words.length - 1;
             while (left < right) { // Reverse words in the line
                 String temp = words[left];
                 words[left] = words[right];
                 words[right] = temp;
                 left++;
                 right--;
             }
 
             String reversedLine = String.join(" ", words);
             result.append(reversedLine).append("\n");
         }
 
         return result.toString().trim();
     }
 }
 