package luogu;
import java.io.IOException;
import java.util.Scanner;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2026-02-13
 * @Description: 01背包问题
 */
public class P2871 {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        String NM = scanner.nextLine();
        String[] NMS = NM.split(" ");
        int N = Integer.parseInt(NMS[0]); // 物品个数
        int M = Integer.parseInt(NMS[1]); // 背包大小
        int[] weights = new int[N]; // 重量数组
        int[] values = new int[N];  // 价值数组

        for (int i = 0; i < N; i++) {
            String cureLine = scanner.nextLine();
            String[] strings = cureLine.split(" ");
            weights[i] = Integer.parseInt(strings[0]);
            values[i] = Integer.parseInt(strings[1]);
        }

        ////////////////////////////////////////////////////////////////
        // transfer : 对于第i个物品，剩余重量j情况下的最大背包价值 = dp[i][j] = Max(情1，情2) = Max(dp[i-1][j], dp[i-1][j-wi])
        // 情1：不放物品i：对于 0 ~ i-1 个物品，剩余重量j情况下的最大背包价值 = dp[i-1][j]
        // 情2：放物品i：对于0~i-1个物品，剩余重量j-wi情况下的最大背包价值+当前物品i价值 = dp[i-1][j-wi]+vi

        // 定义dp
        int[][] dp = new int[N+1][M+1]; // dp[i][j]是从0-i个物品种，剩余背包容量为j，的最大背包价值
        // 初始化dp
        // 对于第0个物品
        // dp[0][j] = 0
        // 对于剩余容量为0
        // dp[i][0] = 0

        int listIdx;
        for (int i = 1; i <= N; i++) {
            // 对于第i个物品
            listIdx = i-1; // 对应数组下标
            for (int j = 1; j <= M; j++) {
                // 对于剩余容量j
                if (j < weights[listIdx]){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = Math.max(
                            dp[i-1][j],
                            dp[i-1][j-weights[listIdx]]+values[listIdx]
                    );
                }
            }
        }

        System.out.println(dp[N][M]);
    }


}
