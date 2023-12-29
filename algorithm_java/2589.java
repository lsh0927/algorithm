import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 2589 {
    static int N, M;
    static char[][] map;
    static int[][] distance;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        distance = new int[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int result = 0;

        // 모든 육지에서 BFS 수행
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'L') {
                    int time = bfs(i, j);
                    result = Math.max(result, time);
                }
            }
        }

        System.out.println(result);
    }

    private static int bfs(int startX, int startY) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                distance[i][j] = -1; // 거리 배열 초기화
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY});
        distance[startX][startY] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (isValid(nx, ny) && map[nx][ny] == 'L' && distance[nx][ny] == -1) {
                    distance[nx][ny] = distance[x][y] + 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        int maxDistance = 0;
        // 최단 거리 중 가장 큰 값 찾기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (distance[i][j] != -1) {
                    maxDistance = Math.max(maxDistance, distance[i][j]);
                }
            }
        }

        return maxDistance;
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}
