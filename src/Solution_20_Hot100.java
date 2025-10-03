import java.util.Stack;

public class Solution_20_Hot100 {
    public static boolean isValid(String s) {
        if (s.length()%2 == 1){
            return false;
        }

        Stack<Character> stack = new Stack<>();
        // ( ) [ ] { }
        // 0 1 2 3 4 5
        char[] charArray = "()[]{}".toCharArray();

        for (char c : s.toCharArray()) {
            switch (c){
                case '(':
                    stack.push(')');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case '{':
                    stack.push('}');
                    break;
                default:
                    if (stack.isEmpty() || c != stack.pop() ){
                        return false;
                    }
                    break;
            }
        }
        return stack.isEmpty();



    }

    public static void main(String[] args) {

        String s = "(){}[]";
        System.out.println(isValid(s));

    }
}
