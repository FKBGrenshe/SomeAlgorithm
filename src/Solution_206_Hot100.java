public class Solution_206_Hot100 {
    public static ListNode reverseList(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }
        // todo
        if(head.next.next == null){
            ListNode prenode = head.next;
            prenode.next = head;
            head.next = null;
            return prenode;

        }

        ListNode nxtNode = head.next.next;
        ListNode tmpNode = head.next;
        ListNode preNode = head;

        preNode.next = null;
        while (true){
            tmpNode.next = preNode;
            preNode = tmpNode;
            tmpNode = nxtNode;
            if(nxtNode.next != null){
                nxtNode = nxtNode.next;
            }else {
                tmpNode.next = preNode;
                break;
            }
        }

        return tmpNode;
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

        reverseList(one);
        System.out.println();


    }
}


/*if(head == null || head.next == null){
            return head;
        }

        ListNode curNode = head;
        ListNode tmpNode = head.next;
        ListNode preNode = null;

        while (curNode.next != null) {
            curNode.next = preNode;
            preNode = curNode;
            curNode = tmpNode;
            tmpNode = tmpNode.next;
        }
        curNode.next = preNode;
        preNode = curNode;
        curNode = tmpNode;

        return preNode;*/
