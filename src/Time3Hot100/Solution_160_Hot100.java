package Time3Hot100;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_160_Hot100 {

    Map<ListNode, Object>  amap = new HashMap<>();

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        // insert into map
        ListNode cura = headA;
        while (cura != null){
            amap.put(cura, null);
            cura = cura.next;
        }


        ListNode curb = headB;
        boolean findflag = false;
        while (curb != null){
            if (amap.containsKey(curb)){
                return curb;
            }
            curb = curb.next;
        }
        return null;
    }


    public static void main(String[] args) {
        ListNode aroot = new ListNode(1);
        aroot.next = new ListNode(2);

        ListNode broot = new ListNode(2);
        broot.next = aroot.next;

        Solution_160_Hot100 solution160Hot100 = new Solution_160_Hot100();
        System.out.println(solution160Hot100.getIntersectionNode(aroot, broot));
    }

}
