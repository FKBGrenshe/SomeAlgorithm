package SORT;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2026-03-16
 * @Description: 计数排序
 */
public class RadixSort extends abstractSort{

    // 可以排序0~10000之间的任意数组
    int[] radix = new int[10000];
    int radixIdx = 0;

    @Override
    int[] sortArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if ( 0 > nums[i] || nums[i] >= 10000){
                System.out.println("输入违法：num[" + i + "]值不符合输入范围0~10000 ：" + nums[i]);
                return nums;
            }
            radix[nums[i]]++;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = findAndFill();
        }
        return nums;
    }

    private int findAndFill() {

        while (radixIdx < radix.length && radix[radixIdx] <= 0){
            radixIdx++;
        }
        if (radixIdx < radix.length) {
            radix[radixIdx]--;
            return radixIdx;
        }

        return Integer.MIN_VALUE;
    }
}
