package testds;
import java.util.*;
import java.util.stream.*;

public class Fib{
    public static int fib(int n){
        if(n == 0) return 0;
        else if(n == 1) return 1;

        return fib(n - 1) + fib(n - 2);
    }
    public static int fibDP(int n, int[] memo){
        if(memo[n] != -1) return memo[n];
        if(n == 0) return 0;
        else if(n == 1) return 1;

        memo[n] = fibDP(n - 1, memo) + fibDP(n - 2, memo);
        return memo[n];
    }
    public static long fibTab(int n){
        long[] tab = new long[n + 1];
        Arrays.fill(tab, 0);
        tab[1] = 1;        
        for(int i = 2 ; i <= n ; i++){
            tab[i] = tab[i - 1] + tab[i - 2];
        }
        return tab[n];
    }
    public static void main(String[] args){
        int n = 50;
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        //System.out.println(fibDP(n, memo));
        System.out.println(fibTab(n));
    }
}