import java.util.Arrays;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-04-19
 * @Description: 寻找目标值-二维数组
 */
public class LCR121 {

    public static boolean findFlag = false;
    public static int target;

    public boolean findTargetIn2DPlants(int[][] plants, int target) {
        this.target = target;
        this.findFlag = false;
        finding(plants,0,plants[0].length-1);
        return this.findFlag;
    }


    public void finding(int[][] plants,int curHang, int curLie){
        if (findFlag){
            return;
        }
        int curValue = plants[curHang][curLie];
        if (curValue == target){
            findFlag = true;
            return;
        }

        if ( curHang+1 < plants.length && curLie-1 >= 0 && target <= plants[curHang+1][curLie-1] ){
            finding(plants,curHang+1, curLie-1);

        }else{
            if(curHang+1<plants.length && plants[curHang+1][curLie] <= target){
                finding(plants,curHang+1,curLie);
            }
            if (curLie-1>=0){
                finding(plants,curHang,curLie-1);
            }
        }


    }

    public static void main(String[] args) {
        LCR121 lcr121 = new LCR121();
        System.out.println(lcr121.findTargetIn2DPlants(
                new int[][]{
                        {1,4},
                        {2,5}

                },
                5
        ));
    }

}
