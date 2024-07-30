import java.util.*;
import java.io.*;

public class Main{

    static Integer[] dp;
    static int[]arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n= Integer.parseInt(br.readLine());

        StringTokenizer st= new StringTokenizer(br.readLine());

        arr= new int[n+1];
        dp= new Integer[n+1];

        for (int i=1;i<=n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
//
//        for (int i=1;i<=n;i++){
//            dp[i]=1;
//        }

        if (n==1){
            System.out.println(1);
            return;
        }

//        for (int i=2;i<=n;i++){
//            for(int j=1;j<i;j++){
//                if (arr[i]>arr[j]){
//                    dp[i]=Math.max(dp[i], dp[j]+1 );
//                }
//            }
//        }

        for (int i=1; i<=n;i++){
            recur(i);
        }
        int max=0;
        for (int i=1; i<=n;i++){
            max=Math.max(max,dp[i]);
        }

        System.out.println(max);
           //System.out.println(max);
    }
    static int recur(int n){

        if (dp[n]==null) {
            dp[n]=1;
            for (int i = n; i >= 1; i--) {
                if (arr[n] > arr[i])
                    dp[n] = Math.max(dp[n], recur(i) + 1);
            }
        }
        return dp[n];
    }

}