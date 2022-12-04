// Kahn's algorithm
/**Direct Acyclic Graph */
/**
Time Complexity : O(E + V)
Space Complexity : O(V)
 */
package testds.graph;
import java.util.*;
public class TopologicalSorting{
    public Map<Integer, List<Integer>> buildGraph(int[][] edges){
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] edge : edges){
            List<Integer> verteces = new ArrayList<>();
            if(graph.containsKey(edge[1])){
                verteces = graph.get(edge[1]);
            }
            verteces.add(edge[0]);
            graph.put(edge[1], verteces);
        }
        return graph;
    }
    public static int[] topologicalSortBFS(Map<Integer, List<Integer>> graph, int totalV){
        int[] inDegree = new int[totalV];
        //Step1 : Find all indegrees
        for(int i : graph.keySet()){
            for(int j : graph.get(i)){
                inDegree[j]++;
            }
        }
        
        int[] result = new int[totalV];
        int v = 0;
        //Step2 : Add to queue, if indegree of any element is '0'
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0 ; i < inDegree.length ; i++){
            if(inDegree[i] == 0) {
                queue.offer(i);
                result[v++] = i;
            }
        }
        //Step3 : For any existing neighbor, decrement indegree, continue step 2
        while(!queue.isEmpty()){
            int curr = queue.poll();
            if(graph.containsKey(curr)){
                for(int neighbor : graph.get(curr)){
                    if(--inDegree[neighbor] == 0) {
                        queue.offer(neighbor);
                        result[v++] = neighbor;
                    }
                }
            }
        }
        //step4 : return result
        return result;
    }
    public static void main(String[] args){
        TopologicalSorting obj = new TopologicalSorting();
        int[][] edges = {{3, 0}, {2, 0}, {3, 2}, {1, 3}, {1, 2}, {1, 5}, {4, 1}, {4, 5}};
        Map<Integer, List<Integer>> graph = obj.buildGraph(edges);

        int[] res = obj.topologicalSortBFS(graph, 6);
        System.out.println(Arrays.toString(res));
    }
}