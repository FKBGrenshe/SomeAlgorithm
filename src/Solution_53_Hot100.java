public class Solution_53_Hot100 {


    public static void main(String[] args) {

        int[] nums = new int[]{
                /*-2,1,-3,4,-1,2,1,-5,4*/
//                5,4,-1,7,8
                -2,-1
        };

        System.out.println(maxSubArray(nums));


    }



    public static int maxSubArray(int[] nums) {
//################################################

        // todo 有效性检查
        if (nums.length <= 1){
            return nums[0];
        }

        // todo 正常流程
        int begin = findBegin(true,-1,nums);
        if (begin == -1){
            // 整个数组全是负数 -- todo 这种情况下头一个数也不一定是最大值
            return nums[0];
        }
        int sum = nums[begin];
        int maxsum = sum;

        // 开始向后查找
        int end = begin+1;
        while (end < nums.length) {
            sum += nums[end];
            // 判断是否大于当前最大和
            if (sum > maxsum){
                maxsum = sum;
            }
            // 如果当前和小于0
            if (sum <= 0){
                begin = findBegin(false,end,nums);
                if (begin == -1){
                    return maxsum;
                }else {
                    end = begin+1;
                    sum = nums[begin];
                    if (sum > maxsum){
                        maxsum = sum;
                    }
                    continue;
                }
            }
            end++;
        }
        return maxsum;
//################################################
    }

    public static int findBegin(boolean firstTime, int end, int[] nums){
        if (firstTime){
            int begin = 0;
            // 第一次找begin
            int maxValue = nums[0];
            // 找到第一个正数
            while (nums[begin] <= 0){
                if (maxValue < nums[begin]){
                    maxValue = nums[begin];
                }
                if (begin < nums.length-1){
                    begin++;
                }else {
                    // 整个数组全是负数
                    // 将nums[0]置为找到的该数组的最大值
                    nums[0] = maxValue;
                    return -1;
                }
            }
            return begin;
        }else {
            // 不是第一次找, 要基于end的位置找
            if (end+1 >= nums.length){
                // 没找到，当前maxsum就是最大值
                return -1;
            }else {
                for (int begin = end + 1; begin < nums.length; begin++) {
                    if (nums[begin] > 0){
                        return begin;
                    }
                }
                // 全找遍了，没有大于0的数当前就是最大值
                return -1;
            }
        }
    }



}
