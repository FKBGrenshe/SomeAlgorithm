package SORT;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-04-12
 * @Description: 排序算法测试
 */
public class test {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            test();
        }
    }

    public static void test() {
        int[] randomArr = randomArr();
        // 初始数组
//        System.out.println(Arrays.toString(randomArr));


        // 排序数组
//        int[] insertSort = Arrays.copyOf(randomArr, randomArr.length);
//        InsertSort.sort(insertSort);
//        System.out.println(Arrays.toString(insertSort));

//        int[] heapSort = Arrays.copyOf(randomArr, randomArr.length);
//        HeapSort.sort(heapSort);

//        int[] mergeSortarr = Arrays.copyOf(randomArr, randomArr.length);
//        MergeSort mergeSort = new MergeSort(mergeSortarr);
//        mergeSort.Sort(0,mergeSortarr.length-1);
//        System.out.println(Arrays.toString(mergeSortarr));

        // 冒泡排序
        int[] bubbleSortarr = Arrays.copyOf(randomArr, randomArr.length);
        BubbleSort bubbleSort = new BubbleSort();
        int[] bubbleSortedArr = bubbleSort.sortArray(bubbleSortarr);
        System.out.println(checkIfSorted(bubbleSortedArr));

        // 选择排序
        int[] selectionSortArr = Arrays.copyOf(randomArr, randomArr.length);
        SelectSort selectSort = new SelectSort();
        int[] selectSortedArr = selectSort.sortArray(selectionSortArr);
        System.out.println(checkIfSorted(selectSortedArr));

        // 插入排序
        int[] insertSortArr = Arrays.copyOf(randomArr, randomArr.length);
        InsertSort insertSort = new InsertSort();
        int[] insertSortedArr = insertSort.sortArray(insertSortArr);
        System.out.println(checkIfSorted(insertSortedArr));

        // 希尔排序
        int[] shellSortArr = Arrays.copyOf(randomArr, randomArr.length);
        ShellSort shellSort = new ShellSort();
        int[] shellSortedArr = shellSort.sortArray(shellSortArr);
        System.out.println(checkIfSorted(shellSortedArr));

        // 快速排序
        int[] quickSortArr = Arrays.copyOf(randomArr, randomArr.length);
        QuickSort quickSort = new QuickSort();
        int[] quickSortedArr = quickSort.sortArray(quickSortArr);
        System.out.println(checkIfSorted(quickSortedArr));

        // 归并排序
        int[] mergeSortArr = Arrays.copyOf(randomArr, randomArr.length);
        MergeSort mergeSort = new MergeSort();
        int[] mergeSortedArray = mergeSort.sortArray(mergeSortArr);
        System.out.println(checkIfSorted(mergeSortedArray));

        // 计数排序
        int[] radixSortArr = Arrays.copyOf(randomArr, randomArr.length);
        RadixSort radixSort = new RadixSort();
        int[] radixSortedArray = radixSort.sortArray(radixSortArr);
        System.out.println(checkIfSorted(radixSortedArray));

        // 桶排序

        // 基数排序

        // 堆排序

    }

    // 随机产生无序数组
    public static int[] randomArr(){
        Random random = new Random();
        int max = 1000, min = 50;
        int n = random.nextInt(max-min+1) + min ;

        int[] org = new int[n];

        for (int i = 0; i < org.length; i++) {
            int idx = random.nextInt(0,10);
            org[i] = idx;
        }
        return org;
    }

    public static boolean checkIfSorted(int[] nums){
        for (int i = 0; i+1 < nums.length; i++) {
            if (nums[i] > nums[i+1]){
                System.out.println(Arrays.toString(nums));
                return false;
            }
        }
        return true;
    }

}






