import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-03-22
 * @Description: 904腐烂的橘子
 */
public class Solution_994_Hot100 {

    int[][] fourDirection = new int[][]{
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
    };

    int count = 0;

    public int orangesRotting(int[][] grid) {
        /**
         * 值 0 代表空单元格；
         * 值 1 代表新鲜橘子；
         * 值 2 代表腐烂的橘子。
         */

        Deque<int[]> deque = new ArrayDeque<>();

        // 查看第0轮的腐烂橘子数量
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2){
                    deque.addLast(new int[]{i, j, 0});
                }
            }
        }
        if (deque.isEmpty()){
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1){
                        return -1;
                    }
                }
            }
            return 0;
        }
        if (deque.size() == grid.length * grid[0].length){
            return 0;
        }


        // 腐烂次数
        int maxNumber = 0;

        while (!deque.isEmpty()){
            // 当前腐烂的橘子的坐标\第几轮
            int[] curIdx = deque.pollFirst();

            for (int[] neighbor : fourDirection) {

                int tempX = curIdx[0]+neighbor[0];
                int tempY = curIdx[1]+neighbor[1];

                // 判断是否越界
                if (tempX >= 0 && tempX < grid.length && tempY >= 0 && tempY < grid[0].length){
                    if(grid[tempX][tempY] == 1){
                        if (maxNumber < curIdx[2]+1){
                            maxNumber = curIdx[2]+1;
                        }
                        // 新鲜橘子腐烂
                        grid[tempX][tempY] = 2;
                        deque.addLast(new int[]{tempX, tempY, curIdx[2]+1});
                    }
                }
            }
        }


        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1){
                    return -1;
                }
            }
        }

        return maxNumber;

    }




    public static void main(String[] args) {
        /**
         * [[1],[2]]
         */
        Solution_994_Hot100 solution994Hot100 = new Solution_994_Hot100();
        /*solution994Hot100.orangesRotting(new int[][]{
                {2,1,1},
                {1,1,0},
                {0,1,1}
        });*/
        solution994Hot100.orangesRotting(new int[][]{
                {1},
                {2}
        });
    }
}
