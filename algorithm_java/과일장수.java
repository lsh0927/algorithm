import java.util.Arrays;
import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        
        Integer[] tmp = Arrays.stream(score).boxed().toArray(Integer[]::new); //기본타입의 배열을 Object를 상속하는 Wrapper 클래스로 박싱해주어야 역순정렬도 가능하다.
        Arrays.sort(tmp, Collections.reverseOrder()); //역순 정렬 함수
        
        
        int result=0;
        int sum=0;
        int count=0;
        int a=0;
        int b=m;
        while(b-1<tmp.length)
        {
            for(int i=a;i<b;i++)
            {
                sum=tmp[b-1]*m;
            }
            result+=sum;
            
            a+=m;
            b+=m;
           
        }
    
      
        return result;
    }
}