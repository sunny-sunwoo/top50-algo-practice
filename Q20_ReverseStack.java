package top50_questions;

import java.util.Stack;

/**
 * Question: Given a stack, reverse the items 
 * without creating any additional data structures.
 * 
 * [Approach] Recursion
 * 
 * @author Sunny Park
 *
 */
public class Q20_ReverseStack {
    public static Stack<Integer> reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) return stack;
        int temp = stack.pop();
        reverse(stack);
        insertAtBottom(stack, temp);
        return stack;
    }
    
    private static void insertAtBottom(Stack<Integer> stack, int num) {
        if (stack.isEmpty()) {
            stack.push(num);
            return;
        }
        int top = stack.pop();
        insertAtBottom(stack, num);
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
