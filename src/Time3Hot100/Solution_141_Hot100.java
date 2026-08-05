package Time3Hot100;

import java.util.ArrayList;
import java.util.List;

public class Solution_141_Hot100 {


    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }

        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != null){

            if (fast == slow || fast.next == slow){
                return true;
            }

            fast = fast.next;
            if (fast == null){
                return false;
            }else{
                fast = fast.next;
            }
            slow = slow.next;
        }
        return false;
    }

}
