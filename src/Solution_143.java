import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2026-02-07
 * @Description: 重排链表
 */
public class Solution_143 {

    ArrayList<ListNode> copy = new ArrayList<>(50000);

    public void reorderList(ListNode head) {
        // 遍历填充copy数组
        ListNode temp = head;

        ListNode listNodehead = new ListNode(-1);
        listNodehead.next = head;
        copy.add(listNodehead);
        while (temp.next != null){
            ListNode listNode = new ListNode(-1);
            listNode.next = temp.next;
            copy.add(listNode);
            temp = temp.next;
        }

        // 双指针
        int left = 0, right = copy.size()-1;

        int times = 0;
        if (copy.size()%2==0){
            times = copy.size()/2-1;
        }else {
            times = copy.size()/2;
        }

        for(;times>0;times--){
            insertRight2Left(left,right);
            left++;
            right--;
        }

        // 当前tailNode->null 收尾
        if (copy.size()%2==0){
            copy.get(left).next.next.next = null;
        }else {
            copy.get(left).next.next = null;
        }


    }

    // 将right节点的node，插入到left+1的位置
    private void insertRight2Left(int left, int right) {

        ListNode headPrevNode = copy.get(left);
        ListNode headNextNode = copy.get(left+1);
        ListNode tailNode = copy.get(right);

        // headPrevNode -> tailNode -> headNextNode
        headPrevNode.next.next = tailNode.next;
        tailNode.next.next = headNextNode.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);


        Solution_143 solution143 = new Solution_143();

        solution143.forListNodes(head);

        solution143.reorderList(head);

        solution143.forListNodes(head);

    }

    public void forListNodes(ListNode curNode){

        StringBuilder stringBuilder = new StringBuilder();
        while (curNode != null){
            stringBuilder.append("->"+curNode.val);
            curNode = curNode.next;
        }

        System.out.println(stringBuilder.toString());
    }

}




/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

//class ListNode {
//    int val;
//    ListNode next;
//    ListNode() {}
//    ListNode(int val) { this.val = val; }
//    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//}