import java.util.Arrays;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-09-11
 * @Description: 被围绕的区域
 */
public class Solution_136 {

    /*char[][] charTable = null;
    // 'o'区域是否逃出去了
    boolean runSuccess = false;

    public void solve(char[][] board) {
        this.charTable = board;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O'){
                    runSuccess = false;
                    run(i,j);
                }
            }
        }

        // 再次遍历，做处理
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'F'){
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'S'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    void run(int i, int j){

        if (i == this.charTable.length-1
                || j == 0
                || i == 0
                || j == this.charTable[0].length-1){
            runSuccess = true;
            this.charTable[i][j] = 'S';
            return;
        }

        // 向右向下找其他相邻的‘o’区域
        if (this.charTable[i][j+1] == 'O') {
            run(i,j+1);
        }
        if (this.charTable[i+1][j] == 'O') {
            run(i+1,j);
        }

        // 对自己做处理
        if (runSuccess){
            this.charTable[i][j] = 'S';
        }else {
            this.charTable[i][j] = 'F';
        }
    }*/

    char[][] charTable;

    public void solve(char[][] board){
        this.charTable = board;

        // [0][0]                              [0][board[0].length-1]

        // [board.length-1][0]       [board.length-1][board[0].length-1]


        //上下边界
        for (int i = 0; i < board[0].length; i++) {
//            System.out.printf("[%d],[%d]",0,i);
            if (board[0][i] == 'O'){
                find(0,i);
            }
//            System.out.printf("[%d],[%d]",board.length-1,i);
            if (board[board.length-1][i] == 'O'){
                find(board.length-1,i);
            }
        }
        //左右边界
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O'){
                find(i,0);
            }
            if (board[i][board[0].length-1] == 'O'){
                find(i,board[0].length-1);
            }
        }

        // 再次遍历，做处理
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'S'){
                    board[i][j] = 'O';
                }
            }
        }

    }

    void find(int i, int j){

        if (i<0 || i>=charTable.length || j<0 || j>=charTable[0].length){
            return;//非法索引
        }
        if (charTable[i][j] == 'O'){
            charTable[i][j] = 'S';
        }else {
            return;
        }
        // 向四个方向四散
        find(i-1,j);
        find(i+1,j);
        find(i,j-1);
        find(i,j+1);

    }


    public static void main(String[] args) {
        Solution_136 solution136 = new Solution_136();
        /*char[][] board = new char[][]{
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}
        };*/
        /*char[][] board = new char[][]{
                {'X'}
        };*/
        /*char[][] board = new char[][]{
                {'X','O','X'},
                {'O','X','O'},
                {'X','O','X'}
        };*/
        char[][] board = new char[][]{
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','O','X','X'}
        };
        solution136.solve(board);


        for (char[] row : board) {
            System.out.println(Arrays.toString(row));
        }

    }

}
