package testds.graph;

import java.util.*;
public class ConnectedComponents{
    public static int countConnectedComponentsRec(Map<Integer, List<Integer>> graph){
        int count = 0;
        Set<Integer> visited = new HashSet<>();
        for(int node : graph.keySet()){
            boolean found = explore(graph, visited, node);
            if(found) count++;
        }
        return count;
    }
    private static boolean explore(Map<Integer, List<Integer>> graph, Set<Integer> visited, int src){
        if(visited.contains(src)) return false;
        visited.add(src);
        for(int neighbor : graph.get(src)){
            explore(graph, visited, neighbor);
        }
        return true;
    }
    public static int countConnectedComponents(Map<Integer, List<Integer>> graph){
        int count = 0;
        Stack<Integer> stack = new Stack<>();       
        Set<Integer> visited = new HashSet<>();        
        for(int node : graph.keySet()){            
            if(!visited.contains(node)){
                stack.push(node);
                while(!stack.isEmpty()){
                    int curr = stack.pop();
                    if(!visited.contains(curr)){
                        visited.add(curr);
                        for(int neighbor : graph.get(curr)){
                            stack.push(neighbor);
                        }
                    }
                }
                count++;
            }
        }
        return count;
    }
    public static List<Set<Integer>> totalConnectedComponents(Map<Integer, List<Integer>> graph){
        List<Set<Integer>> islands = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();       
        Set<Integer> visited = new HashSet<>();        
        for(int node : graph.keySet()){            
            if(!visited.contains(node)){
                Set<Integer> allNodes = new HashSet<>();                
                stack.push(node);
                while(!stack.isEmpty()){
                    int curr = stack.pop();
                    visited.add(curr);
                    allNodes.add(curr);
                    for(int neighbor : graph.get(curr)){
                        if(!visited.contains(neighbor)){
                            stack.push(neighbor);
                        }
                    }
                }
                islands.add(allNodes);
            }
        }
        return islands;
    }
    public static void main(String[] args){
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(3, new ArrayList<>());
        graph.put(4, List.of(6));
        graph.put(6, List.of(4, 5, 7, 8));
        graph.put(8, List.of(6));
        graph.put(7, List.of(6));
        graph.put(5, List.of(6));
        graph.put(1, List.of(2));
        graph.put(2, List.of(1));
        List<Set<Integer>> islands = totalConnectedComponents(graph);
        System.out.println(islands);

        int count = countConnectedComponentsRec(graph);
        System.out.println(count);
    }
}