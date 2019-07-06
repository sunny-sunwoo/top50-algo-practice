package top50_questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * Question: Given a tree, write a function 
 * that prints out the nodes of the tree in level order.
 * 
 * [Intuition] lv by lv -> BFS
 *  using queue, print nodes based on FIFO sequence.
 * 
 * @author Sunny Park
 *
 */
public class Q44_TreeLevelOrder {
    public static List<Integer> levelOrder(Node root) {
        List<Integer> result = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        
        while (!q.isEmpty()) {
            Node top = q.poll();
            result.add(top.val);
            if (top.left != null) q.offer(top.left);
            if (top.right != null) q.offer(top.right);
        }
        return result;
    }
    
    private static class Node {
        Node left;
        Node right;
        int val;
        
        public Node(int val) {
            this.val = val;
        }
    }
    
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        
        n1.left = n2;
        n1.right = n3;
        
        n2.left = n4;
        n2.right = n5;
        
        n3.left= n6;
        n3.right = n7;
        
        System.out.println(levelOrder(n1));
    }
}
