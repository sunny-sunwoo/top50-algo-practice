package top50_questions;

import java.util.Random;

/**
 * Q17 Random Binary Tree
 * Implement a binary tree with a method getRandomNode() that returns a random node.
 * 
 * [Approach] similar to RankNode.
 * - by keeping the number of children, 
 *   sol can achieve logN time.
 *   
 * @author Sunny Park
 *
 */
public class Q17_RandomBinaryTree {
    private static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        int children;
    }
    TreeNode root;
    Random rand;
    
    public int getRandomNode() {
        int count = rand.nextInt(root.children + 1);
        return getRandomNode(root, count);
    }
    
    private int getRandomNode(TreeNode node, int count) {
        if (count == children(node.left)) return node.val;
        if (count < children(node.left)) return getRandomNode(node.left, count);
        return getRandomNode(node.right, count - children(node.left) - 1);
    }
    
    private int children(TreeNode n) {
        if (n == null) return 0;
        return n.children + 1;
    }
}
