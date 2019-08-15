package top50_questions;
/**
 * Question: Given an integer, write a function to compute the number of ones 
 * in the binary representation of the number.
 * 
 * [Approach] bit operation
 * 1. AND operation with 1: XXXXXX1 & 1 = 1
 * 2. right shift
 * @author Sunny Park
 *
 */
public class Q37_NumberofOnes {
    public static int numOfOnes(int input) {
        int num = input;
        int total = 0;
        while (num != 0) {
            total += num & 1;
            num >>= 1;
        }
        return total;
    }
    
    public static void main(String[] args) {
        System.out.println(numOfOnes(7));
        
    }
}
