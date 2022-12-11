package testds.imp;
import java.util.*;
public class NumberOfIslands{
    /**
    Time Complexity : O(M * N)
    Space Complexity : O(M * N)
     */
    public int numIslands(char[][] grid) {
        if(grid.length == 0) return 0;
        Set<String> visited = new HashSet<>();
        int res = 0;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[i].length ; j++){
                String key = i +","+ j;
                if(!visited.contains(key)){
                    if(explore(grid, visited, i, j)){
                        res++;
                    }
                }
            }
        }
        return res;
    }
    private boolean explore(char[][] grid, Set<String> visited, int i, int j){
        String key = i +","+ j;        
        boolean rowInbound = i >= 0 && i < grid.length;
        boolean colInbound = j >= 0 && j < grid[0].length;
        if(!rowInbound || !colInbound) return false;        
        if(grid[i][j] == '0') return false;
        if(visited.contains(key)) return false;
        visited.add(key);

        
        explore(grid, visited, i - 1, j); 
        explore(grid, visited, i + 1, j); 
        explore(grid, visited, i, j - 1); 
        explore(grid, visited, i, j + 1); 
        
        return true;
    }
    public static void main(String[] args){
        NumberOfIslands obj = new NumberOfIslands();
        char[][] grid = {   {'1','1','0','0','0'},
                            {'1','1','0','0','0'},
                            {'0','0','1','0','0'},
                            {'0','0','0','1','1'}
                        };
        /*char[][] grid = {   {'1','1','1','1','0'},
                            {'1','1','0','1','0'},
                            {'1','1','0','0','0'},
                            {'0','0','0','0','0'}
                        };*/
        int res = obj.numIslands(grid);
        System.out.println("Number of islands "+res);
    }
}