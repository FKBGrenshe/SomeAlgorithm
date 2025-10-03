import java.util.ArrayList;
import java.util.List;

public class Solution_22_Hot100 {

    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {

        StringBuilder stringBuilder = new StringBuilder();
        findAllAns(stringBuilder,0,0,n);
        return res;
    }

    public void findAllAns(StringBuilder cur,int left, int right, int n){
        if (cur.length() == n * 2){
            res.add(cur.toString());
        }

        // 加左括号
        if (left < n){
            cur.append('(');
            findAllAns(cur,left+1,right,n);
            cur.deleteCharAt(cur.length()-1);
        }
        // 加右括号
        if (right < left){
            cur.append(')');
            findAllAns(cur,left,right+1,n);
            cur.deleteCharAt(cur.length()-1);
        }


    }



    public static void main(String[] args) {
        Solution_22_Hot100 solution22 = new Solution_22_Hot100();
        List<String> strings = solution22.generateParenthesis(3);
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
