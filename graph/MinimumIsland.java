package testds.graph;

import java.util.*;
public class MinimumIsland{
    public static int minimumIsland(char[][] grid){
        int minimum = Integer.MAX_VALUE;
        Set<String> visited = new HashSet<>();
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                int currValue = explore(grid, i, j, visited);
                System.out.println(i+","+j+"->"+currValue);
                if(currValue != 0){
                    minimum = Math.min(minimum, currValue);
                }
            }
        }
        return minimum;
    }
    public static int explore(char[][] grid, int row, int col, Set<String> visited){
        boolean rowInbound = 0 <= row && row < grid.length;
        boolean colInbounded = 0 <= col && col < grid[0].length;
        if(!rowInbound || !colInbounded) return 0;

        if(grid[row][col] == 'W') return 0;
        
        String pos = row+","+col;
        if(visited.contains(pos)) return 0;
        visited.add(pos);
        
        
        int count = 1 + explore(grid, row - 1, col, visited)
                        + explore(grid, row + 1, col, visited)
                        + explore(grid, row, col - 1, visited)
                        + explore(grid, row, col + 1, visited);
        
        return count;
    }
    public static void main(String[] args){
        char[][] grid =
        {{'W', 'L', 'W', 'W', 'L', 'W'},
         {'L', 'L', 'W', 'W', 'L', 'W'},
         {'W', 'L', 'W', 'W', 'W', 'W'},
         {'W', 'W', 'W', 'L', 'L', 'W'},
         {'W', 'L', 'W', 'L', 'L', 'W'},
         {'W', 'W', 'W', 'W', 'W', 'W'}};
        
         Set<String> visited = new HashSet<>();
         //int count = explore(grid, 0, 1, visited);
         //System.out.println(count);
         int min = minimumIsland(grid);
         System.out.println(min);
         
    }
}