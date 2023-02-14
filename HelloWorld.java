package testds;
import java.util.*;
import java.util.stream.*;
public class HelloWorld{
   
    public static void main(String[] args){
        System.out.println("Hello World");

        String t = "ABC";

        Map<Character, Integer> freqMap = new HashMap<>();
        for(char ch : t.toCharArray()){
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }
        System.out.println(allCharFound(freqMap));
		
    }
    public static boolean allCharFound(Map<Character, Integer> map){
        return map.keySet().stream().filter(i -> i != 0).count() > 0 ? false : true;
    }
}
