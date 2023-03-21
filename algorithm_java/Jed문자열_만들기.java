class Solution {
    public String solution(String s) {
        String answer = "";
        
        answer=s.toLowerCase();
        answer=answer.substring(1);
        
        
        char a= s.charAt(0);
        a=Character.toUpperCase(a);
        
        answer=a+answer;
        return answer;
        //공백은 다른 단어로 판단하여 대소문자 변환
        
    }
}