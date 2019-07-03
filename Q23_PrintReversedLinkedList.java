package top50_questions;

/**
 * Q. Given a stack, reverse the items 
 * without creating any additional data structures.
 * 
 * e.g.
 * reverse(1->2->3) = 3->2->1
 * 
 * [Approach1] Iteration.
 * using prev, curr pointer + temp next pointer.
 * 
 * [Approach2] Recursion.
 * base case: when it reaches the last node -> return the node.
 * logic: set curr node's next node(reverse) -> curr node's next(break)
 * 
 * @author Sunny Park
 *
 */
public class Q23_PrintReversedLinkedList {
    public static Node reverse(Node head) {
        if (head.next == null) return head;
        Node tail = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return tail;
    }
    
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        n1.next = n2;
        n2.next = n3;
        System.out.println(reverse(n1));
        
    }
    
    private static class Node {
        Node next;
        int val;
        Node(int val) {
            this.val = val;
        }
        @Override
        public String toString() {
            if (next == null) return String.valueOf(val);
            return String.valueOf(val) + " -> " + next.toString();
        }
    }
}
