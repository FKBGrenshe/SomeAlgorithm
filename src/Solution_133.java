import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-09-13
 * @Description: 克隆图
 */
public class Solution_133 {

    Map<Integer, Node> newNdoeMap = new HashMap<>();

    public Node cloneGraph(Node node){
        doDeepClone(node);
        return newNdoeMap.get(1);
    }

    public void doDeepClone(Node cloneNode){
        if (cloneNode == null){
            return;
        }

        Node curNode = newNdoeMap.get(cloneNode.val);

        if (curNode==null){
            curNode = new Node(cloneNode.val);
            newNdoeMap.put(curNode.val, curNode);
        }

        for (int i = 0; i < cloneNode.neighbors.size(); i++) {
            Node cloneNeighbor = cloneNode.neighbors.get(i);
            Node newNeighbor = newNdoeMap.get(cloneNeighbor.val);
            if (newNeighbor == null){
                doDeepClone(cloneNeighbor);
            }
            curNode.neighbors.add(newNdoeMap.get(cloneNeighbor.val));
        }
    }






    public static void main(String[] args) {

        Solution_133 solution133 = new Solution_133();

        Node node1 = solution133.cloneGraph(null);


        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        n1.neighbors = new ArrayList<>();
        n2.neighbors = new ArrayList<>();
        n3.neighbors = new ArrayList<>();
        n4.neighbors = new ArrayList<>();

        n1.neighbors.add(n2);
        n1.neighbors.add(n4);

        n2.neighbors.add(n1);
        n2.neighbors.add(n3);

        n3.neighbors.add(n2);
        n3.neighbors.add(n4);

        n4.neighbors.add(n1);
        n4.neighbors.add(n3);

        Node node = solution133.cloneGraph(n1);
        solution133.newNdoeMap.forEach((k,v) -> {
            System.out.println( k + " - " + v);
        });

    }


    static class Node {
        public int val;
        public List<Solution_133.Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Solution_133.Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Solution_133.Node>();
        }
        public Node(int _val, ArrayList<Solution_133.Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}


