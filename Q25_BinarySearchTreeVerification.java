package top50_questions;

/**
 * Question: Given a binary tree, write a function to test if the tree is a binary search tree.
 * @author Sunny Park
 *
 */
public class Q25_BinarySearchTreeVerification {
    
    public static boolean isBST(Node root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private static boolean isBST(Node node, int min, int max) {
        if (node == null) return true;
        if (node.val < min || node.val > max) return false;
        return isBST(node.left, min, node.val) && isBST(node.right, node.val, max);
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
        
        n4.left = n2;
        n4.right = n6;
        
        n2.left = n1;
        n2.right = n3;
        
        n6.left= n5;
        n6.right = n7;
        
        System.out.println(isBST(n4));
    }
}
