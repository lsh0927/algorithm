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