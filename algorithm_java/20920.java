
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 20920 {

    static class Node implements Comparable<Node>{
        String s;
        int cnt;

        public Node(String s, int cnt) {
            this.s = s;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o){
            if(this.cnt==o.cnt)
                return this.s.compareTo(o.s);
            else return Integer.compare(o.cnt, this.cnt);
        }
    }


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());

        PriorityQueue<Node> pq= new PriorityQueue<>();
        HashMap<String,Integer> map= new HashMap<>();

        for(int i=0;i<N;i++){
            String s= br.readLine();
            if(s.length()>=M){
                map.put(s,map.getOrDefault(s,0)+1);
            }
        }

        map.forEach((key,value)->{
            pq.add(new Node(key,value));
        });

        while (!pq.isEmpty()){
            System.out.println(pq.poll().s);
        }

        //사전 순 정렬???
        // 스트링 문자를 사전순으로 정렬하는 방법

    }
}

