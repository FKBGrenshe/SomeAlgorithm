package backTracing;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2026-03-03
 * @Description: 分割回文串
 */
public class Solution_131 {

    List<List<String>> globalResult = new ArrayList<>();
    List<String> curResult = new ArrayList<>();
    String s;

    public List<List<String>> partition(String s) {
        this.s = s;
        backTracing(null,s);

        globalResult.forEach(List::removeFirst);

        return globalResult;
    }

    void backTracing(String curString, String resString){
        if (!isHuiWen(curString)){
            return;
        }

        curResult.add(curString);

        if (resString.isEmpty()){
            globalResult.add(new ArrayList<>(curResult));
            curResult.removeLast();
            return;
        }

        for (int i = 0; i < resString.length(); i++) {
            String nextSubString = resString.substring(0,i+1);
            String nextResString = resString.substring(i+1,resString.length());
            backTracing(nextSubString,nextResString);
        }
        curResult.removeLast();
    }

    boolean isHuiWen(String s){
        if (Objects.isNull(s)){
            return true;
        }
        // todo
        int beginIdx = 0, endIdx = s.length()-1;
        while (beginIdx <= endIdx){
            if (s.charAt(beginIdx++) != s.charAt(endIdx--)){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Solution_LCR_86 solutionLcr86 = new Solution_LCR_86();
//        System.out.println(solutionLcr86.isHuiWen(""));

//        String[][] aabs = solutionLcr86.partition("cbbbcc");
//        List<List<String>> cbbbcc = solutionLcr86.partition("aabba");
        String[][] aabbas = solutionLcr86.partition("aabba");


    }

}
