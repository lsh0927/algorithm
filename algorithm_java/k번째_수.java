import java.util.Arrays;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++){
            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            
          
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];
        }

        return answer;
    }
}

// 결과값이 어떠한 형태를 띠는 지 확인 결과, line 4의 결론 도출
// temp 배열 선언. Arrays.copyOfRange(배열, 시작~끝) 인덱스로, 2번째 매개변수는 index순서를 따르며, 세번째 매개변수는 바로 직전의 인덱스까지만 복사
//i=0일때 1,4까지의 인덱스가 복사 즉 [5,2,6,3]이 복사되며,  
//temp를 정렬하면 [2,3,5,6]이 됨 (아마 퀵정렬)
//answer 배열은 command의 3번째수-1 (index) 를 temp에서 가져옴 즉 순서를 알게됨.