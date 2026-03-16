package SORT;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2026-03-13
 * @Description: 选择排序
 */
public class SelectSort extends abstractSort{
    @Override
    int[] sortArray(int[] nums) {


        for (int beginIdx = 0; beginIdx < nums.length; beginIdx++) {
            // beginIdx: 当前需要将最小值放到的beginIdx
            int minValIdx = findMinValIdx(nums, beginIdx);
            // 交换 beginIdxVal 和 minValIdx的val
            int temp = nums[minValIdx];
            nums[minValIdx] = nums[beginIdx];
            nums[beginIdx] = temp;
        }

        return nums;
    }

    private int findMinValIdx(int[] nums, int beginIdx) {
        int minVal = nums[beginIdx];
        int minValIdx = beginIdx;

        for (int curIdx = beginIdx+1; curIdx < nums.length; curIdx++) {
            if (minVal > nums[curIdx]){
                minVal = nums[curIdx];
                minValIdx = curIdx;
            }
        }
        return minValIdx;
    }
}
