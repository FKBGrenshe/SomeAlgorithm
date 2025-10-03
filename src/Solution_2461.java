import java.util.HashMap;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-04-29
 * @Description: 长度为k子数组中的最大和
 */
public class Solution_2461 {

    HashMap<Integer, Integer> map = new HashMap<>();
    long maxSum = 0;

    public long maximumSubarraySum(int[] nums, int k) {

//        int start = 0;
//        int end = 0;

        long curSum = 0;


        for (int i = 0; i < nums.length; i++) {

            int curKey = nums[i];

            if (map.containsKey(curKey)){
                for (int start = i-map.size(); start < i; start++) {
                    int delKey = nums[start];
                    map.remove(delKey);
                    curSum -= delKey;
                    if (delKey == nums[i]){
                        break;
                    }
                }
            }

            map.put(curKey,1);
            curSum += curKey;
            System.out.println(curSum);
            if (map.size() > k){
                int delKey = nums[i-k];
                map.remove(delKey);
                curSum -= delKey;
                maxSum = Math.max(curSum,maxSum);
            }


            if(map.size() == k){
                maxSum = Math.max(curSum,maxSum);
            }else {
                // map.size() < k
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {


        Solution_2461 solution2461 = new Solution_2461();


        /*System.out.println(solution2461.maximumSubarraySum(
                new int[]{
//                        1,5,4,2,9,9,9
                        9,18,10,13,17,9,19,2,1,18
                },
                5
        ));*/

        int[] test = new int[100000];
        for (int i = 0; i < test.length; i++) {
            test[i] = i+1;
        }
        int k = 100000;
        System.out.println(solution2461.maximumSubarraySum(
                test,
                k
        ));




    }
}
