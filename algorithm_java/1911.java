import java.util.*;
import java.io.*;
public class 1911 {

    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int L=Integer.parseInt(st.nextToken());

        List<int[]> list= new ArrayList<>();

        int max=0;
        for (int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());


            if (max<e){
                max=e;
            }

            list.add(new int[]{s,e});


        }


        boolean[] arr= new boolean[max+1];

        for (int[] a : list) {
            for (int i=a[0]; i<=a[1]; i++){
                arr[i]=true;
            }
        }

        // 웅덩이 부분은 전부 true

        int cnt=0;
        // 하나씩 가면서 true인경우, L만큼 false시키면 되지 않나??
        for (int i=0;i< arr.length;i++){
            if (arr[i]){
                cnt++;
                for (int j=i;j<=i+L;j++){
                    if (j>= arr.length) break;
                    arr[j]=false;
                }
            }
        }

        System.out.println(cnt);





    }
}