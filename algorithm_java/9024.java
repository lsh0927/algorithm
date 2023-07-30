import javax.management.relation.Role;
import java.util.Arrays;
import java.util.*;

public class Main {
    static int n,t;
    static int count=0;
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        int[]num=new int[1000001];
        for(int i=0;i<N;i++)
        {
            n= sc.nextInt();
            t=sc.nextInt();
            for(int j=0;j<n;j++)
            {
                num[j]= sc.nextInt();
            }
            find(num);
            System.out.println(count);
            count=0;
        }
    }
    public static void find(int [] num){ //겹치는 경우는 제외해야 함
        int sum;
        int min=t;

        for(int a=0;a<n-1;a++)
        {
            for(int b=a+1;b<n;b++)
            {
                sum=num[a]+num[b];
                int tmp=Math.abs(t-sum);
                if(tmp<min) {
                    min= tmp;
                    //System.out.println(min);
                }
            }
        }
        for(int c=0;c<n-1;c++)
        {
            for(int d=c+1;d<n;d++) {
                if(Math.abs(t-(num[c]+num[d]))==min)
                    count++;
            }
        }

    }
}   


/*
 * import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);
            int left = 0;
            int right = arr.length - 1;
            int best = (int)(2 * 10e8);
            int count = 1;

            while (true) {
                int sum = arr[left] + arr[right];

                if (Math.abs(sum - k) == best) {
                    count++;
                } else if (Math.abs(sum - k) < best) {
                    count = 1;
                    best = Math.abs(sum - k);
                }

                if (sum == k) {
                    left++;
                    right--;
                } else if (sum < k) {
                    left++;
                } else {
                    right--;
                }

                if (left >= right) {
                    break;
                }
            }

            System.out.println(count);
        }
    }
}
 */