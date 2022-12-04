package testds;
import java.util.*;
public class BestSum{
    public static List<Integer> bestSum(int targetSum, int[] numbers){
        if(targetSum == 0) return new ArrayList<>();
        else if(targetSum < 0) return null;

        List<Integer> bestSum = null;
        for(int i = 0 ; i < numbers.length ; i++){
            int remainder = targetSum - numbers[i];
            
            List<Integer> bestSumSub = bestSum(remainder, numbers);
            if(bestSumSub != null){
                bestSumSub.add(numbers[i]);
                List<Integer> currSumSub = new ArrayList<>(bestSumSub);
                if(bestSum == null || currSumSub.size() < bestSum.size()){
                    bestSum = new ArrayList<>(currSumSub);
                }
            }
        }
        return bestSum;
    }
    public static List<Integer> bestSumDp(int targetSum, int[] numbers, Map<Integer, List<Integer>> memo){
        if(memo.containsKey(targetSum)) return memo.get(targetSum);
        else if(targetSum == 0) return new ArrayList<>();
        else if(targetSum < 0) return null;

        List<Integer> bestSum = null;
        for(int i = 0 ; i < numbers.length ; i++){
            int remainder = targetSum - numbers[i];
            
            List<Integer> bestSumSub = bestSumDp(remainder, numbers, memo);
            if(bestSumSub != null){
                List<Integer> currSumSub = new ArrayList<>(bestSumSub);
                currSumSub.add(numbers[i]);
                
                if(bestSum == null || currSumSub.size() < bestSum.size()){
                    bestSum = currSumSub;
                }
            }
        }
        memo.put(targetSum, bestSum);
        return bestSum;
    }
     public static List<Integer> bestSumTabulation(int targetSum, int[] numbers){
        Map<Integer, List<Integer>> table = new HashMap<>();
        for(int i = 0 ; i <= targetSum ; i++){
            table.put(i, null);
        }
        table.put(0, new ArrayList<>());
        for(int i = 0 ; i <= targetSum ; i++){
            if(table.get(i) != null){
                for(int num : numbers){
                    if(i + num <= targetSum){
                        List<Integer> currList = new ArrayList<>(table.get(i));
                        currList.add(num);
                        if(table.get(i + num) == null || table.get(i + num).size() > currList.size()){
                            table.put(i + num, currList);
                        }
                    }
                }
            }
        }
        System.out.println("table "+table);
        return table.get(targetSum);
   }
    public static void main(String[] args){
        //int targetSum = 7;
        //int[] numbers = {5, 3, 4, 7};
        //int targetSum = 8;
        //int[] numbers = {2, 3, 5};
        //int targetSum = 8;
        //int[] numbers = {1, 4, 5};
        int targetSum = 100;
        int[] numbers = {1, 2, 5, 25};
        //System.out.println(bestSum(targetSum, numbers));
        //Map<Integer, List<Integer>> memo = new HashMap<>();
        //System.out.println(bestSumDp(targetSum, numbers, memo));
        //System.out.println(memo);
        List<Integer> result = bestSumTabulation(targetSum, numbers);
        System.out.println("result "+result);
    }
}