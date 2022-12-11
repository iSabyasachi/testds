package testds.imp;
import java.util.*;
public class BuyAndSellStock{
    /** Time Complexity : O(N)
        Space Complexity : O(1)
     */
    public int maxProfit(int[] prices) {
        if(prices.length <= 1) return 0;
        int peak = prices[0];
        int valley = peak;
        int maxProfit = 0;
        for(int i = 1 ; i < prices.length ; i++){
            if(prices[i] < valley){
                peak = prices[i];
                valley = peak;
            }else{
                peak = Math.max(peak, prices[i]);
                maxProfit = Math.max(maxProfit, peak - valley);
            }
        }
        return maxProfit;
    }   
    public static void main(String[] args){
        BuyAndSellStock obj = new BuyAndSellStock();
        int[] prices = {7,1,5,3,6,4};
        //int[] prices = {7,6,4,3,1};
        //int[] prices = {2,4,1};
        
        int res = obj.maxProfit(prices);
        System.out.println(res);
    }
}