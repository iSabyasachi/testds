package testds;
import java.util.*;
/**
Optimized Time Complexity : O(M * N) & Space Complexity : O (M + N)
Bruteforce Tome Complexity : O(2 ^ (M + N) & Space Complexity : O (M + N))
 */
public class TravelDP{
    private static int count = 0;
    
    public static int travelDP(int a[][], int row, int col, Map<String, Integer> hMap){
        String key = row+","+col;
        if(hMap.containsKey(key))  return hMap.get(key);
        
        if(row == 0 || col == 0) return 0;
        else if(row == 1 && col == 1) return 1;        

        hMap.put(key, travelDP(a, row - 1, col, hMap) + travelDP(a, row, col - 1, hMap));        
        return hMap.get(key);
    }
    public static int travel(int a[][], int row , int col){
        count++;
        if(row == 0 || col == 0) return 0;
        else if(row == 1 && col == 1) return 1;
        
        return travel(a, row - 1, col) + travel(a, row, col - 1);
    }
    public static long tarvelTabulation(int m, int n){
        long[][] array = new long[m+1][n+1];
        for(long[] row : array){
            Arrays.fill(row, 0);
        }
        array[1][1] = 1;
        for(int i = 0 ; i <= m ; i++){
            for(int j = 0 ; j <= n ; j++){
                if(j + 1 <= n) array[i][j + 1] += array[i][j];
                if(i + 1 <= m) array[i + 1][j] += array[i][j]; 
            }
        }

        System.out.println(Arrays.deepToString(array));
       
        return array[m][n];
    }
    public static void main(String[] args){
        System.out.println("Hello World");
        int a[][] = {{1,2,3},{4,5,6}};
        
        //int numOfWays = travel(a, 18, 18);
        Map<String, Integer> hMap = new HashMap<>();
        int numOfWays = travelDP(a, 2, 3, hMap);
        System.out.println(numOfWays);
        System.out.println(count);
        System.out.println(hMap);
    }
}
