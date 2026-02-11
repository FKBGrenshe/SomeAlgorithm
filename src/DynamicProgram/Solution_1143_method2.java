package DynamicProgram;

import java.util.Arrays;
import java.util.Objects;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2026-02-11
 * @Description: 最长公共子序列
 */
public class Solution_1143_method2 {

    // todo 未做完


    int[][] dp;
    int maxVal = 0;

    public int longestCommonSubsequence(String text1, String text2) {

        int text1Length = text1.length();
        int text2Length = text2.length();
        dp = new int[text1Length+1][text2Length+1];

        // 边界处理


        // 中心填充
        int curIdx = 0;
        for (int idx1 = 1; idx1 < text1Length; idx1++) {
            for (int idx2 = 1; idx2 < text2Length; idx2++) {
                if (Objects.equals(text1.charAt(idx1), text2.charAt(idx2))){
                    dp[idx1][idx2] = dp[idx1-1][idx2-1]+1;
                }else {
                    dp[idx1][idx2] = Math.max(dp[idx1-1][idx2],dp[idx1][idx2-1]);
                }
                maxVal = Math.max(maxVal, dp[idx1][idx2]);
            }
        }

        return maxVal;
    }

    public static void main(String[] args) {
        String text1 = "bmvcnwrmxcfcxabkxcvgbozmpspsbenazglyxkpibgzq";
        //             "bmvcnwrmxcfcxabkxcvgbozmpspsbenazglyxkpibgzq";
        String text2 = "bmpmlstotylonkvmhqjyxmnqzctonqtobahcrcbibgzgx";
        //             "bmpmlstotylonkvmhqjyxmnqzctonqtobahcrcbibgzgx";

//        cvgbozmpspsbenazglyxkpib
//                qjyxmnqzctonqtobahcrcbibgz
        Solution_1143_method2 solution1143 = new Solution_1143_method2();
        System.out.println(solution1143.longestCommonSubsequence(text1, text2));
    }
}
