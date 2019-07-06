package top50_questions;

/**
 * Q. Given a linked list, and an input n, 
 * write a function that returns the nth-to-last element of the linked list.
 * 
 * [Approach] using 2 pointers.
 * 
 * Time complexity: O(n), linear scan.
 * Space complexity: O(1), just using pointers.
 * 
 * @author Sunny Park
 *
 */
public class Q42_NthToTheLastElement {
    public static Node nthToLast(Node head, int n) {
        Node checker = head;
        while (n > 0) {
            checker = checker.next;
            n--;
        }
        
        Node curr = head;
        while (checker != null) {
            checker = checker.next;
            curr = curr.next;
        }
        return curr;
    }
    
    private static class Node {
        static int num = 1;
        final int val;
        Node next;
        
        Node() {
            this.val = num++;
        }
        
        @Override
        public String toString() {
            if (next == null) {
                return String.valueOf(val);
            }
            return String.valueOf(val) + " -> " + next;
         }
    }
    
    public static void main(String[] args) {
        Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();
        Node n4 = new Node();
        Node n5 = new Node();
        
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        
        System.out.println(n1);
        System.out.println(nthToLast(n1, 2));
    }
}
