import java.util.Arrays;

public class Solution_3_Hot100 {
    public int lengthOfLongestSubstring(String s) {

        if (s.isEmpty()){
            return 0;
        }

        int consecutiveNumber = 0;
        int maxConsecutiveNumber = 0;
        // 不重复字串的开头字母
        char startWord = s.charAt(0);
        int startWordIdx = 0;

        // 表示 ascii码表中每个字母是否出现，如果出现，位置在S的哪个idx
        int[] existsList = new int[256];
        Arrays.fill(existsList, -1);

        char[] charArray = s.toCharArray();


        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (existsList[(int)c] != -1){
                // 上个字串重复的字母的位置
                int dropStartIdx = existsList[(int)c];
                // 说明重复了，要把当前串从开头到重复位置全部舍弃
                String dropSubString = s.substring(startWordIdx,dropStartIdx+1);
                for (char dropWord : dropSubString.toCharArray()) {
                    existsList[(int)dropWord] = -1;
                }
                // 设置不重复字串开头字母
                startWordIdx = dropStartIdx+1;
                consecutiveNumber -= dropSubString.length();
            }
            // 没重复
            existsList[(int)c] = i;
            if (maxConsecutiveNumber < ++consecutiveNumber){
                maxConsecutiveNumber = consecutiveNumber;
            }
        }

        return maxConsecutiveNumber;
    }

    public int lengthOfLongestSubstringV1(String s){
        int[] ascii = new int[127];
        char[] sCharArray = s.toCharArray();
        Arrays.fill(ascii,-1);

        int len = 0;
        int left = 0;
        int right = 0;
        while (right<sCharArray.length){
            int charRightAscii = (int)sCharArray[right];
            while (ascii[charRightAscii] == -1){
                if (right >= sCharArray.length-1){
                    return Math.max(len,right-left+1);
                }
                ascii[charRightAscii] = right;
                right++;
                charRightAscii = (int)sCharArray[right];
            }
            len = Math.max(len,right-left);

            // right 字符重复
            int conflictIdx = ascii[charRightAscii];
            for ( ; left <= conflictIdx; left++) {
                int charLeftAscii = (int) sCharArray[left];
                ascii[charLeftAscii] = -1;
            }
        }
        return len;
    }


    public static void main(String[] args) {
        Solution_3_Hot100 solution3Hot100 = new Solution_3_Hot100();
        System.out.println(solution3Hot100.lengthOfLongestSubstringV1("abcabcbbca"));
    }
}
