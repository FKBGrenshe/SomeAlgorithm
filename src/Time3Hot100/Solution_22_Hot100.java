package Time3Hot100;

import java.util.ArrayList;
import java.util.List;

public class Solution_22_Hot100 {

    List<String> globalans = new ArrayList<>();
    StringBuilder path = new StringBuilder();

    public List<String> generateParenthesis(int n) {
        backTracing(0,0,n);
        return globalans;
    }

    void backTracing(int curLeftNums, int curRightNums,int totalneed){
        if (curRightNums == totalneed){
            globalans.add(path.toString());
            return;
        }

        int leftRes = totalneed - curLeftNums;
        if (leftRes > 0){
            path.append('(');
            backTracing(curLeftNums+1, curRightNums, totalneed);
            path.deleteCharAt(path.length()-1);
        }

        int rightRes = curLeftNums - curRightNums;
        if (rightRes > 0){
            path.append(')');
            backTracing(curLeftNums, curRightNums+1, totalneed);
            path.deleteCharAt(path.length()-1);
        }
    }

    public static void main(String[] args) {
        Solution_22_Hot100 solution22Hot100 = new Solution_22_Hot100();
        List<String> strings = solution22Hot100.generateParenthesis(3);
        for (String s : strings) {
            System.out.println(s);
        }
    }
}
