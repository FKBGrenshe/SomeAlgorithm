package Time3Hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Solution_1_Hot100 {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, ArrayList<Integer>> idxMap = new LinkedHashMap<>();
        for(int idx = 0; idx < nums.length; idx++){
            int key = nums[idx];
            int val = idx;
            if(idxMap.containsKey(key)){
                idxMap.get(key).add(val);
            }else {
                ArrayList<Integer> curValList = new ArrayList<>(2);
                curValList.add(idx);
                idxMap.put(nums[idx],curValList);
            }

        }

        Arrays.sort(nums);

        int[] ans = new int[]{-1,-1};

        int smallidx = 0;
        int bigidx = nums.length-1;

        int sum = 0;

        while( smallidx < bigidx){

            sum = nums[smallidx] +nums[bigidx];
            if  (sum < target){
                smallidx++;
            }else if (sum == target){
                ans[0] = get(nums[smallidx], idxMap);
                ans[1] = get(nums[bigidx], idxMap);
                return ans;
            }else{
                bigidx--;
            }
        }

        return ans;
    }

    private int get(int val, HashMap<Integer, ArrayList<Integer>> idxMap){
        ArrayList<Integer> curValList = idxMap.get(val);
        int ans = curValList.getFirst();
        curValList.removeFirst();
        return ans;
    }

    public static void main(String[] args){

        Solution_1_Hot100 solution1Hot100 = new Solution_1_Hot100();
        System.out.println(Arrays.toString(solution1Hot100.twoSum(
                new int[]{3, 2,4},
                6
        )));

    }
}