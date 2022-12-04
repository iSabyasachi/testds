package testds.graph;

import java.util.*;
/**Directed Graph */
public class HasPathUnDirected{
    public static Map<Character, List<Character>> buildGraph(List<Character[]> edges){
        Map<Character, List<Character>> graph = new HashMap<>();
        for(Character[] edge : edges){            
            List<Character> neighbors = graph.getOrDefault(edge[0], new ArrayList<>());
            neighbors.add(edge[1]);
            graph.put(edge[0], neighbors);

            neighbors = new ArrayList<>();
            neighbors = graph.getOrDefault(edge[1], new ArrayList<>());
            neighbors.add(edge[0]);
            graph.put(edge[1], neighbors);
        }
        return graph;
    }
    public static boolean hasPath(Map<Character, List<Character>> graph, Set<Character> visited, char src, char dest){
        Stack<Character> stack = new Stack<>();
        stack.push(src);
        while(!stack.isEmpty()){
            char curr = stack.pop();
            visited.add(curr);
            for(char neighbor : graph.get(curr)){
                if(neighbor == dest) return true;
                if(!visited.contains(neighbor)){
                    stack.push(neighbor);
                }
            }
        }
        return false;
    }
    public static boolean hasPathRec(Map<Character, List<Character>> graph, Set<Character> visited, char src, char dest){
        if(src == dest) return true;
        if(visited.contains(src)) return false;
        
        visited.add(src);
        for(Character neighbor : graph.get(src)){ 
            boolean hasPath = hasPathRec(graph, visited, neighbor, dest);
            if(hasPath) return true;
        }
        return false;
    }
    public static void main(String[] args){
        
        List<Character[]> edges = new ArrayList<>();
        edges.add(new Character[]{'i','j'});
        edges.add(new Character[]{'k','i'});
        edges.add(new Character[]{'m','k'});
        edges.add(new Character[]{'k','l'});
        edges.add(new Character[]{'o','n'});

        Map<Character, List<Character>> graph = buildGraph(edges);
        System.out.println(graph);

        Set<Character> visited = new HashSet<>();
        System.out.println(hasPathRec(graph, visited, 'i', 'k'));
        System.out.println(visited);

    }
}