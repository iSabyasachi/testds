package testds.freq;
import java.util.*;
/**
Time Complexity : O(Log N)
Space complexity : O(1)
 */
public class FindFirstAndLastVal{
    public static int[] findFirstAndSecond(int[] input, int target){
        int[] res = {-1, -1};

        //Find first occurance
        int first = findOccurances(input, target, true);
        System.out.println(first);
        //Find last occurance
        int second = findOccurances(input, target, false);
        
        return new int[]{first, second};
    }
    public static int findOccurances(int[] input, int target, boolean first){
        int low = 0, high = input.length - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(target == input[mid]){
                if(first){
                    if(mid - 1 >= 0 && input[mid - 1] != target){
                        return mid;
                    }else if(mid - 1 >= 0 && input[mid - 1] == target){
                        high = mid - 1;
                    }
                }else{
                    if(mid + 1 < input.length - 1 && input[mid + 1] != target){
                        return mid;
                    }else if(mid + 1 < input.length - 1 && input[mid + 1] == target){
                        low = mid + 1;
                    }
                }
            }else if(target > input[mid]){
                low = mid + 1;
            }else if(target < input[mid]){
                high = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        int[] input = {2, 4, 5, 5, 5, 5, 5, 7, 9, 9};
        int target = 5;
        int[] res = findFirstAndSecond(input, target);
        System.out.println(Arrays.toString(res));
    }
}