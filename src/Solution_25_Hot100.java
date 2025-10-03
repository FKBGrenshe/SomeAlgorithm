public class Solution_25_Hot100 {
    public ListNode reverseKGroup(ListNode head, int k) {

        // 虚拟头节点
        ListNode finalHead = new ListNode(-1);
        finalHead.next = head;
        ListNode curPreNode = finalHead;
        ListNode curHeadNoe = head;
        ListNode curTailNode = head;
        if (k == 1){
            // 全部不动
            return finalHead.next;

        }else {
            while (true){
                for (int i = 0; i < k-1; i++) {
                    if (curTailNode.next != null){
                        curTailNode = curTailNode.next;
                    }else {
                        // 说明已经到了链表的尾部，直接返回
                        return finalHead.next;
                    }
                }
                reverseK(curPreNode, curHeadNoe, curTailNode);
                if (curHeadNoe.next == null){
                    return finalHead.next;
                }
                curPreNode = curHeadNoe;
                curHeadNoe = curPreNode.next;
                curTailNode = curHeadNoe;
            }
        }

    }

    public void reverseK(ListNode preNode, ListNode headNode, ListNode tailNode){

        if (headNode.next == tailNode){
            preNode.next = tailNode;
            headNode.next = tailNode.next;
            tailNode.next = headNode;
            return;
        }

        // 暂存当前k个节点反转后需要连接到链表上的前驱和后继节点，并断开这k个节点的连接
        ListNode linkPre = preNode;
        ListNode linkTail = tailNode.next;
        linkPre.next = null;
        tailNode.next = null;
        ///////////////////////////
        // 开始反转
        ListNode pre = linkPre;
        ListNode cur = headNode;
        ListNode nxt = cur.next;
        while (nxt != null){
            cur.next = pre;
            pre = cur;
            cur = nxt;
            nxt = nxt.next;
        }
        // 结尾处理
        cur.next = pre;
        ///////////////////////////
        // 将k个节点重新放回链表
        // 因为反转了，因此headNode和tailNode就已经头成尾，尾成头
        linkPre.next = tailNode;
        headNode.next = linkTail;
    }


    public static void main(String[] args) {
        Solution_25_Hot100 solution25Hot100 = new Solution_25_Hot100();
        //[1,2,3,4,5]
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);

        System.out.println(solution25Hot100.reverseKGroup(
                head,
                2
        ));
    }
}
