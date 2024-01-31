import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());


        int[] score= new int[N];
        List<int[]> scope= new ArrayList<>();

        st= new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            score[i]=Integer.parseInt(st.nextToken());
        }

        for(int j=0;j<K;j++){
            st= new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            scope.add(new int[]{a, b});

            double d=b-a+1;
            double sum=0;

            for(int c=a-1;c<b;c++){
                sum+=score[c];
            }


            double avg=sum/d;

            System.out.printf("%.2f",avg);
        }


    }
}
