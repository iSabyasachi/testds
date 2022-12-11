package testds.imp;
import java.util.*;
public class ContainsDuplicate{
    /**
    Time Complexity : O(N)
    Space Complexity : O(N)
     */
    public boolean containsDuplicate(int[] nums) {
       Set<Integer> numSet = new HashSet<>();
       for(int i = 0 ; i < nums.length ; i++){
        if(numSet.contains(nums[i])) return true;
        numSet.add(nums[i]);
       }
       return false;
    }
    /**
    Time Complexity : O(N Log N)
    Space Complexity : O(1), if heapsort was used.
     */
    public boolean containsDuplicateSorting(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1 ; i++){
            if(nums[i] == nums[i+1]) return true;
        }
        return false;
    }
    public static void main(String[] args){
        ContainsDuplicate obj = new ContainsDuplicate();
        int[] nums = {1, 2, 3, 1};
        boolean isTrue = obj.containsDuplicateSorting(nums);
        System.out.println(isTrue);
    }
}