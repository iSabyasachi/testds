package testds.dp;
import java.util.*;
public class MinCoins{
    public int findMinCoinsUsingDP(int[] arr, int n, int[] memory){
        //Base Case 
        if(n == 0) return 0;
        
        int ans = Integer.MAX_VALUE;
        for(int i = 0 ; i < arr.length ; i++){
            if(n - arr[i] >= 0){
                int subAns = 0;
                if(memory[n - arr[i]] != -1){
                    subAns = memory[n - arr[i]];
                }else{
                    subAns = findMinCoinsUsingDP(arr, n - arr[i], memory);
                }
                if(subAns != Integer.MAX_VALUE && subAns + 1 < ans){
                    ans = subAns + 1;
                }
            }
        }
        return memory[n] = ans;
    }
    public int findMinCoins(int[] arr, int n){
        //Base Case
        if(n == 0) return 0;
        int ans = Integer.MAX_VALUE;

        for(int i = 0 ; i < arr.length ; i++){
            if(n - arr[i] >= 0){
                int subAns = findMinCoins(arr, n - arr[i]);
                if(subAns != Integer.MAX_VALUE && subAns + 1 < ans){
                    ans = subAns + 1;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args){
        System.out.println("Hello DP");
        MinCoins obj = new MinCoins();
        int[] arr = {7,5,1};
        //int numOfCoins = obj.findMinCoins(arr, 18);
        
        int n = 18;
        int[] memory = new int[n+1];
        Arrays.fill(memory, -1);
        memory[0] = 0;
        int numOfCoins = obj.findMinCoinsUsingDP(arr, n, memory);
        System.out.println(numOfCoins);
    }
}
