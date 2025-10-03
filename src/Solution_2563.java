import java.util.Arrays;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-05-14
 * @Description: 统计公平数对的数目
 * <p>
 * arr[i] + arr[j] <= upper -> arr[j] <= upper - arr[i]
 * lower <= arr[i] + arr[j] -> arr[j] >= lower - arr[i]
 */
public class Solution_2563 {

    int[] arr;

    public long countFairPairs(int[] nums, int lower, int upper) {
        long count = 0;
        arr = nums;
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            int targetMin = lower - arr[i];
            int targetMax = upper - arr[i];

            if (targetMax <= arr[0] || targetMin >= arr[arr.length - 1]) {

            } else {
                // arr[left] >= lower - arr[i]
                int left = biSearch(targetMin);
                if (left == -1){
                    continue;
                }
                // arr[right] <= upper - arr[i]
                int right = biSearch(targetMax-1);
                if (right == -1){
                    count += arr.length - left;
                }else {
                    count += right - left + 1;
                }
            }

        }

        return count;
    }

    //    t
    // 0, 2, 2, 3, 4
    // r  m
    //    l

    private int biSearch(int targetVal) {

        if (targetVal > arr[arr.length-1]){
            return -1;
        }
        // 找 >= targetVal 的 第一个位置
        int left = 0;
        int right = arr.length-1;
        while (left <= right){
            int mid = (left+right)/2;
            int midVal = arr[mid];

            if (midVal < targetVal){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Solution_2563 solution2563 = new Solution_2563();

        int[] nums = {
                0, 1, 7, 4, 4, 5
        };
        int lower = 3;
        int upper = 6;

        System.out.println(solution2563.countFairPairs(
                nums, lower, upper
        ));
    }

}
