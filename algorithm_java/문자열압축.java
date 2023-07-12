import java.util.*;
class Solution {
     private List<String> split(String source, int length){
            List<String> tokens=new ArrayList<>();
            //source를 length만큼씩 잘라서, token 리스트에 추가
            for (int startIndex=0; startIndex<source.length(); startIndex+=length){
                int endIndex=startIndex+length;
                if(endIndex>source.length()) endIndex=source.length();
                tokens.add(source.substring(startIndex,endIndex));
            }
            return  tokens;
        }
        
        
        private int compress(String source, int length){
            //압축된 문자열의 길이 반환
            StringBuilder sb=new StringBuilder();
            String last= "";
            int count=0;
            for(String token: split(source,length)){
                if(token.equals(last)){
                    count++;
                }
                else{
                    if(count>1) sb.append(count);
                    sb.append(last);
                    last=token;
                    count=1;
                }
            }
            if(count>1) sb.append(count);
            sb.append(last);
            return sb.length();
        }
       public int solution(String s) {
            int answer = 0;

            //1부터 입력 문자열 s의 길이만큼 자를 문자열의 길이를 설정하며 반복
            int min=Integer.MAX_VALUE;
            for(int length=1; length<s.length();length++){
                int compressed= compress(s,length);
                if(compressed < min){
                    min=compressed;
                }
            }
            return min;

        }
        
    }


    //java code test 8번 문제 -> Test Case 5번에서 실패 ?_?