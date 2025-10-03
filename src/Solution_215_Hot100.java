import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 * 示例 1:
 * 输入: [3,2,1,5,6,4], k = 2
 * 输出: 5
 *
 * 示例 2:
 * 输入: [3,2,3,1,2,4,5,5,6], k = 4
 * 输出: 4
 *
 * 提示：
 * 1 <= k <= nums.length <= 105
 * -104 <= nums[i] <= 104
 */
public class Solution_215_Hot100 {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(nums.length, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < nums.length; i++) {
            pq.offer(nums[i]);
        }

        while (k > 1){
            pq.poll();
            k--;
        }
        return pq.peek();

    }


    public int findKthLargest1(int[] nums, int k) {

        Heap heap = new Heap(nums);
        int times = heap.size;
        int val = 0;
        for (int i = 0; i < k; i++) {
            val = heap.poll();
        }
        return val;
    }



    public static void main(String[] args) {
        System.out.println(new Solution_215_Hot100().findKthLargest1(new int[]{3,2,3,1,2,4,5,5,6}, 4));
        System.out.println(new Solution_215_Hot100().findKthLargest1(new int[]{3,2,1,5,6,4}, 2));
        System.out.println(new Solution_215_Hot100().findKthLargest1(new int[]{3,3,3,3,3,3,3,3,3}, 2));
    }

    class Heap{
        int size;
        int[] arr;

        public Heap(int capacity) {
            arr = new int[capacity];
        }

        public Heap(int[] arr) {
            this.arr = arr;
            size = arr.length;
            heapify();
        }

//        public void up(){
//
//        }

        public int poll(){
            swap(0, size-1);
            int maxVal = arr[size-1];
            size--;
            down(0);
            return maxVal;
        }


        public void down(int parentIdx){
            int leftChildIdx = parentIdx * 2 + 1;
            int rightChildIdx = leftChildIdx + 1;
            int maxIdx = parentIdx;

            if (leftChildIdx < size){
                maxIdx = arr[leftChildIdx] > arr[maxIdx] ? leftChildIdx : maxIdx;
            }
            if (rightChildIdx < size){
                maxIdx = arr[rightChildIdx] > arr[maxIdx] ? rightChildIdx : maxIdx;
            }

            if (maxIdx != parentIdx){
                swap(maxIdx, parentIdx);
                down(maxIdx);
            }

        }

        public void heapify(){
            int lastNonLeafNodeIdx = size/2-1;
            for (int i = 0; i <= size/2-1; i++) {
                down(lastNonLeafNodeIdx);
                lastNonLeafNodeIdx--;
            }

        }

        public void swap(int i, int j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

    }
}
