import java.util.ArrayList;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-09-08
 * @Description: 最大间距
 */
public class Solution_164 {


    private static int pickIntByBit(int val,int bit){
        // bit第几位，返回val的bit位值上的数字
        return val / ((int) Math.pow(10, bit)) % 10;
    }

    /**
     * 使用计数排序， 会超出内存限制
     * @param nums
     * @return
     */
    public int maximumGapByCountingSort(int[] nums) {

        if (nums.length <= 1){
            return 0;
        }
        if (nums.length == 2){
            return Math.abs(nums[0] - nums[1]);
        }

        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max,num);
        }

        int[] counts = new int[max+1];

        for (int i = 0; i < nums.length; i++) {
            counts[nums[i]] = 1;
        }

        int maxDiffer = 0;
        int left = 0;
        int right = 0;
        while (left < counts.length){
            right = left+1;
            if (right >= counts.length){
                break;
            }
            if (counts[left] != 0){
                while (right<counts.length && counts[right] == 0){
                    right++;
                }
                if (right >= counts.length){
                    break;
                }
                maxDiffer = Math.max(maxDiffer, right - left);
            }
            left = right;
        }

        return maxDiffer;

    }

    /**
     * 改进1：使用基数排序代替计数排序
     * @param nums
     * @return
     */
    public int amximumGapByRadixSort(int[] nums){
        if (nums.length <= 1){
            return 0;
        }
        if (nums.length == 2){
            return Math.abs(nums[0] - nums[1]);
        }

        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            maxVal = Math.max(maxVal, nums[i]);
        }
        int totalBits = 0;
        while (maxVal > 0){
            totalBits++;
            maxVal/=10;
        }

        // 排序
        ArrayList<ArrayList<Integer>> bitList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            bitList.add(new ArrayList<>());
        }

        // 从第1位开始，遍历9次，遍历到10^9
        for (int bit = 0; bit <= totalBits; bit++) {

            // 写到桶中
            for (int i = 0; i < nums.length; i++) {
                bitList.get(pickIntByBit(nums[i], bit)).add(nums[i]);
            }
            // 重新写回数组
            int idx = 0;
            for (int i = 0; i < bitList.size(); i++) {
                ArrayList<Integer> list = bitList.get(i);
                for (int j = 0; j < list.size(); j++) {
                    nums[idx++] = list.get(j);
                }
                list.clear();
            }
        }

        // 找出最大差值
        int maxDiffer = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length-1; i++) {
            maxDiffer = Math.max(maxDiffer, nums[i+1] - nums[i]);
        }
        return maxDiffer;
    }




    public static void main(String[] args) {

        System.out.println(pickIntByBit(123, 0));
        System.out.println(pickIntByBit(123, 1));
        System.out.println(pickIntByBit(123, 2));
        System.out.println(pickIntByBit(123, 3));

        Solution_164 solution164 = new Solution_164();
        System.out.println(solution164.amximumGapByRadixSort(
                new int[]{
                        3,6,9,1
                }
        ));
    }


}
