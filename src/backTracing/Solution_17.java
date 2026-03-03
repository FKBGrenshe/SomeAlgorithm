package backTracing;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2026-03-02
 * @Description: 电话号码组合
 */
public class Solution_17 {

    List<String> globalResult = new ArrayList<>();
    String digits;
    int totalLen;
    StringBuilder sb = new StringBuilder();
    Map<Integer,List<Character>> charMap = new HashMap<>();

    {
        this.charMap.put(2,List.of('a','b','c'));
        this.charMap.put(3,List.of('d','e','f'));
        this.charMap.put(4,List.of('g','h','i'));
        this.charMap.put(5,List.of('j','k','l'));
        this.charMap.put(6,List.of('m','n','o'));
        this.charMap.put(7,List.of('p','q','r','s'));
        this.charMap.put(8,List.of('t','u','v'));
        this.charMap.put(9,List.of('w','x','y','z'));
    }

    public List<String> letterCombinations(String digits) {
        totalLen = digits.length();
        this.digits = digits;
        backTracing(0);
        return globalResult;
    }

    void backTracing(int curIdx){
        if (curIdx == totalLen){
            globalResult.add(sb.toString());
            return;
        }

        char curVal_char = digits.charAt(curIdx);
        int curVal_int = Integer.parseInt(String.valueOf(curVal_char));
        List<Character> characters = charMap.get((curVal_int));

        for (Character curChar : characters)  {
            sb.append(curChar);
            backTracing(curIdx+1);
            sb.deleteCharAt(curIdx);
        }
    }

    public static void main(String[] args) {
        Solution_17 solution17 = new Solution_17();
        List<String> strings = solution17.letterCombinations("23");

        strings.forEach(System.out::println);
    }

}
