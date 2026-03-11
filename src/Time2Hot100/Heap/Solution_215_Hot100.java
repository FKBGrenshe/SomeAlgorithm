package Time2Hot100.Heap;

import java.util.*;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2026-03-10
 * @Description: 数组中的第k个最大元素
 */
public class Solution_215_Hot100 {

    public int findKthLargest(int[] nums, int k) {

        Heap heap = new Heap(nums);
        heap.heapify();

        int returnResult = 0;
        for (int i = 0; i < k; i++) {
            returnResult = heap.pop();
        }

        return returnResult;

    }

    static class Heap{
        int[] heaplist;
        int size;

        public Heap(int[] heaplist) {
            this.heaplist = heaplist;
            this.size = heaplist.length;
        }

        // heapify -- 建堆
        public void heapify(){
            // 对原始数组，从最左侧开始，到N/2，进行下潜

            for (int curIdx = size/2; curIdx >= 0; curIdx--) {
                swiftDown(curIdx);
            }
//
//            for (int curIdx = 0; curIdx < heaplist.length/2+1; curIdx++) {
//            }
        }

        // up -- 上浮
        void swiftUp(int curIdx){
            // father
            int fatherIdx = (curIdx-1)/2;
            //
            if ( fatherIdx >= 0 && heaplist[fatherIdx] < heaplist[curIdx]){
                exchange(fatherIdx, curIdx);
                swiftDown(fatherIdx);
            }
        }

        // down -- 下潜
        void swiftDown(int curIdx){
            if (curIdx >= size) return;
            // child
            int leftChildIdx = curIdx*2+1;
            int rightChildIdx = curIdx*2+2;
            int changeIdx;
            if (leftChildIdx >= size) {
                return;
            } else if (rightChildIdx >= size) {
                changeIdx = leftChildIdx;
            }else {
                changeIdx = heaplist[leftChildIdx] >= heaplist[rightChildIdx] ? leftChildIdx : rightChildIdx;
            }
            if (heaplist[changeIdx] > heaplist[curIdx]){
                exchange(curIdx,changeIdx);
                swiftDown(changeIdx);
            }
        }

        public int pop(){
            if (size == 0) return -Integer.MAX_VALUE;
            int rootVal = get(0);
            set(get(size-1), 0);
            removeTail();
            return rootVal;
        }

        private void removeTail() {
            size--;
        }

        private int get(int curIdx){
            return heaplist[curIdx];
        }

        private void set(int newVal, int curIdx){
            heaplist[curIdx] = newVal;
            swiftDown(curIdx);
        }

        private void exchange(int fatherIdx, int curIdx) {
            int tempVal = heaplist[fatherIdx];
            heaplist[fatherIdx] = heaplist[curIdx];
            heaplist[curIdx] = tempVal;
        }

        @Override
        public String toString() {
            return "Heap{" +
                    "heaplist=" + Arrays.toString(heaplist) +
                    '}';
        }

        // insert插入


    }

    public static void main(String[] args) {


        int[] lists = {1};
//        int[] lists = {3, 2, 1, 5, 6, 4};
//        int[] lists = {3,2,3,1,2,4,5,5,6};

        Solution_215_Hot100 solution215Hot100 = new Solution_215_Hot100();
        System.out.println(solution215Hot100.findKthLargest(lists, 1));

//        Heap heap = new Heap(lists);
//        heap.heapify();
//        System.out.println(heap.toString());
    }


}
