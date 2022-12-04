package testds.graph;

import java.util.*;
public class LargestComponent{
    public static int largestComponent(Map<Integer, List<Integer>> graph){
        int largest = Integer.MIN_VALUE;
        Set<Integer> visited = new HashSet<>();
        for(Integer node : graph.keySet()){
            int curr = explore(graph, visited, node);
            largest = Math.max(largest, curr);
        }
        return largest;
    }
    public static int explore(Map<Integer, List<Integer>> graph, Set<Integer> visited, int src){
        if(visited.contains(src)) return 0;

        int count = 1;
        visited.add(src);
        for(Integer neighbor : graph.get(src)){
            count += explore(graph, visited, neighbor);
        }
        return count;
    }
    public static void main(String[] args){
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, List.of(8, 1, 5));
        graph.put(1, List.of(0));
        graph.put(5, List.of(0, 8));
        graph.put(8, List.of(0, 5));
        graph.put(2, List.of(3, 4));
        graph.put(3, List.of(2, 4));
        graph.put(4, List.of(3, 2));

        //System.out.println(explore(graph, new HashSet<>(), 2));
        System.out.println(largestComponent(graph));
    }
}