import java.util.*;
class Solution {
//     public int[] solution(int n, String[] words) {
//         int []answer = new int[]{result, result2};

//         int result=0;
//         int result2=0;
//         //배열의 원소 string을, substring을 이용해 i=0일 때부터 i<length일때까지, 자기 앞의 원소의 뒷글자와, 자기 뒤의 원소의 앞글자를 비교? 
//        
//         int idx=0;
//         for(int i=0;i<words.length();i++)
//         {
//             if(!words[i].substring(words.length()-1).equals(words[i+1].substring(0,0)))
//             {
//                 idx=i+1;
//                 break;
//             }
             
//         }
//         if (idx==0)
//         {
//             answer=[0,0];   
//             return answer;
//         }
//         else
//         {
//             if(idx%n==0)
//             {
//                 result=n;
//                 result2=idx/n;
//             }
//             else{
//                 result=idx%n;
//                 result2=(idx/n)+1;
//             }
//             answer=[result,result2];
//             return answer;
//         }
//     }
// }

public int[] solution(int n, String[] words) {
    int[] answer = {0, 0};
    Set<String> set = new HashSet<>();

    // add first word to set
    set.add(words[0]);

    for (int i = 1; i < words.length; i++) {
        String prev = words[i - 1];
        String curr = words[i];

        // check if current word is valid
        if (prev.charAt(prev.length() - 1) != curr.charAt(0) || set.contains(curr)) {
            answer[0] = i % n + 1;
            answer[1] = i / n + 1;
            break;
        }

        // add current word to set
        set.add(curr);
    }

    return answer;
}}