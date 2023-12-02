import javax.naming.ldap.SortResponseControl;
import java.awt.*;
import java.io.*;
import java.rmi.MarshalledObject;
import java.util.*;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
class Jewelry{
    int mass;
    int value;

    public Jewelry(int mass, int value) {
        this.mass = mass;
        this.value = value;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {


       BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st= new StringTokenizer(br.readLine());
       int N= Integer.parseInt(st.nextToken());
       int K= Integer.parseInt(st.nextToken());

        Jewelry[] jewelries= new Jewelry[N];


        for (int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            int m= Integer.parseInt(st.nextToken());
            int v= Integer.parseInt(st.nextToken());

           jewelries[i]= new Jewelry(m,v);
       }

       Arrays.sort(jewelries, new Comparator<Jewelry>() {
           @Override
           public int compare(Jewelry o1, Jewelry o2) {
               if (o1.mass == o2.mass)
                   return o2.value - o1.value;
               return o1.mass - o2.mass;
           }
       });


        int[] bags= new int[K];
        for (int i=0; i<K;i++){
            bags[i]= Integer.parseInt(br.readLine());
        }

        Arrays.sort(bags);

        PriorityQueue<Integer> pq= new PriorityQueue<>(Comparator.reverseOrder());
        long ans=0;
        //보석의 총 가치
        for (int i=0,j=0; i<K;i++){
            //현재 가방의 무게보다 작거나 같은 보석을 모두 우선순위 큐에 넣음
            //i는 현재 가방의 인덱스를, j는 보석 배열의 인덱스를 나타냄
            while(j<N && jewelries[j].mass<=bags[i])
            {
                pq.offer(jewelries[j++].value);
            }
            if (!pq.isEmpty())
                ans+= pq.poll();
            //가방은 K개 있으므로 넣을 수 있는 최상의 보석을 가방에 차례로 집어 넣음
        }

        bw.write(ans+ "\n");
        bw.flush();
        bw.close();
        br.close();
    }



}
