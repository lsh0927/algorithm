class Solution {
    public int solution(String s) {
        int answer = 0;
        char p= '1';
        
        int same = 0;
        
        int d = 0;
      
        for (char c : s.toCharArray()) { //문자열을 한 글자씩 쪼개서 이를 char타입의 배열에 집어넣어주는 메소드
            if (p == '1') 
            {
                p = c;
                same++;
                answer++;
            }
            else if (p == c)
                same++;
            else 
                d++;
        
            if (same == d) {
                p = '1';
                same = 0; 
                d = 0;
            }
        }

        return answer;
    }
}
