import java.util.LinkedList;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-08-05
 * @Description: 用栈实现队列
 */
public class Solution_232 {

    class MyQueue {

        LinkedList<Integer> stack1 = new LinkedList<>();
        LinkedList<Integer> stack2 = new LinkedList<>();

        public MyQueue() {

        }

        public void push(int x) {
            stack1.push(x);
        }

        public int pop() {
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            Integer pop = stack2.pop();
            while (!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
            return pop;
        }

        public int peek() {
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            Integer pop = stack2.peek();
            while (!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
            return pop;
        }

        public boolean empty() {
            return stack1.isEmpty();
        }
    }


}
