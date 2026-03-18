package DynamicProgram;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2026-03-18
 * @Description: 单词拆分
 */
public class Solution_139_Hot100 {

    boolean[] dp;
    char[] dpChars;

    public boolean wordBreak(String s, List<String> wordDict) {
        dp = new boolean[s.length()+1];
        dpChars = new char[s.length()+1];

        // 初始化
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            dpChars[i] = s.charAt(i-1);
        }

        Integer minStart = Integer.MAX_VALUE;
        for (String string : wordDict) {
            minStart = Math.min(minStart,string.length());
        }

        //-- dp start--//

        // dp[i] = dp[i-word.length] && word.charAt(0) == dpChar[i]
        for (int curIdx = minStart; curIdx < dp.length; curIdx++) {
            for (String curWord : wordDict) {
                if (dp[curIdx])break;
                if (curIdx == 0 ){
                    dp[curIdx] = curWord.charAt(0)==dpChars[curIdx];
                } else if (curIdx >= curWord.length()) {
                    if (dp[curIdx - curWord.length()]){
                        dp[curIdx] = true;
                        for (int i = 0; i < curWord.length(); i++) {
                            if (curWord.charAt(i) != dpChars[curIdx-curWord.length()+i+1]){
                                dp[curIdx] = false;
                                break;
                            }
                        }
                    }
                    //dp[curIdx] = curWord.charAt(0)==dpChars[curIdx] && dp[curIdx - curWord.length()];
                }

            }
        }
        //-- dp  ed --//
        return dp[s.length()];
    }

    public static void main(String[] args) {
//        String s = "leetcode";
        String s = "leetcodeappleapplepenapple";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        wordDict.add("apple");
        wordDict.add("pen");

        Solution_139_Hot100 solution139Hot100 = new Solution_139_Hot100();
        boolean res = solution139Hot100.wordBreak(
                s,
                wordDict
        );

        System.out.printf(res+"");
    }

}
