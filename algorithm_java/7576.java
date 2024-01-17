import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int N,M;
    static int[][] map;
    static int[] dx= {0,1,0,-1};
    static int[] dy= {1,0,-1,0};
    static boolean[][] visit;
    static Queue<int[]> q= new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        M= Integer.parseInt(st.nextToken());
        N= Integer.parseInt(st.nextToken());

        map= new int[N][M];
        visit=new boolean[N][M];
        for(int i=0;i<N;i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
                if(map[i][j]==1){
                    q.add(new int[]{i,j});
                }
            }
        }
        System.out.println(bfs());
    }
    private static int bfs() {

        while (!q.isEmpty()) {

            int[] t = q.poll();
            int x = t[0];
            int y = t[1];

            for (int i = 0; i < 4; i++) { // 상하좌우 체크
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (map[nx][ny] == 0) {
                        map[nx][ny] = map[x][y] + 1;
                        q.add(new int[]{nx, ny});

                    }
//                    if (!visit[nx][ny]) {
//                        map[nx][ny] = 1;
//                        bfs(nx, ny);
//
                }
            }
        }
            int max = Integer.MIN_VALUE;
            if (checkZero()) {
                return -1;
            }else {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        if (max < map[i][j]) {
                            max = map[i][j];
                        }
                    }
                }
                return max - 1;
            }
    }
    private static boolean checkZero() {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 0)
                        return true;
                }
            }
            return false;
        }
}