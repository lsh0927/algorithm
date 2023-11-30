class Solution {
    public int solution(int hp) {
        int answer = 0;
        
        int a=0;
        int b=0;
        
  asdf
        while(hp>4)
        { 
         hp-=5;
         a++;
        }
        if(hp==4 || hp==2)
        {
            b=2;
        }
        else if(hp==3 ||hp==1)
        {
            b=1;
        }
        
        answer=a+b;
        
        
        return answer;
    }
}