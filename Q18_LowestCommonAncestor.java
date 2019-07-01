
/**
 * Q. Given two nodes in a binary tree, 
 * write a function to find the lowest common ancestor.
 * 
 * [Intuition] using Recursion.
 * 
 *  base case 
 *      - 1. curr is null 
 *      - 2. curr is p or q. 
 *      
 *  recursive case - recurse on left, right 
 *      - 1. both are null -> can't find. return null.
 *      - 2. both are not null -> root is the lca.
 *      - 3. return one of the results which is not null. 
 * 
 * @author Sunny Park
 */
public class Q18_LowestCommonAncestor {
    public static Node lca(Node root, Node p, Node q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        
        Node left = lca(root.left, p, q);
        Node right = lca(root.right, p, q);
        
        if (left == null && right == null) return null;
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }
    
    private static class Node {
        Node left;
        Node right;
        int val;
    }
}
