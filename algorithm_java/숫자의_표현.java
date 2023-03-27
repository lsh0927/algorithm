class Solution {
    public int solution(int n) {
        int answer = 0;
        
       
     for (int i = 1; i <= n; i += 2) 
       if (n % i == 0) 
           answer++;

        
        return answer;
    }
}
//진짜 쉬운 문제였는데,,,,, 왜 이리 복잡하게 생각했을까 ㅠㅠ
// class Solution {
//     public int solution(int n) {
//         int answer = 0;
        
//        for (int i = 1; i <= n; ++i) {
//         if (n % i == 0) {
//             if(i>=(n+1)/(i*2)&&(n/i)%2!=0)
//             {
//                 answer++;
//             }
//         }
//     }
        
//         return answer+1;
//     }
// }
