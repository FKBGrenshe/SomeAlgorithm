import java.util.ArrayList;
import java.util.List;

public class Solution_234_Hot100 {
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> val_list = new ArrayList<>();
        while (head != null){
            val_list.add(head.val);
            head = head.next;
        }
        int size = val_list.size();
        for (int i = 0; i < size/2; i++) {
            if(!(val_list.get(i).equals(val_list.get(size-i-1)))){
                return false;
            }
        }
        return true;
    }
}
