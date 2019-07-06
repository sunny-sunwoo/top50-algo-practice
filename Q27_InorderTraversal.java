package top50_questions;

/**
 * Q.Given a binary search tree, 
 * print out the elements of the tree in order without using recursion.
 * => output: ascending order.
 * 
 * [Approach1] Recursion.
 * Time: O(n)
 * Space: O(LogN), call stack cnt = depth of the tree.
 * 
 * [Approach2] Iterator. based on the Stack ds. 
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
        
    }
}
