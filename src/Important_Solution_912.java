import java.util.Arrays;

/**
 * 排序算法总结
 * @author: congchuan
 * @date: 2023/03/06 09:07
 *
 * 给你一个整数数组 nums，请你将该数组升序排列。
 * 你必须在 不使用任何内置函数 的情况下解决问题，时间复杂度为 O(nlog(n))，并且空间复杂度尽可能小。
 *
 * // 插入排序
 * void InsertSort(int* a, int n);
 * // 希尔排序
 * void ShellSort(int* a, int n);
 * // 选择排序
 * void SelectSort(int* a, int n);
 * // 堆排序
 * void AdjustDwon(int* a, int n, int root);
 * void HeapSort(int* a, int n);
 * // 冒泡排序
 * void BubbleSort(int* a, int n);
 * // 快速排序
 * void QuickSort(int* a, int left, int right);
 * // 归并排序递归实现
 * void MergeSort(int* a, int n);
 * // 计数排序
 * void CountSort(int* a, int n);
 *
 */
public class Important_Solution_912 {

    public int[] sortArray(int[] nums) {

//        return BubbleSort(nums);
//        return InsertSort(nums);
//        return simpleSelectionSort(nums);

        if (nums.length == 0 || nums == null){
            return nums;
        }
        QuickSort(nums, 0, nums.length-1);

        return nums;
    }

    // 冒泡排序
    public int[] BubbleSort(int[] nums){
        // 冒泡排序
        for (int i = 0; i < nums.length; i++) {
            // 表示当前需要排序的元素
            for (int j = i+1; j < nums.length; j++) {
                // 表示和当前需要排序的元素进行比较的元素
                if (nums[i] > nums[j]){
                    //
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }


    public int[] QuickSort(int[] nums, int leftIdx, int rightIdx){
        if (leftIdx < rightIdx){
            //
            int pivotIdx = QuickSortPartition(nums, leftIdx, rightIdx);
            // 递归排序左、右子序列
            QuickSort(nums, leftIdx, pivotIdx-1);
            QuickSort(nums, pivotIdx+1, rightIdx);
        }

        return nums;
    }

    // 快速排序
    public int QuickSortPartition(int[] nums, int leftIdx, int rightIdx){
        int pivot = nums[leftIdx]; // 取出基准值

        while (leftIdx < rightIdx){
            // 先右指针向前遍历
            while ( leftIdx < rightIdx && pivot < nums[rightIdx]){
                rightIdx--;
            }
            if (leftIdx < rightIdx){
                // 遇到右指针指向的值小于key
                // 将右指针指向的值赋给左指针的位置
                nums[leftIdx] = nums[rightIdx];
                // 右指针指向的值已经赋给了左指针，所以右指针指向的值已经不需要了
                // 所以坑位就是右指针
                leftIdx++;
            }
            // 再左指针向后遍历
            while (leftIdx < rightIdx && pivot > nums[leftIdx]){
                leftIdx ++;
            }
            if (leftIdx < rightIdx){
                // 遇到左指针指向的值大于key
                // 将左指针指向的值赋给右指针的位置
                nums[rightIdx] = nums[leftIdx];
                // 左指针指向的值已经赋给了右指针，所以左指针指向的值已经不需要了
                rightIdx--;
            }
        }
        // 此时leftIdx和rightIdx同时指向最终的坑位，将基准元素填入
        nums[leftIdx] = pivot;
        // 返回基准元素的位置
        return leftIdx;
    }

    // 直接插入排序
    public int[] InsertSort(int[] nums){
        // 直接插入排序
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i-1]){
                int temp = nums[i];
                if (i == 1){
                    nums[i] = nums[i-1];
                    nums[i-1] = temp;
                }else {
                    for (int j = i-2; j >= 0; j--) {
                        if (temp <= nums[0]){
                            for (int k = i; k > 0; k--) {
                                nums[k] = nums[k-1];
                            }
                            nums[0] = temp;
                            break;
                        }
                        if (temp > nums[j]){
                            // [j,     j+1,    ....,i]
                            // num[j], temp, .... num[i-1]
                            //         num[i]
                            for (int k = i; k > j+1; k--) {
                                nums[k] = nums[k-1];
                            }
                            nums[j+1] = temp;
                            break;
                        }
                    }
                }
            }
        }

        return nums;
    }

    // 简单选择排序
    public int[] simpleSelectionSort(int[] nums){
        // 简单选择排序
        int swapIdx = 0;
        int swapIdxBigger  = -1;
        int tempMinValue = Integer.MAX_VALUE;
        while (swapIdx < nums.length){
            tempMinValue = Integer.MAX_VALUE;
            for (int i = swapIdx+1; i < nums.length; i++) {
                if (nums[i] < tempMinValue){
                    tempMinValue = nums[i];
                    swapIdxBigger = i;
                }
            }
            if (tempMinValue < nums[swapIdx]){
                nums[swapIdxBigger] = nums[swapIdx];
                nums[swapIdx] = tempMinValue;
            }
            swapIdx++;
        }
        return nums;
    }


    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new Important_Solution_912().sortArray(new int[]{5, 2, 3, 1})));
        System.out.println(Arrays.toString(new Important_Solution_912().sortArray(new int[]{5,1,1,2,2,0,0})));
    }


}
