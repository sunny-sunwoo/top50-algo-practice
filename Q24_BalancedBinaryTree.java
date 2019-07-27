package top50_questions;

/**
 * Q24. Given a binary tree,
 * write a function to determine whether the tree is balanced.
 * 
 * Balanced == all branches are same height or +/- 1.
 * @author Sunny Park
 *
 */
public class Q24_BalancedBinaryTree {
    
    public static boolean isBalanced(TreeNode root) {
        return helper(root) != -1;
    }
    
    private static int helper(TreeNode node) {
        if (node == null) return 0;
        
        int left = helper(node.left);
        if (left == -1) return -1;
        
        int right = helper(node.right);
        if (right == -1) return -1;
        
        return Math.abs(left - right) > 1 ? -1 : Math.max(left, right) + 1;
    }
    
    private static class TreeNode {
        TreeNode left;
        TreeNode right;
    }
    
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode();
        TreeNode n2 = new TreeNode();
        TreeNode n3 = new TreeNode();
        TreeNode n4 = new TreeNode();
        TreeNode n5 = new TreeNode();
        TreeNode n6 = new TreeNode();
        
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        
        System.out.println(isBalanced(n1));
        
    }
}
