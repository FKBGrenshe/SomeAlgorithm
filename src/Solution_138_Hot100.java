public class Solution_138_Hot100 {
    public Node copyRandomList(Node head) {

        Node DeepCopyHead = new Node(-1);
        // 1. 创建一个新链表，按照next方向进行深拷贝
        Node oldIdx = head;
        Node newIdx = DeepCopyHead;
        while (oldIdx != null){
            Node newDeepCopyNode = new Node(oldIdx.val);
            newIdx.next = newDeepCopyNode;
            // 下一个节点
            newIdx = newIdx.next;
            oldIdx = oldIdx.next;
        }
        // 2. 复制链表的random节点
        oldIdx = head;
        newIdx = DeepCopyHead.next;
        Node tempCountNode = oldIdx;
        Node tempNewCountNode = DeepCopyHead.next;
        while (oldIdx != null){
            if (oldIdx.random != null){
                while (tempCountNode != oldIdx.random){
                    tempCountNode = tempCountNode.next;
                    tempNewCountNode = tempNewCountNode.next;
                }
                newIdx.random = tempNewCountNode;
            }
            // 下一个节点
            oldIdx = oldIdx.next;
            newIdx = newIdx.next;
            tempCountNode = head;
            tempNewCountNode = DeepCopyHead.next;
        }
        return DeepCopyHead.next;
    }

    public static void main(String[] args) {
        Solution_138_Hot100 solution138 = new Solution_138_Hot100();
        Node node = new Node(7);
        node.next = new Node(13);
        node.next.next = new Node(11);
        node.next.next.next = new Node(10);
        node.next.next.next.next = new Node(1);
        node.random = node.next.next.next.next;
        node.next.random = node;
        node.next.next.random = node.next.next.next.next;
        node.next.next.next.random = node.next.next;
        node.next.next.next.next.random = node;

        Node nodeCopy = solution138.copyRandomList(node);
        while (nodeCopy != null){
            System.out.println(nodeCopy.val);
            nodeCopy = nodeCopy.next;
        }


    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
