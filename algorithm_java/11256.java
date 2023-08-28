import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main  {
    static int T;
    static int J,N;
    static Integer[] num;
    static class Box{
        int R,C;

        public Box(int r, int c) {
            R = r;
            C = c;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int cnt=0;
        int sum=0;
        st=new StringTokenizer(br.readLine());
        T=Integer.parseInt(st.nextToken());

        for(int i=0;i<T;i++){
            cnt=0;
            sum=0;
            st=new StringTokenizer(br.readLine());
            J=Integer.parseInt(st.nextToken());
            N=Integer.parseInt(st.nextToken());
            num=new Integer[N];

            for(int j=0;j<N;j++) {
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                Box box = new Box(r, c);
                int n = box.C * box.R;
                num[j] = n;
            }
            Arrays.sort(num, Collections.reverseOrder());

            for(int k=0;k<N;k++){
                J-=num[k];
                cnt++;
                if(J<=0)
                    break;
            }

            System.out.println(cnt);
        }
    }
}

