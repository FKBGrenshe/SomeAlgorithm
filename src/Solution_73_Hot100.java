import java.util.Arrays;
import java.util.function.IntConsumer;

public class Solution_73_Hot100 {
    public void setZeroes(int[][] matrix) {

        int chang = matrix.length;
        int kuan = matrix[0].length;
        int hasZeroFlag = -1;
        int zeroHang = -1;
        int zeroLie = -1;


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                // 找到第一个非零行非零列
                if (matrix[i][j] == 0){
                    zeroHang = i;
                    zeroLie = j;
                    hasZeroFlag = 1;
                    break;
                }
            }
            if (hasZeroFlag != -1){
                break;
            }
        }
        if (hasZeroFlag == -1){
            // 说明没有0元素
            return;
        }

        for (int i = 0; i < matrix.length; i++) {
            if (i == zeroHang){
                continue;
            }
            for (int valueIdx = 0; valueIdx < matrix[i].length; valueIdx++) {
                if (matrix[i][valueIdx] == 0) {
                    matrix[i][zeroLie] = 0;
                }
            }
        }

        for (int i = 0; i < matrix[0].length; i++) {
            if (i == zeroLie){
                continue;
            }
            for (int valueIdx = 0; valueIdx < matrix.length; valueIdx++) {
                if (matrix[valueIdx][i] == 0){
                    matrix[zeroHang][i] = 0;
                }
            }

        }

//        int first = -1;
        for (int i = 0; i < matrix[zeroHang].length; i++) {
            if (i == zeroLie){
                continue;
            }
            if (matrix[zeroHang][i] == 0 ) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][zeroLie] == 0){
                Arrays.fill(matrix[i], 0);
            }
        }

        for (int j = 0; j < matrix.length; j++) {
            matrix[j][zeroLie] = 0;
        }


        System.out.println(matrix);

    }

    public static void main(String[] args) {
        Solution_73_Hot100 solution73Hot100 = new Solution_73_Hot100();
        solution73Hot100.setZeroes(new int[][]{
                {-4,-2147483648,6,-7,0},
                {-8,6,-8,-6,0},
                {2147483647,2,-9,-6,-10}
        });
    }
}
