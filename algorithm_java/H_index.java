// import java.util.Arrays;

// class Solution {
//     public int solution(int[] citations) {
//         int answer = 0; 
//         Arrays.sort(citations);
    
//         int a=citations.length;     
//         // n편 중, h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면 h의 최댓값이 이 과학자의 H-Index입니다.
        
//         int count=0,i=0;
//       while(citations[i]<=a-count)
//       {
//            i++;
//            count++;
//       }
//         return a-count;
//     }
// }
// import java.util.*;

// class Solution {
//     public int solution(int[] citations) {
//         int answer = 0;

//         Arrays.sort(citations);
//         for(int i=0; i<citations.length; i++){

//             if(citations[i]>=citations.length-i){
//                 answer=citations.length-i;
//                 break;
//             }

//         }
//         return answer;
//     }
// }

import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        //citations에는 인용횟수가 들어가 있음
        //n편중, h번이상 인용된 논문이 h편이상이고 나머지 논문이 h번 이하로 인용
        //-> h의 최댓값
        // 0 1 3 5 6 => 3
        // 0 1 2 3 4 5 6 7 => 3
        // 1 2 3 4 5 6 7 => 4
        
        for(int i=0; i<citations.length; i++){
            int smaller = Math.min(citations[i], citations.length-i);
            answer = Math.max(answer, smaller);
        }
        
        return answer;
    }
}
