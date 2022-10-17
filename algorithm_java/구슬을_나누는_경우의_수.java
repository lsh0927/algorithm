public class Solution {
    public int solution(int balls, int share) {
        int answer = 0;
        
        if((balls-share)==0)
            return 1;
        else
            answer=fact(balls)/(fact(balls-share)*fact(share));
        
        
        return answer;
    }
    
    
    public int fact(int x){
        
       if(x==1 || x==0)
       {
           return 1;
       }
       else
       {
           return(x*fact(x-1));
       }
    
}
}

