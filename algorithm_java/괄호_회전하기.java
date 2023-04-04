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