public class Solution {
    public int solution(int n) {
 
        int count=1;
        
        while(n%count!=1)
            count++;
        
        return count;
    }
} 
