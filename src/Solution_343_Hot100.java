import java.util.Arrays;
import java.util.Map;

public class Solution_343_Hot100 {
    /**
     * 数学原理 -- 尽可能多拆分3
     * @param n
     * @return
     */
    public int integerBreakVersion1(int n) {

        if (n == 2 ){
            return 1;
        }

        int number3 = n / 3;
        if (n % 3 == 1){
            return (int) Math.pow(3, number3-1) * 4;
        }else if (n % 3 == 2){
            return (int) Math.pow(3, number3) * 2;
        }else {
            return (int) Math.pow(3, number3);
        }
    }

    /**
     * DP
     * @param n
     * @return
     */
    public int integerBreakVersion2(int n) {
        // dp definition : dp[i] = integerBreak(i)
        int[] dp = new int[n+1];
        Arrays.fill(dp,0);
        dp[0] = 1; dp[1] = 1; dp[2] = 1; dp[3] = 2;

        // state transfer
        for (int i = 4; i <= n; i++) {
            for (int j = 2; j < i; j++) {
                int tempProduct = Math.max(j * dp[i-j], j * (i-j));
                if (tempProduct > dp[i]){
                    dp[i] = tempProduct;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution_343_Hot100 solution343 = new Solution_343_Hot100();
        System.out.println(solution343.integerBreakVersion2(10));
    }

}
