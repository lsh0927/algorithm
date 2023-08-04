class Solution {
    public int solution(String s) {
        int answer = -1;
        
        //짝을 지어 회전시켰을때, 맞는 경우의 가짓수를 리턴
        int len=s.length();
        int h=0;
        int sum=0;
        for(int i=0;i<len;i++)
        {
            s=s.substring(i)+s.charAt(i); //i번째 인덱스 빼고 호출 + 빠진 인덱스를 뒤에 붙임
            for(int j=0;j<len;j=2*j)
            {
                if((s.charAt(j) == "[" && s.charAt(j+1) == ']'))
                    sum++;
                else if((s.charAt(j) == '{' && s.charAt(j+1) = '}'))
                    sum++;
                else if(!(s.charAt(j) == '(' && s.charAt(j+1) = ')'))
                    sum++;
                else
                    h++;
            }
        }
        
        return sum;
    }
}
/* 정답은 스택을 이용한 풀이.....
 * import java.util.Stack;

class Solution {
    boolean iscorr(String s) {
        Stack<String> st = new Stack<String>();
        String[] strs = s.split("");

        for(String str : strs) {
            if(str.equals("(")||str.equals("{")||str.equals("["))
                st.add(str);
            else {
                if(st.empty())
                    return false;

                String out = st.pop();
                if(str.equals(")")) {
                    if(!out.equals("("))
                        return false;
                }
                if(str.equals("}")) {
                    if(!out.equals("{"))
                        return false;
                }
                if(str.equals("]")) {
                    if(!out.equals("["))
                        return false;
                }
            }
        }

        if(st.empty())
            return true;
        else
            return false;
    }

    public int solution(String s) {
        int answer = 0;

        for(int i = 0 ; i < s.length() ; ++i) {
            if(iscorr(s.substring(i) + s.substring(0, i)))
                answer++;
        }


        return answer;
    }
}
 */



 import java.util.*; 
class Solution {
            public int solution(String s) {
                char[] str=s.toCharArray();
                int count=0;
                
                for(int offset=0;offset<str.length;offset++){
                    if(isCorrect(str,offset))
                        count++;
                }
                return count;
            }
            
            private boolean isCorrect(char[] str,int offset){
                Stack<Character> stack= new Stack<>();
                
                for(int i=-0; i<str.length;i++)
                {
                    //substring()을 안쓰는 이유
                    //매 검사마다 새로운 문자열 객체와 문자 배열 생성-> 매우 비효율
                    char c=str[(offset+i)%str.length];
                    switch (c)
                    {
                        case '(' ->stack.push(')');
                        case '{' -> stack.push('}');
                        case '[' -> stack.push(']');
                        case ')','}',']' -> {
                            if (stack.isEmpty()) return false;
                            if (stack.pop() != c) return false;
                        }
                    }
                }
                
                return stack.isEmpty();
            }
        }