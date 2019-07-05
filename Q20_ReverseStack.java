package top50_questions;

import java.util.Stack;

/**
 * Question. Given a stack, reverse the items 
 * without creating any additional data structures.
 * 
 * [Approach] Double Recursion
 * 1. traverse in reverse order.
 * 2. insert at bottom.
 * 
 * Note. try to draw the stack.
 * 
 * 
 * [Complexity]
 * Time complexity: O(n^2), quadratic.
 *  - insertAtBottom: O(n)
 *  - reverse: O(n)
 *  
 * Space complexity: O(2n) => O(n), not quadratic, 
 *                   bc/ we can *free* the stack space each time while returning back.
 *  - insertAtBottom: O(n)
 *  - reverse: O(n)
 * 
 * 
 * @author Sunny Park
 *
 */
public class Q20_ReverseStack {
    public static Stack<Integer> reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return stack;
        }
        
        int tmp = stack.pop();
        reverse(stack);
        insertAtBottom(stack, tmp);
        return stack;
    }
    
    private static void insertAtBottom(Stack<Integer> stack, int x) {
        if (stack.isEmpty()) {
            stack.push(x);
            return;
        }
        
        int top = stack.pop();
        insertAtBottom(stack, x);
        stack.push(top);
    }
    
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack);
        reverse(stack);
        System.out.println(stack);
    }
}
