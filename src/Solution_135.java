/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-04-27
 * @Description: 分发糖果
 *//*

public class Solution_135 {

    int candys = 0;

    public int candy(int[] ratings) {

        int[] candyNumber = new int[ratings.length];

        if (ratings.length == 0){
            return candys;
        }

        int minValue = Integer.MAX_VALUE;
        int minIdx = -1;
        for (int i = 0; i < ratings.length; i++) {
            if (minValue > ratings[i]){
                minValue = ratings[i];
                minIdx = i;
            }
        }
        // 最小处，candy=1
        candys++;
        candyNumber[minIdx] = 1;
        // 从最小处，向左，向右
        int right = minIdx == 0 ? -1 : minIdx-1;
        int left = minIdx == ratings.length-1 ? -1 : minIdx+1;



        while (right >= 0){
            // 只要小于等于
            candyNumber[right] = ratings[right] <= ratings[right+1] ? 1 : candyNumber[right+1]+1;

            right++;
        }

        while (left < ratings.length){

            left--;
        }

    }

    public static void main(String[] args) {
        Solution_135 solution135 = new Solution_135();
        System.out.println(solution135.candy(
                new int[]{

                }
        ));
    }
}
*/
