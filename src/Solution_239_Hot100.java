import java.util.*;

/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值 。
 * 示例 1：
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * 示例 2：
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * 提示：
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 1 <= k <= nums.length
 */
public class Solution_239_Hot100 {
    public int[] maxSlidingWindow(int[] nums, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<>(nums.length,new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] != o1[0] ? o2[0] - o1[0] : o2[1] - o1[1];
            }
        });

        for (int i = 0; i < k; i++) {
            pq.offer(
                    new int[]{nums[i], i}
            );
        }

        int[] results = new int[nums.length - k + 1];
        results[0] = pq.peek()[0];
        for (int i = k; i < nums.length; i++) {
            pq.offer(
                    new int[]{nums[i], i}
            );
            while (pq.peek()[1] <= i - k){
                pq.poll();
            }
            results[i - k + 1] = pq.peek()[0];
        }

        return results;
    }

    public static void main(String[] args) {
        Solution_239_Hot100 solution239Hot100 = new Solution_239_Hot100();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] results = solution239Hot100.maxSlidingWindow(nums, 3);
        for (int result : results) {
            System.out.println(result);
        }
    }

}
