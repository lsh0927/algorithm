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
/*
 * class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int temp;
        while( !s.equals("1") ) {
            answer[1] += s.length();
            s = s.replaceAll("0", "");
            temp = s.length();
            s = Integer.toBinaryString(temp);
            //System.out.println("s : " + s ); 
            answer[0]++;
            answer[1] -= temp;
        }
        return answer;  
    }
}
 */