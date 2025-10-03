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
        int[] randomArr = randomArr();
        // 初始数组
        System.out.println(Arrays.toString(randomArr));
        // 排序数组
        int[] insertSort = Arrays.copyOf(randomArr, randomArr.length);
        InsertSort.sort(insertSort);
//        System.out.println(Arrays.toString(insertSort));

        int[] shellSort = Arrays.copyOf(randomArr, randomArr.length);
        ShellSort.sort(shellSort);
//        System.out.println(Arrays.toString(shellSort));

        int[] heapSort = Arrays.copyOf(randomArr, randomArr.length);
        HeapSort.sort(heapSort);

        int[] mergeSortarr = Arrays.copyOf(randomArr, randomArr.length);
        MergeSort mergeSort = new MergeSort(mergeSortarr);
        mergeSort.Sort(0,mergeSortarr.length-1);
        System.out.println(Arrays.toString(mergeSortarr));


        for (int i = 0; i < insertSort.length; i++) {
            if (insertSort[i] != shellSort[i]
                    || insertSort[i] != heapSort[i]
                    || insertSort[i] != mergeSortarr[i]
            ){
                System.out.println("false!");
                return;
            }
        }

        System.out.println("true");

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
}






