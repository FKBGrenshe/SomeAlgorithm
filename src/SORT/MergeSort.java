package SORT;


import java.util.Arrays;

public class MergeSort extends abstractSort{
    int[] nums;

    @Override
    int[] sortArray(int[] nums) {
        this.nums = nums;
        int beginIdx = 0;
        int endIdx = nums.length-1;
        doSort(beginIdx, endIdx);
        return nums;
    }

    private void doSort(int beginIdx, int endIdx) {
        if (beginIdx == endIdx) return;
        // 中间idx
        int midIdx = (beginIdx + endIdx)/2;
        // 左子数组排序
        doSort(beginIdx,midIdx);
        // 右子数组排序
        doSort(midIdx+1, endIdx);
        // 排序所有数组
        basicSort(beginIdx, midIdx,endIdx);
    }

    private void basicSort(int beginIdx, int midIdx, int endIdx) {
        int[] tempArr = new int[endIdx-beginIdx+1];
        int curLeftIdx = beginIdx;
        int curRightIdx = midIdx+1;
        int curTempIdx = 0;

        while (curLeftIdx <= midIdx && curRightIdx<= endIdx){
            if (nums[curLeftIdx] <= nums[curRightIdx]){
                // 将左子数组的当前元素放入tempArr
                tempArr[curTempIdx++] = nums[curLeftIdx++];
            }else {
                // 将右子树组的当前元素放入tempArr
                tempArr[curTempIdx++] = nums[curRightIdx++];
            }
        }
        // todo  将剩余元素挨个添加进入tempArr
        if (curRightIdx <= endIdx){
            // 左子数组已经拷贝完了，还差右子数组
            while (curRightIdx <= endIdx){
                tempArr[curTempIdx++] = nums[curRightIdx++];
            }
        }
        // 还差左子数组，右子数组已经拷贝完了
        while (curLeftIdx <= midIdx){
            tempArr[curTempIdx++] = nums[curLeftIdx++];
        }

        // 拷贝回原数组
        curTempIdx = 0;
        for (int i = beginIdx; i <= endIdx; i++) {
            nums[i] = tempArr[curTempIdx++];
        }
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] sortedArray = mergeSort.sortArray(
                new int[]{
                        5, 6, 8, 2, 1, 4, 9, 7, 3
                }
        );

        System.out.println(Arrays.toString(sortedArray));

    }

}








/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-04-15
 * @Description: 归并排序
 */
/*public class MergeSort {
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

}*/
