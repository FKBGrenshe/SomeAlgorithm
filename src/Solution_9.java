import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution_9 {

    static public boolean isPalindrome(int x) {
        if(x == 0){
            return true;
        }
        if(x < 0){
            return false;
        }

        List<Integer> arr = new ArrayList<Integer>();

        for(; x!= 0;){
            int y = x % 10;
            arr.add(y);
            x /= 10;
            System.out.println(y);
        }

//        for(int ten_i = 10; x != 0; ten_i *=10) {
//            int y = x % ten_i;
//            arr.add(y / (ten_i/10));
////            System.out.println(y / (ten_i/10));
//            x -= y;
//
//        }
        int i = 0;
        int j = arr.toArray().length-1;
        boolean flag = true;
        for(; i < j; j--){
            if(arr.get(j).equals(arr.get(i))){
                i++;
                continue;
            }else {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(1231));
    }
}