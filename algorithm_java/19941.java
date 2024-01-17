import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main  {
    static int N;
    static int K;
    static char[] word;
    static int cnt=0;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb= new StringBuilder();

        st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());

        word = br.readLine().toCharArray();

        for(int i=0;i<N;i++){
            if(word[i]=='P') {
                int index = Math.max(i - K, 0);
                boolean check=false;
                //가장 먼저 발견한 햄버거 탐색
                for(int j=index;j<i;j++)
                {
                    if(bergerCheck(j)){
                        check=true;
                        break;
                    }
                }
                if(!check)
                {
                    index=i+K>=N? N-1: i+K;
                    for(int j=i+1;j<=index;j++){
                        if(bergerCheck(j))
                            break;
                    }
                }
            }
        }
        System.out.println(cnt);

    }
    static boolean bergerCheck(int index){
        if(word[index]=='H'){
            word[index]='X';
            cnt++;
            return true;
        }

            return false;

    }
}
//햄버거와 사람이 주어졌을 때,
//사람의 위치-K~사람의 위치+K까지의 햄버거를 먹을 수 잇는데, 가장 왼쪽에 있는 햄버거를 먹는것이 다음 사람을 위해 좋은 선택이다.