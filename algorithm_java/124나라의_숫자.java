import java.util.*;
class Solution {
    public String solution(int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        int a=0;
        int cnt=3;
        
        while(a<n)
        {
            a+=cnt;
            sb.append(4);
            if(a>=n)
                break;
            cnt*=3;          
        }
        //n=12라면 a=12, sb=44
        //n=13이라면 a=39 sb=444
        
        //1번의 경우 a-n=0;-> sb=44
        //2번의 경우 a-n=26 -> sb의 444~411->9개 out 244~211 9개 out 144~112까지 8개 out-> answer=111
        
        //그럼 a-n을 compare라고 하고, 여기서 숫자를 빼내는것을 어떻게 구현?
        // compare가 1이면 마지막 4를 2로 바꾸고, 2면 1로 바꾸고, 3이면 마지막에서 두번째 4를 2로, 4면 두번째와 마지막을 2로,,,,,
        //진자 복잡하네 이거 아닌거 같은데..
        
        
        
        return answer;
    }
}

// class Solution {
//     public String solution(int n) {
//         StringBuilder answer = new StringBuilder();

//         while (n > 0) {
//             int num = n%3;
//             if (num == 0) {
//                 answer.insert(0, "4"); 
//                 n = n/3 - 1;
//             }
//             else {
//                 answer.insert(0, Integer.toString(num));
//                 n = n/3;
//             }

//         }

//         return answer.toString();
//     }
// }