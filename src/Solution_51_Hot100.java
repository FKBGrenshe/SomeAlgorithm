import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-03-25
 * @Description: 51N皇后
 */
public class Solution_51_Hot100 {

    List<List<String>> res = new ArrayList<>();
    ArrayList<String> curRes = new ArrayList<>();

    List<Integer[]> ans = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        // 初始化
        char[][] chessBoard = new char[n][n];
        for (char[] chars : chessBoard) {
            Arrays.fill(chars, '.');
        }

        findQueens(chessBoard, 0);

        /*List<Integer> xPath = new ArrayList<>();
        List<Integer> yPath = new ArrayList<>();
        findAllAns(0,0,xPath, yPath,n);

        for (Integer[] answer : ans) {

            for (int i = 0; i < answer.length; i++) {
                int j = answer[i];
                String string = buildAns(i, j, n);
                curRes.add(string);
            }
            res.add(new ArrayList<>(curRes));
            curRes.clear();
        }*/

        return res;
    }

    private void findQueens(char[][] chessBoard, int i) {
        // 表示当前第i行需要插入皇后
        if (i == chessBoard.length){
            // 插完了,加到res里面，return
            res.add(chessBoard2List(chessBoard));
            return;
        }

        for (int j = 0; j < chessBoard[0].length; j++) {
            // 判断当前位置是否有效
            if (isValid(chessBoard,i,j)){
                chessBoard[i][j] = 'Q';
                findQueens(chessBoard,i+1);
                // 回溯
                chessBoard[i][j] = '.';
            }
        }

    }

    private boolean isValid(char[][] chessBoard, int i, int j) {
        // 检查行列
        for (int x = 0; x < chessBoard[i].length; x++) {
            if(chessBoard[x][j] == 'Q' || chessBoard[i][x] == 'Q'){
                return false;
            }
        }
        //检查斜对角线
        for (int x = i-1, y = j-1; x >= 0 && y >= 0; x--,y--){
            if (chessBoard[x][y] == 'Q'){
                return false;
            }
        }
        for (int x = i-1, y = j+1; x >= 0 && y < chessBoard[i].length; x--,y++){
            if (chessBoard[x][y] == 'Q'){
                return false;
            }
        }
        return true;
    }

    public List chessBoard2List(char[][] chessBoard){
        List<String> list = new ArrayList<>();
        for (char[] chars : chessBoard){
            list.add(String.copyValueOf(chars));
        }
        return list;
    }



    public void findAllAns(int x, int y, List<Integer> xPath, List<Integer> yPath, int n){
        if (xPath.size() == n){

            // 下标为x(行坐标)，值为y（列坐标）
            Integer[] path = new Integer[n];
            for (int i = 0; i < xPath.size(); i++) {
                int tempX = xPath.get(i);
                int tempY = yPath.get(i);
                path[tempX] = tempY;
            }

            for (Integer[] others : ans) {
                // 说明是重复的
                if (Arrays.equals(others,path)){
                    return;
                }
            }
            ans.add(path);
            return;
        }

        // 递归 -- 找不冲突的皇后位置
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean canFlag = true;
                for (int tempIdx = 0; tempIdx < xPath.size(); tempIdx++) {
                    int QuennX = xPath.get(tempIdx);
                    int QuennY = yPath.get(tempIdx);
                    if(!own(QuennX,QuennY,i,j)){
                        canFlag = false;
                        break;
                    }
                }
                if (canFlag){
                    // 说明当前位置可以
                    xPath.add(i);
                    yPath.add(j);
                    findAllAns(i,j,xPath,yPath,n);
                }else {
                    continue;
                }

                // 回溯
                xPath.remove(xPath.size()-1);
                yPath.remove(yPath.size()-1);
            }
        }
        // 说明没有找到到答案
        int a = 2;
    }

    private boolean own(int QueenX, int QueenY, int i , int j) {
        // 同一行或者同一列
        if (i == QueenX || j == QueenY){
            return false;
        }
        // 斜对角线
        if (Math.abs(QueenX - i) == Math.abs(QueenY - j)){
            return false;
        }
        return true;
    }

    public String buildAns(int i ,int j, int n){
        StringBuilder stringBuilder = new StringBuilder();
        for (int count = 0; count < j; count++) {
            stringBuilder.append(".");
        }
        stringBuilder.append("Q");
        for (int count = j+1; count < n; count++) {
            stringBuilder.append(".");
        }

        return stringBuilder.toString();
    }



    public static void main(String[] args) {
        List<List<String>> lists = new Solution_51_Hot100().solveNQueens(4);
        for (List<String> list : lists) {
            for (String s : list) {}
        }
    }
}
