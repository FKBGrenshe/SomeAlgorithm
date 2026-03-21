package DynamicProgram;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2026-03-21
 * @Description: 最长有效括号
 */
public class Solution_32_Hot100 {


    public int longestValidParentheses(String s) {
        boolean[] dp = new boolean[s.length()];


        int curIdx = 0;
        while ( curIdx < s.length() && s.charAt(curIdx) == ')'){
            curIdx++;
        }

        for (; curIdx < s.length(); curIdx++) {
            if (s.charAt(curIdx) == ')'){
                int pairedLeftIdx = findPreNonPairedtLeft(curIdx,s,dp);
                if (pairedLeftIdx != -1){
                    dp[pairedLeftIdx] = true;
                    dp[curIdx] = true;
                }
            }
        }

        int curCount = 0;
        int maxCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if (dp[i]){
                curCount ++;
                maxCount = Math.max(curCount,maxCount);
            }else {
                curCount = 0;
            }
        }

        return maxCount;
    }

    private int findPreNonPairedtLeft(int curIdx, String s, boolean[] dp) {
        for (int idx = curIdx-1; idx >= 0; idx--) {
            if (!dp[idx] && s.charAt(idx) == '('){
                return idx;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Solution_32_Hot100 solution32Hot100 = new Solution_32_Hot100();
        System.out.println(solution32Hot100.longestValidParentheses("()(()"));
        System.out.println(solution32Hot100.longestValidParentheses(""));
        System.out.println(solution32Hot100.longestValidParentheses(")()())"));
        System.out.println(solution32Hot100.longestValidParentheses("(()()"));
        System.out.println(solution32Hot100.longestValidParentheses("()())()"));
        System.out.println(solution32Hot100.longestValidParentheses("))))()"));
        System.out.println(solution32Hot100.longestValidParentheses("))))((()))))))()"));
    }
}
