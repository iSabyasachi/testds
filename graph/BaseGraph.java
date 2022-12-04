package testds.graph;

import java.util.*;
/**
Time Complexity : O(Edge) or O(Edge + Node) or O(Node ^ 2)
Space Complexity : O(Node)
 */
public class BaseGraph{
    public static void testBfs(Map<Character, List<Character>> graph, char src){
        Queue<Character> queue = new LinkedList<>();
        queue.offer(src);
        while(!queue.isEmpty()){
            char curr = queue.poll();
            System.out.print(curr+" ");
            for(Character neighbor : graph.get(curr)){
                queue.offer(neighbor);
            }
        }
    }
    public static void testDfs(Map<Character, List<Character>> graph, char src){
        Stack<Character> stack = new Stack<>();
        stack.push(src);
        while(!stack.isEmpty()){
            char curr = stack.pop();
            System.out.print(curr+" ");
            for(char neighbor : graph.get(curr)){
                stack.push(neighbor);
            }
        }
    } 
    public static void testDfsUnDir(Map<Character, List<Character>> graph, Set<Character> visited, char src){
        Stack<Character> stack = new Stack<>();
        stack.push(src);        
        while(!stack.isEmpty()){
            char curr = stack.pop();
            visited.add(curr);
            System.out.print(curr+" ");
            for(char neighbor : graph.get(curr)){
                if(!visited.contains(neighbor))
                    stack.push(neighbor);
            }
        }
    } 
    static int count;
    public static void testDfsRec(Map<Character, List<Character>> graph, Set<Character> visited, char src){
        count++;
        if(visited.size() == graph.size()) return;

        System.out.print(src+" ");
        visited.add(src);

        for(char neighbor : graph.get(src)){
            if(!visited.contains(neighbor))
                testDfsRec(graph, visited, neighbor);
        }
    }
    public static void main(String[] args){
        //Undirected Graph
        Map<Character, List<Character>> graph = new HashMap<>();
        graph.put('a', List.of('b','c'));
        graph.put('b', List.of('a','d'));
        graph.put('c', List.of('a','e'));
        graph.put('d', List.of('b','f'));
        graph.put('e', List.of('c'));
        graph.put('f', List.of('d'));

        /*
        testDfsRec(graph, visited, 'a');
        System.out.println();
        System.out.println("count "+count);
        System.out.println();*/

        Set<Character> visited = new HashSet<>();
        visited = new HashSet<>();
        testDfsUnDir(graph, visited, 'a');
    }
    /*
    public static void main(String[] args){
        Map<Character, List<Character>> graph = new HashMap<>();
        //Undirected graph
        graph.put('a', List.of('b','c'));
        graph.put('b', List.of('d'));
        graph.put('c', List.of('e'));
        graph.put('d', List.of('f'));
        graph.put('e', new ArrayList<>());
        graph.put('f', new ArrayList<>());

        testBfs(graph, 'a');
        System.out.println();
        testDfs(graph, 'a');

        System.out.println();
        Set<Character> visited = new HashSet<>();
        testDfsRec(graph, visited, 'a');
    }*/
}