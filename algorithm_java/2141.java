import java.util.*;
import java.io.*;
public class 2141 {

    static class Node implements Comparable<Node>{
        long dis;
        long num;

        public Node(long dis, long num) {
            this.dis = dis;
            this.num = num;
        }

        @Override
        public int compareTo(Node o){
            return (int) (this.dis-o.dis);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N= Integer.parseInt(br.readLine());
        StringTokenizer st;

        List<Node> list= new ArrayList<>();

        long sum=0;

        for (int i=0;i<N;i++){
            st= new StringTokenizer(br.readLine());
            long dis= Long.parseLong(st.nextToken());
            long num= Long.parseLong(st.nextToken());
            list.add(new Node(dis,num));
            sum+=num;
        }
        Collections.sort(list);

        long result=0;
        for (int i=0;i<N;i++){
            result+=list.get(i).num;
            if ((sum+1)/2<=result){
                System.out.println(list.get(i).dis);
                break;
            }
        }
    }
}