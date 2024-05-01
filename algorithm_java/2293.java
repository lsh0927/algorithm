
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;


public class Main {


    static int[] dp;
    static int[] coin;
    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());


        coin= new int[n];
        for (int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            coin[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(coin);
        dp= new int[n];
        dp[0]=0;

        dp[k]=Split(k,n);

        System.out.println(dp[k]);
    }
    public static int Split(int remain, int n){

        if (remain<coin[0])
        {
            dp[remain]=0;
            return dp[remain];
        }
        if (remain==coin[0])
        {
            dp[remain]=1;
            return dp[remain];
        }
        for (int j=0;j<n;j++) {
            dp[remain] = Split(remain - coin[j], n) + Split(coin[j], n);
        }
        return dp[remain];
    }
}
