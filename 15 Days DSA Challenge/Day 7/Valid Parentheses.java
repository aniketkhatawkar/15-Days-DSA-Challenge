import java.util.*;

public class Main {
    public static void main(String[] args) {
        String input1 = "[()]{}{[()()]()}";
        String input2 = "[[}[";

        System.out.println(isValidParenthesis(input1) ? "Balanced" : "Not Balanced");
        System.out.println(isValidParenthesis(input2) ? "Balanced" : "Not Balanced");
    }
    public static boolean isValidParenthesis(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
