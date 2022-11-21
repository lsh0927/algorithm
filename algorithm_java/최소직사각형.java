class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int rmax=0;
        int cmax=0;
        for(int i=0; i<sizes.length;i++)
        {
            if(rmax<sizes[i][0])
                rmax=sizes[i][0];
        }
        for(int j=0; j<sizes.length;j++)
        {
            if(cmax<sizes[j][1])
                cmax=sizes[j][1];
        }
        
        answer=rmax*cmax;
        //명함의 가로와 세로를 바꿔 수납할 방법       
        return answer;
    }
}public class 최소직사각형 {
    
}
