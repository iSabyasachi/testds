package testds.imp;
import java.util.*;
public class ValidPalindrome{
    public static void main(String[] args){
        String s = "A man, a plan, a canal: Panama";
        //String s = "0P";
        boolean isPalindrome = isPalindromeUsingReverse(s);
        System.out.println(isPalindrome);
    }
    /**
    Time Complexity : O(N)
    Space Complexity : O(N)
     */
    public static boolean isPalindromeUsingReverse(String s) {
       StringBuilder sbr = new StringBuilder();
        // Approach 1
        for(char ch : s.toCharArray()){
            if(Character.isLetterOrDigit(ch))
                sbr.append(Character.toLowerCase(ch));
        }
        //Approach 2 (Using Stream)
        /*
        s.chars().filter(ch -> Character.isLetterOrDigit(ch)).
        mapToObj(ch -> Character.toLowerCase((char)ch)).
        forEach(sbr::append);
        */
        String str = sbr.toString();
        String strRev = sbr.reverse().toString();        
        return str.equals(strRev);
    }
    /**
    Time Complexity : O(N)
    Space Complexity : O(1)
     */
    public static boolean isPalindrome(String s) {
        for(int i = 0 , j = s.length() - 1 ; i < j ; i++, j--){
            while(i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
            while(i < j && !Character.isLetterOrDigit(s.charAt(j))) j--;

            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) 
                return false;
        }
        return true;
    }
    /**
    Time Complexity : O(N)
    Space Complexity : O(N), for toCharArray() and charList
     */
    public static boolean isPalindromeOld(String s) {
        s = s.trim();
        if(s.length() <= 1) return true;

        s = s.toLowerCase();        
        List<Character> charList = new ArrayList<>(s.length());
        char[] chars = s.toCharArray();
        for(char ch : chars){
            if(Character.isLetterOrDigit(ch))
                charList.add(ch);
        }

        int low = 0, high = charList.size() - 1;
        while(low <= high){
            if(charList.get(low++) != charList.get(high--)) return false;
        }
        return true;
    }
}