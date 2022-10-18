class Solution {
    public long solution(int balls, int share) {
        long  answer = 0;
        
        if((balls-share)==0)
            return 1;
        else
            answer=fact(balls)/(fact(balls-share)*fact(share));
        
        
        return answer;
    }
    
    
    public  long fact(int x){
        
       if(x==1 || x==0)
       {
           return 1;
       }
       else
       {
           return long (x*fact(x-1));
       }
    
}
}