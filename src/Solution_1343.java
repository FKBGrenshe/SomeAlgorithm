/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-04-28
 * @Description: 大小为k且平均值大于等于阈值的子数组数目
 */
public class Solution_1343 {

    public int numOfSubarraysV1(int[] arr, int k, int threshold) {
        int count = 0;

        double avg = 0;
        for (int i = 0; i < k; i++) {
            avg += arr[i];
        }
        avg /= k;

        if (avg >= threshold){
            count++;
        }

        for (int i = k; i < arr.length; i++) {
            avg += (double)arr[i]/k;
            avg -= (double)arr[i-k]/k;

            if (avg >= threshold){
                count++;
            }
        }




        return count;
    }



    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0;
        threshold = threshold*k;
        int avg = 0;
        for (int i = 0; i < k; i++) {
            avg += arr[i];
        }

        if (avg >= threshold){
            count++;
        }

        for (int i = k; i < arr.length; i++) {
            avg += arr[i];
            avg -= arr[i-k];

            if (avg >= threshold){
                count++;
            }
        }

        return count;
    }


    public static void main(String[] args) {
        Solution_1343 solution1343 = new Solution_1343();

        int k = 3;
        int threshold = 5;

        System.out.println(solution1343.numOfSubarrays(
                new int[]{
                        11,13,17,23,29,31,7,5,2,3
                },
                k,
                threshold
        ));
    }

}
