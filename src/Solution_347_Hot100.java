import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * 提示：
 * 1 <= nums.length <= 105
 * k 的取值范围是 [1, 数组中不相同的元素的个数]
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
 *
 *  进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。
 */
public class Solution_347_Hot100 {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];

        Arrays.sort(nums);
        // 将数组排序，然后统计每个数字出现的次数
        Map<Integer, Integer> numbers = new HashMap<>();
        for (int num : nums) {
            if (numbers.containsKey(num)){
                numbers.replace(num, numbers.get(num) + 1);
            }else {
                numbers.put(num, 1);
            }
        }
        // [a,b] -- a:数值（numbers下标）， b：数值a出现的次数
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        numbers.forEach((key, value) -> {
            priorityQueue.offer(new int[]{key, value});
        });

        for (int i = 0; i < k; i++) {
            ans[i] = priorityQueue.poll()[0];
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution_347_Hot100 solution347 = new Solution_347_Hot100();
        int[] nums = {-1,-1};
        System.out.println(solution347.topKFrequent(nums, 2));
    }
}
