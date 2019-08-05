package top50_questions;

import java.util.Arrays;

/**
 * Question: Given 2 sorted arrays, A and B, where A is long enough to hold the 
 * contents of A and B, write a function to copy the contents of B into A without
 * using any buffer or additional memory.
 * 
 * e.g. 
 *  A = {1,3,5,0,0,0}
 *  B = {2,4,6}
 *  
 *  mergeArrays(A, B)
 *  A = {1,2,3,4,5,6}
 *  
 * [Approach] merge sort in reverse dir.
 *  - place ptr at the end of A.
 *  - put greater elem out of 2 arrs. while decrementing 
 * @author Sunny Park
 *
 */
public class Q10_MergeArrays {
    public static int[] mergeArrays(int[] a, int m, int[] b, int n) {
        int ptr = m + n - 1;
        m = m - 1; 
        n = n - 1;
        while (m >= 0 && n >= 0) {
            a[ptr--] = a[m] >= b[n] ? a[m--] : b[n--];
        }
        
        // missing elem check from b!
        System.arraycopy(b, 0, a, 0, n + 1);
        
//        while (m >= 0) {
//            a[ptr--] = a[m--];
//        }
//        
//        while (n >= 0) {
//            a[ptr--] = b[n--];
//        }
        
        return a;
    }
    
    public static void main(String[] args) {
        int[] a = {1, 3, 5, 0, 0, 0};
        int[] b = {2, 4, 6};
        
        System.out.println(Arrays.toString(mergeArrays(a, 3, b, 3)));
    }
}
