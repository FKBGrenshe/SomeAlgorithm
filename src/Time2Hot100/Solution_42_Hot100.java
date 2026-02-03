package Time2Hot100;

import java.util.Map;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2026-02-03
 * @Description:
 */
public class Solution_42_Hot100 {


    int sum = 0;
    int[] globalHeight = null;

    public int trap(int[] height) {

        globalHeight = height;

        int leftIdx = 0;
        int rightIdx = 0;
        int leftHeight = height[leftIdx];
        int rightHeight = height[rightIdx];
        int curIdx = 0;


        // 以左为边界
        while (curIdx < height.length) {

            if (leftHeight <= height[curIdx]) {
                rightIdx = curIdx;
                rightHeight = height[rightIdx];
                doSum(leftIdx, rightIdx, leftHeight, rightHeight);

                ///
                leftIdx = curIdx;
                leftHeight = height[leftIdx];
            } else {
                if (height[curIdx] > rightHeight) {
                    rightIdx = curIdx;
                    rightHeight = height[curIdx];
                }
            }
            curIdx++;
        }


        if (leftIdx < height.length) {
            rightIdx = height.length - 1;
            rightHeight = height[rightIdx];
            // 以右为边界
            for (curIdx = height.length - 1; curIdx > leftIdx; curIdx--) {
                if (height[curIdx] >= rightHeight) {
                    doSum(curIdx, rightIdx, height[curIdx], rightHeight);
                    rightIdx = curIdx;
                    rightHeight = height[rightIdx];
                }
            }
            if (rightIdx > leftIdx) {
                doSum(leftIdx, rightIdx, height[leftIdx], height[rightIdx]);
            }
        }

        return sum;


    }

    private void doSum(int leftIdx, int rightIdx, int leftHeight, int rightHeight) {

        int lowHeight = Math.min(leftHeight, rightHeight);
        for (int i = leftIdx + 1; i < rightIdx; i++) {
            sum += lowHeight - globalHeight[i];
        }

    }

    public static void main(String[] args) {
//        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] height = {4,2,0,3,2,5};
        Solution_42_Hot100 solution42Hot100 = new Solution_42_Hot100();
        System.out.println(solution42Hot100.trap(height));
    }
}
