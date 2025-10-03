import java.util.List;

public class Solution_19_Hot100 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fastNode = head;

        for (int i = 0; i < n; i++) {
            fastNode = fastNode.next;
        }

        if (fastNode == null){
            // fastNode 为null 表明需要删除的就是头节点
            return head.next;
        }else {
            fastNode = fastNode.next;
            ListNode slowNode = head;
            /*if (fastNode == null){
                // 说明队列已经走完了，该删了
                slowNode.next = fastNode;
                return head;
            }*/
            // 删除的不是头节点
            while (fastNode != null){
                // 找到了需要删除的节点的前一个节点
                slowNode = slowNode.next;
                fastNode = fastNode.next;
            }
            // slowNode -> needDeleteNode -> fastNode -> null
            slowNode.next=slowNode.next.next;
            return head;

        }
    }
    public static void main(String[] args) {
        ListNode h = new ListNode(1);
        ListNode h1 = new ListNode(2);h.next=h1;
//        ListNode h2 = new ListNode(3); h1.next=h2;
//        ListNode h3 = new ListNode(4); h2.next=h3;
//        ListNode h4 = new ListNode(5); h3.next = h4;
        removeNthFromEnd(h,1);
    }

}
