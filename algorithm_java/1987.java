/*
 * import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static class Move{
        int x;
        int y;
        int step;

        public Move(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }
    static int R,C;
    static int map[][];
    static boolean isVisited[];
    static int[] dx={1,0,0,-1};
    static int[] dy={0,-1,1,0};
    static int answer=0;

    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        R= Integer.parseInt(st.nextToken());
        C= Integer.parseInt(st.nextToken());

         map= new int[C][R];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < C; j++) {
                map[j][i] = line.charAt(j) - 'A';
            }
        }

        isVisited= new boolean[26];
        Move move= new Move(0,0,0);
        DFS(move);

        System.out.println(answer+1);
    }

    public static void DFS(Move move){
        if (isVisited[map[move.x][move.y]]){
            answer=Math.max(answer, move.step);
            return;
        }

        else {
            isVisited[map[move.x][move.y]]=true;

            for (int i=0;i<4;i++){
                int cx= move.x+dx[i];
                int cy= move.y+dy[i];

                if (cx>=0 && cy>=0 && cx<C && cy<R){
                    move.step+=1;
                    DFS(move);
                }
                //TODO 여기서 move.step+1을 하고 DFS호출을 하면 안되는 이유?
            }
            isVisited[map[move.x][move.y]]=false;
        }
    }
}

 */

//  import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.*;


// public class Main {


//     static int R,C;
//     static int map[][];
//     static boolean isVisited[];
//     static int[] dx={1,0,0,-1};
//     static int[] dy={0,-1,1,0};
//     static int answer=0;

//     public static void main(String[] args) throws Exception{
//         BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st= new StringTokenizer(br.readLine());

//         R= Integer.parseInt(st.nextToken());
//         C= Integer.parseInt(st.nextToken());

//          map= new int[C][R];

//         for (int i = 0; i < R; i++) {
//             st = new StringTokenizer(br.readLine());
//             String line = st.nextToken();
//             for (int j = 0; j < C; j++) {
//                 map[j][i] = line.charAt(j) - 'A';
//             }
//         }

//         isVisited= new boolean[26];
//         DFS(0,0,0);

//         System.out.println(answer);
//     }

//     public static void DFS(int x, int y, int count){
//         if (isVisited[map[x][y]]){
//             answer=Math.max(answer, count);
//             return;
//         }

//         else {
//             isVisited[map[x][y]]=true;

//             for (int i=0;i<4;i++){
//                 int cx=x+dx[i];
//                 int cy=y+dy[i];

//                 if (cx>=0 && cy>=0 && cx<C && cy<R){
//                     DFS(cx,cy,count+1);
//                 }
//             }
//             isVisited[map[x][y]]=false;
//         }
//     }
// }
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
public class Main {
    public static int R, C;
    public static String[][] graph;
    public static boolean[][] visited;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public static int result = 0;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        graph = new String[R][C];
        visited = new boolean[R][C];
        for(int i=0;i<R;++i){
            graph[i] = br.readLine().split("");
        }
 
        DFS(0,0, graph[0][0], 1);
        System.out.println(result);
    }
 
    public static void DFS(int x, int y, String str, int count){
 
        result = Math.max(result, count);
 
        for (int i = 0; i < 4; ++i) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= R || ny < 0 || ny >= C||visited[nx][ny]) {
                continue;
            }
            if (!str.contains(String.valueOf(graph[nx][ny]))) {
                visited[nx][ny] = true;
                DFS(nx, ny, str+graph[nx][ny],count + 1);
                visited[nx][ny] = false;
            }
        }
 
    }
 
}