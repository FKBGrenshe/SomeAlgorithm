package Time3Hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_142_Hot100 {

    List<ListNode> slow = new ArrayList<>();
    Map<ListNode, Object> slowmap = new HashMap<>();

    public ListNode detectCycle(ListNode head) {

        ListNode cur = head;
        while (cur != null){
            if (slowmap.containsKey(cur)){
                return cur;
            }
            slowmap.put(cur, null);
            cur = cur.next;
        }
        return null;
    }


    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = root;

        Solution_142_Hot100 solution142Hot100 = new Solution_142_Hot100();
        System.out.println(solution142Hot100.detectCycle(root));
    }
}
