package top50_questions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Question: Given a boolean matrix, update it so that if any cell is true, 
 * all the cells in that row and column are true.
 * 
    [true,  false, false]      [true,  true,  true ]
    [false, false, false]  ‐>  [true,  false, false]
    [false, false, false]      [true,  false, false]
    
 * 
 * [Approach] Linear scan
 * 1. if curr cell is true -> fill row & col
 * 2. by keeping visited, avoid repeating.
 *    - row 0, 1, 2, ... 
 *    - col -1, -2, -3, ...
 * 
 * @author Sunny Park
 *
 */
public class Q06_ZeroMatrix {
    public static boolean[][] getZeroMatrix(boolean[][] input) {
        boolean[][] output = new boolean[input.length][input[0].length];
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                if (!input[i][j]) continue;
                fillRow(output, i, visited);
                fillCol(output, j, visited);
            }
        }
        return output;
    }
    
    public static void fillRow(boolean[][] output, int i, Set<Integer> visited) {
        if (visited.contains(i)) return;
        visited.add(i);
        Arrays.fill(output[i], true);
    }
    
    public static void fillCol(boolean[][] output, int j, Set<Integer> visited) {
        int col = - Math.abs(j) - 1;
        if (visited.contains(col)) return;
        visited.add(col);
        for (int c = 0; c < output[0].length; c++) {
            output[c][j] = true;
        }
    }
    
    public static void main(String[] args) {
        boolean[][] input = {{true, true, false}, {false, false, false}, {false, false, false}};
        boolean[][] output = getZeroMatrix(input);
        for (int i = 0; i < output.length; i++) {
            System.out.println(Arrays.toString(output[i]));
        }
    }
}
