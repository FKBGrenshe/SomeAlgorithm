public class Solution_142_Hot100 {

    public static ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        if(head == head.next){
            return head;
        }
        ListNode fastNode = head;
        ListNode slowNode = head;
        while (fastNode.next != null && fastNode.next.next != null ){
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
            if(fastNode == slowNode) {
                // 说明遇上了 todo 再设置一个tmpNode
                return calDistance(head, slowNode);
            }
        }
        return null;
    }

    private static ListNode calDistance(ListNode head, ListNode slowNode) {
        ListNode tmpNode = head;
        while (tmpNode != slowNode){
            tmpNode = tmpNode.next;
            slowNode = slowNode.next;
        }
        return tmpNode;
    }


    public static void main(String[] args) {
        ListNode zero = new ListNode(0);
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        /*one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = one;*/
        three.next = two;
        two.next = zero;
        zero.next = four;
        four.next = two;

        detectCycle(three);

    }

}
