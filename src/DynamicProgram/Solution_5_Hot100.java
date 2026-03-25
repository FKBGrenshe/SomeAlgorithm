package DynamicProgram;

import java.util.Arrays;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2026-03-25
 * @Description: 最长回文子串
 */
public class Solution_5_Hot100 {

    int[][] dp;
    String s;

    int maxLen = Integer.MIN_VALUE;
    int maxLenStartIdx = -1;
    int maxLenEndIdx = -1;


    // [startIdx, endIdx] = start == end && [start+1, end-1]

    public String longestPalindrome(String s) {
        dp = new int[s.length()][s.length()];
        this.s = s;

        for (int curRow = 0; curRow < s.length(); curRow++) {
//            dp[0][curRow] = 1;
//            dp[curRow][0] = 1;
//            dp[curRow][1] = 1;
            dp[curRow][curRow] = 1;

        }
//        for (int curRow = 0; curRow < s.length(); curRow++) {
        for (int curRow = s.length()-1; curRow >= 0; curRow--) {
            for (int curColumn = curRow; curColumn < s.length(); curColumn++) {
//            for (int curColumn = 0; curColumn < s.length(); curColumn++) {
                // [startIdx,endIdx] = [startIdx+1, endIdx-1] + start==end
                // 依赖于 往下，往左
                // 从 下，左开始
                int startIdx = curRow;
                int endIdx = curColumn;

                if (s.charAt(startIdx) == s.charAt(endIdx)){
                    int subStart = startIdx+1;
                    int subEnd = endIdx-1;
                    if (subStart <= subEnd){
                        dp[startIdx][endIdx] = dp[subStart][subEnd];
                    }else {
                        dp[startIdx][endIdx] = 1;
                    }

                    if (dp[curRow][curColumn] == 1){
                        if (maxLen < curColumn - curRow+1){
                            maxLen = curColumn - curRow+1;
                            maxLenStartIdx = curRow;
                            maxLenEndIdx = curColumn;
                            // 优化
                            if (maxLen == s.length()) return s;
                        }
                    }
                }
            }
        }
        if (maxLen == Integer.MIN_VALUE){
            return s.substring(0,1);
        }
        return s.substring(maxLenStartIdx, maxLenEndIdx+1);
    }

    private boolean doCheck(int startIdx, int endIdx) {
        while (startIdx <= endIdx){
            if (s.charAt(startIdx++) != s.charAt(endIdx--)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution_5_Hot100 solution5Hot100 = new Solution_5_Hot100();
        System.out.println(solution5Hot100.longestPalindrome("babad"));
    }

}
