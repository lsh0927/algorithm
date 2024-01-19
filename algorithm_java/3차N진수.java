import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
    StringBuilder sb = new StringBuilder();
    int count = 0;
    int index = 0;

        while (sb.length() < t * m) {
            String converted = changeToN(index, n);            
            sb.append(converted);
            index++;
        }

        String answer = "";
        for (int i = p - 1; i < sb.length(); i += m) {
            answer += sb.charAt(i);
            count++;
            
            
            if (count == t) {
                break;
            }
        }

        return answer;
    }

    public String changeToN(int num, int base) {
        return Integer.toString(num, base).toUpperCase();
    }

}



        //1차: 0~9
        //2차: 한자리씩 끊어서 : (10,11,12)=> (1,0,1,1,1,2)
        
        //n: 진법
        //t: 구해야 할 숫자 개수(튜브가 말해야 하는 숫자 개수)
        //m: 게임 참가 인원
        //p: 튜브의 순서(인덱스)
        
        /*
        예제:
        n=2 ,t=4, m=2, p=1
        
        이진법으로 0 1 10 11 100 101...이 되고, 
        10부터는 끊어 말하니까 0, 1', 1, 0', 1, 1' 1 0' 0....
        이중 튜브가 말해야하는건 0 1 1 1임
        
        */