/*
class Solution {
    int a;
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];

        
        //자기보다 뒤에 있으면서, 자기보다 큰 가장 가까운 수를 뒷큰수라 칭함
        //모든 원소에 대한 뒷 큰수들을 차례로 담은 배열을 return
        //뒷 큰수가 존재하지 않을 시 -1을 담음
        
        for(a=0;a<numbers.length-1;a++)
        {
            answer[a]=dks(numbers);
        }
        answer[numbers.length-1]=-1;
        
        return answer;
    }
    public int dks(int[] numbers){
            for(int b=a+1;b<numbers.length;b++)
            {
                if(numbers[a]<numbers[b]){
                    return numbers[b];
                }
                
            }
        
        return -1;
    }
}

*/

//2번째-> 함수 구분 없이 한번에 작성, but 같은 구간에서 시간 초과
/*
 * class Solution {

    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        
        //자기보다 뒤에 있으면서, 자기보다 큰 가장 가까운 수를 뒷큰수라 칭함
        //모든 원소에 대한 뒷 큰수들을 차례로 담은 배열을 return
        //뒷 큰수가 존재하지 않을 시 -1을 담음
        
        for(int a=0;a<numbers.length-1;a++)
        {
            int count=0;
            for(int b=a+1;b<numbers.length;b++)
            {
                if(numbers[a]<numbers[b])
                {
                    answer[a]=numbers[b];
                    count++;
                    break;
                }   
            }
            if(count==0)
                answer[a]=-1;
        }
        answer[numbers.length-1]=-1;
        return answer;
    }
   
}
 */




//3번째 시도, 처음부터 -1로 초기화 및 뒷큰수 발견시 바로 바꾸고 break해도 같은 곳에서 시간 초과
 /*class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        for (int a = 0; a < numbers.length - 1; a++) {
            answer[a] = -1; // 초기값 -1로 설정
            
            for (int b = a + 1; b < numbers.length; b++) {
                if (numbers[a] < numbers[b]) {
                    answer[a] = numbers[b];
                    break; // 뒷 큰 수를 찾으면 반복문 종료
                }
            }
        }
        answer[numbers.length-1]=-1;
        return answer;
    }
}
 */
//최종 정답: 스택을 이용한 풀이...
import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        Stack<Integer> s = new Stack<>();
        s.push(0);
        for(int i = 1; i < numbers.length; i++){
            while(!s.isEmpty()){
                int idx = s.pop();
                if(numbers[i] > numbers[idx]){ // 뒤가 더 클때
                    answer[idx] = numbers[i];
                } else { // 앞이 더 크거나 같을 때
                    s.push(idx);
                    break;
                } 
            }
            s.push(i);
        }

        return answer;
    }
}
