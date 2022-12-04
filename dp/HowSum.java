package testds;
import java.util.*;
public class HowSum{
    public static List<Integer> howSum(int targetSum, int[] numbers){
        if(targetSum == 0) return new ArrayList<>();
        else if(targetSum < 0) return null;
       
        for(int i = 0 ; i < numbers.length ; i++){
            int remainder = targetSum - numbers[i];
            List<Integer> subResult = howSum(remainder, numbers);
            if(subResult != null){
                subResult.add(numbers[i]);
                return subResult;
            }
        }
        return null;
    }
    public static List<Integer> howSumDP(int targetSum, int[] numbers, Map<Integer, List<Integer>> memo){
        if(memo.containsKey(targetSum)) return memo.get(targetSum);
        if(targetSum == 0) return new ArrayList<>();
        else if(targetSum < 0) return null;
       
        for(int i = 0 ; i < numbers.length ; i++){
            int remainder = targetSum - numbers[i];
            List<Integer> subResult = howSumDP(remainder, numbers, memo);
            if(subResult != null){
                subResult.add(numbers[i]);
                memo.put(numbers[i], subResult);
                return subResult;
            }
        }
        return null;
    }
    public static List<Integer> howSumTabulation(int targetSum, int[] numbers){
        Map<Integer, List<Integer>> table = new HashMap<>();
        for(int i = 0 ; i <= targetSum ; i++){
            if(i != 0)
                table.put(i, null);
            else
                table.put(0, new ArrayList<>());
        }
        for(int i = 0 ; i <= targetSum ; i++){
            if(table.get(i) != null){
                for(int num : numbers){
                    if(i + num <= targetSum){
                        List<Integer> currList = new ArrayList<>(table.get(i));
                        currList.add(num);
                        table.put(i + num, currList);
                    }
                }
            }
        }
        System.out.println(table);
        return table.get(targetSum);
    }
    public static void main(String[] args){
        System.out.println("Hello World");
        //int targetSum = 7;
        //int[] numbers = {5, 3, 4, 7};
        //int targetSum = 300;
        //int[] numbers = {7, 14};
        //List<Integer> result = howSum(targetSum, numbers);
        //System.out.println(result);
        //Map<Integer, List<Integer>> memo = new HashMap<>();
        //List<Integer> result = howSumDP(targetSum, numbers, memo);
        //System.out.println(result);
        //System.out.println(memo);
        // int[] numbers = {2, 3};
        //int[] numbers = {5, 3, 4, 7};
        //int[] numbers = {2, 3, 5};
        int targetSum = 300;
        int[] numbers = {7, 14};
        List<Integer> result = howSumTabulation(targetSum, numbers);
        System.out.println(result);
        
    }
}
