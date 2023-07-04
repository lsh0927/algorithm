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

import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Integer[] intArray = new Integer[citations.length];

        for(int i = 0; i < citations.length; i++)
            intArray[i] = citations[i];

        Arrays.sort(intArray, Collections.reverseOrder());

        for(int i = 0; i < intArray.length; i++) {
            if(intArray[i] <= i+1)
                return i;
        }

        return intArray.length;
    }
}