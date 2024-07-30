import java.util.*;
import java.io.*;

public class Main{

    static HashMap<Integer,Integer> map= new HashMap<>();
    static int n;
    static int[][]arr;
    static int[] dx={1,0,-1,0};
    static int[] dy={0,1,0,-1};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n= Integer.parseInt(br.readLine());
        arr= new int[n][n];
        visited= new boolean[n][n];

        for (int i=0;i<n;i++){
            String s= br.readLine();
            for (int j=0; j<n;j++){
                arr[i][j]=Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }

        int num=1;
        for (int i=0;i<n;i++){
            for (int j=0; j<n;j++){

                if(arr[i][j]==1 && !visited[i][j]) {
                    map.put(num,1);
                    dfs(i, j,num);
                }
                num+=1;
            }
        }

        List<Integer> list= new ArrayList<>();
        for (int i : map.values()) {
            list.add(i);
        }
        Collections.sort(list);

        System.out.println(map.size());
        for (int i : list) {
            System.out.println(i);

        }
    }
    static void dfs(int r, int c, int nn){

        visited[r][c]=true;

        for (int i=0;i<4;i++){
            int nx= r+dx[i];
            int ny= c+dy[i];


            if (nx>=0 && nx<n && ny>=0 && ny<n && arr[nx][ny]==1&& !visited[nx][ny]) {
                visited[nx][ny]=true;
                map.put(nn,map.get(nn)+1);
                dfs(nx,ny,nn);
            }
        }


    }
}