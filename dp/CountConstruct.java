package testds;
import java.util.*;

public class CountConstruct{

    public static int countConstruct(String target, String[] wordBank){
        if(target.equals("")) return 1;

        int totalCount = 0;
        for(int i = 0 ; i < wordBank.length ; i++){
            String prefix = wordBank[i];
            if(target.startsWith(prefix) && target.length() >= prefix.length()){
                String suffix = target.substring(prefix.length());
                int numOfWays = countConstruct(suffix, wordBank);
                totalCount += numOfWays;
            }
        }
        return totalCount;
    }
    public static int countConstructDP(String target, String[] wordBank, Map<String, Integer> memo){
        if(memo.containsKey(target)) return memo.get(target);
        else if(target.equals("")) return 1;

        int totalCount = 0;
        for(int i = 0 ; i < wordBank.length ; i++){
            String prefix = wordBank[i];
            if(target.startsWith(prefix) && target.length() >= prefix.length()){
                String suffix = target.substring(prefix.length());
                int numOfWays = countConstructDP(suffix, wordBank, memo);
                totalCount += numOfWays;
            }
        }
        memo.put(target, totalCount);
        return totalCount;
    }

    public static void main(String[] args){
        //String target = "abcdef";
        //String[] wordBank = {"ab", "abc", "cd", "def", "abcd","ef"};
        //String target = "skateboard";
        //String[] wordBank = {"bo", "rd", "ate", "t", "ska", "sk", "boar"};
        String target = "purple";
        String[] wordBank = {"purp", "p", "ur", "le", "purpl"};
        //int result = countConstruct(target, wordBank);
        Map<String, Integer> memo = new HashMap<>();
        int result = countConstructDP(target, wordBank, memo);
        System.out.println(result);
    }
}