/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-04-20
 * @Description: 重复的子字符串
 */
public class Solution_459 {
    public boolean repeatedSubstringPattern(String s) {

        boolean flag = false;

        char[] sCharArray = s.toCharArray();

        for (int length = s.length()/2; length > 0; length--) {
            flag = isSame(sCharArray, length) == true ? true : flag;
            if (flag){
                return flag;
            }
        }

        return false;
    }

    public boolean isSame(char[] chars, int sublength){
        // 保证当前子长度可以整除chars
        if (chars.length%sublength != 0){
            return false;
        }
        int Idx = 0;
        while (Idx+2*sublength-1 < chars.length){
            for (int res = 0; res < sublength; res++) {
                if (chars[Idx+res] != chars[Idx+res+sublength]){
                    return false;
                }
            }
            Idx += sublength;
        }
        return true;
    }


    public static void main(String[] args) {
        Solution_459 solution459 = new Solution_459();
        System.out.println(solution459.repeatedSubstringPattern(
                "aabaaba"
        ));
    }


}
