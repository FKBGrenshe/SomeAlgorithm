package SORT;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2026-03-13
 * @Description: 冒泡排序
 */
public class BubbleSort extends abstractSort {

    boolean isSorted = false;

    @Override
    int[] sortArray(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            boolean isSorted = true;
            for (int curIdx = 0; curIdx+1 < nums.length; curIdx++) {
                if (nums[curIdx] > nums[curIdx+1]){
                    isSorted = false;
                    int temp = nums[curIdx];
                    nums[curIdx] = nums[curIdx+1];
                    nums[curIdx+1] = temp;
                }
            }
            if (isSorted) return nums;
        }

        return nums;
    }

}
