package Time3Hot100;

public class Solution_206_Hot100 {

    // 1-> 2-> 3-> 4
    // 1<- 2<- 3<- 4

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        //pre  cur -> nxt
        ListNode prebackup = head;
        ListNode curbackup = prebackup.next;
        ListNode nextbackup = curbackup.next;

        prebackup.next = null;
        while (curbackup != null){
            // reverse
            curbackup.next = prebackup;
            // next round
            prebackup = curbackup;
            curbackup = nextbackup;
            if (nextbackup != null){
                nextbackup = nextbackup.next;
            }else {
                nextbackup = null;
            }
        }
        return prebackup;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
//        ListNode listNode2 = new ListNode(2);
//        ListNode listNode3 = new ListNode(3);

//        listNode1.next = listNode2;
//        listNode2.next = listNode3;

        Solution_206_Hot100 solution206Hot100 = new Solution_206_Hot100();
        ListNode listNode = solution206Hot100.reverseList(listNode1);
        System.out.println(listNode);
    }
}
