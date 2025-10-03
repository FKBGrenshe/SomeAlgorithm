/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-04-19
 * @Description: 寻找文件副本
 */
public class LCR120 {
    public int findRepeatDocument(int[] documents) {
        int[] numbers = new int[100000];
        for(int value : documents){
            if(numbers[value]== 1){
                return value;
            }
            numbers[value]++;
        }
        return 999;
    }

    public static void main(String[] args) {
        LCR120 lcr120 = new LCR120();
        System.out.println(lcr120.findRepeatDocument(
                new int[]{
                        2, 5, 3, 0, 5, 0
                }
        ));
    }
}
