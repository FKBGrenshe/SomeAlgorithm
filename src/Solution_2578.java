import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-04-15
 * @Description: 2578最小和分割
 */
public class Solution_2578 {
    public int splitNum(int num) {

        int[] numbers = new int[10];
        char[] charArray = String.valueOf(num).toCharArray();

        int count = 0;
        for (char c : charArray) {
            int value = c - '0';
            if (value!=0)
                count++;
            numbers[value] ++;
        }

        // 0 不用考虑
        int length = count/2;

        char[] num2chars = new char[length];
        char[] num1chars;
        if (count%2 != 1){
            num1chars = new char[length];
        }else {
            num1chars = new char[length+1];
        }
        Arrays.fill(num1chars, 'a');
        Arrays.fill(num2chars, 'a');



        int curNumber = 1;
        for (int i = 0; i < length && curNumber < 10; ) {
            while (numbers[curNumber]!=0 && i< length){
                if (num1chars[i] == 'a'){
                    num1chars[i] = (char)(curNumber + '0');
                    numbers[curNumber]--;
                }
                else if (num2chars[i] == 'a'){
                    num2chars[i] = (char)(curNumber + '0');
                    numbers[curNumber]--;
                }else {
                    i++;
                }
            }
            curNumber++;
        }

        if (num1chars.length > length){
            for (int number = 9; number > 0; number--) {
                if(numbers[number] != 0) {
                    num1chars[length] = (char) (number + '0');
                    break;
                }
            }

        }


        int finalValue;
        if (num2chars.length != 0){
            finalValue = Integer.valueOf(String.copyValueOf(num1chars)) + Integer.valueOf(String.copyValueOf(num2chars));
        }else {
            finalValue = Integer.valueOf(String.copyValueOf(num1chars));
        }



        return finalValue;
    }

    public static void main(String[] args) {
        Solution_2578 solution2578 = new Solution_2578();
        System.out.println(solution2578.splitNum(20));
    }
}
