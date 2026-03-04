package backTracing;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2026-03-04
 * @Description: 复原IP地址
 */
public class Solution_93 {

    Integer curVal;
    StringBuilder globalS;
    List<String> globalResult = new ArrayList<>();
    StringBuilder stringBuilder = new StringBuilder();
    int globalDepth = 0;


    public List<String> restoreIpAddresses(String s) {
        this.globalS = new StringBuilder(s);

        for (int i = 1; i < 4; i++) {
            backTracing(0,i);
        }
//        backTracing(0,3);

        for (int i = 0; i < globalResult.size(); i++) {

            globalResult.addLast(globalResult.removeFirst().substring(1));

        }

        return globalResult;
    }

    private void backTracing(int beginIdx, int endIdx) {

        if (endIdx > globalS.length()){
            return;
        }

        String curString = globalS.substring(beginIdx,endIdx);

        if (globalDepth >= 4 || !isLegal(curString)){
            return;
        }

        if ( globalDepth == 3&& endIdx == globalS.length()){
            stringBuilder.append(".").append(curString);
            globalResult.add(stringBuilder.toString());
            stringBuilder.delete(stringBuilder.length()-(curString.length()+1),stringBuilder.length());
            return;
        }

        stringBuilder.append(".").append(curString);
        globalDepth++;
        for (int i = 1; i <4; i++) {
            backTracing(endIdx,endIdx+i);
        }
        stringBuilder.delete(stringBuilder.length()-(curString.length()+1),stringBuilder.length());
        globalDepth--;
    }


    boolean isLegal(String curString){

        if (curString.length()>1 && curString.charAt(0) == '0'){
            return false;
        }

        curVal = Integer.valueOf(curString);
        return curVal >= 0 && curVal <= 255;
    }

    public static void main(String[] args) {
        Solution_93 solution93 = new Solution_93();
//        List<String> strings = solution93.restoreIpAddresses("25525511135");
//        List<String> strings = solution93.restoreIpAddresses("0000");
        List<String> strings = solution93.restoreIpAddresses("101023");
        strings.forEach(System.out::println);
    }


}
