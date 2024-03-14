import java.util.*;
import java.io.*;
 
class 1092{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 크레인 대수

        int[] c = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            c[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine()); // 박스의 수

        int[] box = new int[M];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            box[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(c);
        Arrays.sort(box);

        // 모든 박스를 배로 옮길 수 없는 경우
        if (c[N - 1] < box[M - 1]) {
            System.out.println(-1);
            return;
        }

        boolean[] visited = new boolean[M];
        int time = 0;
        int count = 0;
        int bidx=M-1;
        int cidx=N-1;


//        while (count <M) {
//            time++;
//            cidx=N-1;
//            //크레인을 모두 탐색하면서 뺄수있는 박스 다뺌
//            while (cidx>=0 && bidx>=0){
//                if (!visited[bidx]  && c[cidx]>=box[bidx]) {
//                    bidx--;
//                    cidx--;
//                    visited[bidx]=true;
//                    count++;
//                }
//                else cidx--;
//            }
//
//
//        }

        while (count < M) {

            cidx = N - 1;
            for (bidx = M - 1; cidx >= 0 && bidx >= 0; bidx--) {
                if (!visited[bidx] && c[cidx] >= box[bidx]) {
                    visited[bidx] = true;
                    cidx--;
                    count++;
                }
            }
            time++;
        }
        System.out.println(time);
    }

}