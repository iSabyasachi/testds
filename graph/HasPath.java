package testds.graph;

import java.util.*;
/**Directed Graph */
public class HasPath{
    public static boolean hasPathBFS(Map<Character, List<Character>> graph, char src, char dest){
        Queue<Character> queue = new LinkedList<>();
        queue.offer(src);
        while(!queue.isEmpty()){
            char curr = queue.poll();
            if(curr == dest) return true;
            for(char neighbor : graph.get(curr)){
                queue.offer(neighbor);
            }
        }
        return false;
    }
    public static boolean hasPathDFS(Map<Character, List<Character>> graph, char src, char dest){
        Stack<Character> stack = new Stack<>();
        stack.push(src);
        while(!stack.isEmpty()){
            char curr = stack.pop();
            if(curr == dest) return true;
            for(char neighbor : graph.get(curr)){
                stack.push(neighbor);
            }
        }
        return false;
    }
    public static boolean hasPathDFSRec(Map<Character, List<Character>> graph, char src, char dest){
        if(src == dest) return true;

        for(char neighbor : graph.get(src)){
            boolean hasPath = hasPathDFSRec(graph, neighbor, dest);
            if(hasPath) return true;
        }

        return false;
    }
    public static void main(String[] args){
        Map<Character, List<Character>> graph = new HashMap<>();

        graph.put('f', List.of('g','i'));
        graph.put('g', List.of('h'));
        graph.put('h', new ArrayList<>());
        graph.put('i', List.of('g','k'));
        graph.put('j', List.of('i'));
        graph.put('k', new ArrayList<>());

        //System.out.println("Has Path "+hasPathDFSRec(graph, 'g', 'k'));
        //System.out.println("Has Path "+hasPathDFS(graph, 'f', 'k'));
        System.out.println("Has Path "+hasPathBFS(graph, 'f', 'k'));
    }
}