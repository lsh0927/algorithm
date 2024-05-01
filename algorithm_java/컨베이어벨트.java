import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class 컨베이어벨트 {

    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());
        boolean[] robot = new boolean[N];

        //arr[0] 올리는 위치, arr[N-1] 내리는 위치

        int[] arr= new int[2*N];
        st= new StringTokenizer(br.readLine());
        for (int i=0;i<2*N; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        //내구도가 0이 아니면 올리는 위치에 로봇을 올림
        //올리거나 이동하면 내구도 --

        //while 내구도 >= 1으로 구현

        int level=0;
        while (true){
            level++;

            //1단계
            int temp= arr[2*N-1];

            for (int i=2*N-1;i>0;i--){
                arr[i]=arr[i-1];
            }
            arr[0]=temp;

            for (int i=N-1;i>0;i--){
                robot[i] = robot[i-1];
            }

            //로봇도 이동했으니 없음
            robot[0]=false;
            robot[N-1]=false;
            //마지막 로봇은 아무튼 내림


            //2단계
            for (int i=N-1;i>0;i--)
            {
                if (robot[i-1] && !robot[i] && arr[i]>=1){
                    robot[i-1]=false;
                    robot[i]=true;
                    arr[i]--;
                    robot[N-1]=false;
                }
            }

            //3단계
            if (arr[0]>0)
            {
                robot[0]=true;
                arr[0]--;
            }

            //4단계
            int cnt=0;
            for (int i=0; i<2*N; i++){
                if (arr[i]==0)
                    cnt++;
            }
            if (cnt>=K) break;


        }
        System.out.println(level);

    }
}