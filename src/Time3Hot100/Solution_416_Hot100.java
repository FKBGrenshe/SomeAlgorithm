//package Time3Hot100;
//
//import java.util.Arrays;
//
//public class Solution_416_Hot100 {
//    public boolean canPartition(int[] nums) {
//        Arrays.sort(nums);
//
//
//        int idx = 0;
//        int leftSum = 0;
//
//        int rightSum = 0;
//        for (int num : nums) {
//            rightSum += num;
//        }
//
//        while (leftSum < rightSum){
//            int moveVal = nums[idx];
//            leftSum += nums[idx];
//            rightSum -= nums[idx];
//            idx++;
//        }
//
//        return leftSum == rightSum;
//
//    }
//
//    public static void main(String[] args) {
//        Solution_416_Hot100 solution416Hot100 = new Solution_416_Hot100();
//        System.out.println(solution416Hot100.canPartition(
//                new int[]{
//                        1, 5, 11, 5
//                }
//        ));
//    }
//}
