public class Solution_169_Hot100 {
    public static int majorityElement(int[] nums) {

        /**
         * 摩尔投票法
         *  超过一半数量的数值，‘一命抵一命’总能赢下
         *      随便假定其他一个数，‘一命抵一命’必输
         *
         */

        int king = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (king != nums[i]){
                count--;
            }else {
                count++;
            }
            if (count == 0){
                king = nums[i];
                count = 1;
            }
        }
        return king;

        /*if(nums.length <= 0){
            // 有效性检查
            return nums[0];
        }

        // 数量多于一半，那‘一人换一条命’剩下的也是数量多的
        int len = nums.length;
        // 相当于重新排序数组，要求 nums[i] != nums[i+1]
        for (int i = 1; i < len; i++) {
            int prev = nums[i-1];
            if (nums[i] == prev){
                boolean findFlag = false;
                // 找到与prev不同的，并与nums[i]交换
                for (int j = i+1; j < len; j++) {
                    if (nums[j] != prev){
                        // 找到了 -- 与prev不同的，并与nums[i]交换
                        nums[i] = nums[j];
                        nums[j] = prev;
                        findFlag = true;
                        break;
                    }
                }
                if (!findFlag){
                    // 遍历完，没找到？ -- prev值就是最多的
                    return prev;
                }
            }
        }
        return nums[len-1];*/
    }

    public static void main(String[] args) {
        int[] ints = {3,2,3};
        System.out.println(majorityElement(ints));
    }
}
