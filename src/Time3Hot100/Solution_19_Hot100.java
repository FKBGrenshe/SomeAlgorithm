package Time3Hot100;

public class Solution_19_Hot100 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null){
            if (n == 1){
                return null;
            }else {
                return head;
            }
        }

        ListNode nextNidx = head;
        for (int i = 1; i < n; i++) {
            nextNidx = nextNidx.next;
        }

        ListNode curIdx = head;
        ListNode preIdx = null;

        while (nextNidx.next != null){
            preIdx = curIdx;

            curIdx = curIdx.next;
            nextNidx = nextNidx.next;
        }

        if (preIdx == null){
            head = head.next;
            return head;
        }
        preIdx.next = curIdx.next;
        return head;
    }


    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
//        root.next.next = new ListNode(3);
//        root.next.next.next = new ListNode(4);

        Solution_19_Hot100 solution19Hot100 = new Solution_19_Hot100();
        solution19Hot100.removeNthFromEnd(root, 2);
    }
}
