package Time3Hot100;

import java.util.ArrayList;
import java.util.List;

public class Solution_131_Hot100 {

    List<List<String>> globalAns = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backTracing(0,s);
        return globalAns;
    }

    void backTracing(int beginidx, String s){
        if (beginidx == s.length()){
            globalAns.add(new ArrayList<>(path));
            return;
        }

        for (int endidx = beginidx; endidx < s.length(); endidx++) {
            String curString = s.substring(beginidx, endidx+1);
            if (checkhuiwen(curString)){
                path.addLast(curString);
                backTracing(endidx+1,s);
                path.removeLast();
            }
        }

    }

    public boolean checkhuiwen(String curstring){

        if (curstring.length() <= 1){
            return true;
        }

        int left = 0;
        int right = curstring.length()-1;
        while (left <= right){

            if (curstring.charAt(left) != curstring.charAt(right)){
                return false;
            }

            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution_131_Hot100 solution131Hot100 = new Solution_131_Hot100();
        List<List<String>> aab = solution131Hot100.partition("cbbbcc");
        System.out.println(aab);
    }

}
