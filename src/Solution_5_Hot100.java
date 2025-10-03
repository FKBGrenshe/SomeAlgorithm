import java.util.Arrays;

/**
 * 给你一个字符串 s，找到 s 中最长的 回文 子串。
 *
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 *  示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 * 提示：
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 */
public class Solution_5_Hot100 {
    public String longestPalindrome(String s) {

        // dp[i][j] 表示 s[i,j] 是否是回文串
        boolean[][] dp = new boolean[s.length()][s.length()];

        int maxLength = 0;
        String maxStr = "";

        // dp initialize
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = true;
        }

        // status transfer
        for (int len = 2; len < dp.length; len++) {
            // 从长度为2的字符串开始遍历
            for (int i = 0; i < dp.length; i++) {
                // 先按照行
                dp[i][i+len-1] = dp[i+1][i+len-2] ^ s.charAt(i) == s.charAt(i+len-1);
            }
            for (int i = 0; i < dp.length; i++) {
                // 再按照列
                dp[i+len-1][i] = dp[i+len-2][i+1] ^ s.charAt(i) == s.charAt(i+len-1);
            }
        }

        return maxStr;

    }

    public static void main(String[] args) {
        Solution_5_Hot100 solution5 = new Solution_5_Hot100();
//        System.out.println(solution5.longestPalindrome("babad"));
        System.out.println(solution5.longestPalindrome("aacabdkacaa"));
    }
}
