package SORT;

import java.util.Arrays;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-04-15
 * @Description: 归并排序
 */
public class MergeSort {
    // 原数组
    int[] nums;
    // 辅助数组
    int[] help;

    public MergeSort(int[] nums) {
        this.nums = nums;
        this.help = Arrays.copyOf(this.nums,this.nums.length);
    }

    public void Sort(int startIdx, int endIdx){
        // 终止条件
        if (startIdx == endIdx){
            // 表明当前分组只有一个数，已经有序，无序排序
            return;
        }

        // 递归
        // 左Sort-右Sort-中间合并
        int middleIdx = (endIdx+startIdx)/2;
        this.Sort(startIdx,middleIdx);
        this.Sort(middleIdx+1,endIdx);
        this.merge(startIdx, middleIdx, middleIdx+1, endIdx);

    }


    public void merge(int leftStartIdx, int leftEndIdx, int rightStartIdx, int rightEndIdx){

        int orgBeginIdx = leftStartIdx;

        // help数组（辅助数组）中写入排序好的顺序，再写回nums原数组
        int helpIdx = leftStartIdx;

        while (leftStartIdx <= leftEndIdx && rightStartIdx <= rightEndIdx){
            if (nums[leftStartIdx] <= nums[rightStartIdx]){
                //将左子数组中元素进行写入
                help[helpIdx] = nums[leftStartIdx];
                //指针右移
                helpIdx++;
                leftStartIdx++;
            }else {
                //将右子数组中元素进行写入
                help[helpIdx] = nums[rightStartIdx];
                // 指针右移
                helpIdx++;
                rightStartIdx++;
            }
        }

        // 必有一个子数组已经填写完成
        while (rightStartIdx <= rightEndIdx){
            //将右子数组中元素进行写入
            help[helpIdx] = nums[rightStartIdx];
            // 指针右移
            helpIdx++;
            rightStartIdx++;
        }
        while (leftStartIdx <= leftEndIdx){
            //将右子数组中元素进行写入
            help[helpIdx] = nums[leftStartIdx];
            // 指针右移
            helpIdx++;
            leftStartIdx++;
        }
        // 两个子数组均写入完成，将数组写回nums
        for (int i = orgBeginIdx; i <= rightEndIdx; i++) {
            nums[i] = help[i];
        }
    }

}
