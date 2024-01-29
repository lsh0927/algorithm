import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;
public class Main {

    static int []arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       int N=sc.nextInt();
       int K=sc.nextInt();
       int sum=0;
       arr=new int[N];
       int max=Integer.MIN_VALUE; // 합이 음수일수도 있는데 왜 0으로 초기화했어!
       for(int o=0;o<N;o++){
           arr[o]= sc.nextInt();
       }


      for(int i=0;i<=N-K;i++) {
          sum = 0;
          for (int j = i; j < i+K; j++) {
              sum += arr[j];
          }
          //System.out.println(sum);
          if (max <= sum) {
              max = sum;
              //System.out.println(min);
          }

      }
        System.out.println(max);
    }

}//맞지만, 시간 + 메모리 낭비 심함

/*
 * import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());

        // 입력값 배열 삽입
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int max = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];

            // 처음으로 구해진 합을 최댓값을 설정
            if(i == k - 1) {
                max = sum;
            }

            // 한칸씩 밀며 합 구하기
            if(i >= k) {
                sum -= arr[i - k];
                max = Math.max(max, sum);
            }
        }

        System.out.println(max);

    }
}
 */ //시간과 메모리 거의 5~6배 단축


 /*
  * import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        int K= Integer.parseInt(st.nextToken());

        int[] arr= new int[N];

        st= new StringTokenizer(br.readLine());

        for (int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        List<Integer> list= new ArrayList<>();
        int sum=0;
        for (int a=0;a<=N-K;a++){
            for (int b=a;b<a+K;b++){
                sum+=arr[b];
            }
            list.add(sum);
            sum=0;
        }
        //list의 맥스를 뽑아...!
        int maxValue = Collections.max(list);


        System.out.println(maxValue);
    }
}
  */