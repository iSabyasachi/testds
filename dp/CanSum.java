package testds;
import java.util.*;
/**
M : Target Sum & N : Array Length
Optimized Time Complexity : O(N * M) & Space Complexity : O (M)
Bruteforce Tome Complexity : O(N ^ M) & Space Complexity : O (M))
 */
public class CanSum{
    public static boolean canSumDP(int targetSum , int[] numbers, boolean[] memo){
        if(memo[targetSum] == true) return true;
        else if(targetSum == 0) return true;

        for(int i = 0 ; i < numbers.length ; i++){
            int remainder = targetSum - numbers[i];
            if(remainder >= 0 && canSumDP(remainder, numbers, memo) == true){
                memo[remainder] = true;
                return true;
            };
        }
        memo[targetSum] = false;
        return false;
    }
    public static boolean canSum(int targetSum , int[] numbers){
        if(targetSum == 0) return true;
        
        for(int i = 0 ; i < numbers.length ; i++){
            int currSum = targetSum - numbers[i];
            if((targetSum - numbers[i]) >= 0){
                if(canSum(currSum, numbers)) return true;
            }
        }

        return false;
    }
    public static boolean canSumTabulation(int targetSum, int[] numbers){
        boolean[] table = new boolean[targetSum+1];
        Arrays.fill(table, false);
        table[0] = true;
        for(int i = 0 ; i <= targetSum ; i++){
            if(table[i]){
                for(int num : numbers){
                    if(i + num <= targetSum)
                        table[i + num] = true;
                }
            }
        }
        return table[targetSum];
    }
    public static void main(String[] args){
        System.out.println("Hello World");
        //boolean isTrue = canSum(7, new int[]{5, 3, 4, 7});
        //System.out.println(isTrue);
        
        int targetSum = 7;
        boolean[] memo = new boolean[targetSum+1];
        Arrays.fill(memo, false);
        boolean isTrue = canSumDP(targetSum, new int[]{5, 3, 4, 7}, memo);
        System.out.println(isTrue);
        System.out.println(Arrays.toString(memo));
        //System.out.println(canSumTabulation(targetSum, numbers));
    }
}
