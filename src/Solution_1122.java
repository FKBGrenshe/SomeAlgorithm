import java.util.Arrays;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-09-08
 * @Description: 数组的相对排序
 */
public class Solution_1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2){

        int[] arr1Count = new int[1001];
        int[] answer = new int[arr1.length];
        int answerIdx = 0;

        for (int i = 0; i < arr1.length; i++) {
            arr1Count[arr1[i]]++;
        }

        for (int i = 0; i < arr2.length; i++) {
            int tempVal = arr2[i];
            int times = arr1Count[tempVal];
            for (int time = 0; time < times; time++) {
                answer[answerIdx++] = tempVal;
            }
            arr1Count[tempVal] = 0;
        }


        // 将剩余追加到数组上
        int times;
        for (int i = 0; i < arr1Count.length; i++) {
            if ((times = arr1Count[i]) != 0){
                for (int time = 0; time < times; time++) {
                    answer[answerIdx++] = i;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution_1122 solution1122 = new Solution_1122();
        int[] answer = solution1122.relativeSortArray(
                new int[]{1, 2, 3, 4, 4, 5, 6},
                new int[]{2, 1, 3}
        );
        System.out.println(Arrays.toString(answer));
    }
}
