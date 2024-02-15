import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 뿌요뿌요
 {

    static int N=12;
    static int M=6;
    static int[] dx={-1,0,1,0};
    static int[] dy={0,1,0,-1};
    static String[][] map= new String[N][M];
    static int count=0;
    static boolean check;
    // static boolean[][] visited; 이거 안됨. 뿌요가 다시 내려오면 방문 여부 의미 없어짐 -> 새로 갱신하거나 dfs 안에서 선언
    public static void main(String[] args) throws IOException {
         BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st;

         for (int i=0;i<N;i++){
             st= new StringTokenizer(br.readLine());
             for (int j=0;j<M;j++){
                 map[i][j]= st.nextToken();
             }
         }

         //2중 for문으로 탐색하면서, 한 단계 마다 연쇄를 모두 일으킴 -> 여기서 한번에 다 끝내고 중력에 의해 떨어지는 것까지 구현
         for (int i=0;i<N;i++){
             for (int j=0;j<M;j++){
                 if (map[i][j].equals(".")){
                     continue;
                 } else {
                     dfs(i,j,0);

                     //dfs를 돌면서 4개 이상 한번이라도 돌았다면 1개의 연쇄 증가
                     if (check)
                         count++;
                 }
                 check=false;
             }
         }

        System.out.println(count);
    }

    public static void dfs(int x, int y,int sum){
        boolean[][] visited;
        visited= new boolean[N][M];

        visited[x][y]=true;
        //리스트에 추가

        //4개 이상
        if (sum==4){
            //연결된 노드들을 없애야 함
            //dfs를 할때마다 지나온 칸들의 정보를 기억했다가, 4개가 되면 for문으로 해당하는 노드의 칸을 "."로 채우고,
            //떨어지는 것까지 구현해야함

            check=true;
            //리스트에 노드 추가


        }

        for (int i=0;i<4;i++){
            int nx= x+dx[i];
            int ny= y+dy[i];

            if (!visited[nx][ny] && nx>=0 && nx<N  && ny>=0 && ny<M){
                dfs(nx,ny,sum+1);
            }
        }

    }
}

//5개 이상의 노드를 어떻게 처리할까?