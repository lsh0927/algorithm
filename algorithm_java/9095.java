import java.util.Scanner;
import java.util.*;

public class Main {
    static int dp[] = new int[11];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
//        int[] arr = new int[N];
//        for (int i = 0; i < N; i++) {
//            arr[i] = sc.nextInt();
//        }
//

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int j = 4; j <= 10; j++) { // 4부터 반복
            dp[j] = dp[j - 3] + dp[j - 2] + dp[j - 1]; // 점화식
        }

        for (int i = 0; i < N; i++) {
            int n = sc.nextInt();

            System.out.println(dp[n]);
        }
    }
}
//
//        for(int n=0;n<arr.length;n++)
//        {
//            System.out.println(recur(arr[n]));
//        }
//    }
//    static int recur(int N) {
//        if (dp[N] == null) {
//            if (N > 3) {
//                dp[N] = (recur(N - 1) - 1) * 2 + 1;
//            }
//        }
//        return dp[N];
//    }
//}