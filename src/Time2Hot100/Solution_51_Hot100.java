package Time2Hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2026-03-07
 * @Description: N皇后
 */
public class Solution_51_Hot100 {

    List<List<String>> globalResult = new ArrayList<>();
    List<String> curResult = new ArrayList<>();
    StringBuilder stringBuilder = new StringBuilder();

    /* 表示当前棋盘上所有皇后的可攻击位置
    值 =
        0 // 该位置不可被攻击；
        1 // 该位置被一个皇后攻击；
        2 // 该位置被两个皇后攻击，（如果当前位置摆放皇后则不合理）
     */
    int[][] attackBoard;
    // 表示当前所有摆放皇后的位置
    boolean[][] queenBoard;
    int n;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        attackBoard = new int[n][n];
        queenBoard = new boolean[n][n];

        backTracing(0);
        return globalResult;
    }

    private void backTracing(int curRow) {
        if (curRow == n){
            // 到达最底层，成功
            globalResult.add(new ArrayList<>(curResult));
            return;
        }

        // 对当前第curRow行进行列遍历，看看哪一列可以放
        for (int curColumn = 0; curColumn < n; curColumn++) {
            purOrRemoveQueen(curRow, curColumn, true);
            if (!canAttack()){
                // 构造当前string
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < curColumn; i++) {
                    sb.append('.');
                }
                sb.append('Q');
                for (int i = curColumn+1; i < n; i++) {
                    sb.append('.');
                }
                String curString = sb.toString();
                curResult.add(curString);
                // 下一层循环
                backTracing(curRow+1);
                // 回溯
                curResult.remove(curString);
            }
            purOrRemoveQueen(curRow,curColumn,false);
        }

    }


    /**
     *  从棋盘上放置or移走皇后
     * @param curRow
     * @param curColumn
     * @param purOrRemove true代表放置，false代表移走
     */
    private void purOrRemoveQueen(int curRow, int curColumn, boolean purOrRemove) {

        if (purOrRemove){
            // put queen on the board
            queenBoard[curRow][curColumn] = true;
            changeAttackBoard(curRow, curColumn, 1);
        }else {
            // remove queen from the board
            queenBoard[curRow][curColumn] = false;
            changeAttackBoard(curRow,curColumn,-1);
        }

    }

    /**
     * 基于queen的位置，对同一行/一列/斜对角线记录攻击次数
     * @param queenRowIdx
     * @param queenColumnIdx
     * @param changedValue
     */
    private void changeAttackBoard(int queenRowIdx, int queenColumnIdx, int changedValue) {

        // 自己位置
        // attackBoard[queenRowIdx][queenColumnIdx] += changedValue;

        // 同一行
        for (int column = 0; column < n; column++) {
            if (column == queenColumnIdx) continue;
            attackBoard[queenRowIdx][column] += changedValue;
        }
        // 同一列
        for (int row = 0; row < n; row++) {
            if (row == queenRowIdx) continue;
            attackBoard[row][queenColumnIdx] += changedValue;
        }
        // 斜线
        int curRowIdx = queenRowIdx-1;
        int curColumnIdx = queenColumnIdx-1;
        // 左上 -- -1， -1
        while (legalIdx(curRowIdx, curColumnIdx)){
            attackBoard[curRowIdx][curColumnIdx] += changedValue;
            curRowIdx--;curColumnIdx--;
        }

        // 右上 -- -1， +1
        curRowIdx = queenRowIdx-1;
        curColumnIdx = queenColumnIdx+1;
        while (legalIdx(curRowIdx, curColumnIdx)){
            attackBoard[curRowIdx][curColumnIdx] += changedValue;
            curRowIdx--; curColumnIdx++;
        }
        // 左下 -- +1， -1
        curRowIdx = queenRowIdx+1;
        curColumnIdx = queenColumnIdx-1;
        while (legalIdx(curRowIdx, curColumnIdx)){
            attackBoard[curRowIdx][curColumnIdx] += changedValue;
            curRowIdx++; curColumnIdx--;
        }
        // 右下 -- +1， +1
        curRowIdx = queenRowIdx+1;
        curColumnIdx = queenColumnIdx+1;
        while (legalIdx(curRowIdx, curColumnIdx)){
            attackBoard[curRowIdx][curColumnIdx] += changedValue;
            curRowIdx++; curColumnIdx++;
        }
    }

    private boolean legalIdx(int curRowIdx, int curColumnIdx) {
        return curRowIdx >= 0 && curRowIdx < n && curColumnIdx >= 0 && curColumnIdx < n;
    }


    /**
     * 判断当前摆放位置，皇后是否被攻击
     * @return true：被攻击，摆放不合理
     */
    boolean canAttack(){
        for (int row = 0; row < queenBoard.length; row++) {
            for (int column = 0; column < queenBoard[0].length; column++) {
                if (queenBoard[row][column]){
                    if (attackBoard[row][column] >= 1){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution_51_Hot100 solution51Hot100 = new Solution_51_Hot100();


        List<List<String>> lists = solution51Hot100.solveNQueens(4);
        lists.forEach(s -> s.forEach(System.out::println));

    }

}
