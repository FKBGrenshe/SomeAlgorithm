/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-04-27
 * @Description: 最长公共前缀
 */
public class Solution_14 {
    public String longestCommonPrefix(String[] strs) {

        int nums = strs.length;

        // 假定第一个word即最长公共前缀
        int minLength = strs[0].length();

        for (int i = 1; i < strs.length; i++) {
            minLength = wordsCompare(strs[0],strs[i],minLength);
        }

        return strs[0].substring(0,minLength);
    }

    private int wordsCompare(String word1, String word2, int length){

        length = Math.min(length,word2.length());

        for (int i = 0; i < length; i++) {
            if (word1.charAt(i) != word2.charAt(i)){
                return i;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        Solution_14 solution14 = new Solution_14();
        System.out.println(solution14.longestCommonPrefix(
                new String[]{
                        "flower", "flow", "flight"
                }
        ));
    }
}
