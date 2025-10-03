import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.function.Function;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-04-18
 * @Description: 两数之和
 */
public class Solution_1 {
    // 2147483647
    public int[] twoSum(int[] nums, int target) {

        int[] another = new int[nums.length];

        //<value, index>
        HashMap<Integer, Integer> record = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (record.containsKey(target-nums[i])){
                return new int[]{record.get(target-nums[i]),i};
            }else {
                record.put(nums[i],i);
            }
        }
        throw new IllegalArgumentException("");
    }

    public static void main(String[] args) {
        Solution_1 solution1 = new Solution_1();
        int[] ints = solution1.twoSum(
                new int[]{3, 4, 3},
                6);
        System.out.println(Arrays.toString(ints));
    }

    public int[] reverseBookList(ListNode head) {

        if(head == null){
            return new int[]{};
        }
        if (head.next != null){
            return new int[]{head.val};
        }
        if(head.next.next == null){
            return new int[]{head.next.val, head.val};
        }

        // null 1-> 2->3
        // null<-1 2->3
        //      pre
        // pre cur nxt
        // cur.nxt = pre
        // pre = cur, cur = nxt, nxt = nxt.next
        int count = 0;
        ListNode cur = head;
        ListNode pre = null;
        ListNode nxt = cur.next;

        while(cur != null){
            count++;
            cur.next = pre;
            pre = cur;
            cur = nxt;
            nxt = nxt.next;
        }


        ListNode temp = pre;
        int[] ansLsit = new int[count];
        for (int i = 0; i < ansLsit.length; i++) {
            ansLsit[i] = temp.val;
            temp = temp.next;
        }


        return ansLsit;


    }


}
