package top50_questions;

/**
 * Q. Given two integers, write a function to sum the numbers 
 * without using any arithmetic operators.
 * 
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
 * @see <a href = "https://leetcode.com"> LC#371. Sum of Two Integers</a>
 * @author Sunny Park
 *
 */
public class Q19_Sum {
    /**
     * Wrong answer: sum(20, 30) doesn't work. 
     * bc/ carry happens in the last opr, (sum | carry)
     * 
     *          10100 
     *          11110
     *          -----
     *   xor:   01010
     *   and:  101000
     *        --------
     *           X      <- this is the cause. 
     *                     I should check the (carry + sum) separately. 
     *          
     * @param a
     * @param b
     * @return
     */
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
        System.out.println(sum(20, 30));
        System.out.println(sum_recursive(10, 16));
        System.out.println(sum_iterative(10, 16));
    }
}
