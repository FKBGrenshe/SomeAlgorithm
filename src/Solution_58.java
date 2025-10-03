/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-04-21
 * @Description: 最后一个单词长度
 */
public class Solution_58 {

    public int lengthOfLastWord(String s) {

        char[] chars = s.toCharArray();

        int endIdx = 0;

        for (int i = chars.length-1; i > 0; i--) {
            if (chars[i] != ' '){
                endIdx = i;
                break;
            }
        }

        for (int startIdx = endIdx-1; startIdx >= 0; startIdx--) {
            if (chars[startIdx] == ' '){
                return endIdx - startIdx;
            }
        }

        return endIdx+1;

    }

    public static void main(String[] args) {
        Solution_58 solution58 = new Solution_58();
        System.out.println(solution58.lengthOfLastWord(
                "a "
//                "   fly me   to   the moon  "
        ));
    }


}
