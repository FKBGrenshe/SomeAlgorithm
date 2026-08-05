//package Time3Hot100;
///**
// * Definition for singly-linked list.
// * public class ListNode {
// *     int val;
// *     ListNode next;
// *     ListNode(int x) {
// *         val = x;
// *         next = null;
// *     }
// * }
// */
//public class Solution160_Hot100 {
//
//
//
//
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//
//        ListNode reverseA = new ListNode(-1);
//        ListNode reverseB = new ListNode(-1);
//
//        ListNode tailA = doFindLastNode(headA, reverseA);
//        ListNode tailB = doFindLastNode(headB, reverseB);
//
//        if (!equalnode(tailA, tailB)){
//            return null;
//        }
//
//        backUpFind(reverseA, reverseB);
//
//    }
//
//    private ListNode doFindLastNode(ListNode headA, ListNode reverseTempHead) {
//        while (headA.next != null){
//            headA = headA.next;
//
//            new ListNode()
//
//        }
//        return headA;
//    }
//
//    public boolean equalnode(ListNode a, ListNode b){
//        if (a == null || b == null){
//            return false;
//        }
//
//        return a == b;
//    }
//}
