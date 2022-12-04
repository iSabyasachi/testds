package testds;
import java.util.*;
import java.util.stream.*;

public class AllConstruct{
    public static List<List<String>> allConstruct(String target, String[] wordBank){
        if(target.equals(""))return List.of(new ArrayList<>());

        List<List<String>> result = new ArrayList<>();
        for(int i = 0 ; i < wordBank.length ; i++){
            String prefix = wordBank[i];
            if(target.startsWith(prefix) && target.length() >= prefix.length()){ 
                String suffix = target.substring(prefix.length());
                List<List<String>> suffixWays = allConstruct(suffix, wordBank);
                for(List<String> currWay : suffixWays){
                    currWay.add(0,prefix);
                }
                result.addAll(suffixWays);
            }
        }
        return result;
    }     
    public static void main(String[] args){
        //String target = "abcdef";
        //String[] wordBank = {"ab", "abc", "cd", "def", "abcd", "ef", "c"};
        //String target = "skateboard";
        //String[] wordBank = {"bo", "rd", "ate", "t", "ska", "sk", "boar"};
        String target = "purple";
        String[] wordBank = {"purp", "p", "ur", "le", "purpl"};
        List<List<String>> result = allConstruct(target, wordBank);
        System.out.println(result);
    }
}