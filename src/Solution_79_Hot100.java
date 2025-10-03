/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-03-24
 * @Description: 79单词搜索
 */
public class Solution_79_Hot100 {

    boolean findFlag = false;
    int[][] fourDirection = new int[][]{
            {0,1},
            {0,-1},
            {1,0},
            {-1,0}
    };

    public boolean exist(char[][] board, String word) {

        boolean[][] dp = new boolean[board.length][board[0].length];

        // findHeadChar
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (findFlag){
                    break;
                }
                if (board[i][j] == word.charAt(0)) {
                    // 只有当前字母是word的开头，才开始寻找
                    dp[i][j] = true;
                    findWord(board, word, i, j, 1, dp);
                    // 后置操作
                    dp[i][j] = false;
                }
            }
        }
    return findFlag;
    }

    public void findWord(char[][] board, String word, int x, int y, int index, boolean[][] dp) {
        if (findFlag){
            return;
        }
        if (index == word.length()) {
            findFlag = true;
            return;
        }

        for (int[] dir : fourDirection) {
            int tempX = x + dir[0];
            int tempY = y + dir[1];
            if (tempX >= 0 && tempX < board.length
                    && tempY >= 0 && tempY < board[0].length
                    && !dp[tempX][tempY] && board[tempX][tempY] == word.charAt(index)){
                dp[tempX][tempY] = true;
                findWord(board, word, tempX, tempY, index + 1, dp);
                // 后置操作
                dp[tempX][tempY] = false;
            }
        }


    }

    public static void main(String[] args) {
        Solution_79_Hot100 solution79Hot100 = new Solution_79_Hot100();
        boolean res = solution79Hot100.exist(
                new char[][]{
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}
                },
                "ABCCED"
        );
        System.out.println(res);
    }
}
