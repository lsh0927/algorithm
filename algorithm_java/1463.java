import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

    static Integer[] dp;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n= Integer.parseInt(br.readLine());

        dp= new Integer[n+1];

        dp[0]=0;
        dp[1]=0;
//        dp[2]=1;
//        dp[3]=1;



        System.out.println(find(n));
    }
    static int find(int n){


        if (dp[n]==null){



            if (n%6==0){
                dp[n]=Math.min(find(n-1),Math.min(find(n/3),find(n/2)))+1;


            } else if (n%3==0) {
                dp[n]=Math.min(find(n/3),find(n-1))+1;
            }

            else if (n%2==0) {
                dp[n]=Math.min(find(n/2),find(n-1))+1;
            }
            else {
                dp[n]=find(n-1)+1;
            }
        }


        return dp[n];

    }
}
