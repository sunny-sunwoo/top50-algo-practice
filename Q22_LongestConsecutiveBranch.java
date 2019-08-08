package top50_questions;

import com.google.common.primitives.Ints;

/**
 * Question: Given a tree, write a function to find the length of the longest branch 
 * of nodes in increasing consecutive order.
 * 
 * @author Sunny Park
 *
 */
public class Q22_LongestConsecutiveBranch {
    public static int findConsecutiveLength(TreeNode node) {
        return findLength(node, Integer.MAX_VALUE, 0);
    }
    
    private static int findLength(TreeNode node, int prevVal, int maxLen) {
        if (node == null) return maxLen;
        
        if (node.val != prevVal + 1) {
            return Ints.max(maxLen, findLength(node.left, node.val, 1), 
                    findLength(node.right, node.val, 1));
        }
        
        return Ints.max(findLength(node.left, node.val, maxLen + 1), 
                findLength(node.right, node.val, maxLen + 1));
    }
    
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode(int val) {
            this.val = val;
        }
    }
}
