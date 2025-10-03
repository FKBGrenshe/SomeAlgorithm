import java.util.Arrays;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-04-21
 * @Description:
 */
public class Solution_274 {
    public int hIndex(int[] citations) {

        Arrays.sort(citations);

        int h = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            int temp = citations.length - i;
            if (temp <= citations[i]){
                h = temp;
            }
        }

        return h;

        // 0, 1, 3, 5, 6
        // 5  4  3  2  1

    }

    public static void main(String[] args) {
        Solution_274 solution274 = new Solution_274();
        System.out.println(solution274.hIndex(new int[]{
                1,3,1
        }));
    }
}
