package top50_questions;

import java.util.Stack;

/**
 * Q.Given a binary search tree, 
 * print out the elements of the tree in order without using recursion.
 * => output: ascending order.
 * 
 * [Approach1] Recursion.
 * Time: O(n)
 * Space: O(LogN), call stack cnt = depth of the tree.
 * 
 * [Approach2] BST Iterator. using the Stack!
 * note. helper method to push the left to the end.
 *  
 * Time: O(n)
 * Space: O(n), the stack size will be n/2 at max.
 * 
 * @author Sunny Park
 *
 */
public class Q27_InorderTraversal {
    public static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.println(root);
        inorder(root.right);
    }
    
    public static void inorder_stack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        pushLeft(stack, root);
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            pushLeft(stack, top.right);
            System.out.println(top);
        }
    }
    
    private static void pushLeft(Stack<TreeNode> stack, TreeNode node) {
        if (node == null) {
            return;
        }
        stack.push(node);
        pushLeft(stack, node.left);
    }
    
    private static class TreeNode {
        TreeNode left;
        TreeNode right;
        static int id = 1;
        int val;
        
        TreeNode() {
            this.val = id;
            id++;
        }
        
        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }
    
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode();
        TreeNode n2 = new TreeNode();
        TreeNode n3 = new TreeNode();
        TreeNode n4 = new TreeNode();
        TreeNode n5 = new TreeNode();
        TreeNode n6 = new TreeNode();
        TreeNode n7 = new TreeNode();
        
        n2.left = n1;
        n2.right = n3;
        n4.left = n2;
        n4.right = n6;
        n6.left = n5;
        n6.right = n7;
        
        inorder(n4);
        inorder_stack(n4);
        
    }
}
