import java.util.*;

class Solution {
    public String solution(String s) {
        
        //짝수는 대문자, 홀수는 소문자
        
        // 빈칸 공백은 고려x
        String answer = "";
        //String result = s.replaceAll(" " , ""); 공백제거 메소드인데, answer에는 다시 공백 추가해야하므로 비효율적
        
        // 2. 배열 생성 (문자열 길이)
         String[] str = s.split("");
         int idx = 0; 
        
         for(int i=0; i<str.length; i++){
                if(str[i].equals(" ")){ //띄어쓰기 있다면
                    idx = 0; //인덱스 0 초기화
                }
                else if(idx % 2 == 0){ 
                    str[i] = str[i].toUpperCase(); //대문자로 변경
                    idx++; //idx 증가
                }
                else if(idx % 2 != 0){ 
                    str[i] = str[i].toLowerCase(); //소문자로 변경
                    idx++; //idx 증가
                }
            answer += str[i];
        }
        

        return answer;
    }
}
/*
 * class Solution {
    public String solution(String s) {
      //문자열을 이용한 풀이
        StringBuilder builder= new StringBuilder();
        boolean toUpper=true;
        
        for(char c: s.toCharArray())
        {
            if(!Character.isAlphabetic(c)){
                builder.append(c);
                toUpper=true;
            }
            else{
                if(toUpper)
                {
                    builder.append(Character.toUpperCase(c));
                }
                else{
                    builder.append(Character.toLowerCase(c));
                }
                toUpper=!toUpper;
            }
        }
        return builder.toString();
    }
}
 */