import java.util.ArrayList;
import java.util.List;

public class Solution_9_TrueAnswer {
    static public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int revertNumber = 0;

        while(x > revertNumber){
            revertNumber = revertNumber*10 + x%10;
            x /= 10;
        }

        if(x == revertNumber || x == revertNumber/10){
            return true;
        }
        else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(12321));
    }
}
