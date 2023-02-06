import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        Queue<Integer> q = new LinkedList<>(); //큐 선언
        List<Integer> answerList = new ArrayList<>(); //리스트 선언

        for (int i = 0; i < speeds.length; i++) { 
            double remain = (100 - progresses[i]) / (double) speeds[i];  //남은 기간 저장
            int date = (int) Math.ceil(remain);  //반올림해주는 Math.ceil()함수

            if (!q.isEmpty() && q.peek() < date) {  //큐가비어있거나&&첫번째 값이 date보다 작다면
                answerList.add(q.size()); //큐의 크기(원소의 개수)를 answerlist에 넣고
                q.clear(); //큐를 비움
            }

            q.offer(date); //큐에 날을 대입함
        }

        answerList.add(q.size()); //for문이 끝나면 q.size를 answerList에 추가함

        int[] answer = new int[answerList.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}