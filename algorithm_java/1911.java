// import java.util.*;
// import java.io.*;
// public class 1911 {

//     public static void main(String[] args) throws IOException {

//         BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st= new StringTokenizer(br.readLine());
//         int N=Integer.parseInt(st.nextToken());
//         int L=Integer.parseInt(st.nextToken());

//         List<int[]> list= new ArrayList<>();

//         int max=0;
//         for (int i=0;i<N;i++) {
//             st = new StringTokenizer(br.readLine());
//             int s = Integer.parseInt(st.nextToken());
//             int e = Integer.parseInt(st.nextToken());


//             if (max<e){
//                 max=e;
//             }

//             list.add(new int[]{s,e});


//         }


//         boolean[] arr= new boolean[max+1];

//         for (int[] a : list) {
//             for (int i=a[0]; i<=a[1]; i++){
//                 arr[i]=true;
//             }
//         }

//         // 웅덩이 부분은 전부 true

//         int cnt=0;
//         // 하나씩 가면서 true인경우, L만큼 false시키면 되지 않나??
//         for (int i=0;i< arr.length;i++){
//             if (arr[i]){
//                 cnt++;
//                 for (int j=i;j<=i+L;j++){
//                     if (j>= arr.length) break;
//                     arr[j]=false;
//                 }
//             }
//         }

//         System.out.println(cnt);
import java.util.*;
import java.io.*;
public class 1911 {

    static class Node implements Comparable<Node>{
        int s,e;

        public Node(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        //시작값 기준 오름차순, 같으면 끝값 내림차순 정렬
        public int compareTo(Node o){
            if (this.s==o.s)
                return o.e-this.e;
            else
                return this.s-o.s;
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int L=Integer.parseInt(st.nextToken());

       PriorityQueue<Node> pq= new PriorityQueue<>();

       for (int i=0;i<N;i++){
           st= new StringTokenizer(br.readLine());
           int s=Integer.parseInt(st.nextToken());
           int e=Integer.parseInt(st.nextToken());

           pq.offer(new Node(s,e));

       }

        int result=0; //널빤지 개수
        int fill=0; //현재 덮인 최대 위치

        while (!pq.isEmpty()){
            Node cur= pq.poll();
            //현재 웅덩이가 이미 널빤지로 채워진 경우
            if (cur.e<fill)
                continue;

            if (fill< cur.s){
                fill= cur.s;
            }

            int remain= (cur.e-fill)%L;
            result+=(cur.e-fill)/L;

            fill= cur.e;
            //널빤지 범위 넘어갈 때

            if (remain!=0){
                result++;
                fill+=L-remain;
            }
        }

        System.out.println(result);


    }
}




//     }
// }