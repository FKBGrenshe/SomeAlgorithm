import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-04-28
 * @Description:
 */
public class Solution_1456 {

    HashSet<Character> aeiou = new HashSet<>(5);


    public int maxVowels(String s, int k) {

        aeiou.add('a');
        aeiou.add('e');
        aeiou.add('i');
        aeiou.add('o');
        aeiou.add('u');

        boolean[] isAeiou = new boolean[s.length()];
        //Arrays.fill(isAeiou,false);

        int MaxAeiouNumbers = 0;
        int curAeiouNumbers = 0;
        int start = 0, end = 0;

        for (start = 0; start < k; start++) {
            if (aeiou.contains(s.charAt(start))){
                curAeiouNumbers++;
            }
        }
        if (MaxAeiouNumbers < curAeiouNumbers){
            MaxAeiouNumbers = curAeiouNumbers;
        }

        for (; start < s.length(); start++,end++) {
            if (aeiou.contains(s.charAt(start))){
                curAeiouNumbers++;
            }
            if (aeiou.contains(s.charAt(end))){
                curAeiouNumbers--;
            }
            if (MaxAeiouNumbers < curAeiouNumbers){
                MaxAeiouNumbers = curAeiouNumbers;
                if (MaxAeiouNumbers == k){
                    return k;
                }
            }
        }



        return MaxAeiouNumbers;
    }

    public static void main(String[] args) {
        Solution_1456 solution1456 = new Solution_1456();

        int k = 3;
        String s = "abciiidef";

        System.out.println(solution1456.maxVowels(
                s,
                k
        ));
    }



}
