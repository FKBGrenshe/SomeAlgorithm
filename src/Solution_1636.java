import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-09-08
 * @Description: 按照频率将数组升序排序
 */
public class Solution_1636 {


    public int[] frequencySort(int[] nums) {
        int[] answer = new int[nums.length];
        int[] counts = new int[201];
        // val -> counts[idx] : idx = val+100
        for (int val : nums) {
            counts[val+100]++;
        }

        int pinlv = 1;
        int answerIdx = 0;
        while (pinlv <= 201){
            for (int i = counts.length - 1; i >= 0; i--) {
                if (counts[i] == pinlv){
                    for (int j = 0; j < pinlv; j++) {
                        answer[answerIdx++] = i-100;
                    }
                }
            }
            pinlv++;
        }
        return answer;

        /*HashMap<Integer, Integer> countMap = new HashMap<>();

        // put into countingMap
        for (int i = 0; i < nums.length; i++) {
            if (countMap.containsKey(nums[i])){
                countMap.put(nums[i],1);
            }else {
                countMap.put(nums[i],countMap.get(nums[i])+1);
            }
        }*/
    }


    public static void main(String[] args) {
        Solution_1636 solution1636 = new Solution_1636();
        int[] answer = solution1636.frequencySort(
                new int[]{1, 1, 2, 2, 2, 3, 4, 4}
        );
        System.out.println(Arrays.toString(answer));
    }


}
