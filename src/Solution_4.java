/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-04-15
 * @Description: 寻找两个正序数组的中位数
 */
public class Solution_4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = (nums1.length + nums2.length)/2;
        int p1 =0, p2=0;
        int curFlag = 0;

        int curCount=0;
        while(curCount < length){
            if(nums1[p1] <= nums2[p2]){
                p1++;
                curFlag = 1;
            }else{
                p2++;
                curFlag = 2;
            }
            curCount++;
        }

        double avg;

        if (curFlag == 1){
            avg = nums1[p1];
            p1++;
        }else{
            avg = nums2[p2];
            p2++;
        }


        if((nums1.length + nums2.length)%2 != 1){

            if (p1 < nums1.length && p2 < nums2.length){
                if(nums1[p1] <= nums2[p2]){
                    avg += nums1[p1];
                }else{
                    avg += nums2[p2];
                }
            }else if (p2 < nums2.length){
                avg += nums2[p2];
            }else {
                avg += nums1[p1];
            }
            avg /= 2;
        }
        return avg;

    }

    public static void main(String[] args) {
        Solution_4 solution4 = new Solution_4();
        System.out.println(solution4.findMedianSortedArrays(
                new int[]{1,3},
                new int[]{2, 2}
        ));
    }
}
