package testds.imp;
import java.util.*;
public class TwoSum{
    /**
    Time Complexity : O(N)
    Space Complexity : O(N)
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> table = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            int val = target - nums[i];
            if(table.containsKey(val)){
                return new int[]{table.get(val), i};
            }else{
                table.put(nums[i], i);
            }
        }
        return new int[]{-1, -1};
    }
    public static void main(String[] args){
        TwoSum obj = new TwoSum();
        int[] nums = {2,7,11,15}; 
        int target = 9;
        int[] res = obj.twoSumBS(nums, target);
        System.out.println(Arrays.toString(res));
    }
}