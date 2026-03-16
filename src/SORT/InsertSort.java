package SORT;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2026-03-14
 * @Description: 直接插入排序
 * 空间复杂度：O(1) -- 仅需要有限个变量
 * 时间复杂度：O(n^2) -- 两层for循环嵌套
 * 稳定性：稳定 -- 重复元素可以不交换位置
 */
public class InsertSort extends abstractSort {

    @Override
    int[] sortArray(int[] nums) {

        for (int curIdx = 1; curIdx < nums.length; curIdx++) {
            // [0，beginIdx-1]
            insert2ApproprateIdx(nums, curIdx);
        }
        return nums;
    }

    private void insert2ApproprateIdx(int[] nums, int curIdx) {
        // 将 curIdx 插入到当前有序数组的合适位置
        // 即倒序交换比curIdx数值大的
        for (int beforeIdx = curIdx -1; beforeIdx >= 0; beforeIdx--) {
            if (nums[beforeIdx] > nums[curIdx]){
                exchangeVals(nums,beforeIdx, curIdx);
                curIdx = beforeIdx;
            }else {
                break;
            }
        }
    }

    private void exchangeVals(int[] nums, int beforeIdx, int curIdx) {
        int biggerTemp = nums[beforeIdx];
        nums[beforeIdx] = nums[curIdx];
        nums[curIdx] = biggerTemp;
    }
}
