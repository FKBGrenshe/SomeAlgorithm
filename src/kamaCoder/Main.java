package kamaCoder;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> containNode = new ArrayList<Integer>();

        Scanner in = new Scanner(System.in);
        // 总人数
        int n = in.nextInt();
        // 初始朋友关系
        int m = in.nextInt();
        // 事件数量
        int q = in.nextInt();

        boolean[][] relationMap = new boolean[n+1][n+1];

        for (int i = 0; i < m; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            relationMap[u][v] = true;
            relationMap[v][u] = true;
        }

        for (int i = 0; i < q; i++) {
            //op=1: 删除关系
            //op=2：查询关系
            int op = in.nextInt();

            int u = in.nextInt();
            int v = in.nextInt();

            if (op == 1){
                relationMap[u][v] = false;
                relationMap[v][u] = false;
            }else {
                String res = findRelation(relationMap, u,v, containNode) ? "Yes" : "No";
                System.out.println(res);
                containNode.clear();
            }
        }
    }

    public static boolean findRelation(boolean[][] relationMap, int u, int v, ArrayList<Integer> containNode){
        // 查询u和v是否能认识
        if (relationMap[u][v]){
            return true;
        }else {
//            ArrayList<Integer> relationList = new ArrayList<>();
            Deque<Integer> relationQueue = new ArrayDeque<>();
            // 将u认识的所有人入队
            for (int j = 0; j < relationMap[u].length; j++) {
                if (relationMap[u][j]){
//                    relationList.add(j);
                    relationQueue.addLast(j);
                }
            }
            while (!relationQueue.isEmpty()){
                Integer idx = relationQueue.pollFirst();
                containNode.add(idx);
                if (relationMap[idx][v]){
                    return true;
                }else {
                    for (int j = 0; j < relationMap[u].length; j++) {
                        if (relationMap[idx][j] && !relationQueue.contains(j) && !containNode.contains(j)){
                            relationQueue.addLast(j);
                        }
                    }
                }
            }
            return false;
        }

    }



}