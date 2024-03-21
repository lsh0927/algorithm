import java.util.*;
import java.io.*;
class 12904 {

    static List<String> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S= br.readLine();
        String T= br.readLine();
        list= new ArrayList<>();

        dfs(S,T);

        if (list.contains(T))
            System.out.println(1);
        else System.out.println(0);
    }
    public static void dfs(String S, String T){
        if (S.length()==T.length()){
            list.add(S);
            return;
        }
        String s1= S+"A";

        char arr[]= S.toCharArray();
        String s2="";
        for (int i= arr.length-1;i>=0;i--){
            s2+=arr[i];
        }
        s2+="B";
                //문자열을 거꾸로 뒤집는 방법
        dfs(s1,T);
        dfs(s2,T);

    }
}