import org.w3c.dom.ls.LSException;

public class Solution_2_Hot100 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode t1Node = l1;
        ListNode t2Node = l2;

        ListNode sumArray = new ListNode(-1);
        ListNode sump = sumArray;

        // 进位符
        boolean flag = false;

        int val1,val2;

        while (t1Node != null || t2Node != null){
            if(t1Node != null){
                 val1 = t1Node.val;
            }else {
                 val1 = 0;
            }

            if(t2Node != null){
                 val2 = t2Node.val;
            }else {
                 val2 = 0;
            }

            // 该位置是否进位
            if(flag){
                val1 ++;
                // 重置进位符
                flag = false;
            }
            // 该位置值
            int sum = val1 + val2;
            // 判断下一位有无进位
            if (sum >= 10){
                flag = true;
            }
            sum = sum%10;

            // 赋值
            sump.next = new ListNode(sum);
            sump = sump.next;


            // 下一位
            if(t1Node != null){t1Node = t1Node.next;}
            if(t2Node != null){t2Node = t2Node.next;}
        }
        if(flag){
            sump.next = new ListNode(1);
            sump = sump.next;
        }
        return sumArray.next;
    }

    public static void main(String[] args) {
        ListNode red_one = new ListNode(1);
        ListNode red_two = new ListNode(2);
        ListNode red_four = new ListNode(4);
        red_one.next = red_two;red_two.next = red_four;
        ListNode green_one = new ListNode(1);
        ListNode green_three = new ListNode(3);
        ListNode green_four = new ListNode(4);
        green_one.next = green_three; green_three.next = green_four;

        addTwoNumbers(red_one,green_one);

    }
}
