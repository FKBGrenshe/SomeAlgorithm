import java.util.*;
import java.util.stream.Collectors;

public class Solution_15_Hot100 {
    public List<List<Integer>> threeSumV1(int[] nums) {

        List<List<Integer>> answerList = new ArrayList<>();

        Arrays.sort(nums);

        for (int firstIdx = 0; firstIdx < nums.length - 1; firstIdx++) {
            if (nums[firstIdx] > 0){
                break;
            }
            //去重：若当前元素与前一个元素相等，得到的结果前一次已经得到了
            if (firstIdx>0&&nums[firstIdx]==nums[firstIdx-1]){
                continue;
            }

            int secondIdx = firstIdx + 1;
            int thirdIdx = nums.length - 1;
            while (secondIdx < thirdIdx){
                int result = nums[firstIdx] + nums[secondIdx] + nums[thirdIdx];
                if (result == 0){
                    answerList.add(Arrays.asList(nums[firstIdx],nums[secondIdx],nums[thirdIdx]));
                    thirdIdx--;
                    secondIdx++;
                } else if (result > 0) {
                    thirdIdx --;
                }else {
                    secondIdx++;
                }
            }

        }

        // distinct
        for (int i = 0; i < answerList.size() - 1; i++) {
            if (answerList.get(i).equals(answerList.get(i+1))){
                answerList.remove(i);
                i --;
            }
        }
        return answerList;

    }



    public List<List<Integer>> threeSumV2(int[] nums) {
        List<List<Integer>> ansList = new ArrayList<>();
        Arrays.sort(nums);

        for (int targetIdx = 0; targetIdx < nums.length-2; targetIdx++) {

            if (nums[targetIdx]> 0){
                break;
            }

            if (targetIdx>0 && nums[targetIdx] == nums[targetIdx-1]){
                continue;
            }
            if (nums[targetIdx] + nums[nums.length-1] + nums[nums.length-2] < 0){
                continue;
            }
            if (nums[targetIdx] + nums[targetIdx+1] + nums[targetIdx+2] > 0){
                continue;
            }

            int smallIdx = targetIdx+1;
            int bigIdx = nums.length-1;
            while (smallIdx < bigIdx){
                if (nums[bigIdx]<0){
                    break;
                }
                int curVal = nums[smallIdx] + nums[bigIdx] + nums[targetIdx];
                if (curVal == 0){
                    ansList.add(Arrays.asList(nums[targetIdx], nums[smallIdx], nums[bigIdx]));
                    while (smallIdx < bigIdx && nums[smallIdx+1] == nums[smallIdx]){
                        smallIdx++;
                    }
                    while (smallIdx < bigIdx && nums[bigIdx-1] == nums[bigIdx]){
                        bigIdx--;
                    }
                    smallIdx++;
                    bigIdx--;
                }
                else if (curVal < 0){
                    smallIdx++;
                } else {
                    bigIdx--;
                }
            }
        }
        return ansList;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int j = i+1, k = nums.length-1;
            if (i > 0 && nums[i] == nums[i-1]) continue;
            if (nums[i] > 0) break;
            while (j < k){
                if (nums[k] < 0) break;
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j-1]) j++;
                    while (j < k && nums[k] == nums[k+1]) k--;
                }
                else if (sum < 0) {
                    while (j < k && nums[j] == nums[j-1]) j++;
                    j++;
                }
                else {
                    while (j < k && nums[k] == nums[k+1]) k--;
                    k--;
                }

            }
        }
        return result;
    }


    public static void main(String[] args) {
        Solution_15_Hot100 solution15Hot100 = new Solution_15_Hot100();
        System.out.println(solution15Hot100.threeSum(new int[]{
//                -2,0,3,-1,4,0,3,4,1,1,1,-3,-5,4,0
//                -1,0,1,2,-1,-4
//                0,0,0,0
//                -2,0,1,1,2
//                0,0,0
//                1,1,1
                0,0,0,0,0,0,0,0,0,0,0,0,
                0,0,0,0,0,0,0,0,0,0,0,0,
                0,0,0,0,0,0,0,0,0,0,0,0,
                0,0,0,0,0,0,0,0,0,0,0,0,
                0,0,0,0,0,0,0,0,0,0,0,0,
                0,0,0,0,0,0,0,0,0,0,0,0,
                0,0,0,0,0,0,0,0,0,0,0,0,
                0,0,0,0,0,0,0,0,0,0,0,0,
                0,0,0,0,0,0,0,0,0,0,0,0,
                0,0,0,0,0,0,0,0,0,0,0,0,
                0,0,0,0,0,0,0,0,0,0,0,0,
                0,0,0,0,0,0,0,0,0,0,0,0,
                0,0,0,0,0,0,0,0,0,0,0,0,
                0,0,0,0,0,0,0,0,0,0,0,0,
                0,0,0,0,0,0,0,0,0,0,0,0,
                0,0,0,0,0,0,0,0,0,0,0,0,
                0,0,0,0,0,0,0,0,0,0,0,0,
                0,0,0,0,0,0,0,0,0,0,0,0,
                0,0,0,0,0,0,0,0,0,0,0,0,
                0,0,0,0,0,0,0,0,0,0,0,0,
                0,0,0,0,0,0,0,0,0,0,0,0,
                0,0,0,0,0,0,0,0,0,0,0,0,
                0,0,0,0,0,0,0,0,0,0,0,0,
                0,0,0,0,0,0,0,0,0,0,0,0,
                0,0,0,0,0,0,0,0,0,0,0,0,
                0,0,0,0,0,0,0,0,0,0,0,0,
                0,0,0,0,0,0,0,0,0,0,0,0,
                0,0,0,0,0,0,0,0,0,0,0,0,
                0,0,0,0,0,0,0,0,0,0,0,0,
                0,0,0,0,0,0,0,0,0,0,0,0,
                0,0,0,0,0,0,0,0,0,0,0,0,
                0,0,0,0,0,0,0,0,0,0,0,0,
        }));
    }
}
