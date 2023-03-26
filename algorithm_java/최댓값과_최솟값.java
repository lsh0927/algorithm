import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        int a,b;
        //공백을 기준으로, 문자를 배열에 넣고 최대 최소를 구별
        
        String[] strArr = s.split(" ");
        int[] intArr = new int[strArr.length];

        for(int i=0; i<strArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);    
        }
        
        Arrays.sort(intArr);
        
        a=intArr[0];
        b=intArr[intArr.length-1];
        
        answer=a+" "+b;
        
        return answer;
    }
}