public class Solution_283_Hot100 {
    public static void moveZeroes(int[] nums) {
        int p0=0, px=0;
        int len = nums.length;
        if(len == 1){
            return;
        }

        boolean flagnonzero = false; // 找没找到非零
        boolean flagzero = false; // 找没找到零

        for (int i = 0; i < len; i++) {
            if (nums[i] == 0){
                // 寻找数组中第一个0位置
                p0 = i;
                flagzero = true;
                for (int j = p0+1; j < len; j++) {
                    // 寻找数组中在第一个0位置之后的第一个非零位置
                    if(nums[j]!=0){
                        px=j;
                        flagnonzero=true;
                        break;
                    }
                }
                if (flagnonzero){
                    flagnonzero = false;
                    break;

                }
                // 没找到在第一个0位置之后存在非零数 -- 数组天然顺序正确
                return;
            }
        }

        if(!flagzero){
            // 数组中无0 -- 数组天然顺序正确
            return;
        }

        // todo 已经找到第一个0位置，且已经找到第一个0后第一个非零位置
        while (true){
            // todo 交换两位置
            int tmp = nums[p0];
            nums[p0] = nums[px];
            nums[px] = tmp;
            // todo 寻找下一个p0 、px
            //p0 就是这次交换之后的px位置
            // todo 此处不对，px前面可能还有0
            for (int i = p0 +1; i <= px; i++) {
                if (nums[i]==0){
                    p0 = i;
                    break;
                }
            }
            // 寻找px位置
            for (int i = p0+1; i < len; i++) {
                if (nums[i]!=0){
                    px = i;
                    flagnonzero = true;
                    break;
                }
            }
            if (!flagnonzero){
                // 没找到，说明后面第一个0后面没有非零数，完成了排序
                return;
            }
            flagnonzero=false;
        }
    }

    public static void main(String[] args) {
//        moveZeroes(new int[]{0,1,0,3,12});
        moveZeroes(new int[]{1,1});
    }
}
