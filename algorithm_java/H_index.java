
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
/*
 * import java.util.Arrays;


class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int len = citations.length;

        Arrays.sort(citations);

        for(int i = len; i >= 1; i--) {
            
            int h = 0;
            for(int j = 0; j < len; j++) {
                if(citations[j] >= i) {
                    h++;
                }
            }
            
            if(h >= i && len - h <= i) {
                answer = i;
                break;
            }
            
        }

        return answer;
    }
}


 */