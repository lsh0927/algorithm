import java.util.*;
import java.io.*;

class Main
{
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        String L= st.nextToken();
        String R= st.nextToken();

        char[] larr = L.toCharArray();
        char[] rarr = R.toCharArray();

        int cnt=0;

        if (larr.length!= rarr.length){
            System.out.println(cnt);
        }
        else {
            //맨 앞 자리수부터 비교할 인덱스 선언
            int idx=0;

            while (idx< rarr.length){
                if (larr[idx]=='8' && rarr[idx]=='8'){
                    cnt++;
                    idx++;
                }
                else if ( larr[idx] == rarr[idx]){
                    idx++;
                }
                else{
                    break;
                }
            }
            System.out.println(cnt);

        }


    }
}