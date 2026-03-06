package Time2Hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2026-03-06
 * @Description: 分割回文串
 */
public class Solution_131_Hot100 {

    List<List<String>> globalResult = new ArrayList<>();
    List<String> curResult = new ArrayList<>();
    String s;

    public List<List<String>> partition(String s) {
        this.s = s;
        backTracing(0);
        return globalResult;
    }

    private void backTracing(int beginIdx) {
        if (beginIdx == s.length()){
            globalResult.add(new ArrayList<>(curResult));
        }

        for (int endIdx = beginIdx; endIdx < s.length(); endIdx++) {
            String curSubString = s.substring(beginIdx, endIdx + 1);
            if (isHUIWEN(curSubString)){
                curResult.add(curSubString);
                backTracing(endIdx+1);
                curResult.removeLast();
            }
        }
    }

    boolean isHUIWEN(String subString){

        int begin = 0, end = subString.length()-1;
        while (begin <= end){
            if (subString.charAt(begin++) != subString.charAt(end--)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution_131_Hot100 solution131Hot100 = new Solution_131_Hot100();
        List<List<String>> res = solution131Hot100.partition("aabb");

        res.forEach(s -> System.out.println(s.toString()));

    }

}
