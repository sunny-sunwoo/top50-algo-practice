package top50_questions;

public class Q21_TreeToDLL {
    public static DLNode convert(TreeNode root) {
        if (root == null) return null;
        DLNode left = convert(root.left);
        DLNode right = convert(root.right);
        DLNode newNode = new DLNode(root.val);
        newNode.left = left;
        newNode.right = right;
        return newNode;
    }
    
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode(int val) {
            this.val = val;
        }
        
        @Override
        public String toString() {
            if (left == null && right == null) return "Node-" + String.valueOf(val);
            return left + " // " + "Node-" + this.val + " // " + right;
        }
    }
    
    private static class DLNode {
        int val;
        DLNode left;
        DLNode right;
        
        DLNode(int val) {
            this.val = val;
        }
        
        @Override
        public String toString() {
            if (left == null && right == null) return "DLNode-" + String.valueOf(val);
            return left + " // " + "DLNode-" + this.val + " // " + right;
        }
    }
    
    
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        
        System.out.println(n1);
        System.out.println(convert(n1));
    }
}
