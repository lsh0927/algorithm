import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};

        ArrayList<Integer> list = new ArrayList<> (); //어레이리스트 선언

        for(int i=0; i<numbers.length-1; i++) {
            for(int j=i+1; j<numbers.length; j++) {
                int sum = numbers[i] + numbers[j]; //두개의 원소 합
                if(! list.contains(sum)) list.add(sum); //list에 없으면 추가 ( contains 함수가 중요 )
            }
        }

        Collections.sort(list); //정렬

        answer = new int[list.size()];

        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i); //원소 복사
        }


        return answer;
    }
}