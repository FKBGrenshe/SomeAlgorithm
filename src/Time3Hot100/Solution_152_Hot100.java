//package Time3Hot100;
//
//import java.util.Arrays;
//
//public class Solution_152_Hot100 {
//
//
//    // 2, 6,
//    // 2, 3, -2, 4
//    // 99, 99,
//
//    public int maxProduct(int[] nums) {
//        int[] dpMax = new int[nums.length];
//        int[] dpMin = new int[nums.length];
//
//        Arrays.fill(dpMax, -99);
//        Arrays.fill(dpMin, 99);
//
//        if (nums[0] >= 0){
//            dpMax[0] = nums[0];
//        }else{
//            dpMin[0] = nums[0];
//        }
//
//        int prevMax, prevMin, curValpreMax, curValpreMin, curVal;
//
//        for (int i = 1; i < nums.length; i++) {
//            curVal = nums[i];
//            curValpreMax = -99;
//            curValpreMin = 99;
//
//            prevMax = dpMax[i-1];
//            prevMin = dpMin[i-1];
//
//            if (prevMax != -99){
//                curValpreMax = curVal*prevMax;
//            }
//            if(prevMin != 99){
//                curValpreMin = curVal*prevMin;
//            }
//
//            int[] arr = new int[]{curVal, curValpreMax, curValpreMin, prevMax, prevMin};
//            Arrays.sort(arr);
//
//            int k = 0, j = 4;
//            while (k <= j){
//                if (dpMax[k] != -99 && arr[k] != -99){
//                    dpMax[k] = arr[k];
//                }
//                if (dpMin[j] != 99 && arr[j] != 99){
//                    dpMin[j] = arr[j];
//                }
//
//                k++;
//                j--;
//            }
//
//        }
//
//
//        // final
//        return dpMax[nums.length-1];
//    }
//}
