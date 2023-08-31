import java.io.*;


public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        int dp[] = new int[n];
        int max = n;
        int max_idx = -1;
        int len = 1;
        for(int i=0;i<n;i++)
        {
            arr[i] = Integer.parseInt(br.readLine());
            if (arr[i] == n)
                max_idx = i;
        }
        for(int i = max_idx;i >=0;i--)
        {
            if(arr[i] == max-1)
            {
                max--;
                len++;
            }
        }
        bw.write(Integer.toString(n - len));
        bw.flush();
    }
}