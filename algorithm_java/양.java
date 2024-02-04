import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class 양 {

    static int R,C;
    static char[][] map;
    static boolean[][] visited;
    static List<List<Character>> list;
    static int[] dx={1,0,-1,0};
    static int[] dy={0,1,0,-1};
    static int lamb,wolf;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map= new char[R][C];
        visited= new boolean[R][C];
        list= new ArrayList<>();



        for (int i=0;i<R;i++){
            String S= br.readLine();
            for (int j=0;j<C;j++)
            {
                map[i][j]=S.charAt(j);
            }
        }

        lamb=0;
        wolf=0;
        for (int i=0;i<R;i++){
            for (int j=0;j<C;j++){
                if (!visited[i][j]) {
                    for (int k=0;k<3;k++){
                        list.add(new ArrayList<>()); //0번은 울타리, 1번은 늑대, 2번은 양
                    }
                    dfs(i, j);
                    if (list.get(1).size()<list.get(2).size())
                    {
                        lamb+=list.get(2).size();

                    }
                    else {
                        wolf+=list.get(1).size();
                    }
                    list.clear();
                }

            }
        }
        System.out.println(lamb+" "+wolf);

    }
    static void dfs(int row, int col){
        visited[row][col]=true;

        if (map[row][col] == '#') {
            return;
        }

        for (int i=0;i<4;i++){
            int nr= row+dx[i];
            int nc= col+dy[i];



            if (nr >= 0 && nr < R && nc >= 0 && nc < C && !visited[nr][nc]) {

                 if (map[nr][nc] == '.') {
                    list.get(0).add('.');
                    dfs(nr,nc);
                }else if (map[nr][nc] == 'v') {
                    list.get(1).add('v');
                    dfs(nr, nc);
                } else if (map[nr][nc] == 'o') {
                    list.get(2).add('o');
                    dfs(nr, nc);
                }
            }
        }
//오답임

    }
}

/*
 * import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

    static int R, C;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int lamb, wolf;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String S = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = S.charAt(j);
            }
        }

        lamb = 0;
        wolf = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!visited[i][j] && map[i][j] != '#') {
                    int[] result = dfs(i, j);
                    if (result[0] > result[1]) {
                        lamb += result[0];
                    } else {
                        wolf += result[1];
                    }
                }
            }
        }
        System.out.println(lamb + " " + wolf);
    }

    static int[] dfs(int row, int col) {
        visited[row][col] = true;
        int[] result = new int[2];

        if (map[row][col] == 'o') {
            result[0]++;  // 양 수 증가
        } else if (map[row][col] == 'v') {
            result[1]++;  // 늑대 수 증가
        }

        for (int i = 0; i < 4; i++) {
            int nr = row + dx[i];
            int nc = col + dy[i];

            if (nr >= 0 && nr < R && nc >= 0 && nc < C && !visited[nr][nc] && map[nr][nc] != '#') {
                int[] subResult = dfs(nr, nc);
                result[0] += subResult[0];
                result[1] += subResult[1];
            }
        }

        return result;
    }
}

 */