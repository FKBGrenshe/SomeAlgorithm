import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution_17_Hot100 {


    Character[][] charList = new Character[][]{
            {},{},
            {'a','b','c'},
            {'d','e','f'},
            {'g','h','i'},
            {'j','k','l'},
            {'m','n','o'},
            {'p','q','r','s'},
            {'t','u','v'},
            {'w','x','y','z'}
    };

    List<String> results = new ArrayList<>();
    List<Character> path = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()){
            return results;
        }

        char[] charArray = digits.toCharArray();
        backTracingVer1(charArray,0);

        return results;

        /*int numbers = Integer.parseInt(digits);
        int digitLen = 1;

        for (int i = 0; i < digits.length(); i++) {
            digitLen *= 10;
        }

        for (int i = 0; i < digits.length(); i++) {
            int val = numbers % digitLen;
            digitLen /= 10;
            backTracing();
        }*/

    }

    private void backTracingVer1(char[] charArray, int curIndex) {
        if (path.size() == charArray.length){
            StringBuilder stringBuilder = new StringBuilder();
            for (Character character : path) {
                stringBuilder.append(character);
            }
            String substring = stringBuilder.toString();
            results.add(substring);
            return;
        }
        int charSetidx = charArray[curIndex] - '0';
        for (int x = 0; x < charList[charSetidx].length; x++) {
            path.add(charList[charSetidx][x]);
            backTracingVer1(charArray,curIndex+1);
            path.remove(path.size()-1);
        }
    }

    /*void backTracing(String digits, int startIndex){
        // 终止条件 -- 叶子节点
        if (digits.length() == path.size()){
            results.add(path.toString());
            return;
        }
        // 单层递归
        for (int i = path.size(); i < digits.length(); i++){
            int charSetidx = digits.charAt(i) - '0';
            for (int x = 0; x < charList[charSetidx].length; x++) {
                path.add(charList[charSetidx][x]);
                backTracing(digits,x+1);
                path.remove(path.size()-1);
            }
        }
    }*/
}
