package Time3Hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_51_Hot100 {

    int[][] cannotMap;
    char[][] boardMap;
    List<List<String>> globalans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        boardMap = new char[n][n];
        cannotMap = new int[n][n];
        reInit();
        backTracing(0,n);
        return globalans;
    }

    private void backTracing(int i, int n) {
        if (i == n){
            addToGlobalans();
            return;
        }
        boolean curLevelHave = false;
        for (int j = 0; j < n; j++) {
            if (canSetQueen(i,j)){
                boardMap[i][j] = 'Q';
                setQueenAttack(i,j, true);
                backTracing(i+1,n);
                setQueenAttack(i,j,false);
                boardMap[i][j] = '.';
            }
        }

    }

    private void addToGlobalans() {
        List<String> curAns = new ArrayList<>();
        StringBuilder curLevel = new StringBuilder();
        for (int i = 0; i < boardMap.length; i++) {
            curLevel.delete(0, curLevel.length());

            for (int j = 0; j < boardMap[i].length; j++) {
                curLevel.append(boardMap[i][j]);
            }

            curAns.add(curLevel.toString());
        }
        globalans.add(curAns);
    }

    private void reInit() {
        for (int i = 0; i < boardMap.length; i++) {
            Arrays.fill(boardMap[i], '.');
        }

        for (int i = 0; i < cannotMap.length; i++) {
            Arrays.fill(cannotMap[i],0);
        }
    }

    void setQueenAttack(int i, int j, boolean flag){
        dochange(i,j,flag);
        int newVal = cannotMap[i][j];
        int n = boardMap.length;
        // 行，
        for (int x = 0; x < n; x++) {
            if (x == j){
                continue;
            }
            dochange(i,x,flag);
//            cannotMap[i][x] = flag? cannotMap[i][x]++:cannotMap[i][x]--;
        }
        // 列，
        for (int x = 0; x < n; x++) {
            if (x == i){
                continue;
            }
            dochange(x,j,flag);
//            cannotMap[x][j] = flag?cannotMap[x][j]++:cannotMap[x][j]--;
        }
        // 对角线
        // left - up
        int xi = i;
        int xj = j;
        while (--xi >= 0 && --xj >= 0){
            if (xi == i && xj == j){
                continue;
            }
            dochange(xi,xj,flag);
//            cannotMap[xi][xj] = flag?cannotMap[xi][xj]++:cannotMap[xi][xj]--;
        }
        // left - down
        xi = i;
        xj = j;
        while (++xi < n && --xj >= 0){
            if (xi == i && xj == j){
                continue;
            }
            dochange(xi,xj,flag);
//            cannotMap[xi][xj] = flag?cannotMap[xi][xj]++:cannotMap[xi][xj]--;
        }
        // right - down
        xi = i;
        xj = j;
        while (++xi < n && ++xj < n){
            if (xi == i && xj == j){
                continue;
            }
            dochange(xi,xj,flag);
//            cannotMap[xi][xj] = flag?cannotMap[xi][xj]++:cannotMap[xi][xj]--;
        }
        // right - up
        xi = i;
        xj = j;
        while (--xi >= 0 && ++xj < n ){
            if (xi == i && xj == j){
                continue;
            }
            dochange(xi,xj,flag);
//            cannotMap[xi][xj] = flag?cannotMap[xi][xj]++:cannotMap[xi][xj]--;
        }
    }

    private void dochange(int xi, int xj, boolean flag) {
        if (flag) {
            cannotMap[xi][xj]++;
        }else {
            cannotMap[xi][xj]--;
        }
    }

    boolean canSetQueen(int i, int j){
        return cannotMap[i][j] == 0;
    }

    public static void main(String[] args) {
        Solution_51_Hot100 solution51Hot100 = new Solution_51_Hot100();
//        solution51Hot100.cannotMap = new boolean[4][4];
//        solution51Hot100.boardMap = new char[4][4];
//        solution51Hot100.setQueenAttack(1,1, true);
//        System.out.println(solution51Hot100.cannotMap.length);

        List<List<String>> lists = solution51Hot100.solveNQueens(4);
        for (List<String> list : lists) {
            list.forEach(k -> System.out.println(k));
        }
    }

}
