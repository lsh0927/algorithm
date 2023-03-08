import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        
        Arrays.sort(d); //여기서 런타임 에러가 발생한듯?
        
        int sum=0;
        int count=0;
        int i=0;
        while(sum<budget)
        {
            if(sum+d[i]>budget)
                break;
            else{
                sum+=d[i];
                i++;
                count++;
        }
        }
            
        return count;
    }
}