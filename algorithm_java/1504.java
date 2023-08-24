import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
    private static int N,E,Ans; //정점과 간선
    private static int INF= 2000000000;
    private static ArrayList<Node>[] adjList;
    private static int[] cost;
    private static boolean[] visited;
    private static class Node implements Comparable<Node>{
        int dest,cost; //목적지와 비용(거리)으로 구성

        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node o){
            return this.cost-o.cost; //cost기준 오름차순 정렬
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st;
        
        Ans=0;
        st= new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        E=Integer.parseInt(st.nextToken());
        
        adjList=new ArrayList[N+1];
        cost= new int[N+1];
        visited=new boolean[N+1];
        
        //인접리스트 초기화
        for(int i=0;i<N+1;i++){
            adjList[i]=new ArrayList<>();
            
        }
        for(int i=0;i<E;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken()); //출발지 
            int b=Integer.parseInt(st.nextToken()); //도착지
            int c=Integer.parseInt(st.nextToken());  //비용
            adjList[a].add(new Node(b,c)); //단방향인 경우를 계산
            adjList[b].add(new Node(a,c)); //양방향이므로 반대의 경우를 계산
            
        }
        st= new StringTokenizer(br.readLine());
        int v1=Integer.parseInt(st.nextToken());
        int v2=Integer.parseInt(st.nextToken());
        
        int ans1=0; // 1>v1>v2>N
        ans1+=dijkstra(1,v1);
        ans1+=dijkstra(v1,v2);
        ans1+=dijkstra(v2,N);

        int ans2=0; // 1>v1>v2>N
        ans2+=dijkstra(1,v2);
        ans2+=dijkstra(v2,v1);
        ans2+=dijkstra(v1,N);
        
        if(ans1>=INF && ans2>=INF) Ans=-1;
        else Ans=Math.min(ans1,ans2);
        bw.write(Ans+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
    private static int dijkstra(int start, int end){
        //최저 비용 기준 탐색경로 저장을 위한 우선 순위 큐
        PriorityQueue<Node> pq= new PriorityQueue<>();
        Arrays.fill(visited,false); //방문 여부 체크 배열을 false로 초기화
        Arrays.fill(cost,INF); //cost배열 INF로 초기화
        
        cost[start]=0;
        pq.add(new Node(start,0)); //초기상태 설정
        
        while (!pq.isEmpty()){
            Node now=pq.poll();
            
            if(visited[now.dest]) continue;
            visited[now.dest]=true;
            
            //탐색
            for(Node next:adjList[now.dest]){
                if(cost[next.dest]>next.cost+now.cost){
                    cost[next.dest]= next.cost+now.cost;
                    pq.add(new Node(next.dest,cost[next.dest]));
                }
            }
        }
        return cost[end];
    }
}
