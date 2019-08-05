package top50_questions;

import com.google.common.primitives.Ints;

/**
 * Question: Given a 2D array of 1s and 0s, find the largest square subarray of all 1s.
 * 
 * [Approach] memoization with 1 extra row & col.
 * 1. linear scan of 2d arr
 *    1) curr cell is 1 ? -> min(top-left, left, up cell) + 1
 *    2) otherwise(cell is 0), -> 0 
 * 2. return the memo
 * 
 * [Note]
 * check index! cuz memo array has 1 more row/col in it.
 * - where to put grid OR memo! (it can be confusing.)
 * @author Sunny Park
 *
 */
public class Q07_SquareSubmatrix {
    public static int squareSubmatrix(int[][] grid) {
        int[][] memo = new int[grid.length + 1][grid[0].length + 1];
        int result = 0;
        for (int i = 1; i < memo.length; i++) {
            for (int j = 1; j < memo[0].length; j++) {
                if (grid[i - 1][j - 1] == 0) continue;
                memo[i][j] = Ints.min(memo[i - 1][j - 1], memo[i - 1][j], memo[i][j - 1]) + 1;
                result = Math.max(result, memo[i][j]);
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[][] input = {{1, 0, 0}, {1, 1, 0}, {1, 1, 1}};
        System.out.println(squareSubmatrix(input));
    }
}
