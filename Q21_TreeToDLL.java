package top50_questions;

/**
 * Question: Given a tree, write a function to convert it into a circular doubly linked list 
 * from left to right by only modifying the existing pointers.
 * @author Sunny Park
 *
 */
public class Q21_TreeToDLL {
    public static Node treeToList(Node node) {
        if (node == null) return node;
        Node leftList = treeToList(node.left);
        Node rightList = treeToList(node.right);
        
        // to make it circular!
        node.left = node;
        node.right = node;
        
        node = concatenate(leftList, node);
        node = concatenate(node, rightList);
        return node;
       
    }
    
    /*  <- 1 <-> 2 <-> 3        4 <-> 5 <-> 6 ->
           a          aEnd      b          bEnd
           
           a.left = bEnd
           bEnd.right = a
           
           aEnd.right = b
           b.left = aEnd
           
           => circular DLL!
    */
    private static Node concatenate(Node a, Node b) {
        if (a == null) return b;
        if (b == null) return a;
        
        Node aEnd = a.left; // cuz it's circular DLL!
        Node bEnd = b.left;
        
        a.left = bEnd;
        bEnd.right = a;
        
        aEnd.right = b;
        b.left = aEnd;
        
        return a;
    }
    
    private static class Node {
        int val;
        Node left;
        Node right;
        
        Node(int val) {
            this.val = val;
        }
        
        @Override
        public String toString() {
            if (left == null && right == null) return "Node-" + String.valueOf(val);
            return left + " // " + "Node-" + this.val + " // " + right;
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
        
        n3.left = n6;
        n3.right = n7;
        
        System.out.println(n1);
        //System.out.println(treeToList(n1));
    }
    
    
}
