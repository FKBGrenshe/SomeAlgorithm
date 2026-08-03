package Time3Hot100;

import java.util.Arrays;

public class Solution_994_Hot100 {

    int[][] grid;
    int[][] curtimebad;

    int[][] neighbours = new int[][]{
            {0,1},
            {0,-1},
            {1,0},
            {-1,0}
    };

    public int orangesRotting(int[][] grid) {
        this.grid = grid;
        curtimebad = new int[grid.length][grid[0].length];

        if (!containSepcial(1)){
            return 0;
        }

        if (!containSepcial(2)){
            return -1;
        }



        int time = 0;

        while (containSepcial(1)){
            time++;

            if (doChange() == 0){
                time--;
                break;
            }
        }

        return containSepcial(1) ? -1:time;
    }

    private int doChange() {

        int makebadNums = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2){
                    makebadNums += makebad(i,j);
                }
            }
        }
        doRefresh();
        return makebadNums;
    }

    private void doRefresh() {
        for (int i = 0; i < curtimebad.length; i++) {
            for (int j = 0; j < curtimebad[0].length; j++) {
                if (curtimebad[i][j] == 2){
                    grid[i][j] = 2;
                }
            }
            Arrays.fill(curtimebad[i],0);
        }
    }

    private int makebad(int i, int j) {

        int makebadNums = 0;

        for (int[] delta : neighbours) {
            int curI = i + delta[0];
            int curJ = j + delta[1];

            if (
                    curI >= 0 & curI < grid.length &&
                    curJ >= 0 & curJ < grid[0].length &&
                            grid[curI][curJ] == 1
            ){
                curtimebad[curI][curJ] = 2;
                makebadNums++;
            }
        }

        return makebadNums;
    }

    private boolean containSepcial(int orangeType){
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == orangeType){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution_994_Hot100 solution994Hot100 = new Solution_994_Hot100();
        System.out.println(solution994Hot100.orangesRotting(
                new int[][]{
                        {2, 1, 1},
                        {0, 1, 1},
                        {1, 0, 1}
                }
        ));
        System.out.println(solution994Hot100.orangesRotting(
                new int[][]{
                        {1,2}
                }
        ));
    }
}
