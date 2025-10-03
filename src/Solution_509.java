import java.util.Arrays;

public class Solution_509 {

    public int fib(int n) {

        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }

        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);

        dp[0] = 0; dp[1] = 1;

        for ( int idx = 2 ; idx < dp.length; idx++) {
            if (dp[idx] == -1){
                dp[idx] = dp[idx-1] + dp[idx-2];
            }
        }
        return dp[n];
    }


    public int fibnew(int n){

        if (n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }

        int[] dp = new int[n+1];
        dp[0] = 0; dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }


}
