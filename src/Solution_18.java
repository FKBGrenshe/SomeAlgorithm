import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-05-03
 * @Description: 四数之和
 */
public class Solution_18 {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> fourSum(int[] nums, int target) {

        Arrays.sort(nums);

        if (target < 0 && nums[0] > 0){
            return ans;
        }

        for (int minIdx = 0; minIdx < nums.length-3; minIdx++) {
            long curTarget = target - nums[minIdx];

            long tempMinSum = 0l;
            tempMinSum += nums[minIdx+1] + nums[minIdx+2] + nums[minIdx+3];
            long tempMaxSum = 0l;
            tempMaxSum += nums[nums.length-1];
            tempMaxSum += nums[nums.length-2];
            tempMaxSum += nums[nums.length-3];

            if (curTarget < tempMinSum || curTarget > tempMaxSum){
                continue;
            }


            // 从 [minIdx+1,...n-1]中寻找三个数 -> curTarget
            for (int midMinIdx = minIdx+1; midMinIdx < nums.length-2; midMinIdx++) {
                long curTwoTarget = curTarget - nums[midMinIdx];
                // 从 [minIdx+1,...n-1]中寻找两个数 -> curTwoTarget
                int midMaxIdx = midMinIdx+1;
                int maxIdx = nums.length-1;

                while (midMaxIdx < maxIdx){
                    long sum = nums[midMaxIdx] + nums[maxIdx] - curTwoTarget;

                    if (sum == 0){
                        List<Integer> result = new ArrayList<>();
                        result.add(nums[minIdx]);
                        result.add(nums[midMinIdx]);
                        result.add(nums[midMaxIdx]);
                        result.add(nums[maxIdx]);
                        if (!ans.contains(result)){
                            ans.add(result);
                        }

                        while (midMaxIdx < maxIdx && nums[midMaxIdx] == nums[midMaxIdx+1]){
                            midMaxIdx++;
                        }
                        while (midMaxIdx < maxIdx && nums[maxIdx] == nums[maxIdx-1]){
                            maxIdx--;
                        }
                        midMaxIdx++;
                        maxIdx--;
                    } else if (sum < 0) {
                        midMaxIdx++;
                    }else {
                        maxIdx--;
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution_18 solution18 = new Solution_18();
        int[] nums = new int[]{
//                1,0,-1,0,-2,2
//                2,2,2,2,2
//                1000000000,1000000000,1000000000,1000000000
//                -1000000000,-1000000000,-1000000000,-1000000000
//                0,4,-5,2,-2,4,2,-1,4
                0,0,0,1000000000,1000000000,1000000000,1000000000
        };
//        int target = -294967296;
//        int target = 294967296;
        int target = 1000000000;

        List<List<Integer>> ans = solution18.fourSum(nums, target);

        ans.forEach(each -> {
            System.out.println(each.toString());
        });

    }


}
