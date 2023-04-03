class Solution {
    public int[] solution(String s) {
        int[] answer = {0,0};
        int sum=0;
        int sum2=0;   
        while(!s.equals("1"))
        {  
            StringBuilder sb = new StringBuilder(s);
            for(int i=1;i<sb.length();i++)
            {
                if(sb.charAt(i)=='0')
                {
                    sb.deleteCharAt(i);
                    sum++;
                    System.out.println(sb);
                }
            }
            int len=sb.length();
            s= Integer.toBinaryString(len);
            //System.out.println(s);
            sum2++;
            
        }
        answer[0]=sum2;
        answer[1]=sum;
        return answer;
    }
}