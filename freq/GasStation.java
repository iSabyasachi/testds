package testds.freq;
import java.util.*;

public class GasStation{
    public static int findGasStation(int[] gas, int[] cost){
        if(gas.length != cost.length) return -1;
        
        for(int i = 0 ; i < gas.length ; i++){
            if(isGasAvailable(gas, cost, i)) return i;
        }
        return -1;
    }
    // int[] gas = new int[]{1, 5, 3, 3, 5, 3, 1, 3, 4, 5};
    //int[] cost = new int[]{5, 2, 2, 8, 2, 4, 2, 5, 1, 2};
    public static boolean isGasAvailable(int[] gas, int[] cost, int n){
        int tank = 0;
        
        for(int i = n ; i < gas.length ; i++){ 
            tank = tank + gas[i];           
            if(tank - cost[i] < 0) return false;
            else{
                tank = tank - cost[i];
            }
        }
        for(int i = 0 ; i < n ; i++){
            tank = tank + gas[i];           
            if(tank - cost[i] < 0) return false;
            else{
                tank = tank - cost[i];
            }
        }
        return true;
    }
    public static void main(String[] args){
        int[] gas = new int[]{1, 5, 3, 3, 5, 3, 1, 3, 4, 5};
        int[] cost = new int[]{5, 2, 2, 8, 2, 4, 2, 5, 1, 2};
        //int[] gas = new int[]{1, 2, 3, 4, 5};
        //int[] cost = new int[]{3, 4, 5, 1, 2};
        int res = findGasStation(gas, cost);
        System.out.println(res);
    }
}