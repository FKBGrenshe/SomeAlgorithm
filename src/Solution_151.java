import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-04-23
 * @Description: 反转字符串中的单词
 */
public class Solution_151 {

    List<String> strings = new ArrayList<>();

    public String reverseWords(String s) {
        split(s);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = strings.size() - 1; i >= 0; i--) {
            stringBuilder.append(strings.get(i));
            stringBuilder.append(' ');
        }
        String string = stringBuilder.toString();
        return string.substring(0,string.length()-1);
    }

    public void split(String s){
        int startIdx = 0;
        int endIdx = 0;

        while (startIdx <s.length() && endIdx < s.length()){
            //找到字符串中第一个单词
            while ( startIdx < s.length() && s.charAt(startIdx) == ' '){
                startIdx++;
            }
            endIdx = startIdx;
            while ( endIdx < s.length() &&s.charAt(endIdx) != ' '){
                endIdx++;
            }
            if (startIdx < s.length()){
                strings.add(s.substring(startIdx,endIdx));
                s = s.substring(endIdx);
                // 重置
                startIdx = 0;
                endIdx = 0;
            }else {
                break;
            }


        }
    }

    public static void main(String[] args) {
        String s = "     a good   example  ";
        Solution_151 solution151 = new Solution_151();
        System.out.println(solution151.reverseWords(s));
    }
}
