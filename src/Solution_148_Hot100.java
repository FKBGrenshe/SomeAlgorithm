import java.util.List;

/**
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表
 * 链表中节点的数目在范围 [0, 5 * 10^4] 内
 * -105 <= Node.val <= 105
 */
public class Solution_148_Hot100 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        /*
        需排序指针指向下一个需要排序的Node
            指针左边是已经排序完成的
            指针右边是待排序的
         */
        ListNode prevIdx = head;
        ListNode sortedListHead = head;
        while (prevIdx.next != null){
            if (prevIdx.val > prevIdx.next.val){
                // 把待排序的Node先隔离出来，避免循环链表
                ListNode insertNode = prevIdx.next;
                prevIdx.next = insertNode.next;
                // 需要插入排序
                sortedListHead = insertIntoSortedNodeList(sortedListHead, insertNode, prevIdx);
            }else {
                prevIdx = prevIdx.next;
            }
        }
        return sortedListHead;
    }


    public ListNode insertIntoSortedNodeList(ListNode sortedListHead, ListNode insertNode, ListNode sortedListTail){

        if (sortedListHead.val > insertNode.val){
            insertNode.next = sortedListHead;
            return insertNode;
        }
        ListNode prevNode = sortedListHead;
        while (prevNode != sortedListTail){
            if (prevNode.val <= insertNode.val && prevNode.next.val > insertNode.val){
                insertNode.next = prevNode.next;
                prevNode.next = insertNode;
                break;
            }else {
                prevNode = prevNode.next;
            }
        }
        return sortedListHead;
    }


    public static void main(String[] args) {
        // 4,19,14,5,-3,1,8,5,11,15
        ListNode head = new ListNode(4);
        head.next = new ListNode(19);
        head.next.next = new ListNode(14);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(-3);
        head.next.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next.next.next = new ListNode(11);
        head.next.next.next.next.next.next.next.next.next = new ListNode(15);
        Solution_148_Hot100 solution_148_hot100 = new Solution_148_Hot100();
        ListNode listNode = solution_148_hot100.sortList(head);
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }



}
