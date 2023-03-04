import java.util.*;
class Solution {
    public int[] solution(String s) {
        
        int[] answer = new int[s.length()]; 
        
        HashMap <Character,Integer> map = new HashMap<>();
        
        for(int i=0; i<s.length();i++){
            char ch = s.charAt(i); // String으로 저장된 문자열 중에서 한 글자만 선택해서 char타입으로 변환
            
            answer[i] = i-map.getOrDefault(ch,i+1); // 찾는 키가 존재한다면 찾는 키의 값을 반환하고 없다면 기본 값을 반환하는 메서드
            
            map.put(ch,i);
        }
        
        return answer;
    }
}
class Solution2 { //이 풀이가 더 정석인 느낌?
    public int[] solution(String str) {
        int[] result = new int[str.length()];

        for(int i=0;i<str.length();i++){

            String subStr = str.substring(0,i); //str의 0~i-1까지 문자열만 가져옴
            if(subStr.indexOf(str.charAt(i))==-1) {  //indexOf()- 특정문자나 문자열에서 해당하는 문자의 인덱스값 반환, 못찾으면 -1반환
                //뒤에서부터 인덱스를 찾는 lastindexOf()도 있음
                result[i] = -1;
            }else {
                result[i] = i-subStr.lastIndexOf(str.charAt(i));
            }
        }
        return result;
    }
}