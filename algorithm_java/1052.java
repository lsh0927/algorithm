import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
    static int N;
    static int K;
    static int ans=0;
    public static void main(String[] args) throws IOException {
       BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st= new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());

        //1개만 옮기려면 ->N= 2^n
        //2개 ::      ->N= 2^n1 +2^n2

        //ex) 13,2 => 8+4+1 => 1을 없애고 4쪽에 붙어야하니 3개의 물병을 사야 함.
        ans=count(N,K);

        System.out.println(ans);
    }
    public static int count(int num,int d){
        int count=0;
        int sum=0;
        int result;
        List<Integer> list= new ArrayList<>();
        int i=1;
        while(num>0) {
            while (i*2<= num) {
                i = i * 2;
            }
            list.add(i);
            num-=i;
            count++;
            i=1;
        }
        int index= count-d;
        if(index>0){
            for(int j=d;j<count;j++)
            {
                sum+=list.get(j);
            }
            result=list.get(d-1)-sum;
            return result;
        }
        else
            return 0;
    }
}