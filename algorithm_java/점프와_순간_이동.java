import java.util.*;
public class Solution{
    public int solution(int n) {
        int ans = 0;

        //한번에 K칸 이동-> k소모
        //(현재 온 거리에 x2에 해당하는 "위치로" 순간이동)-> 소모 x
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
       
        int cnt=0;
        //dp문제 같은데....
        //1을 먼저 이동해야 순간이동을 사용 가능한것.
        //위치가 2일때 x2를 할지, 3일때 x2를 할지..5일때 할지.. 어떻게 찾지?
        while(n>1)
        {
            if(n%2==0)
            {
                n/=2;
            }
            else{
                n-=1;
                cnt++;
            }
        }
        ans=cnt+1;
        
        
        return ans;
    }
}