public class Solution_72_Hot100 {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for (int i = 0; i < word1.length()+1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < word2.length()+1; i++) {
            dp[0][i] = i;
        }

        // status transfer
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                /* dp[i][j] =
                    math.min{

                    }
                 */

                if (word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    // 如果 word1第i-1个字符 不等于 word2第j-1个字符
                    /**
                     * 有三种操作：
                     * 1. 将i-1换成j-1
                     * 2. word1的i-1多余，删掉
                     * 3. word2的j-1多余，删掉
                     */
                    int delete1 = dp[i][j-1] + 1;
                    int delete2 = dp[i-1][j] + 1;
                    int change = dp[i-1][j-1] + 1;
                    dp[i][j] = Math.min(change, Math.min(delete1, delete2));
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        Solution_72_Hot100 solution72Hot100 = new Solution_72_Hot100();
//        System.out.println(solution72Hot100.minDistance("horse", "ros"));
        System.out.println(solution72Hot100.minDistance("intention", "execution"));
    }
}
