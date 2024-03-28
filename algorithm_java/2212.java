import java.util.*;
import java.io.*;
 class 2212 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());
        int K= Integer.parseInt(br.readLine());


        if (N<=K)
        {
            System.out.println(0);
            return;

        }

        int[] arr= new int[N];
        int[] diff= new int[N-1];
        StringTokenizer st= new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i=0;i<N-1;i++){
            diff[i]=arr[i+1]-arr[i];
        }

        Arrays.sort(diff);

        for (int i=N-2;i>N-K-1;i--){
            diff[i]=0;
        }

        int sum=0;

        for (int i=0;i<N-1;i++){
            sum+=diff[i];
        }
        System.out.println(sum);
    }
}