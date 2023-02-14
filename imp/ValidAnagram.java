package testds.imp;
import java.util.*;
public class ValidAnagram{
    public static void main(String[] args){
        String s = "anagram";
        String t = "nagaram";
        boolean isAnagram = ValidAnagram.isValidAnagramUsingSort(s, t);
        System.out.println("Is Anagram "+isAnagram);
    }
    /**
    Time Complexity : O(N Log N)
    Space Complexity : O(N)
    Space depends on the sorting implementation which, usually, costs O(1)
    auxiliary space if heapsort is used.
    O(N) for toCharArray()
     */
    public static boolean isValidAnagramUsingSort(String s, String t){
        if(s.length() != t.length()) return false;

        char[] charsS = s.toCharArray(); 
        Arrays.sort(charsS);  
        char[] charsT = t.toCharArray(); 
        Arrays.sort(charsT);      
        return Arrays.equals(charsS, charsT);
    }
    /**
    Time Complexity : O(N) , where N is the smaller length between s and t
    Space Complexity : O(1)
     */
    public static boolean isValidAnagram(String s, String t){
        int[] table = new int[128];
        for(char ch : s.toCharArray()){
            table[ch]++;
        }
        for(char ch : t.toCharArray()){
            table[ch]--;
            if(table[ch] < 0) return false;
        }
        for(int i : table){
            if(i != 0) return false;
        }
        return true;
    }
}