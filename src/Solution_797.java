import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-03-21
 * @Description: 797所有可能路径
 */
public class Solution_797 {

    List<List<Integer>> paths = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {


        int NodeNumbers = graph.length;

        int[][] dp = new int[NodeNumbers][NodeNumbers];

        for (int i = 0; i < graph.length; i++) {
            for (int j : graph[i]) {
                dp[i][j] = 1;
                dp[j][i] = 1;
            }
        }
        //
        path.add(0);
        FindPath(dp);
        return paths;
    }

    public void FindPath(int[][] graph){

        // 终端条件
        if (path.get(path.size()-1) == graph.length-1){
            paths.add(new ArrayList<>(path));
            return;
        }

        //
        for (int i = 0; i < graph.length; i++) {
            if (graph[path.get(path.size()-1)][i] == 1 && !path.contains(i)){
                // 找到path中不包含 且 当前节点可以连接的节点
                path.add(i);
                FindPath(graph);
                // 格式化
                path.remove(path.size()-1);
            }

        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution_797().allPathsSourceTarget(new int[][]{{1, 2}, {3}, {3}, {}});
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}


class Main {

    ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
    ArrayList<Integer> tempPath = new ArrayList<>();
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int nodeNumbers = scanner.nextInt();
        int edgeNumbers = scanner.nextInt();

        int[][] graph = new int[nodeNumbers][nodeNumbers];

        int xNode,yNode;

        for (int i = 0; i < edgeNumbers; i++) {
            xNode = scanner.nextInt();
            yNode = scanner.nextInt();
            graph[xNode-1][yNode-1] = 1;
            graph[yNode-1][xNode-1] = 1;
        }

        Main solution98 = new Main();
        solution98.tempPath.add(0);
        solution98.FindPath(graph,nodeNumbers-1);
        for (int i = 0; i < solution98.paths.size(); i++) {
            for (int i1 = 0; i1 < solution98.paths.get(i).size(); i1++) {
                System.out.print(solution98.paths.get(i).get(i1) + 1 + " ");
            }
            System.out.println();
        }

    }

    void FindPath(int[][] grapgh, int finalNode){
        if (tempPath.get(tempPath.size()-1) == finalNode){
            // 说明路径完整，可以加入导paths中
            paths.add(new ArrayList<>(tempPath));
            return;
        }
        int curNode = tempPath.get(tempPath.size()-1);
        for (int i = 0; i < grapgh.length; i++) {
            if (grapgh[curNode][i] == 1){
                // 找到相连的路
                if (!tempPath.contains(i)){
                    // 确保不是回头路
                    tempPath.add(i);
                    FindPath(grapgh,finalNode);
                    // 结尾处理
                    tempPath.remove(tempPath.size()-1);
                }
            }
        }
    }

}