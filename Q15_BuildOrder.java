package top50_questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Q. Given a list of packages that need to be built and the dependencies for each package,
 * determine a valid order in which to build the packages.
 * e.g.
 * 0: 
 * 1: 0
 * 2: 0
 * 3: 1, 2
 * 4: 3
 * => 0,1,2,3,4
 * 
 * [Approach] topological sorting
 * 1. populate adjList
 * 2. create an indegree arr
 * 3. put pkg with indegree 0 to the q.
 * 4. poll. add to the result
 * 5. check neighbors. put to the q if indegree == 0. decrementing indegree.
 * 
 * @author Sunny Park
 *
 */
public class Q15_BuildOrder {
    public static List<Integer> buildOrder(List<List<Integer>> input) {
        int[] indegree = new int[input.size()];
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            adjList.add(new ArrayList<>());
        }
        
        int idx = 0;
        for (List<Integer> curr : input) {
            indegree[idx] = curr.size();
            for (int n : curr) {
                adjList.get(n).add(idx);
            }
            idx++;
        }
        
        List<Integer> result = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int ind : indegree) {
            if (ind == 0) q.offer(ind);
        }
        
        while (!q.isEmpty()) {
            int top = q.poll();
            result.add(top);
            
            for (int neighbor : adjList.get(top)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) q.offer(neighbor);
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        List<List<Integer>> input = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            input.add(new ArrayList<>());
        }
        input.get(1).add(0);
        input.get(2).add(0);
        input.get(3).addAll(Arrays.asList(1,2));
        input.get(4).add(3);
        
        System.out.println(buildOrder(input));
        
    }
}
