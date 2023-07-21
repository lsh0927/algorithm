/* 
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args){
       Scanner sc= new Scanner(System.in);
        int N= sc.nextInt();

        System.out.println(fibonacci(N)%10007);

    }

    static int fibonacci(int N) {
        // N에 대한 0, 1의 호출 횟수가 없을 떄(탐색하지 않은 값일 때)
        if(N==2)
            return 2;
        else if(N==3)
            return 3;
        else{
            return fibonacci(N-1)+fibonacci(N-2);
        }

    }

}
*/ //실행은 되나 시간 초과
//
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    static int N;
    static int[] D;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        D = new int[1001];
        D[1] = 1;
        D[2] = 2;

        for(int i=3; i<=N; i++) {
            D[i] = D[i-1] + D[i-2];
            D[i] %= 10007;
        }
        System.out.println(D[N]);

    }
}
//좀.... 하...