import java.util.LinkedList;

/**
 * 用队列实现栈
 */
public class Solution_225 {
    public static void main(String[] args) {

         MyStack obj = new MyStack();
         obj.push(1);
         obj.push(2);
         int param_2 = obj.top();
         int param_3 = obj.pop();
         boolean param_4 = obj.empty();
        System.out.println("");
    }
}

class MyStack {

    LinkedList<Integer> queue = new LinkedList<>();

    public MyStack() {

    }

    public void push(int x) {
        queue.offer(x);
        for (int i = 1; i < queue.size(); i++) {
            queue.offer(queue.poll());
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.size() != 0;
    }
}