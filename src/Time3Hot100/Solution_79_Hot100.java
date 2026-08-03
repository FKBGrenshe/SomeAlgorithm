package Time3Hot100;

public class Solution_79_Hot100 {

    int[][] neighbour = new int[][]{
        new int[]{0,1},
        new int[]{0,-1},
        new int[]{1,0},
        new int[]{-1,0}
    };

    char[][] board;
    boolean[][] pathboard;

    StringBuilder curPath = new StringBuilder();


    public boolean exist(char[][] board, String word) {
        this.pathboard = new boolean[board.length][board[0].length];
        this.board = board;
        boolean findFlag = false;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (this.board[i][j] == word.charAt(0)){
                    curPath.append(word.charAt(0));
                    pathboard[i][j] = true;
                    findFlag = findFlag || backTracing(curPath, word, i,j, -1,-1);
                    pathboard[i][j] = false;
                    curPath.deleteCharAt(curPath.length()-1);
                }
            }
        }
        return findFlag;
    }

    public boolean backTracing(StringBuilder curPath, String word, int i, int j, int previ, int prevj){
        if (curPath.length() == word.length()){
            return true;
        }

        boolean findFlag = false;
        // 当前位置 [i,j]
        // 下一个字母
        char nextChar = word.charAt(curPath.length());
        // 下一个位置 [nextI, nextJ]
        for (int[] delta : neighbour) {
            int nextI, nextJ = 0;
            nextI = i + delta[0];
            nextJ = j + delta[1];

            if (legalIdxI(nextI) && legalIdxJ(nextJ) && (previ != nextI || prevj != nextJ)){
                if (nextChar == board[nextI][nextJ]){
                    if (!pathboard[nextI][nextJ]){
                        curPath.append(nextChar);
                        pathboard[nextI][nextJ] = true;
                        findFlag = findFlag || backTracing(curPath,word,nextI,nextJ,i,j);
                        pathboard[nextI][nextJ] = false;
                        curPath.deleteCharAt(curPath.length()-1);
                    }
                }
            }
        }
        return findFlag;
    }

    private boolean legalIdxI(int nextI) {
        return nextI >= 0 && nextI < board.length;
    }

    private boolean legalIdxJ(int nextJ) {
        return nextJ >= 0 && nextJ < board[0].length;
    }

    public static void main(String[] args) {
        Solution_79_Hot100 solution79Hot100 = new Solution_79_Hot100();
        System.out.println(solution79Hot100.exist(
                new char[][]{
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'},
                },
//                "ABCCED"
//                "AF"
                "SEE"
        ));
    }
}
