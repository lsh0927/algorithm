import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            A.add(Integer.parseInt(st.nextToken()));
        }

        ArrayList<Integer> SumList = new ArrayList<>();
        SumList.add(0);
        int sum = 0;
        for (int value : A) {
            sum += value;
            SumList.add(sum);
        }

        int Max = 0;

        for (int i = 0; i < N; i++) {
            if (i + K <= N) {
                Max = Math.max(Max, SumList.get(i + K) - SumList.get(i));
            } else {
                Max = Math.max(Max, SumList.get(N) - SumList.get(i) + SumList.get((i + K) % N));
            }
        }

        System.out.println(Max);
    }
}
