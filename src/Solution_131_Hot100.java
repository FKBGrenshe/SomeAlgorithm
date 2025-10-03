import java.util.ArrayList;
import java.util.List;

public class Solution_131_Hot100 {

    List<String> path = new ArrayList<>();
    List<List<String>> results = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backTracing(s,0);
        return  results;
    }

    private void backTracing(String s,int startIdx){
        // 终止条件
        if (startIdx == s.length()){
            results.add(new ArrayList<>(path));
            return;
        }
        // 单层递归
//        for (int i = startIdx; i < s.length(); i++) {
            for (int endIdx = startIdx; endIdx < s.length(); endIdx++) {
                String subString = s.substring(startIdx, endIdx+1);
                if (isHuiWen(subString)){
                    // 是回文，往path中放
                    path.add(subString);
                    // 递归
                    backTracing(s,endIdx+1);
                    // 回溯
                    path.remove(path.size()-1);
                }
//            }
        }
    }

    private boolean isHuiWen(String subString){
        boolean flag=true;
        for(int i=0;i<subString.length()/2;i++){
            if((subString.charAt(i))!=(subString.charAt(subString.length()-1-i))){
                flag=false;
            }
        }
        return flag;
    }
}
