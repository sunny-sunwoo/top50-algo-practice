package top50_questions;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Question: Find the median of two sorted arrays.
 * 
 * [Approach] Binary Search
 *  - To find kth number in sorted arrays, I can use binary search 
 *  by updating the starting point and k accordingly.
 *  
 *  arr1 = [1, 3, 5]
 *  arr2 = [2, 4, 6]
 *  k = 4
 *  
 *  1. compare arr1[k/2 - 1] vs arr2[k/2 - 1]
 *  2. proceed the "starting point" where its elem is "smaller" than the other,
 *     bc/ no need to care about the elem and elems before that. 
 *  3. recurse with k -> k - k/2
 *     bc/ 5 -> 5 - 2 = 3. (instead of 2.)
 * 
 * [find median - public]
 * when arr1.length = m, arr2.length = n,
 * result = findkth(k = (m + n + 1) / 2 ) + findkth(k = (m + n + 2) / 2 )
 * result = (double) result / 2.0
 *  
 *  e.g. 
 *  odd number, totalLen = 5 -> 5+1/2 = 3, 5+2/2 = 3 -> findkth(3) + findkth(3)
 *  even number, totalLen = 6 -> 6+1/2 = 3, 6+2/2 = 4 -> findkth(3) + findkth(4)
 *  
 * [findkth - private]
 *  1. check arguments to see if exhausted.
 *      if so, rt result from the other arr.
 *      
 *  2. chekc if k == 1. simply rt min.
 *  3. binary search
 *      1) set mid1, mid2 as I.MAX 
 *         bc/ we care about the smaller value when proceeding the start ptr.
 *      2) update the value of st + k/2 -1 while checking the boundary.
 *      3) rt recursive call. with updated st & k by comparing mids.
 *  
 * @author Sunny Park
 *
 */
public class Q01_MedianOfArrays {
    
    public static double findMedian(int[] arr1, int[] arr2) {
        checkArgument(checkNotNull(arr1).length > 0);
        checkArgument(checkNotNull(arr2).length > 0);
        
        int m = arr1.length;
        int n = arr2.length;
        
        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;
        
        return (findkth(arr1, 0, arr2, 0, left) + findkth(arr1, 0, arr2, 0, right)) / 2.0;
    }
    
    private static int findkth(int[] arr1, int start1, int[] arr2, int start2, int k) {
        if (start1 >= arr1.length) return arr2[start2 + k - 1];
        if (start2 >= arr2.length) return arr1[start1 + k - 1];
        
        if (k == 1) return Math.min(arr1[start1], arr2[start2]);
        
        int mid1 = Integer.MAX_VALUE;
        int mid2 = Integer.MAX_VALUE;
        
        mid1 = (start1 + k/2 - 1) < arr1.length ? arr1[start1 + k/2 - 1] : mid1;
        mid2 = (start2 + k/2 - 1) < arr2.length ? arr2[start2 + k/2 - 1] : mid2;
        
        return mid1 < mid2 ? findkth(arr1, start1 + k/2, arr2, start2, k - k/2) 
                : findkth(arr1, start1, arr2, start2 + k/2, k - k/2);
    }
    
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2, 4, 6};
        System.out.println(findMedian(arr1, arr2));
        System.out.println(findkth(arr1, 0, arr2, 0, 6));
    }
}
