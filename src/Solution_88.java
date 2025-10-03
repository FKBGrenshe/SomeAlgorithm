import com.sun.source.tree.WhileLoopTree;

import java.util.Arrays;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-04-21
 * @Description: 合并两个有序数组
 */
public class Solution_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        if (nums2.length == 0) {
            return;
        }

        int[] org1 = Arrays.copyOf(nums1, nums1.length);

        int num1IdX = 0;
        int num2IdX = 0;
        for (int i = 0; i < org1.length; i++) {

            if (num2IdX >= nums2.length){
                while (i < org1.length){
                    nums1[i] = org1[num1IdX];
                    num1IdX++;
                    i++;
                }
            }else{
                if (org1[num1IdX] < nums2[num2IdX] && num1IdX < m){
                    nums1[i] = org1[num1IdX];
                    num1IdX++;
                }else {
                    nums1[i] = nums2[num2IdX];
                    num2IdX++;
                }
            }

        }

//
//
//
//        for (int num2Idx = 0; num2Idx < nums2.length; num2Idx++) {
//            // 将数组1的指针移动到第一个比数组2当前值大的地方
//            while (nums1[num1IdX] < nums2[num2Idx] && num1IdX < m+num2Idx) {
//                num1IdX++;
//            }
//            // 将数组1中大于nums2[2IDx]位置全部后移
//            for (int i = nums1.length - 1; i >= num1IdX; i--) {
//                nums1[i] = nums1[i - 1];
//            }
//            nums1[num1IdX] = nums2[num2Idx];
//        }

        System.out.println(Arrays.toString(nums1));
    }

    public void mergeVer2(int[] nums1, int m, int[] nums2, int n) {
        int idx1 = m-1 ,idx2 = n-1;

        for (int i = nums1.length - 1; i >= 0; i--) {

            if (idx2 < 0){
                return;
            } else if (idx1 < 0) {
                for (int i1 = i; i1 >= 0; i1--) {
                    nums1[i1] = nums2[idx2];
                    idx2--;
                }
                return;
            }else {
                // 倒序插入
                if (nums1[idx1] >= nums2[idx2]){
                    nums1[i] = nums1[idx1];
                    idx1--;
                }else {
                    nums1[i] = nums2[idx2];
                    idx2--;
                }
            }
        }
        System.out.println("11");
    }


    public static void main(String[] args) {
        Solution_88 solution88 = new Solution_88();
        solution88.mergeVer2(
                new int[]{4,5,6,0,0,0},
                3,
                new int[]{1,2,3},
                3
        );
    }
}
