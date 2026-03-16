package SORT;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2026-03-16
 * @Description: 快速排序
 */
public class QuickSort extends abstractSort{
    @Override
    int[] sortArray(int[] nums) {
        doQuickSort(nums, 0, nums.length-1);
        return nums;
    }

    private void doQuickSort(int[] nums, int beginIdx, int endIdx) {
        if (beginIdx >= endIdx) return;
        // 先整体
        int pivotIdx = partition(nums, beginIdx, endIdx);
//        System.out.println(beginIdx + "-" + pivotIdx + "-" + endIdx);
//        if (beginIdx == 0 && pivotIdx == 1 && endIdx == 1){
//            System.out.println();
//        }
        // 再 左右子数组
        doQuickSort(nums, beginIdx, pivotIdx-1);
        doQuickSort(nums, pivotIdx+1, endIdx);
    }

    // 分区函数：将数组分为两部分，小于基准值的在左，大于基准值的在右
    private int partition(int[] nums, int leftIdx, int rightIdx){
        int pivotIdx = ThreadLocalRandom.current().nextInt(rightIdx-leftIdx+1)+leftIdx;
        // 1st：将基准点放在数组最左侧
        swap(nums, pivotIdx, leftIdx);
        pivotIdx = leftIdx;
        // 2nd：基准值
        int pivotVal = nums[pivotIdx];
        // 3rd：左指针：指向当前需要检查的元素
        int curLeftIdx = pivotIdx+1;
        // 4th：右指针：从右向左寻找比基准值小的元素
        int curRightIdx = rightIdx;

        // 寻找
        while (curLeftIdx <= curRightIdx){
            // 左指针向右移动，找到第一个大于pivotVal的元素idx
            while ( curLeftIdx<= curRightIdx && nums[curLeftIdx] <= pivotVal){
                curLeftIdx++;
            }
            // 右指针向左移动：找到第一个小于pivotVal的元素idx
            while ( curRightIdx >= curLeftIdx && nums[curRightIdx] >= pivotVal){
                curRightIdx--;
            }

            // 交换元素
            if (curLeftIdx <= curRightIdx){
                swap(nums, curLeftIdx++,curRightIdx--);
            }
        }
        // 将基准点放到分区点位置，{小于基准值的所有元素，pivotVal，大于基准值的所有元素}
        swap(nums, curRightIdx, pivotIdx);
        return curRightIdx;
    }


    private void swap(int[] a, int i, int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }


    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] sortedArray = quickSort.sortArray(new int[]{
                5, 6, 8, 2, 1, 4, 9, 7, 3,
                5, 6, 8, 2, 1, 4, 9, 7, 3
        });

        System.out.println(Arrays.toString(sortedArray));

    }
}
