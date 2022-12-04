package test.freq;
import java.util.*;
public class TestAnagrams{
    /**
    Time Complexity : O(N)
    Space Complexity : O(N)
     */
    public static boolean isAnagramOpt(String s1, String s2){  
        if(s1 == null || s2 == null) return false;
        else if(s1 != null && s2 != null && s1.length() != s2.length()) return false;

        Map<Character, Integer> table = new HashMap<>();
        for(char ch : s1.toCharArray()){
            table.put(ch, table.getOrDefault(ch, 0) + 1);
        }

        for(char ch : s2.toCharArray()){
            if(table.get(ch) == 0) return false;
            table.put(ch, table.get(ch) - 1);
        }
        return true;
    }
    /**
    Time Complexity : O(N Log N)
    Space Complexity : O(N)
     */
    public static boolean isAnagramSort(String s1, String s2){        
        if(s1 == null || s2 == null) return false;
        else if(s1 != null && s2 != null && s1.length() != s2.length()) return false;
        
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();

        Arrays.sort(chars1);
        Arrays.sort(chars2);

        return String.valueOf(chars1).length() == String.valueOf(chars2).length();
    }
    /**
    Time Complexity : O(N)
    Space Complexity : O(1)
     */
    public static boolean isAnagram(String s1, String s2){
        int[] table = new int[128];
        for(char ch : s1.toCharArray()){
            table[ch]++;
        }

        for(char ch : s2.toCharArray()){
            table[ch]--;
        }

        for(int i : table){
            if(i != 0) return false;
        }
        return true;
    }
    public static void main(String[] args){
        String s1 = "danger";
        String s2 = "garden";
        boolean isAnagram = isAnagramOpt(s1, s2);
        System.out.println(isAnagram);
    }
}