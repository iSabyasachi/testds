package testds.imp;
import java.util.*;
public class LongestSubString{
    /**
    Time complexity : O(2n) = O(N)
    In the worst case each character will be visited twice by i and j.

    Space complexity : O(min(m,n))
    Same as the previous approach. We need O(k) space for the sliding window, 
    where k is the size of the Set. The size of the Set is upper bounded by the 
    size of the string nnn and the size of the charset/alphabet m.
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        int res = 0;
        int left = 0;
        for(int right = 0; right < s.length() ; right++){
            char r = s.charAt(right);
            freq.put(r, freq.getOrDefault(r, 0) + 1);

            while(freq.get(r) > 1){
                char l = s.charAt(left);
                freq.put(l, freq.get(l) - 1);
                left++;
            }
            res = Math.max(res, (right - left + 1));
        }
        return res;
    }
    public static void main(String[] args){
        LongestSubString obj = new LongestSubString();
        //String s = "a";
        String s = "pwwkew";
        int longest = obj.lengthOfLongestSubstring(s);
        System.out.println(longest);
    }
}