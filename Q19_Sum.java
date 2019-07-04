package top50_questions;

/**
 * Q. Given two integers, write a function to sum the numbers 
 * without using any arithmetic operators.
 * 
 * [Approach] Bit operation.
 * 
 * - XOR opr: addition
 * 
 *         1      1
 *       ^ 1      0
 *      ----    ----
 *         0      1
 * 
 * 
 * - & opr, << opr: carry
 *  
 *      111
 *    & 111
 *    ------
 *      111
 * 
 * @author Sunny Park
 *
 */
public class Q19_Sum {
    public static int sum(int a, int b) {
        int sum = a ^ b;
        int carry = (a & b) << 1;
        return sum | carry;
    }
    
    public static int sum_recursive(int a, int b) {
        if (b == 0) return a;
        int psum = a ^ b;
        int carry = (a & b) << 1;
        return sum_recursive(psum, carry);
    }
    
    public static int sum_iterative(int a, int b) {
        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
     
    public static void main(String[] args) {
        System.out.println(sum(10, 16));
        System.out.println(sum_recursive(10, 16));
        System.out.println(sum_iterative(10, 16));
    }
}
