package Time3Hot100;

import java.util.ArrayList;
import java.util.List;

public class Solution_234_Hot100 {

    List<Integer> arr = new ArrayList<>();

    public boolean isPalindrome(ListNode head) {

        ListNode curnode = head;
        while (curnode != null){
            arr.add(curnode.val);
            curnode = curnode.next;
        }

        return check();

    }

    private boolean check(){
        int left = 0;
        int right = arr.size()-1;

        while (left < right){

            if (arr.get(left) != arr.get(right)){
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
