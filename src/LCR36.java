import java.util.Stack;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-08-05
 * @Description: 逆波兰表达式求值
 */
public class LCR36 {

    public int evalRPN(String[] tokens) {

        String v1 = "";
        String v2 = "";
        String res = "";

        Stack<String> stack = new Stack<>();
        for (String token : tokens) {

            switch (token){
                case "+" :
                    v1 = stack.pop();
                    v2 = stack.pop();
                    res = Integer.toString(Integer.parseInt(v1) + Integer.parseInt(v2));
                    stack.push(res);
                    break;
                case "-" :
                    v1 = stack.pop();
                    v2 = stack.pop();
                    res = Integer.toString(Integer.parseInt(v2) - Integer.parseInt(v1));
                    stack.push(res);
                    break;
                case "/":
                    v1 = stack.pop();
                    v2 = stack.pop();
                    res = Integer.toString(Integer.parseInt(v2) / Integer.parseInt(v1));
                    stack.push(res);
                    break;
                case "*":
                    v1 = stack.pop();
                    v2 = stack.pop();
                    res = Integer.toString(Integer.parseInt(v1) * Integer.parseInt(v2));
                    stack.push(res);
                    break;
                default:
                    stack.push(token);
            }

        }
        return Integer.parseInt(stack.peek());

    }


    public static void main(String[] args) {
        LCR36 lcr36 = new LCR36();
        String[] tokens = new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(lcr36.evalRPN(tokens));
    }

}
