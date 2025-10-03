import java.util.Arrays;

public class Solution_91 {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        /*dp[1]才表示s[1]*/
        dp[0] = 1; dp[1] = 1;

        // iterate
        char[] charArray = s.toCharArray();
        if (charArray[0] == '0'){
            return 0;
        }
        for (int i = 1; i < charArray.length; i++) {
            int dpidx = i+1;
            int value = charArray[i] - '0';

            if (value == 0){
                /*该项为0*/
                if (charArray[i-1] == '1' || charArray[i-1] == '2'){
                    dp[dpidx] = dp[dpidx - 2];
                }else {
                    return 0;
                }
            }else {
                dp[dpidx] = dp[dpidx - 1];
                /*该项不为0*/
                if ( (s.charAt(i-1) - '0') == 1){
                    /*上一项可以当开头1*/
                    dp[dpidx] += dp[dpidx - 2];
                }else if ((s.charAt(i-1) - '0') == 2 && value <= 6){
                    /*上一项可以当开头1*/
                    dp[dpidx] += dp[dpidx - 2];
                }
            }
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {
        Solution_91 solution91 = new Solution_91();
        System.out.println(solution91.numDecodings("230"));
    }
}
