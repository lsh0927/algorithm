import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


public class Main {

    static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static int[] fndHome= new int[3];
    static int n;
    static List<Edge>[]list= new ArrayList[100001];
    static class Edge implements Comparable<Edge>{
        int v,dis;

        public Edge(int v, int dis) {
            this.v = v;
            this.dis = dis;
        }
        @Override
        public int compareTo(Edge o){
            if(this.dis==o.dis)
                return this.v-o.v;
            else{
                if(this.dis>o.dis)
                    return 1;
                else
                    return -1;
            }
        }

    }
    static int[] d1,d2,d3;
    static int[] dijkstra(int start) {
        int d[] = new int[n + 1];
        Arrays.fill(d, 987654321);
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        while (!pq.isEmpty()) {
            int cur = pq.peek().v;
            int curDis = pq.peek().dis;
            pq.poll();
            if (d[cur] < curDis)
                continue;
            for (int i = 0; i < list[cur].size(); i++) {
                int next=list[cur].get(i).v;
                int nextDis= list[cur].get(i).dis;
                if(d[next]>nextDis+curDis)
                {
                    d[next]=nextDis+curDis;
                    pq.add(new Edge(next, nextDis+curDis));
                }
            }
        }
        return d;
    }
    public static void main(String[] args) throws Exception {
            n=Integer.parseInt(br.readLine());
            StringTokenizer st= new StringTokenizer(br.readLine());
            for(int i=0;i<3;i++){
                fndHome[i]=Integer.parseInt(st.nextToken());
            }
            int m= Integer.parseInt(br.readLine());
            for(int i=1;i<=n;i++)
                list[i]=new ArrayList<Edge>();

            for(int i=0;i<m;i++){
                    st=new StringTokenizer(br.readLine());
                    int v1= Integer.parseInt(st.nextToken());
                    int v2= Integer.parseInt(st.nextToken());
                    int dis=Integer.parseInt(st.nextToken());
                    list[v1].add(new Edge(v2,dis));
                    list[v2].add(new Edge(v1,dis));
            }
            d1=dijkstra(fndHome[0]);
            d2=dijkstra(fndHome[1]);
            d3=dijkstra(fndHome[2]);
            int max=-1;
            int max_idx=-1;
            for(int i=1;i<=n;i++)
            {
                int a = d1[i];
                int b= d2[i];
                int c = d3[i];
                int min = Math.min(a,b);
                min = Math.min(min,c);
                if(max == min && max_idx >i)
                {
                   max_idx = i;
                }
                else if(max < min)
                {
                    max = min;
                    max_idx = i;
                }

        }
        bw.write(Integer.toString(max_idx));
        bw.flush();
    }
}

