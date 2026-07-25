package SORT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertSortByBinaryTree {

    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(4, 3, 2, 5, 6, 1);
        List<Integer> sortedList = binaryTreeSort(ints);
        
        for (int num : sortedList) {
            System.out.println(num);
        }
    }

    public static List<Integer> binaryTreeSort(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return new ArrayList<>();
        }
        
        Node root = null;
        for (Integer num : numbers) {
            root = insertIntoTree(root, num);
        }
        
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;
    }

    public static Node insertIntoTree(Node currentNode, int newValue) {
        if (currentNode == null) {
            return new Node(newValue);
        }

        if (newValue < currentNode.val) {
            currentNode.left = insertIntoTree(currentNode.left, newValue);
        } else {
            currentNode.right = insertIntoTree(currentNode.right, newValue);
        }
        return currentNode;
    }

    public static void inorderTraversal(Node currentNode, List<Integer> resultList) {
        if (currentNode == null) {
            return;
        }
        inorderTraversal(currentNode.left, resultList);
        resultList.add(currentNode.val);
        inorderTraversal(currentNode.right, resultList);
    }
}

class Node {
    int val;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
    }
}