package testds.freq;
import java.util.*;
public class CourseSchedule{
    List<List<Integer>> graph = new ArrayList<>();
    Set<Integer> path = new HashSet<>();
    boolean[] visited;
    boolean cycleDetected = false;
    /**
    Time Complexity : O(E + V ^ 2)
    Space Complexity : O(E + V)
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new boolean[numCourses];
        for(int i = 0 ; i < numCourses ; i++) graph.add(new ArrayList<>());
        for(int[] req : prerequisites) graph.get(req[1]).add(req[0]);

        for(int i = 0 ; i < numCourses ; i++){
            detectCycle(graph, i);
        }
        
        return !cycleDetected;
    }
    public void detectCycle(List<List<Integer>> graph, int curr){
        if(visited[curr]) return;

        visited[curr] = true;

        path.add(curr);
        for(int neighbor : graph.get(curr)){
            if(path.contains(neighbor)){
                cycleDetected = true;
                break;
            }
            detectCycle(graph, neighbor);
        }
        path.remove(curr);
    }
    /**
    Time Complexity : O(E + V)
    Space Complexity : O(V)
     */
     /*
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] prerequisite : prerequisites){
            List<Integer> list = new ArrayList<>();
            if(map.containsKey(prerequisite[1])){
                list = map.get(prerequisite[1]);
            }
            list.add(prerequisite[0]);
            map.put(prerequisite[1], list);
        }
        List<Integer> res = topologicalSort(map, numCourses);

        return res.size() == numCourses; 
    }
    public List<Integer> topologicalSort(Map<Integer, List<Integer>> map, int nodes){
        //1. Find indegrees of all nodes
        //2. Create a queue and add all nodes that have indegree '0' and add those nodes to result
        //3. Find all neighbors and decrements their indegree, if zero continue step 2
        int[] indegrees = new int[nodes];
        for(int node : map.keySet()){
            for(int neighbor : map.get(node)){
                indegrees[neighbor]++;
            }
        }
        System.out.println("indegrees "+Arrays.toString(indegrees));
        List<Integer> result = new ArrayList<>();
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 0 ; i < indegrees.length ; i++){
            if(indegrees[i] == 0){
                queue.offer(i);
                result.add(i);
            }
        }
        while(!queue.isEmpty()){
            int currNode = queue.poll();
            if(map.containsKey(currNode)){
                for(int neighbor : map.get(currNode)){
                    if(--indegrees[neighbor] == 0){
                        queue.offer(neighbor);
                        result.add(neighbor);
                    };
                }
            }
        }
        System.out.println("result "+result);
        return result;
    }*/
    public static void main(String[] args){
        int n = 6;
        int[][] edges = {{3,0}, {1,3}, {2,1}, {4,1}, {4,2}, {5,3},{5,4}};
        //int n = 2;
        //int[][] edges = {{0, 1},{1, 0}};
        CourseSchedule obj = new CourseSchedule();

        boolean isTrue = obj.canFinish(n, edges);
        System.out.println(isTrue);
    }
}