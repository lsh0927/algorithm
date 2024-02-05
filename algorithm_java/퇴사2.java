import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class 퇴사2 {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N= Integer.parseInt(br.readLine());

        int[][] arr= new int[N+2][2];
        int[] dp= new int[N+2];
        for (int i=1;i<N+1;i++){
            st= new StringTokenizer(br.readLine());
            for (int j=0;j<2;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //점화식 dp[n+tn]=max(dp[n+tn],max+arr[i][1])


        int max=Integer.MIN_VALUE;
        for (int i=1; i<=N+1;i++){
            max=Math.max(max,dp[i]);

            int fin= i+arr[i][0];
            if (fin<=N+1){
                dp[fin]=Math.max(dp[fin],max+arr[i][1]);
            }
        }

        System.out.println(dp[N+1]);

    }
}
