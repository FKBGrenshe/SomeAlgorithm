import java.util.Arrays;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-05-14
 * @Description: 咒语和药水的成功对数
 */
public class Solution_2300 {

    public int[] successfulPairs(int[] spells, int[] potions, long success) {

        Arrays.sort(potions);
        int[] ans = new int[spells.length];

        for (int idx = 0; idx < ans.length; idx++) {

            long goal =  success / spells[idx];
            long curProd = goal * spells[idx];
            if (curProd < success){
                goal++;
            }
            int searchIdx = binarySearchIdx(potions, goal);

            if ( searchIdx >= potions.length ){
                ans[idx] = 0;
            }else {
                long searchIdxProd = (long) potions[searchIdx] * (long) spells[idx];
                if (searchIdxProd < success){
                    ans[idx] = 0;
                }
                ans[idx] = potions.length-searchIdx;
            }
        }
        return ans;
    }

    private int binarySearchIdx(int[] arr, long target){
        // 寻找第一个大于等于target的位置
        int left = 0;
        int right = arr.length-1;
        while (left <= right){

            int mid = (left+right)/2;
            if (arr[mid] < target){
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Solution_2300 solution2300 = new Solution_2300();

        int[] spells = {5,1,3};
        int[] potions = {1,2,3,4,5};
        long success = 7;

        System.out.println(Arrays.toString(solution2300.successfulPairs(
                spells, potions, success
        )));
    }



}
