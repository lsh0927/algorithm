class Solution
{
    public int solution(String t, String p)
    {
        int answer = 0;

        for(int i=0; i<=t.length()-p.length(); i++) //문자열의 길이 
            if(Long.parseLong(t.substring(i, i+p.length())) <= Long.parseLong(p)) //str-> long타입으로 변환 + substring: i번째 수 뒤부터~ 끝 인덱스 바로 전까지만 남김
                answer++;

        return answer;
    }
}
