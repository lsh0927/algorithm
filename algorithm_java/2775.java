import java.io.*;
import java.util.*;

class Main {


    static int dp[][];
    public static void main(String args[]) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int t= Integer.parseInt(br.readLine());
        /*
        a층의 b호에 살려면 자신의 아래 층의 1호부터 b호까지 사람 수의 합만큼 사람을 데려와야함
         */


        for (int i=0;i<t;i++){
            int k=Integer.parseInt(br.readLine());
            int n=Integer.parseInt(br.readLine());
            dp= new int[k+1][n+1];
            print(dp,k,n);
        }


    }
    static void print(int[][] dp,int k, int n) {

        for (int a=0;a<=n;a++){
            dp[0][a]=a;
        }

        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                for (int h=1;h<=j;h++)
                    dp[i][j]+=dp[i-1][h];
            }
        }
        System.out.println(dp[k][n]);
    }

}