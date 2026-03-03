package backTracing;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2026-03-02
 * @Description: 77组合
 */
public class Solution_77 {

    List<List<Integer>> globalRes = new ArrayList<>();
    Integer k = -1;
    Integer n = -1;

    /**
     * 返回所有可能的组合
     * @param n 最大值N
     * @param k 每个组合中数的个数
     * @return
     * @examples
     */
    public List<List<Integer>> combine(int n, int k) {
        this.k = k;
        this.n = n;
        backTracing(new ArrayList<>(),1,n);

        return globalRes;
    }


    void backTracing(List<Integer> curRes, int avalMin, int avalMax){
        if (curRes.size() == k){
            globalRes.add(new ArrayList<>(curRes));
            return;
        }

        for (int i = avalMin; i <= avalMax; i++) {
            curRes.add(Integer.valueOf(i));
            backTracing(curRes,i+1,avalMax);
            curRes.remove(Integer.valueOf(i));
        }
    }

    public static void main(String[] args) {
        Solution_77 solution77 = new Solution_77();
        List<List<Integer>> combine = solution77.combine(4, 2);

        printRes(combine);

    }

    public static void printRes(List<List<Integer>> lists) {

        StringBuilder sb = new StringBuilder();

        lists.forEach(new Consumer<List<Integer>>() {
            @Override
            public void accept(List<Integer> integers) {
                sb.append(integers.toString()+"\n");
            }
        });
        System.out.println(sb.toString());

    }


}