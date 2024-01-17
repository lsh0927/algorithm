import java.util.*;

class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        
        int length1 = word1.length();
        int length2 = word2.length();
        int maxLength = Math.max(length1, length2);
        
        for (int i = 0; i < maxLength; i++) {
            if (i < length1) {
                result.append(word1.charAt(i));
            }
            
            if (i < length2) {
                result.append(word2.charAt(i));
            }           
        }
        
        return result.toString();
    }
}