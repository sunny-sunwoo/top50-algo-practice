package top50_questions;

import java.util.Stack;

/**
 * Q. Given a LL, write a function to determine
 * whether the list is a palindrome.
 * 
 * e.g.
 * palindrome(1 -> 2 -> 3) = false
 * palindrome(1 -> 2 -> 1) = true
 * 
 * [Approach] 2 pointers for runner & walker
 * 
 * Odd number                       Even number
 * 1 -> 2 -> 1 -> null              1 -> 2 -> 2 -> 1 -> null
 * ^         ^                      ^         ^          ^
 * ^   ^                            ^    ^    ^
 * 
 * 1. proceed until the runner.next or runner is null.
 *    pushing elem at walker to the stack. 
 *    
 * 2. check runner != null -> to skip the elem at the mid.
 * 
 * 3. compare while popping.
 * 
 * [time / space]
 * time: O(n)
 * space: O(n) 
 * 
 * @author Sunny Park
 *
 */
public class Q30_Palindromes {
    
    public static boolean palindrome(Node head) {
        Stack<Integer> stack = new Stack<>();
        Node slow = head;
        Node fast = head;
        
        while (fast != null && fast.next != null) {
            stack.push(slow.val);
            fast = fast.next.next;
            slow = slow.next;
        }
        
        if (fast != null) {
            slow = slow.next;
        }
        
        while (!stack.isEmpty() && slow != null) {
            if (stack.pop() != slow.val) {
                return false;
            }
            slow = slow.next;
        }
        return true;
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
    
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(2);
        Node n4 = new Node(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        System.out.println(palindrome(n1));
    }

}
