package SORT;


import java.util.ArrayList;
import java.util.Arrays;

public class ShellSort extends abstractSort{
    @Override
    int[] sortArray(int[] nums) {
        int gap = nums.length/2;

        while (gap != 0){
            // sort
            for (int curIdx = 0; curIdx < gap; curIdx++) {
                // 0 1 2 3 4 5 6 7 8 9
                ArrayList<Integer> idxList = new ArrayList<>();
                int thisTimdIdxs = curIdx;
                while (thisTimdIdxs < nums.length){
                    idxList.add(thisTimdIdxs);
                    thisTimdIdxs += gap;
                }
                sortSubArray(nums,idxList);
            }
            //
            gap /= 2;
        }
        return nums;
    }

    private void sortSubArray(int[] nums,ArrayList<Integer> idxList) {
        for (int curIdxListIdx = 1; curIdxListIdx < idxList.size(); curIdxListIdx++) {
            doInsertSort(nums,idxList,curIdxListIdx);
        }
    }

    private void doInsertSort(int[] nums, ArrayList<Integer> idxList, int curIdxListIdx) {
        int curVal = nums[idxList.get(curIdxListIdx)];
        int preVal = nums[idxList.get(curIdxListIdx-1)];
        while (preVal > curVal){
            nums[idxList.get(curIdxListIdx)] = preVal;
            nums[idxList.get(curIdxListIdx-1)] = curVal;
            curIdxListIdx--;
            if (curIdxListIdx <= 0) return;
            curVal = nums[idxList.get(curIdxListIdx)];
            preVal = nums[idxList.get(curIdxListIdx-1)];
        }
    }

    public static void main(String[] args) {
        int[] nums = {
                8,5,4,6,2,1,9,3,7
        };
        ShellSort shellSort = new ShellSort();
        int[] ints = shellSort.sortArray(nums);
        System.out.println(Arrays.toString(ints));
    }

}


//
///**
// * @Author: Bingyu Chen
// * @CreateTime: 2025-04-12
// * @Description: 希尔排序
// * 时间复杂度：较难精确计算，大致o(N^1.3)
// * 空间复杂度：O(1)
// * 稳定性： 不稳定
// */
//public class ShellSort {
//    public static void sort(int[] arr){
//
//        int gap = arr.length/2;
//
//        while (gap > 1){
//            // 每轮gap的插入排序
//            for (int i = 0; i < gap; i++) {
//                int numbers = (arr.length-i+1)/gap;
//                int[] curIdxs = new int[numbers];
//                for (int j = 0; j < curIdxs.length; j++) {
//                    curIdxs[j] = i + j*gap;
//                }
//                // 对当前gap间隔分出的位置数组curIdxs进行排序
//                insertSortByIdxs(arr,curIdxs);
//            }
//
//            // gap缩小
//            gap /= 2;
//        }
//        gap = 1;
//        // 插入排序
//        int[] curIdxs = new int[arr.length];
//        for (int j = 0; j < curIdxs.length; j++) {
//            curIdxs[j] = j;
//        }
//        // 对当前gap间隔分出的位置数组curIdxs进行排序
//        insertSortByIdxs(arr,curIdxs);
//    }
//
//    public static void insertSortByIdxs(int[] arr,int[] idxs){
//        for (int i = 1; i < idxs.length; i++) {
//            insert(arr, idxs, i);
//        }
//    }
//
//    public static void  insert(int[] arr, int[] idx, int i){
//        int curValue = arr[idx[i]];
//        int curValueIdx = idx[i];
//
//        if (curValue > arr[idx[i-1]]){
//            //本身就有序
//            return;
//        }
//
//        for (int j = i - 1; j >= 0; j--) {
//            if (arr[idx[j]] > curValue){
//                // 将arr进行交换
//                arr[idx[j+1]] = arr[idx[j]];
////                idx[j+1] = idx[j];
//            }else{
//                arr[idx[j+1]] = curValue;
////                idx[j] = curValueIdx;
//                return;
//            }
//        }
//        // curValue是最小的
//        arr[idx[0]] = curValue;
////        idx[0] = curValueIdx;
//    }
//
//
//}
