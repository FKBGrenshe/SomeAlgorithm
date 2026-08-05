package Time3Hot100;

import java.util.List;

public class Solution_21_Hot100 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null){
            return list2;
        }if (list2 == null){
            return list1;
        }

        ListNode switchlist;
        if (list1.val >= list2.val){
            switchlist = list2;
            list2 = list1;
            list1 = switchlist;
        }

        ListNode temp1 = list1;
        ListNode pre1 = temp1;
        ListNode temp2 = list2;


        while (temp1 != null && temp2 != null){

            if (temp1.next != null){
                if (temp1.val <= temp2.val && temp2.val <= temp1.next.val){
                    ListNode needinsert = temp2;
                    temp2 = temp2.next;

                    needinsert.next = temp1.next;
                    temp1.next = needinsert;
                }
                pre1 = temp1;
                temp1 = temp1.next;
            }else {
                if (temp1.val <= temp2.val ){
                    temp1.next = temp2;
                    return list1;
                }else {
                    ListNode needinsert = temp2;
                    temp2 = temp2.next;

                    needinsert.next = temp1.next;
                    temp1.next = needinsert;
                }
            }
        }

        if (temp2 != null){
            pre1.next = temp2;
        }
        return list1;
    }

    public static void main(String[] args) {

//        ListNode list1 = new ListNode(1);
//        list1.next = new ListNode(2);
//        list1.next.next = new ListNode(4);
//        ListNode list2 = new ListNode(1);
//        list2.next = new ListNode(3);
//        list2.next.next = new ListNode(4);


        ListNode list1 = new ListNode(2);
        ListNode list2 = new ListNode(1);

        Solution_21_Hot100 solution21Hot100 = new Solution_21_Hot100();
        System.out.println(solution21Hot100.mergeTwoLists(
                list1, list2
        ));
    }
}
