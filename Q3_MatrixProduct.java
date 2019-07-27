package top50_questions;

import java.util.Arrays;

/**
 * 
 * Q. Given a matrix, find the path from top left to bottom right
 * with the greatest product by moving only down and right.
 * 
 * e.g. 
 * [[1,2,3]
 *  [4,5,6]
 *  [7,8,9]]  => 2016(1,4,7,8,9)
 *  
 * [[-1,2, 3]
 *  [4, 5,-6]
 *  [7, 8, 9]]  => 1080(-1,4,5,-6,9)
 *   
 *  [Approach] dp. 1) keeping min & max product. 2) using Pair object.
 *   chances are : max can be min*curr OR max*curr
 *   
 *   1. create a memoization 2d array. of Pair
 *   2. for the first cell - put itself.
 *   3. for the first row: prev(col - 1) memo * curr
 *      for the first col: prev(row - 1) memo * curr
 *      
 *   4. other than that,
 *      curr min = min value among 2 prev cells. 
 *      curr max = max value among 2 prev cells. 
 *      
 *   5. fill out curr memo cell.
 *      max = curr min * curr OR curr max * curr
 *      min = same with max.
 *   
 * @author Sunny Park
 *
 */
public class Q3_MatrixProduct {
    public static int findMatrixProduct(int[][] input) {
        Pair[][] memo = new Pair[input.length][input.length];
        memo[0][0] = Pair.of(input[0][0], input[0][0]) ;
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                if (i == 0 && j == 0) continue;
                int curr = input[i][j];
                
                if (i == 0) {
                    memo[i][j] = Pair.of(memo[i][j - 1].max * curr, memo[i][j - 1].max * curr);
                    continue;
                }
                
                if (j == 0) {
                    memo[i][j] = Pair.of(memo[i - 1][j].max * curr, memo[i - 1][j].max * curr);
                    continue;
                }
                
                
                int currMin = Math.min(memo[i - 1][j].min, memo[i][j - 1].min);
                int currMax = Math.max(memo[i - 1][j].max, memo[i][j - 1].max);
                
                memo[i][j] = Pair.of(Math.max(currMin * curr, currMax * curr), Math.min(currMin * curr, currMax * curr));         
            }
        }
        for (int i = 0; i < memo.length; i++) {
            System.out.println(Arrays.toString(memo[i]));
        }
        return memo[input.length - 1][input.length - 1].max;
    }
    
    private static class Pair {
        int max;
        int min;
        
        private Pair(int left, int right) {
            this.max = left;
            this.min = right;
        }
        
        static Pair of(int left, int right) {
            return new Pair(left, right);
        }
        
        @Override
        public String toString() {
            return  "(max: " + max + ", min: " + min + ")";
        }
    }
    
    public static void main(String[] args) {
        int[][] input = {{-1,2,3},{4,5,-6},{7,8,9}};
        System.out.print(findMatrixProduct(input));
    }
}
