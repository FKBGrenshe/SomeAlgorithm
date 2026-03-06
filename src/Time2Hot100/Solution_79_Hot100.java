package Time2Hot100;

import java.util.Arrays;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2026-03-06
 * @Description: 单词搜索
 */
public class Solution_79_Hot100 {

    /* board[Row][Column] */

    char[][] globalBoard;
    boolean[][] usedBoard;
    String globalWord;
    boolean result = false;

//    int[][] curNeighbourResult = new int[4][2];
//    int curRow, curColumn;

    public boolean exist(char[][] board, String word) {
        globalBoard = board;
        usedBoard = new boolean[board.length][board[0].length];
        globalWord = word;

        for (int row = 0; row < globalBoard.length; row++) {
            for (int column = 0; column < globalBoard[0].length; column++) {
                if (result) return result;
                if (globalBoard[row][column] == word.charAt(0)) {
                    usedBoard[row][column] = true;
                    backTracing(1,row,column);
                    usedBoard[row][column] = false;
                }
            }
        }
        return result;
    }

    private void backTracing(int curIdx, int fatherWordRow, int fatherWordColumn) {
        if (curIdx == globalWord.length()){
            result = true;
            return;
        }

        int[][] curNeighbourResult = findNeighbourExit(globalWord.charAt(curIdx), fatherWordRow, fatherWordColumn);
        for (int i = 0; i < curNeighbourResult.length; i++) {
            int curRow = curNeighbourResult[i][0];
            if (curRow == -1) continue;
            int curColumn = curNeighbourResult[i][1];

            usedBoard[curRow][curColumn] = true;
            backTracing(curIdx+1, curRow,curColumn);
            usedBoard[curRow][curColumn] = false;

            // 减枝
            if (result) return;
        }
    }

    private int[][] findNeighbourExit(char c, int fatherWordRow, int fatherWordColumn) {
        int[][] curNeighbourResult = new int[4][2];
        Arrays.fill(curNeighbourResult[0],-1);
        Arrays.fill(curNeighbourResult[1],-1);
        Arrays.fill(curNeighbourResult[2],-1);
        Arrays.fill(curNeighbourResult[3],-1);
        boolean isFind = false;
        // 上 - fatherWordRow - 1
        if (fatherWordRow >= 1){
            if (!usedBoard[fatherWordRow - 1][fatherWordColumn]
                && globalBoard[fatherWordRow - 1][fatherWordColumn] == c
            ){
                curNeighbourResult[0][0] = fatherWordRow - 1;
                curNeighbourResult[0][1] = fatherWordColumn;
                isFind = true;
            }
        }
        // 下 - fatherWordRow + 1
        if (fatherWordRow+1 < globalBoard.length){
            if (!usedBoard[fatherWordRow + 1][fatherWordColumn]
                    && globalBoard[fatherWordRow + 1][fatherWordColumn] == c
            ){
                curNeighbourResult[1][0] = fatherWordRow + 1;
                curNeighbourResult[1][1] = fatherWordColumn;
                isFind = true;
            }
        }
        // 左 - fatherWordColumn - 1
        if (fatherWordColumn >= 1){
            if (!usedBoard[fatherWordRow][fatherWordColumn - 1]
                    && globalBoard[fatherWordRow][fatherWordColumn - 1] == c
            ){
                curNeighbourResult[2][0] = fatherWordRow;
                curNeighbourResult[2][1] = fatherWordColumn - 1;
                isFind = true;
            }
        }
        // 右 - fatherWordColumn + 1
        if (fatherWordColumn + 1< globalBoard[0].length){
            if (!usedBoard[fatherWordRow][fatherWordColumn + 1]
                    && globalBoard[fatherWordRow][fatherWordColumn + 1] == c
            ){
                curNeighbourResult[3][0] = fatherWordRow;
                curNeighbourResult[3][1] = fatherWordColumn + 1;
                isFind = true;
            }
        }
        return curNeighbourResult;
    }

    public static void main(String[] args) {
        Solution_79_Hot100 solution79Hot100 = new Solution_79_Hot100();

        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };

//        String word = "SEE";
        String word = "ABCCEDF";

        boolean exist = solution79Hot100.exist(
                board,
                word
        );
        System.out.println(exist);
    }


}
