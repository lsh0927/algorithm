import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(br.readLine());

        String s= sb.toString();
        Stack<Character> stack= new Stack<>();
        int cnt=0;
        int cut=0;
        for(int i=0; i<s.length();i++){
            
            if (s.charAt(i)=='(') {
                stack.push(s.charAt(i));
                cnt++;
            }
            else if (s.charAt(i)==')') {
                    if(s.charAt(i-1)=='(')
                    {   
                        cnt--;
                        cut+=cnt;
                        stack.pop();
                    }
                    else{
                        cut++;
                        cnt--;
                        stack.pop();
                    }
            }
        }
        System.out.println(cut);
    }
}
