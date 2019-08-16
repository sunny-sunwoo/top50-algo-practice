package top50_questions;
/**
 * Question: Given a list of integers, write a function that returns 
 * all sets of 3 numbers in the list, a, b, and c, so that a + b + c == 0.
 * 
 * e.g.
 * threeSum({‐1, 0, 1, 2, ‐1, ‐4})
   output: [[‐1, ‐1, 2], [‐1, 0, 1]]
   
 * [Approach] Binary Search
 * 1. sort the arr first.
 * 2. linear scan: range of i (0 ~ n - 2)
 *    => target = - arr[i]
 *    => lo = i + 1, hi = n - 1
 *    => case1) arr[lo] + arr[hi] = target // MATCHED
 *        - add to the result
 *        - increment lo & decrement hi (to find next ptr)
 *      case2) arr[lo] + arr[hi] < target 
 *        - increment lo
 *      case3) arr[lo] + arr[hi] > target 
 *        - decrement hi
 * 3. return result.
 * 
 * 
 * [Note]
 * 1. sort first!
 * 2. make sure lo & hi get changed in the next turn (same numbers can be included in the input.)
 * 
 * @author Sunny Park
 *
 */
public class Q43_ThreeSum {

}
