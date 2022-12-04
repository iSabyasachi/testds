package testds;
import java.util.*;

public class CanConstruct{
    
    public static boolean canConstruct(String target, String[] wordBank){
        if(target.equals("")) return true;

        for(int i = 0 ; i < wordBank.length ; i++){
            if(target.startsWith(wordBank[i]) && target.length() >= wordBank[i].length()){
                String subTarget = target.substring(wordBank[i].length());
                boolean isTrue = canConstruct(subTarget, wordBank);
                if(isTrue) return true;
            }
        }
        return false;
    }
    public static boolean canConstructDP(String target, String[] wordBank, Map<String, Boolean> memo){
        if(memo.containsKey(target) && memo.get(target) == true) return true;
        else if(target.equals("")) return true;

        for(int i = 0 ; i < wordBank.length ; i++){
            if(target.startsWith(wordBank[i]) && target.length() >= wordBank[i].length()){
                String subTarget = target.substring(wordBank[i].length());
                boolean isTrue = canConstructDP(subTarget, wordBank, memo);
                memo.put(target, true);
                if(isTrue) return true;
            }
        }
        memo.put(target, false);
        return false;
    }
    public static boolean canConstructTabulation(String target, String[] wordBank){
        Boolean[] table = new Boolean[target.length() + 1];
        Arrays.fill(table, false);
        table[0] = true;
       
        for(int i = 0 ; i < target.length() ; i++){
            if(table[i] == true){
                for(String word : wordBank){
                    if(word.startsWith(target.charAt(i)+"")){
                        String subStr = target.substring(i, i + word.length());
                        if(subStr.equals(word)){
                            if(i + subStr.length() <= table.length - 1){
                                table[i + subStr.length()] = true;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(Arrays.toString(table));
        return table[target.length()];
    }
    public static void main(String[] args){
        String target = "abcdef";
        String[] wordBank = {"ab", "abc", "cd", "def", "abcd"};
        //String target = "skateboard";
        //String[] wordBank = {"bo", "rd", "ate", "t", "ska", "sk", "boar"};
        //System.out.println(canConstruct(target, wordBank));
        Map<String, Boolean> memo = new HashMap<>();
        System.out.println(canConstructDP(target, wordBank, memo));
    }
}