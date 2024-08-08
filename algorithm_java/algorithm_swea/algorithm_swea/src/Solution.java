import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int[] list;
	static int cnt = 0;
	static int result = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int TC = 1; TC <= T; TC++) {
			StringTokenizer sz = new StringTokenizer(br.readLine());
			String num = sz.nextToken();
			
			//옮기는 횟수
			cnt = Integer.parseInt(sz.nextToken());
			
			//옮기는 횟수는 숫자판의 길이만큼이면 전부 옮길 수 있음
			if(cnt > num.length())
				cnt = num.length();
			
			list = new int[num.length()];

			for (int i = 0; i < num.length(); i++)
				list[i] = num.charAt(i) - '0';
			
			solve(0, 0);
			
			System.out.println("#" + TC + " " + result);
			
			init();
		}
		br.close();
	}
	
	public static void solve(int s, int e) {
		if (e == cnt) {
			result = Math.max(result, Integer.parseInt(Arrays.toString(list).replaceAll("[^0-9]", "")));
			return;
		}
		
		for (int i = s; i < list.length - 1; i++) {
			for (int j = i + 1; j < list.length; j++) {
				swap(i, j);
				solve(i, e + 1);
				swap(i, j);
			}
		}
	} 
	
	public static void swap(int a, int b) {
		int temp = list[a];
		list[a] = list[b];
		list[b] = temp;
	}
	
	public static void init() {
		list = null;
		result = 0;
		cnt = 0;
	}
}
