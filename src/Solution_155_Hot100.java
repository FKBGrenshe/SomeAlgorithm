import java.util.Stack;

public class Solution_155_Hot100 {
    public static void main(String[] args) {

    }
}

class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()){
            // 第一次压入
            stack.push(val);
            minStack.push(val);
        }else {
            // 非第一次压入
            stack.push(val);
            int minStackValue = minStack.peek();
            if (val > minStackValue){
                minStack.push(minStackValue);
            }else {
                minStack.push(val);
            }
        }
    }

    public void pop() {
        minStack.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }


}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
