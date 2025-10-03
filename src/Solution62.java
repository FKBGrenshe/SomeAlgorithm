import java.util.Arrays;
import java.util.Dictionary;

public class Solution62 {
    public int uniquePaths(int m, int n) {

        // 假设为宽长方形，即长为max，宽为min
        int min = Math.min(m,n);
        int max = Math.max(m,n);

        if (m == 1){
            return n - 1;
        }
        else if (n == 1){
            return m - 1;
        }

        // dp 定义 -- dp[x][y] 记录从(0,min) 到 (x,y) 的路径数量
        int[][] dp = new int[max][min];

        // 初始化：左上角，顶行，最左列均为1
        dp[0][min-1] = 1;
        dp[1][min-1] = 1;
        dp[0][min-2] = 1;

        printShape(max, min, dp);
        // 递推公式 -- 从左到右，从上到下

        for (int X = 2; X < max; X++) {
            int x = X;
            for (int Y = min-1; Y >= 0; Y--) {
                int y = Y;
                for (; x >= 0; x--) {
                    if (y >= 0){
                        if (!(y+1 < min)){
                            dp[x][y] = dp[x-1][y];
                        }else if (!(x-1 >= 0)){
                            dp[x][y] = dp[x][y+1];
                        }else {
                            dp[x][y] = dp[x-1][y] + dp[x][y+1];
                        }
                        y--;
                        printShape(max, min, dp);
                    }
                }
            }
        }


        // 剩余小三角形
        int numbers = 1;
        for (int y = min-2; y >= 0 ; y--) {
            for (int x = max - 1 - numbers + 1; x < max; x++) {
                dp[x][y] = dp[x-1][y] + dp[x][y+1];
                printShape(max, min, dp);
            }
            numbers++;
        }


        return dp[max-1][0];
    }

    private static void printShape(int m, int n, int[][] dp) {
        System.out.println("'----------'");
        for (int Yidx = n -1; Yidx >= 0 ; Yidx--) {
            for (int Xidx = 0; Xidx < m; Xidx++) {
                System.out.print(dp[Xidx][Yidx]+ " \t ");
            }
            System.out.println();
        }
        System.out.println("'----------'");
    }

    public static void main(String[] args) {
        Solution62 solution62 = new Solution62();
        System.out.println(solution62.uniquePaths(7, 3));
    }
}
