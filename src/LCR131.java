import java.util.Arrays;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-04-19
 * @Description: 砍竹子1
 */
public class LCR131 {

    public int[] dp;
    public int maxProd;

    public int cuttingBamboo(int bamboo_len) {
        dp = new int[bamboo_len+1];
        Arrays.fill(dp, 1);
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= bamboo_len; i++) {
            fillDp(i);
        }

//        cutting(bamboo_len, 1);
        return dp[bamboo_len];
    }

    private void fillDp(int i){
        // dp[i] 为 i长的竹子分段的最大乘积
        for (int j = 1; j < i/2+1; j++) {

            int curMaxJ = Math.max(j, dp[j]);
            int curMaxI_j = Math.max(i-j,dp[i-j]);
            int curProd = curMaxI_j * curMaxJ;

            if (dp[i] < curProd){
                dp[i] = curProd;
            }
        }
    }

    private void cutting(int bamboo_len, int curProd) {
        if (bamboo_len <= 0){
            return;
        }

        for (int i = 2; i <= bamboo_len; i++) {
            curProd *= i;
            if (maxProd < curProd){
                maxProd = curProd;
            }
            cutting(bamboo_len-i, curProd);
            curProd /= i;
        }
    }


    public static void main(String[] args) {
        LCR131 lcr131 = new LCR131();
        System.out.println(lcr131.cuttingBamboo(48));
    }
}
