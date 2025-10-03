/**
 * @author fkbgr
 */
public class Solution_24_Hot100 {


    public static ListNode swapPairs(ListNode head) {

        // todo 有效性检查
        if (head == null || head.next ==null){
            return head;
        }


        // todo 两两交换
        ListNode t1 = head, t2 = t1.next;
        // 是否是第一次交换，如果是则需要重设头节点
        // 交换t1 & t2
        t1.next = t2.next;
        t2.next = t1;
        head = t2;
        // 记下交换后t1的位置，以便下一次连接交换后的t2
        ListNode t1prev = t1;
        // t1 & t2前挪
        t1 = t1.next;
        t2 = t1.next;

        while (t2 != null){
            // 交换t1 & t2
            t1.next = t2.next;
            t2.next = t1;
            // 连接交换后的t2
            t1prev.next = t2;
            // t1prev 记下交换后t1的位置，以便下一次连接交换后的t2
            t1prev = t1;
            // t1 & t2前挪
            if (t1.next == null || t1.next.next ==null){
                break;
            }
            t1 = t1.next;
            t2 = t1.next;
        }
        return head;



    }


    public static void main(String[] args) {

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2); n1.next = n2;
        ListNode n3 = new ListNode(3); n2.next = n3;
        ListNode n4 = new ListNode(4); n3.next = n4;
        swapPairs(n1);

    }
}
