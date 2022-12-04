package testds.graph;

import java.util.*;
public class IslandCount{
    public static int islandCount(char[][] grid, int rowLength, int colLength){
        Set<String> visited = new HashSet<>(); 
        int countIsland = 0;
        for(int row = 0 ; row <rowLength ; row++){
            for(int col = 0 ; col <colLength ; col++){
                boolean isFound = explore(grid, visited, row, col);
                if(isFound) countIsland++;
            }
        }
        return countIsland;
    }
    public static boolean explore(char[][] grid, Set<String> visited, int row, int col){
        boolean rowInbounds = 0 <= row && row < grid.length;
        boolean colInbounds = 0 <= col && col < grid[0].length;
        if(!rowInbounds || !colInbounds) return false; 

        if(grid[row][col] == 'W') return false;

        if(visited.contains(row+","+col)) return false;
        visited.add(row+","+col);

        explore(grid, visited, row - 1, col);
        explore(grid, visited, row + 1, col);
        explore(grid, visited, row, col - 1);
        explore(grid, visited, row, col + 1);
        System.out.println("visited "+visited);

        return true;
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
         //boolean found = explore(grid, visited, 0, 1);
         int count = islandCount(grid, 6, 6);
         System.out.println(count);
    }
}