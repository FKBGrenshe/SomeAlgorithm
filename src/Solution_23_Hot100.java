import java.util.List;

public class Solution_23_Hot100 {
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0){
            return null;
        }

        ListNode head = new ListNode(-1);
        ListNode tail = head;

        // 标识待插入的节点
        ListNode tempMinNode = null;
        // 标识是那个链表的头节点
        int minIndex = 0;
        int minValue = Integer.MAX_VALUE;
        // 每次从list中挑出最小的节点，然后加入到新链表中，直到所有节点都加入到新链表中。
        while (true){
            // 查找当前最小的头节点
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null){
                   if (lists[i].val < minValue){
                       minValue = lists[i].val;
                       minIndex = i;
                       tempMinNode = lists[minIndex];
                   }
                }
            }
            if (tempMinNode == null){
                break;
            }
            // 插入到新链表中
            tail.next = tempMinNode;
            // 下一次迭代做准备：1. tail指向下一个节点 2. lists中该链表头节点指向下一个节点 3. minValue重置为最大值, minIndex重置为0, tempMinNode重置为null
            tail = tail.next;
            lists[minIndex] = lists[minIndex].next;
            minValue = Integer.MAX_VALUE;
            minIndex = -1;
            tempMinNode = null;
        }
        return head.next;
    }

    public static void main(String[] args) {
        // lists = [[1,4,5],[1,3,4],[2,6]]
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1);
        lists[0].next = new ListNode(4);
        lists[0].next.next = new ListNode(5);
        lists[1] = new ListNode(1);
        lists[1].next = new ListNode(3);
        lists[1].next.next = new ListNode(4);
        lists[2] = new ListNode(2);
        lists[2].next = new ListNode(6);
        Solution_23_Hot100 solution_23_hot100 = new Solution_23_Hot100();
        solution_23_hot100.mergeKLists(lists);
        while (solution_23_hot100.mergeKLists(lists) != null){
            System.out.println(solution_23_hot100.mergeKLists(lists).val);
        }
    }
}
