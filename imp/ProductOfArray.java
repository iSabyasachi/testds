package testds.imp;
import java.util.*;
public class ProductOfArray{
    /**
    Time Complexity : O(N)
    Space Complexity : O(1)
     */
    public int[] productExceptSelfSpaceOpt(int[] nums) {
        int[] res = new int[nums.length];

        res[0] = 1;
        for(int i = 1 ; i < nums.length ; i++){
            res[i] = res[i-1] * nums[i-1];
        }

        int R = 1;
        for(int i = res.length - 1 ; i >= 0 ; i--){
            res[i] = res[i] * R;
            R *= nums[i]; 
        }
        return res;
    }
    /**
    Time Complexity : O(N)
    Space Complexity : O(N)
     */
    public int[] productExceptSelfOpt(int[] nums) {
        int[] prefix = new int[nums.length];
        
        prefix[0] = 1;
        for(int i = 1 ; i < nums.length ; i++){
            prefix[i] = prefix[i-1] * nums[i-1];
        }
        System.out.println("prefix "+ Arrays.toString(prefix));

        int[] suffix = new int[nums.length];
        suffix[nums.length - 1] = 1;
        for(int i =  nums.length - 2; i >= 0 ; i--){
            suffix[i] = suffix[i+1] * nums[i+1];
        }
        System.out.println("suffix "+ Arrays.toString(suffix));

        int[] res = new int[nums.length];
        for(int i = 0 ; i < res.length ; i++){
            res[i] = prefix[i] * suffix[i];
        }
        
        return res;
    }
    /**
    Time Complexity : O(N^2)
     */
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        for(int i = 0 ; i < nums.length ; i++){
            int product = 1;
            for(int j = 0 ; j < nums.length ; j++){
                if(j != i)
                    product *= nums[j];
            }
            res[i] = product;
        }
        return res;
    }
    public static void main(String[] args){
        ProductOfArray obj = new ProductOfArray();
        //int[] nums = {1,2,3,4};
        int[] nums = {-1,1,0,-3,3};
        int[] res = obj.productExceptSelfSpaceOpt(nums);
        System.out.println("res "+Arrays.toString(res));
    }
}