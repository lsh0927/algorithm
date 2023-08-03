//투포인터랑 이진탐색 둘다 쓰려다가 망함

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {
    static int start,end;
    static Long min=2000000001L;
    static int []rec={0,0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

            start= arr.length/2;
            end= arr.length/2+1;

        while(start!=0 || end!=arr.length-1){
            int mid1=(start+1)/2;
            int mid2=(end+ arr.length+1)/2;
            if(sum(arr,start,end)==0)
            {
                System.out.println(arr[start]+" "+arr[end]);
                return;
            }
            else if(sum(arr,start,end)<0){
                //0이하 ->값을 올려야합
                if(Math.abs(min)<=Math.abs(sum(arr,start,end)))  {
                    System.out.println(rec[0] + " " + rec[1]);
                    return;
                }
                end=mid2;
            }
            else {
                //0이상 -> 값을 내려야함
                if(Math.abs(min)<=Math.abs(sum(arr,start,end))) {
                    System.out.println(rec[0] + " " + rec[1]);
                    return;
                }
                start=mid1;
            }

        }
        System.out.println(rec[0]+" "+rec[1]);


        }

    private static long sum(int[] arr, int start, int end) {
        long result = arr[start] + arr[end];
        if(Math.abs(min)>Math.abs(result))
        {
            min=result;
            rec[0]=arr[start];
            rec[1]=arr[end];
        }

        return result;
    }
}

//투포인터
/*
 * import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		long[] arr = new long[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		int left =0;
		int right =n-1;
		int ml =0, mr = 0;
		long min = Long.MAX_VALUE;
		while(left<right) {
			long sum = arr[left]+arr[right];
			if(min > Math.abs(sum)) {
				min = Math.abs(sum);
				ml = left; mr = right;
			}
			if(sum>=0) {
				right--;	
			}else {
				left++;
			}
		}
		System.out.println(arr[ml] +" "+arr[mr]);
	}
}
 */


//이진 탐색
 
 /*
  * import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static long[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		arr = new long[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		long min = Long.MAX_VALUE;
		int ml =0, mr = 0;
		for(int i=0; i<n-1; i++) {
			int left =i+1;
			int right =n-1;
			while(left<=right) {
				int mid = (left+right)/2;
				long sum = Math.abs(arr[i]+arr[mid]);
				
				if(min > sum) {
					min = sum;
					ml = i; mr = mid;
				}
				if(arr[mid]>= -arr[i]) {
					right = mid-1;
				}else{
					left = mid+1;
				}
			}
		}
		System.out.println(arr[ml]+" "+arr[mr]);
	}
}
  */

//위의 코드 다 틀렸다. 

  /*import java.io.*;
import java.util.Arrays;

public class Main {

	static int N;
	static long[] arr;
	static long min = Long.MAX_VALUE;
	static int a, b;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		arr = new long[N];

		String[] sarr = br.readLine().split(" ");
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(sarr[i]);

		Arrays.sort(arr);

		for (int i = 0; i < N - 1; i++) {

			int idx = binSearch((int) (-arr[i]), i + 1, N - 1);
			long sum = Math.abs(arr[i] + arr[idx]);

			if (min > sum) {
				a = (int) arr[i];
				b = (int) arr[idx];
				min = sum;
			}
		}

		bw.write(a + " " + b + "\n");
		bw.flush();

	}

	public static int binSearch(int n, int left, int right) {

		int pl = left;
		int pr = right;

		do {

			int pc = (pl + pr) / 2;

			if (arr[pc] == n)
				return pc;

			if (arr[pc] < n)
				pl = pc + 1;
			else
				pr = pc - 1;

		} while (pl <= pr);

		
		if (pl > right)
			return pr;
		if (pr < left)
			return pl;

		if (Math.abs(n - arr[pl]) < Math.abs(n - arr[pr]))
			return pl;
		else
			return pr;
	}
} */