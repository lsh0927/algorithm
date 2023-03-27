class Solution {
    public int solution(int n) {
        int answer = 0;
        
       for (int i = 1; i <= n; ++i) {
        if (n % i == 0) {
            if(i>=(n+1)/(i*2)&&(n/i)%2!=0)
            {
                answer++;
            }
        }
    }
        
        return answer+1;
    }
}