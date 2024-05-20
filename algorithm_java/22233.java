
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 22232 {


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int N= Integer.parseInt(st.nextToken());
        int M= Integer.parseInt(st.nextToken());


        Set<String> set= new HashSet<>();

        for(int i=0;i<N;i++){
            String s= br.readLine();
            set.add(s);
        }



        for(int i=0;i<M;i++){
            String[] arr= br.readLine().split(",");

            for(String s: arr){
                if (set.contains(s)){
                    set.remove(s);
                }
            }

            System.out.println(set.size());
        }



    }
}

