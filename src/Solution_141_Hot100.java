public class Solution_141_Hot100 {
    public static boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        if(head == head.next){
            return true;
        }
        ListNode fastNode = head.next;
        ListNode slowNode = head;
        /*if(fastNode.next == slowNode){
            return true;
        }*/
        while (fastNode.next != null && fastNode.next.next != null ){
            if(fastNode == slowNode) {
                return true;
            }
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = one;

        System.out.println(hasCycle(one));

    }
}
