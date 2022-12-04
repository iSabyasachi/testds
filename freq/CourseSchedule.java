package testds.freq;
import java.util.*;
public class CourseSchedule{
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> courseDict = new HashMap<>();
        for(int[] prerequisite : prerequisites){
            List<Integer> nodes = new ArrayList<>();
            if(courseDict.containsKey(prerequisite[1])){
                nodes = courseDict.get(prerequisite[1]);
            }
            nodes.add(prerequisite[0]);
            courseDict.put(prerequisite[1], nodes);
        }
        boolean[] path = new boolean[numCourses];
        for(int currCourse = 0 ; currCourse < numCourses ; currCourse++){
            if(this.isCyclic(currCourse, courseDict, path)){
                return false;
            }
        }
        return true;
    }
    public static boolean isCyclic(int currCourse, Map<Integer, List<Integer>> courseDict, boolean[] path){
        if(path[currCourse]) return true;//Cyclic
        if(!courseDict.containsKey(currCourse)) return false;
        
        path[currCourse] = true;

        boolean res = false;
        for(int nextCourse : courseDict.get(currCourse)){
            res = isCyclic(nextCourse, courseDict, path);
            if(res) break;
        }

        path[currCourse] = false;
        return res;
    }
    public static void main(String[] args){
        int n = 19;
        //int[][] edges = {{3,0}, {1,3}, {2,1}, {4,1}, {4,2}, {5,3},{5,4}};
        int[][] edges = {{0,10}, {3,18}, {5,5}, {6,11}, {11,14}, {13,1}, {15,1}, {17,4}};
        //int n = 2;
        //int[][] edges = {{0,1}};
        CourseSchedule obj = new CourseSchedule();
        //int n = 5;
        //int[][] edges = {{1,4}, {2,4}, {3,1}, {3,2}};
        boolean isTrue = obj.canFinish(n, edges);
        System.out.println(isTrue);
    }
}