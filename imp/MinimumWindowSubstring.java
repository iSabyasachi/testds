package testds.imp;
import java.util.*;
public class MinimumWindowSubstring{
    public static void main(String[] args){
        MinimumWindowSubstring obj = new MinimumWindowSubstring();
        String s = "ADOBECODEBANC";
        //String s = "ADOBEC";
        String t = "ABC";
        String res = obj.minWindow(s, t);
        System.out.println("Minimum Window Substring is "+res);
    }
    int currLength = 0;
    public String minWindow(String s, String t) {
        // Store each character of t in frequency table
        // create a sliding window, if the current character is present in frequency table,
        // search all characters till frequency table becomes empty and then compare the length
        // store the min length in the result
        Map<Character, Integer> freqMap = new HashMap<>();
        for(char ch : t.toCharArray()){
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }
        String result = "";
        for(int i = 0 ; i < s.length() ; i++){
            Map<Character, Integer> currMap = new HashMap<>(freqMap);
            if(currMap.containsKey(s.charAt(i))){
                currMap.put(s.charAt(i), freqMap.get(s.charAt(i)) - 1);
                for(int j = i + 1 ; j < s.length() ; j++){
                    char ch = s.charAt(j);
                    if(currMap.containsKey(ch) && currMap.get(ch) == 0){
                        break;
                    }

                    if(currMap.containsKey(ch) && currMap.get(ch) > 0){
                        currMap.put(ch, freqMap.get(ch) - 1);

                        if(allCharFound(currMap)){                           
                            if(result.equals("")){
                                result = s.substring(i, j + 1);
                            }else{
                                result = s.substring(i, j + 1).length() < result.length() ? s.substring(i, j + 1) : result;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
    public boolean allCharFound(Map<Character, Integer> map){       
        return map.values().stream().filter(i -> i != 0).count() > 0 ? false : true;
    }
}