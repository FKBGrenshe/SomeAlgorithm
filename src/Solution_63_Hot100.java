//public class Solution_63_Hot100 {
//    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//        int gao = obstacleGrid.length;
//        int chang = obstacleGrid[0].length;
//
//        // dp定义
//        int[][] dpTable = new int[obstacleGrid.length][obstacleGrid[0].length];
//        // 初始化
//        dpTable[1][0] = obstacleGrid[1][0] == 1 ? 0 : 1;
//        dpTable[0][1] = obstacleGrid[0][1] == 1 ? 0 : 1;
//        // 状态转换
//        // 初始遍历方向
//        int initLoopVector = Math.min(gao, chang);
//        for (int i = 1; i < initLoopVector; i++) {
//            /*if (initLoopVector == gao){
//                // 高更短，每一次从上往下遍历，再i++向左移动
//                for (int j = 0; j <; j++) {
//
//                }
//            }*/
//        }
//
//
//    }
//
//    public static void main(String[] args) {
//        Solution_63_Hot100 solution63Hot100 = new Solution_63_Hot100();
//        solution63Hot100.uniquePathsWithObstacles(new int[][]{
//                {0,0,0},
//                {0,1,0},
//                {0,0,0}
//        });
//    }
//}
