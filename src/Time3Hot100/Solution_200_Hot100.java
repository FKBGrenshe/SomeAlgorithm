package Time3Hot100;

public class Solution_200_Hot100 {

    boolean[][] scanmap;
    int curNums = 0;

    int[][] neighbors = new int[][]{
            {0,1},
            {0,-1},
            {1,0},
            {-1,0}
    };

    public int numIslands(char[][] grid) {
        scanmap = new boolean[grid.length][grid[0].length];

        // find first island
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !scanmap[i][j]){
                    curNums++;
                    scanisland(i,j, grid);
                }
            }
        }
        return curNums;
    }

    private void scanisland(int i, int j, char[][] grid) {
        if (grid[i][j] == '0'){
            return;
        }
        if (scanmap[i][j]){
            return;
        }
        scanmap[i][j] = true;
        for (int[] delta : neighbors) {
            int nextI = i + delta[0];
            int nextJ = j + delta[1];
            if (legalI(nextI) && legalJ(nextJ)){
                scanisland(nextI,nextJ, grid);
            }
        }
    }

    private boolean legalI(int nextI) {
        return nextI >= 0 && nextI < scanmap.length;
    }
    private boolean legalJ(int nextJ) {
        return nextJ >= 0 && nextJ < scanmap[0].length;
    }

    public static void main(String[] args) {
        Solution_200_Hot100 solution200Hot100 = new Solution_200_Hot100();
        System.out.println(solution200Hot100.numIslands(
                new char[][]{
                        {'1', '1', '1', '1', '0'},
                        {'1', '1', '0', '1', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '0', '0', '0'}
                }
        ));
    }


}
