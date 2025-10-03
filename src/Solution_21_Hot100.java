import java.util.List;

public class Solution_21_Hot100 {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null || list2 == null){
            if(list1 != null){
                return list1;
            }else if (list2 != null){
                return list2;
            }else {
                return null;
            }
        }

        // list1为基，list2主挪动
        ListNode t1Node = list1; ListNode nxt1Node = list1.next;
        ListNode t2Node = list2; ListNode nxt2Node = list2.next;


        if(nxt1Node == null && nxt2Node == null){
            if(t2Node.val > t1Node.val){
                t1Node.next = t2Node;
                return t1Node;
            }else {
                t2Node.next = t1Node;
                return t2Node;
            }
        }


        if(nxt1Node == null && nxt2Node != null){
            // list1 & list2 交换
            ListNode tmp = list1;
            list1 = list2;
            list2 = tmp;
            // list1为基，list2主挪动
             t1Node = list1;  nxt1Node = list1.next;
             t2Node = list2;  nxt2Node = list2.next;
        }
        if(nxt1Node != null && nxt2Node == null){
            if(t2Node.val<t1Node.val){
                t2Node.next=t1Node;
                return list2;
            }
            while (nxt1Node != null){
                if (t2Node.val < nxt1Node.val){
                    // 正常插入，直接返回
                    t1Node.next = t2Node;
                    t2Node.next = nxt1Node;
                    return list1;
                }else {
                    t1Node = nxt1Node;
                    nxt1Node = nxt1Node.next;
                }
            }
            // 查到最后了，还是不行，直接插在最右侧
            t1Node.next = t2Node;
            return list1;
        }

        // 判断谁是地基：哪个list第一个元素最小，哪个是地基
        if(t1Node.val>t2Node.val){
            // 更换地基
            // list1 & list2 交换
            ListNode tmp = list1;
            list1 = list2;
            list2 = tmp;
            // list1为基，list2主挪动
            t1Node = list1;  nxt1Node = list1.next;
            t2Node = list2;  nxt2Node = list2.next;
        }

        while (nxt2Node != null){
            if(nxt1Node.next == null){
                // 如果nxt1.next == null -- 说明地基没有更大的了，要么往nxt左边放，放不下全塞到右边去
                while (nxt2Node != null){
                    if(t2Node.val > nxt1Node.val){
                        // 说明地基没有更大的了，将后续全塞到右边去
                        nxt1Node.next = t2Node;
                        return list1;
                    }
                    // 正常往左边插入,地基右边界不挪动
                    t1Node.next = t2Node;
                    t2Node.next = nxt1Node;
                    t1Node = t2Node;
                    t2Node = nxt2Node;
                    nxt2Node = nxt2Node.next;
                }
                // 往左插到list2剩最后一个了
                if (t2Node.val > nxt1Node.val){
                    nxt1Node.next = t2Node;
                }else {
                    // 正常往左边插入,地基右边界不挪动
                    t1Node.next = t2Node;
                    t2Node.next = nxt1Node;
                }
                return list1;
            }

            if(nxt1Node.val<t2Node.val){
                // 地基范围太小，挪动地基
                t1Node = t1Node.next;
                nxt1Node = nxt1Node.next;
            }else {
                // 地基范围合适，插入节点,地基右边界不挪动
                t1Node.next = t2Node;
                t2Node.next = nxt1Node;
                t1Node = t2Node;
                t2Node = nxt2Node;
                nxt2Node = nxt2Node.next;
            }
        }

        if(nxt1Node.next != null){
            // list2插入只剩最后一个，且还没有到达list1右边界
            // nxt1Node.next != null nxt2Node.next == null
            // 往左插到list2剩最后一个了
            while (t2Node.val > nxt1Node.val){
                if(nxt1Node.next != null){
                    t1Node = nxt1Node;
                    nxt1Node = nxt1Node.next;
                    continue;
                }else {
                    nxt1Node.next = t2Node;
                    return list1;
                }
            }
            // 正常往左边插入,地基右边界不挪动
            t1Node.next = t2Node;
            t2Node.next = nxt1Node;
            return list1;
        }
        return list1;
    }

    public static void main(String[] args) {
        /*ListNode red_one = new ListNode(-8);
        ListNode red_two = new ListNode(1);
        ListNode red_four = new ListNode(6);
        red_one.next = red_two;red_two.next = red_four;
        ListNode green_one = new ListNode(-5);
        ListNode green_three = new ListNode(4);
        ListNode green_four = new ListNode(8);
        green_one.next = green_three; green_three.next = green_four;
        mergeTwoLists(red_one,green_one);*/

        ListNode list2 = new ListNode(-9);
        ListNode list1_1 = new ListNode(1);
        ListNode list1_2 = new ListNode(3);
        ListNode list1_4 = new ListNode(6);
        list1_1.next = list1_2;list1_2.next=list1_4;
        mergeTwoLists(list1_1,list2);


        /*ListNode list1_v2 = new ListNode(-2);
        ListNode list1_5 = new ListNode(5);
        list1_v2.next = list1_5;

        ListNode list2_v9 = new ListNode(-9);
        ListNode list2_v6 = new ListNode(-6);
        ListNode list2_v3 = new ListNode(-3);
        ListNode list2_v1 = new ListNode(-1);
        ListNode list2_1 = new ListNode(1);
        ListNode list2_6 = new ListNode(6);
        list2_v9.next=list2_v6;list2_v6.next=list2_v3;list2_v3.next=list2_v1;list2_v1.next=list2_1;list2_1.next=list2_6;
        mergeTwoLists(list1_v2,list2_v9);*/





    }
}
