/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-03-19
 * @Description: 48.旋转图像
 */
public class Solution_48_Hot100 {
    public void rotate(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        // 第i行第j列元素( [i][j] ) -- 旋转90度后 -- 倒数第i列第j行元素 （[j][n-1-i]）
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                dp[j][matrix[0].length - 1 - i] = matrix[i][j];
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = dp[i][j];
            }
        }

        System.out.println(matrix);

    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        Solution_48_Hot100 solution48 = new Solution_48_Hot100();
        solution48.rotate(matrix);
    }

}
