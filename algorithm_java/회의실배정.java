import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 회의실배정 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] meeting = new int[N][2];

        StringTokenizer st;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            meeting[i][0] = Integer.parseInt(st.nextToken());	// 시작시간
            meeting[i][1] = Integer.parseInt(st.nextToken());	// 종료시간
        }

        Arrays.sort(meeting, new Comparator<int[]>() {

            //종료시간 작은 순으로 정렬
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        int fin=0;
        int cnt=0;
        for(int i = 0; i < N; i++) {
            // 이전 종료시간이 다음 시작시간 보다 작음
            if(fin <= meeting[i][0]) {
                fin = meeting[i][1];
                cnt++;
            }
        }
        System.out.println(cnt);
    }

}