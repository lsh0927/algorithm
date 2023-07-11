import java.util.*;

public class Main {
    public static int[] arr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();
        arr = new int[N];

        for(int a=0; a<N; a++)
            arr[a]=scanner.nextInt();

        int start = 0, end = 0, count = 0, sum = 0;

        while(start < N) {
            if(sum > M || end == N)
                sum-=arr[start++];
            else
                sum+=arr[end++];

            if(sum==M)
                count++;
        }

        System.out.println(count);

    }
}