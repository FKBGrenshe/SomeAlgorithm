/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-05-12
 * @Description: 找到最长的半重复子字符串
 */
public class Solution_2370 {

    public int longestSemiRepetitiveSubstring(String s) {
        if (s.length() == 0 || s.length() == 1){
            return s.length();
        }
        int count = 0;
        int start = 0;
        char[] sCharArray = s.toCharArray();
        int conflict = 0;
        for (int end = 1; end < sCharArray.length; end++) {
            if (sCharArray[end] == sCharArray[end-1]){
                if (conflict == 0){
                    conflict++;
                }else {
                    while (sCharArray[start] != sCharArray[start+1]){
                        start++;
                    }
                    start++;
                }
            }
            count = Math.max(count,end-start+1);
        }

        return count;
    }

    public static void main(String[] args) {
        Solution_2370 solution2370 = new Solution_2370();
        System.out.println(solution2370.longestSemiRepetitiveSubstring(
//            "52233"
                "111111111111"
        ));
    }

}
