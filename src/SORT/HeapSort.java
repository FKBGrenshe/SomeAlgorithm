package SORT;

import java.util.Arrays;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-04-13
 * @Description: 堆排序
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,6,2,4,8,0};
        sort(arr);
    }

    public static void sort(int[] arr){
        Heap heap = new Heap(arr.length, arr);
        // 自顶向下，建立大根堆
        for (int i = 0; i < arr.length; i++) {
            heap.heapUp(arr[i],i);
        }
        // 弹出最大值，向下调整
        for (int i = 0; i < arr.length; i++) {
            int tempMax = heap.getValueByIdx(0);
            //arr[arr.length-1-i] = tempMax;
            heap.swap(0, heap.getSize()-1);
            heap.SizeSmall();
            heap.heapDown(heap.getValueByIdx(0),0);
        }

        System.out.println(Arrays.toString(arr));
    }

}

class Heap{

    private int size;
    private int[] arr;

    public Heap(int size, int[] arr) {
        this.size = size;
        this.arr = arr;
    }

    //向上调整：与父节点比较，如果大于父节点，则交换
    public void heapUp(int value, int i){
        int parentIdx = Math.max((i - 1) / 2, 0);
        while (value > arr[parentIdx]){
            swap(i, parentIdx);
            i = parentIdx;
            parentIdx = Math.max((i - 1) / 2, 0);
        }
    }

    // 向下调整：与左右子节点中最大的进行比较，如果小于其，则进行交换
    public void heapDown(int value, int i){
        int leftChildIdx = 2*i + 1;
        while (leftChildIdx < size){
            // 右子节点idx=leftChildIdx+1在size范围内&&右子节点值大于左子节点值 -- 最大子节点为右子节点; 否则最大节点为左子节点
            int maxChildIdx = leftChildIdx+1<size && arr[leftChildIdx] < arr[leftChildIdx+1] ? leftChildIdx+1:leftChildIdx;

            if (arr[maxChildIdx] > value){
                swap(i,maxChildIdx);
                //当前节点位置变为最大子节点位置
                i = maxChildIdx;
                leftChildIdx = 2*i + 1;
            }else {
                break;
            }
        }
    }


    // 将两个节点进行交换
    public void swap(int idx1, int idx2){
        int temp = arr[idx2];
        arr[idx2] = arr[idx1];
        arr[idx1] = temp;
    }

    public int getValueByIdx(int idx){
        return arr[idx];
    }

    public int getSize(){
        return size;
    }

    public void SizeSmall(){
        size--;
    }

}