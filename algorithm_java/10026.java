import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char Grid[][];		// 그리드 맵
    static boolean visit[][];	// 방문 체크
    static int[] dx = {0, -1, 0, 1};	// 상하좌우 x
    static int[] dy = {-1, 0, 1, 0};	// 상하좌우 y
    static int N;			// 그리드의 크기
    static int notRGB = 0;	// 적록색약 아닌 사람이 봤을때
    static int RGB = 0;		// 적록색약인 사람이 봤을때

    // <- , ↑ , -> , ↓ ... 동서남북 4방향 체크해가며 dfs 돌리기
    public static void dfs(int x, int y) {
        visit[x][y] = true;		// 현재 위치 방문체크
        char color = Grid[x][y];	// 현재 색 저장

        for(int i=0; i<4; i++) { // 상하좌우 체크
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && ny>=0 && nx<N && ny<N) {
                // 상하좌우중 같은색의 약이고 방문하지 않은곳 -> 끝까지 탐색
                if(Grid[nx][ny] == color && !visit[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        Grid = new char[N][N];
        visit = new boolean[N][N];
        for(int i=0; i<N; i++) {
            String str = bf.readLine();
            for(int j=0; j<N; j++) {
                Grid[i][j] = str.charAt(j);
            }
        }

        // 적록색약이 아닌 사람이 봤을때 구역의 갯수 구하기
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!visit[i][j]) {
                    dfs(i, j);
                    notRGB ++;
                }
            }
        }

        // 적록색약인 사람의 경우 -> 빨간색과 초록색의 차이를 느끼지 못하므로 동일하게 봄.
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(Grid[i][j] == 'G')	// 초록 -> 빨강으로 변경
                    Grid[i][j] = 'R';
            }
        }

        visit = new boolean[N][N];	// 방문표시 초기화

        // 적록색약인 사람이 봤을때 구역의 갯수 구하기
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!visit[i][j]) {
                    dfs(i, j);
                    RGB ++;
                }
            }
        }

        System.out.println(notRGB + " " + RGB);
        bf.close();
    }

}