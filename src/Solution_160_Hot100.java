/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution_160_Hot100 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 保证链表剩余长度相同
        int SizeA = 0, SizeB = 0;
        ListNode lengthNode = headA;
        while (lengthNode != null){
            lengthNode = lengthNode.next;
            SizeA++;
        }
        lengthNode = headB;
        while (lengthNode != null){
            lengthNode = lengthNode.next;
            SizeB++;
        }

        //
        ListNode curANode = headA;
        ListNode curBNode = headB;

        // 跳到两链表长度相等的最大位置
        boolean ABiggerThanB = SizeA > SizeB;
        int differ = ABiggerThanB ? SizeA - SizeB : SizeB -SizeA;
        if (ABiggerThanB){
            // 先把A中多余跳过
            for (int i = 0; i < differ; i++) {
                curANode = curANode.next;
            }
        }else{
            // 先把B中多余跳过
            for (int i = 0; i < differ; i++) {
                curBNode = curBNode.next;
            }
        }

//        if(SizeB > SizeA){
//            // ListA 改为 ListB
//            // 1. swap (lenA, lenB)
//            int tmpLen = SizeA;
//            SizeA = SizeB;
//            SizeB = tmpLen;
//            // 2. swap (curA, curB)
//            curANode = headB;
//            curBNode = headA;
//        }
//        int gap = SizeA - SizeB;
//        while (gap != 0){
//            curANode = curANode.next;
//            gap--;
//        }



        // 此处开始，两链条处于相同长度
        while (curANode != null){
            if(curANode==curBNode){
                return curANode;
            }
            curANode = curANode.next;
            curBNode = curBNode.next;
        }
        return null;

    }

    public static void main(String[] args) {

    }
}