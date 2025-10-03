import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-03-21
 * @Description: 200岛屿数量
 */
public class Solution_200_Hot100 {

    List<Integer> curPath = new ArrayList<>();

    int[][] fourDirection = new int[][]{
            // 右、左、下、上
            {0,1},
            {0,-1},
            {1,0},
            {-1,0}
    };

    // 岛屿数量
    int count = 0;

    public int numIslands(char[][] grid) {

        // 初始化记录矩阵dp
        boolean[][] dp = new boolean[grid.length][grid[0].length];

        // 遍历矩阵, 只要找到没有标记的为陆地1的节点，就是新岛屿，使用findAllIlandsNode方法进行标记当前新岛屿
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (dp[i][j] ==false && grid[i][j] == '1'){
                    count++;
                    dp[i][j] = true;
                    findAllIlandsNode(grid, i, j, dp);
                }
            }
        }
        return count;
    }

    public void findAllIlandsNode(char[][] grid, int x, int y, boolean[][] dp){

        // 终止条件
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length){
            // 当前位置越界，则返回
            return;
        }

        // 正常深度优先遍历 -- 遍历该节点的上下左右
        // 如果x和y的对应节点是陆地 & [x][y]没有标记过，则标记为已访问，并继续遍历
        for (int[] liejuNode : fourDirection) {
            int tempX = x + liejuNode[0];
            int tempY = y + liejuNode[1];
            if (tempX >= 0 && tempY >= 0 && tempX < grid.length && tempY < grid[0].length && grid[tempX][tempY] == '1' && dp[tempX][tempY] == false ){
                dp[tempX][tempY] = true;
                findAllIlandsNode(grid, tempX, tempY, dp);
                System.out.println(tempX + " " + tempY);
            }
        }
    }

    public static void main(String[] args) {
        Solution_200_Hot100 solution200Hot100 = new Solution_200_Hot100();
        /*int countIslands = solution200Hot100.numIslands(new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}

        });*/

        /**
         * grid = [
         *   ["1","1","0","0","0"],
         *   ["1","1","0","0","0"],
         *   ["0","0","1","0","0"],
         *   ["0","0","0","1","1"]
         * ]
         */

        int countIslands1 = solution200Hot100.numIslands(new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        });

        System.out.println();
    }

}
