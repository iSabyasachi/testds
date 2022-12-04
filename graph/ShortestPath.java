package testds.graph;

import java.util.*;
import java.util.stream.*;
public class ShortestPath{
    public static Map<Character, List<Character>> buildGraph(List<Character[]> edges){
        Map<Character, List<Character>> graph = new HashMap<>();
        for(Character[] edge : edges){
            List<Character> nodes = graph.getOrDefault(edge[0], new ArrayList<>());
            nodes.add(edge[1]);
            graph.put(edge[0], nodes);

            nodes = graph.getOrDefault(edge[1], new ArrayList<>());
            nodes.add(edge[0]);
            graph.put(edge[1], nodes);
        }
        return graph;
    }
    
     public static int shortestPath(Map<Character, List<Character>> graph,Set<Character> visited, char src, char dest){
        if(src == dest) return 0;

        visited.add(src);        
        int shortestPath = Integer.MAX_VALUE;
        for(char neighbor : graph.get(src)){
        	if(!visited.contains(neighbor)) {
        		int count = 1 + shortestPath(graph, visited, neighbor, dest);
                shortestPath = Math.min(shortestPath, count);
        	}
        }
        return shortestPath;
    }
    public static int shortestPathBFS(Map<Character, List<Character>> graph, char src, char dest) {
    	Queue<Map<Character,Integer>> queue = new LinkedList<>();
    	queue.offer(Map.of(src, 0));
    	Set<Character> visited = Stream.of(new Character[]{src}).collect(Collectors.toSet());

    	
    	while(!queue.isEmpty()) {
    		Map<Character,Integer> currMap = queue.poll();
            char currKey = currMap.keySet().stream().findFirst().get();
            int currVal = currMap.get(currKey);

            if(currKey == dest) return currVal;

    		for(Character neighbor : graph.get(currKey)) {                
        		if(!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(Map.of(neighbor, currVal + 1));
                }
        	}
    	}
    	return -1;
    }
    public static void main(String[] args){
        List<Character[]> edges = new ArrayList<>();
        edges.add(new Character[]{'w', 'x'});
        edges.add(new Character[]{'x', 'y'});
        edges.add(new Character[]{'z', 'y'});
        edges.add(new Character[]{'z', 'v'});
        edges.add(new Character[]{'w', 'v'});

        /*Set<Character> visited = new HashSet<>();
        Map<Character, List<Character>> graph = buildGraph(edges);
        System.out.println(graph);
        int res = shortestPath(graph, visited, 'w', 'z');
        System.out.println("Shortest Path "+res);*/

        Map<Character, List<Character>> graph = buildGraph(edges);
        System.out.println(graph);
       
        int res = shortestPathBFS(graph, 'w', 'z');
        System.out.println("Shortest Path "+res);
        
       
    }
}