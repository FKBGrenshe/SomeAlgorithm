import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-03-19
 * @Description: 295.数据流的中位数
 */
public class Solution_295_Hot100 {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }
}

class MedianFinder {

    PriorityQueue<Integer> queMin;
    PriorityQueue<Integer> queMax;

    public MedianFinder() {
        queMax = new PriorityQueue<>((a, b) -> (a - b));
        queMin = new PriorityQueue<>((a, b) -> (b - a));
    }

    public void addNum(int num) {
        if (queMin.isEmpty() || num <= queMin.peek()){
            queMin.offer(num);
            //
            if (queMax.size() + 1 < queMin.size()){
                queMax.offer(queMin.poll());
            }
        }else {
            queMax.offer(num);
            if (queMax.size() > queMin.size()){
                queMin.offer(queMax.poll());
            }
        }
    }

    public double findMedian() {
        if (queMin.size() > queMax.size()){
            return queMin.peek();
        }else {
            return (queMin.peek() + queMax.peek()) / 2.0;
        }
    }
}


