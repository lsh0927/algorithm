import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int k;
    static ArrayList<Integer> arr[];
    static boolean[] isVisit;
    static StringBuilder sb;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br= new BufferedReader( new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());

        arr= new ArrayList[N+1]; //좌표를 그대로 받아들이기 위해 +1 사용
        isVisit=new boolean[N+1];
        sb= new StringBuilder();
        for(int i=0;i<arr.length;i++){
            arr[i]=new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());

            arr[a].add(b);
            arr[b].add(a);
        }

        for(int i=0;i<arr.length;i++){
            Collections.sort(arr[i]);
        }

        dfs(k);
        isVisit=new boolean[N+1];
        sb.append("\n");
        bfs(k);
        System.out.println(sb);

    }
    public static void dfs(int index){
        isVisit[index]=true;
        sb.append(index+" ");
        for(int i:arr[index]){
            if(!isVisit[i])
                dfs(i);
        }
    }
    public static void bfs(int index){
        isVisit[index]=true;
        Queue<Integer> q= new LinkedList<>();
        q.add(index);
        while (!q.isEmpty()){
            int a= q.poll();
            sb.append(a+" ");
            for(int i: arr[a]){
                if(!isVisit[i])
                {
                    q.add(i);
                    isVisit[i]=true;
                }
            }
        }
    }
}
