/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-04-19
 * @Description: 库存管理1-找最小值
 */
public class LCR128 {
    public int inventoryManagement(int[] stock) {
        int minValue = 5001;
        for(int i : stock){
            if(minValue > i){
                minValue = i;
            }
        }

        return minValue;
    }
}
