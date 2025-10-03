/**
 * 给你一个满足下述两条属性的 m x n 整数矩阵：
 *
 * 每行中的整数从左到右按非严格递增顺序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false
 */
public class Solution_74_Hot100 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix[0][0] > target || matrix[matrix.length-1][matrix[0].length-1] < target){
            return false;
        }
        // m行 n列
        // 先确定在哪行
        int lineIdx = 0;
        for (lineIdx = 0; lineIdx < matrix.length; lineIdx++) {
            if (matrix[lineIdx][0] == target){
                return true;
            }
            if (matrix[lineIdx][0] > target){
                // 再确定在哪列
                return findColumn(matrix[lineIdx-1], target) != -1;
            }
        }
        // 再确定在哪列
        return findColumn(matrix[lineIdx-1], target) != -1;

    }


    public int findColumn(int[] numbers, int target){

        int leftIdx = 0;
        int rightIdx = numbers.length-1;
        int medianIdx = (leftIdx + rightIdx)/2;
        while (leftIdx <= rightIdx){
            if (numbers[medianIdx] == target){
                return medianIdx;
            }
            if (numbers[medianIdx] > target){
                rightIdx = medianIdx - 1;
            }else {
                leftIdx = medianIdx + 1;
            }
            medianIdx = (leftIdx + rightIdx)/2;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution_74_Hot100 solution74Hot100 = new Solution_74_Hot100();
        /*System.out.println(solution74Hot100.searchMatrix(new int[][]{
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}
        }, 13));*/
        System.out.println(solution74Hot100.searchMatrix(new int[][]{
                {1,3}
        }, 3));
    }
}
