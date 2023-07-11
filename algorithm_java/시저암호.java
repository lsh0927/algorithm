class Caesar {
    String caesar(String s, int n) {
        String result = "";
    n = n % 26;
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (Character.isLowerCase(ch)) {
        ch = (char) ((ch - 'a' + n) % 26 + 'a');
      } else if (Character.isUpperCase(ch)) {
        ch = (char) ((ch - 'A' + n) % 26 + 'A');
      }
      result += ch;
    }
        return result;
    }

    public static void main(String[] args) {
        Caesar c = new Caesar();
        System.out.println("s는 'a B z', n은 4인 경우: " + c.caesar("a B z", 4));
    }
}
//내 풀이
/*
import java.util.*;
class Solution {
    public String solution(String str, int n) {
        
        //문자열을 민다-> 아스키코드+n
        //공백은 밀어도 계속 공백
        
        for(int i = 0; i < str.length(); i++) 
        {
	        if(str.charAt(i)!=32) //여기 잘못됨(공백일때를 제외하는게 아니라, 대소문자 구분이 필요하고, 단순히 아스키코드값을 더하는게 아닌, a~z의 26개 알파벳이 계속 순환하도록 밀어내야함)
                {
                    str.charAt(i)=str.charAt(i)+"n"; //line 6과 같은 과정이 필요한듯
                }
        }
        return str;
    }
}
 */
/* 
 class Solution {
    public String solution(String s, int n) {
        String answer = "";
        StringBuilder builder= new StringBuilder();
        for(char c: s.toCharArray()){
            builder.append(push(c,n));
        }
           return builder.toString();
    }
        
        //문자열 객체를 이용한 풀이
        private char push(char c, int n){
            if(!Character.isAlphabetic(c)) return c;
            
            int offset= Character.isUpperCase(c) ? 'A' : 'a';
            int position= c-offset;
            position= (position+n)%('Z'-'A'+1);
            return (char)(offset +position);
        }
        
}
*/