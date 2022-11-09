public class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        int count;
        int dev;

        int a;
            for(int i=left; i<=right;i++) //13~17까지 
            {   
                dev=1;
                count=0;
                while(i>=dev) 
                {
                    
                    if(i%dev==0)
                    {
                        count++;
                    }
                    dev++;
                } 
                 if(count%2==0)
                 {
                    answer=answer+i;
                 }
                 else
                    answer=answer-i;
                
                
            }
        
        return answer;
    }
} 약수의_개수와_덧셈 {
    
}
