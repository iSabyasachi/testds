/**Direct Acyclic Graph */
package testds.graph;
import java.util.*;
/** Time Complexity : O(E + V)
Space Complexity : O(V)
 */
public class DAG{
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
    public void topologicalSort(Map<Integer, List<Integer>> graph, int v){
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[v];

        for(int i = 0 ; i < v ; i++){
            if(!visited[i])
            this.findPath(i, graph, stack, visited);
        }
        
        int[] res = new int[stack.size()];
        int i = 0;
        while(!stack.isEmpty()){
            res[i] = stack.pop();
            i++;
        }
        System.out.println(Arrays.toString(res));
    }
    private void findPath(int v, 
                            Map<Integer, List<Integer>> graph, Stack<Integer> stack, boolean[] visited){
        if(!graph.containsKey(v)) return;
        visited[v] = true;

        for(int neighbor : graph.get(v)){
            if(!visited[neighbor])
                findPath(neighbor, graph, stack, visited);
        }
        stack.push(v);
    }
    public static void main(String[] args){
        DAG obj = new DAG();
        int[][] edges = {{3, 0}, {2, 0}, {3, 2}, {1, 3}, {1, 2}, {4, 1}, {4, 5}};
        Map<Integer, List<Integer>> graph = obj.buildGraph(edges);
        System.out.println(graph);
        obj.topologicalSort(graph, 6);
    }
}
