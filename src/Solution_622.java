/**
 * 循环队列 -- 环形队列
 */
public class Solution_622 {
    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3
        circularQueue.enQueue(1);  // 返回 true
        circularQueue.enQueue(2);  // 返回 true
        circularQueue.enQueue(3);  // 返回 true
        circularQueue.enQueue(4);  // 返回 false，队列已满
        circularQueue.Rear();  // 返回 3
        circularQueue.isFull();  // 返回 true
        circularQueue.deQueue();  // 返回 true
        circularQueue.enQueue(4);  // 返回 true
        circularQueue.Rear();  // 返回 4
        System.out.println();
    }
}
class MyCircularQueue {

    int[] cirArray;
    int begin,end,size;

    public MyCircularQueue(int k) {
        // 构造器，设置队列长度为 k
        this.cirArray = new int[k];
        begin = 0;
        end = 0;
        size = 0;
    }

    public boolean enQueue(int value) {
        // 向循环队列插入一个元素。如果成功插入则返回真
        if (isFull()){
            // isFull
            return false;
        }else {
            cirArray[end] = value;
            end = (++end)%cirArray.length;
            size++;
            return true;
        }
    }

    public boolean deQueue() {
        if (isEmpty()){
            return false;
        }else {
            begin = (++begin)%cirArray.length;
            size--;
            return true;
        }
    }

    public int Front() {
        // 从队首获取元素。如果队列为空，返回 -1
        return isEmpty() ? -1 : cirArray[begin];
    }

    public int Rear() {
        // 获取队尾元素。如果队列为空，返回 -1
        return isEmpty() ? -1 : cirArray[(end-1+cirArray.length)%cirArray.length];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == cirArray.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
