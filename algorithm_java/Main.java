
// import java.io.BufferedReader;
// import java.io.InputStreamReader;
// import java.util.*;

// public class Main {

//     static class Node implements Comparable<Node>{
//         String s;
//         int cnt;

//         public Node(String s, int cnt) {
//             this.s = s;
//             this.cnt = cnt;
//         }

//         @Override
//         public int compareTo(Node o){
//             if(this.cnt==o.cnt)
//                 return this.s.compareTo(o.s);
//             else return Integer.compare(o.cnt, this.cnt);
//         }
//     }


//     public static void main(String[] args) throws Exception {

//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st= new StringTokenizer(br.readLine());

//         int N=Integer.parseInt(st.nextToken());
//         int M=Integer.parseInt(st.nextToken());

//         PriorityQueue<Node> pq= new PriorityQueue<>();
//         HashMap<String,Integer> map= new HashMap<>();

//         for(int i=0;i<N;i++){
//             String s= br.readLine();
//             if(s.length()>=M){
//                 map.put(s,map.getOrDefault(s,0)+1);
//             }
//         }

//         map.forEach((key,value)->{
//             pq.add(new Node(key,value));
//         });

//         while (!pq.isEmpty()){
//             System.out.println(pq.poll().s);
//         }

//         //사전 순 정렬???
//         // 스트링 문자를 사전순으로 정렬하는 방법

//     }
// }


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node>{
        String s;
        int cnt;

        public Node(String s, int cnt) {
            this.s = s;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o){
            if(this.cnt!=o.cnt)
                return Integer.compare(o.cnt, this.cnt);

            if (this.s.length()!= o.s.length()){
                return Integer.compare(o.s.length(),this.s.length());
            }
            else return this.s.compareTo(o.s);
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

        List<String> word= new ArrayList<>();

        while (!pq.isEmpty()){
           // System.out.println(pq.poll().s);
            word.add(pq.poll().s);
        }

        // 정렬된 단어들을 출력
        StringBuilder sb = new StringBuilder();
        for (String str : word) {
            sb.append(str + "\n");
        }
        System.out.println(sb);
    }
}

