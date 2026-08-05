//package Time3Hot100;
//
//public class Solution_2_Hot100 {
//
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//
//        int val1 = parse(l1);
//        int val2 = parse(l2);
//
//        int lenval1 = getlen(val1);
//        int lenval2 = getlen(val2);
//
//        if (lenval1 < lenval2){
//            int res = lenval2 - lenval1;
//            for (int i = 0; i < res; i++) {
//                val1 *= 10;
//            }
//        }else if (lenval2 < lenval1){
//            int res = lenval1 - lenval2;
//            for (int i = 0; i < res; i++) {
//                val2 *= 10;
//            }
//        }
//        int val3 = val1+val2;
//
//        return buildLink(val3);
//
//    }
//
//    private int getlen(int val1) {
//        int len = 0;
//        while (val1 != 0){
//            len++;
//            val1 /= 10;
//        }
//        return len;
//    }
//
//    private int parse(ListNode l1) {
//        int len = 1;
//        ListNode cur = l1;
//        while (cur != null){
//            cur = cur.next;
//            len *= 10;
//        }
//        len /= 10;
//        int res = 0;
//        cur = l1;
//        while (cur != null){
//            res += cur.val * len;
//            cur = cur.next;
//            len /= 10;
//        }
//        return res;
//    }
//
//    private ListNode buildLink(int val3) {
//        ListNode cur = new ListNode(val3%10);
//        ListNode head = cur;
//        val3 /= 10;
//        while (val3 != 0 ){
//            int res = val3 % 10;
//            val3 /= 10;
//            ListNode nxt = new ListNode(res);
//            cur.next = nxt;
//            cur = cur.next;
//        }
//        return head;
//    }
//
//
//    public static void main(String[] args) {
//
//        ListNode list1 = new ListNode(2);
//        list1.next = new ListNode(4);
//        list1.next.next = new ListNode(9);
//        ListNode list2 = new ListNode(5);
//        list2.next = new ListNode(6);
//        list2.next.next = new ListNode(4);
//        list2.next.next.next = new ListNode(9);
//
//
//        Solution_2_Hot100 solution2Hot100 = new Solution_2_Hot100();
//        System.out.println(solution2Hot100.addTwoNumbers(list1, list2));
//    }
//
//}
