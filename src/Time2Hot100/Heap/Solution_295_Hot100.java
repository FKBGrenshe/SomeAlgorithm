package Time2Hot100.Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2026-03-10
 * @Description: 数据流中的中位数
 */
public class Solution_295_Hot100 {

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
//        // arr = [1]
//        medianFinder.addNum(1);
//        // arr = [1, 2]
//        medianFinder.addNum(2);
//        // 返回 1.5 ((1 + 2) / 2)
//        System.out.println(medianFinder.findMedian());
//        // arr[1, 2, 3]
//        medianFinder.addNum(3);
//        // return 2.0
//        System.out.println(medianFinder.findMedian());

        medianFinder.addNum(1);
        medianFinder.addNum(4);
        medianFinder.addNum(3);
        medianFinder.addNum(2);
        medianFinder.addNum(7);
        medianFinder.addNum(9);
        medianFinder.addNum(5);
        medianFinder.addNum(8);
        medianFinder.addNum(6);

    }

    static class MedianFinder {

        Heap minHeap, maxHeap;
        int totalSize = 0;

        public MedianFinder() {
            minHeap = new Heap(false);
            maxHeap = new Heap(true);
        }

        public void addNum(int num) {
            if (minHeap.getSize() == 0) {
                minHeap.insert(num);
                return;
            }

            int minHeapMin = minHeap.getRootVal();

            if (num < minHeapMin){
                maxHeap.insert(num);
            }else {
                minHeap.insert(num);
            }

            // 调整heapSize
//            int minHeapSize = minHeap.getSize();
//            int maxHeapSize = maxHeap.getSize();

            while (minHeap.getSize() - maxHeap.getSize() > 1){
                maxHeap.insert(minHeap.pop());
            }
            while (maxHeap.getSize() - minHeap.getSize() > 0){
                minHeap.insert(maxHeap.pop());
            }

        }

        public double findMedian() {
            totalSize = minHeap.getSize()+maxHeap.getSize();
            if (totalSize % 2 == 0){
                // 偶数
                return  ((double)minHeap.getRootVal() + (double)maxHeap.getRootVal()) /2;
            }else {
                // 奇数
                return minHeap.getRootVal();
            }
        }



        static class Heap{
            ArrayList<Integer> list;
            boolean max;

            /**
             * 创建堆
             * @param max ： 指定是大根堆还是小根堆
             */
            public Heap(boolean max) {
                this.list = new ArrayList<>();
                this.max = max;
            }

            public void insert(int val){
                // 插入：放到数组末尾，swiftUp上浮
                list.addLast(val);
                swiftUp(list.size()-1);
            }

            private void swiftUp(int curIdx) {
                if (curIdx == 0) return;
                int fatherIdx = (curIdx-1)/2;
                if (fatherIdx < 0) return;
                if (canSwiftUp(curIdx,fatherIdx)){
                    exchange(curIdx, fatherIdx);
                    swiftUp(fatherIdx);
                }
            }

            private boolean canSwiftUp(int curIdx, int fatherIdx) {
                Integer curVal = list.get(curIdx);
                Integer fatherVal = list.get(fatherIdx);
                if (max){
                    // 大根堆-是否满足上浮条件：curVal > fatherVal
                    return curVal > fatherVal;
                }else {
                    // 小根堆-是否满足上浮条件：curVal < fatherVal
                    return curVal < fatherVal;
                }
            }

            private void exchange(int curIdx, int fatherIdx) {
                int tempVal = list.get(fatherIdx);
                list.set(fatherIdx, list.get(curIdx));
                list.set(curIdx, tempVal);
            }

            public int pop(){
                // 弹出Root元素
                Integer rootVal = list.get(0);
                // 将末尾元素放到数组首位 - swiftDown
                list.set(0,list.get(list.size()-1));
                list.removeLast();
                swiftDown(0);
                return rootVal;
            }

            private void swiftDown(int curIdx) {
                if (curIdx >= list.size()) return;
                int leftChildIdx = 2*curIdx + 1;
                int rightChildIdx = 2*curIdx + 2;
                int changeIdx;
                if (leftChildIdx >= list.size()) return;
                if (rightChildIdx >= list.size()){
                    changeIdx = leftChildIdx;
                }else {
                    changeIdx = chooseLeftChildIdx(leftChildIdx, rightChildIdx) ? leftChildIdx : rightChildIdx;
                }

                if (canSwiftDown(curIdx, changeIdx)){
                    exchange(curIdx,changeIdx);
                    swiftDown(changeIdx);
                }

            }

            private boolean canSwiftDown(int curIdx, int changeIdx) {
                if (max){
                    // 大根堆：如果当前节点更小，则可以下潜
                    return list.get(curIdx) <= list.get(changeIdx);
                }else {
                    // 小根堆：如果当前节点更大，则可以下潜
                    return list.get(curIdx) > list.get(changeIdx);
                }
            }

            private boolean chooseLeftChildIdx(int leftChildIdx, int rightChildIdx) {
                if (max){
                    // 大根堆：应该选择孩子中更大的那个
                    return list.get(leftChildIdx) > list.get(rightChildIdx);
                }else {
                    // 小根堆：应该选择孩子中更小的那个
                    return list.get(leftChildIdx) <= list.get(rightChildIdx);
                }
            }

            public int getRootVal() {
                return list.getFirst();
            }

            public int getSize(){
                if (Objects.isNull(list) || this.list.isEmpty()){
                    return 0;
                }
                return list.size();
            }
        }
    }

}