// class Solution{
//     public long solution(int num) {
//         long answer = 0;
//         if(num<2){
//             answer=num;
//         }
//         else{
//             answer=solution(num-1)+solution(num-2);
//         }
//         return answer;
//     }
// }


// class Solution { //시간을 아끼는 방법 1

//     public int solution(int n) {
//         int answer = 0;
//         long[] pib=new long[n+1];
//         pib[0]=0L;
//         pib[1]=1L;
//         int times=1;
//         for(int i=2; i<=n; i++){
//             pib[i]=(pib[i-1]+pib[i-2])%1234567L;
//         }
//         //answer=(int)(pib[n]%1234567L);
//         answer=(int)(pib[n]);
//         return answer;
//     }
// }
import java.util.*;

class Solution {
            //배열 선언, 종료조건 설정
            private final int[] dp= new int[100001];
            private int fibo(int n){
                if(dp[n]!= -1)
                    return dp[n];
                if(n==0 || n==1) 
                    return n;
                
                return dp[n]=(fibo(n-1)+fibo(n-2)) %1234567;
            }
            
            public int solution(int n) {
                Arrays.fill(dp,-1);
                // for(int i=0;i<=n;i++)
                //     fibo(i);
                    
                return fibo(n);
            }
        }