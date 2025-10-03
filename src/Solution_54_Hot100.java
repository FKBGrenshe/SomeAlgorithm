import java.util.ArrayList;
import java.util.List;

public class Solution_54_Hot100 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int count = 0;
        int totalCount = matrix.length * matrix[0].length;
        List<Integer> result = new ArrayList<>(totalCount);
        // 优先顺序：右->下->左->上
        /**            [i-1][j]
         * [i][j-1] <- [i][j] -> [i][j+1]
         *             [i+1][j]
         */
        int i = 0, j = 0;
        result.add(matrix[i][j]);
        matrix[i][j] = Integer.MIN_VALUE;
        while (count != totalCount){

            // 右
            if (j+1 < matrix[0].length && matrix[i][j+1] != Integer.MIN_VALUE){
                // 将所有右边的全部依次填充
                for (int k = j+1; k < matrix[0].length; k++) {
                    if (matrix[i][k] != Integer.MIN_VALUE){
                        result.add(matrix[i][k]);
                        matrix[i][k] = Integer.MIN_VALUE;
                        j = k;
                    }else {
                        j = k-1;
                        break;
                    }
                }
            }
            // 下
            else if (i+1 < matrix.length && matrix[i+1][j] != Integer.MIN_VALUE) {
                // 将所有下边的全部依次填充
                for (int k = i+1; k < matrix.length; k++) {
                    if (matrix[k][j] != Integer.MIN_VALUE){
                        result.add(matrix[k][j]);
                        matrix[k][j] = Integer.MIN_VALUE;
                        i = k;
                    }else {
                        i = k-1;
                        break;
                    }
                }
            }
            // 左
            else if (j - 1 >= 0 && matrix[i][j - 1] != Integer.MIN_VALUE) {
                // 将所有左边的全部依次填充
                for (int k = j-1; k >= 0; k--) {
                    if (matrix[i][k] != Integer.MIN_VALUE){
                        result.add(matrix[i][k]);
                        matrix[i][k] = Integer.MIN_VALUE;
                        j = k;
                    }else {
                        j = k+1;
                        break;
                    }
                }
            }
            // 上
            else if (i - 1 >= 0 && matrix[i - 1][j] != Integer.MIN_VALUE) {
                // 将所有上边的全部依次填充
                for (int k = i-1; k >= 0; k--) {
                    if (matrix[k][j] != Integer.MIN_VALUE){
                        result.add(matrix[k][j]);
                        matrix[k][j] = Integer.MIN_VALUE;
                        i = k;
                    }else {
                        i = k+1;
                        break;
                    }
                }
            }else {
                return result;
            }
            count ++;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution_54_Hot100 solution54Hot100 = new Solution_54_Hot100();
        int[][] matrix = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        // [[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16],[17,18,19,20],[21,22,23,24]]
        matrix = new int[][]{
                {1,    2,  3,  4},
                {5,    6,  7,  8},
                {9,    10, 11, 12},
                {13,   14, 15, 16},
                {17,   18, 19, 20},
                {21,   22, 23, 24}
        };

        List<Integer> list = solution54Hot100.spiralOrder(matrix);
        System.out.println(list);


    }


}
