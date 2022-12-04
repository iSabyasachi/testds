package testds.freq;
import java.util.*;
public class KthLargestElement{
    
    /**
    Time Complexity : O(N Log N)
    Space Complexity : O(N)
     */
    public static int kthLargestElement(int[] arr, int k){
        if(arr.length == 0 || k > arr.length) return -1;
        Arrays.sort(arr);
        // 1 2 3 4 5 6
        return arr[arr.length - 1 - k + 1];
    }
    public static void main(String[] args){
        int[] arr = {2,1,4,5,6,3};
        int k = 2;
        System.out.println(kthLargestElement(arr, k));
    }
}