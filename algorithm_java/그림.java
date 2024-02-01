import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static List<Integer> list;
    static boolean[][] visited;
    static int[] dx= {1,0,-1,0};
    static int[] dy= {0,1,0,-1};
    static int N,M;
//    static  int max= Integer.MIN_VALUE;
    static int count=0;
    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());


        list= new ArrayList<>();
        map= new int[N][M];
        visited= new boolean[N][M];
        //int space=1;
       // 안쓰는 코드 int ans=0;

        //새로운 방식
        boolean zero= true;

        for (int i=0;i<N;i++)
        {
            st= new StringTokenizer(br.readLine());
            for (int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
              //  System.out.println(map[i][j]);
                if (map[i][j]==1){
//                    visited[i][j]=false; 안쓰는 코드
//                    ans=dfs(map,space,i,j);
//                    visited[i][j]=true;
                    zero=false; //일단 그림이 있다는 것


                }
//                if (max<ans) 안쓰는 코드
//                    max=ans;
            }
        }

        if (zero==true)
        {
            System.out.println("0");
            System.out.println("0");
            return;
        }

        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                count=0;
                if (!visited[i][j] && map[i][j]==1){
                    dfs(i,j);
                    list.add(count);
                }
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        System.out.println(list.get(list.size()-1));

    }
    static void dfs(int x,int y){
        visited[x][y]=true;
        count++;

        for (int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];

            if (nx>=0 && nx<N && ny>=0 && ny<M && !visited[nx][ny] && map[nx][ny]==1){
                dfs(nx,ny);
            }
        }
    }
}


