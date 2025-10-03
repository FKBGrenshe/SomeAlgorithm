import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution_9_ver1 {

    static public boolean isPalindrome(int x) {
        if(x == 0){
            return true;
        }
        if(x < 0){
            return false;
        }

        List<Integer> arr = new ArrayList<Integer>();

        int x_back = x;

        for(; x!= 0;){
            int y = x % 10;
            arr.add(y);
            x /= 10;
            System.out.println(y);
        }

        int verse_x = 0;

        for(Integer i:arr){
            verse_x *= 10;
            verse_x += i.intValue();
        }
        if(x_back == verse_x){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(12321));
    }
}