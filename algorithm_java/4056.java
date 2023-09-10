// import javax.print.DocFlavor;
// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.*;
// import java.util.StringTokenizer;
// import java.util.PriorityQueue;
// import java.util.Stack;

// public class Main {
//     static int[][] map=new int[9][9];
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


//         for (int i = 0; i < 9; i++) {
//             StringTokenizer st = new StringTokenizer(br.readLine());
//             for(int j=0;j<9;j++)
//                 map[i][j] = Integer.parseInt(st.nextToken());
//         }

//         for (int i = 0; i < 9; i++) {
//             for(int j=0;j<9;j++)
//             {
//                 if(map[i][j]==0)
//                 {
//                     int s=devide(i,j);
//                     solve(i,j,s);
//                 }
//             }
//         }
//     }
//     private static int devide(int y,int x){
//         int sector;
//         if(x<4 && y<4){sector=1;}
//         else if(x<7 && y<4){sector=2;}
//         else if(y<4){sector=3;}

//         if(x>3 && y>3 && y<7){sector=4;}
//         else if(x<6 &&x>3 && y>3 && y<7){sector=5;}
//         else if(y>3 && y<7){sector=6;}

//         if(x<3 && y>6){sector=7;}
//         else if(x>3 && x<6 && y>6){sector=8;}
//         else {sector=9;}

//         return sector;
//     }
//     private static void solve(int y,int x, int s){
//         //0(빈칸)이 있는 곳과,그 위치(섹터 및 좌표)를 전달받아 스토쿠 해결
//         //가로, 세로, 섹터안의 조건을 충족하는지 판별
//         //어떤 숫자가 없는지 확인하고, 그 숫자를 찾아야 하는데,
//         //만약 숫자가 2개이상 비어있다면 일단 조건 중 하나를 만족하는 숫자대입
//         //그 숫자가 다른 조건들에 위배되면 그 숫자를 빼고 다른 숫자를 대입
//         //->백트래킹 문제
//     }
// }


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
	
	static int[][] map;
	static boolean[][]rowChk;
	static boolean[][]colChk;
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = pint(br.readLine());
		for (int testcase = 1; testcase <= tc; testcase++) {
			int N = 9;
			map = new int[N][N];
			boolean success=true;
			rowChk = new boolean[N][N+1];
			colChk = new boolean[N][N+1];
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j]=s.charAt(j)-'0';
					if(map[i][j]!=0) {
						if(!rowChk[i][map[i][j]])rowChk[i][map[i][j]]=true;
						else success=false;//row체크
						if(!colChk[j][map[i][j]])colChk[j][map[i][j]]=true;
						else success=false;//col체크
					}
				}
			}

			//block 체크
			for (int bx = 0; bx < 9; bx+=3) {
				for (int by = 0; by < 9; by+=3) {
					boolean[]blockChk=new boolean[N+1];
					for (int i = 0; i < 3; i++) {
						for (int j = 0; j < 3; j++) {
							if(map[bx+i][by+j]==0)continue; // 0일때는 넘어간다
							if(!blockChk[ map[bx+i][by+j] ])
								blockChk[ map[bx+i][by+j] ]=true;//0이 아닌 값을 처음 만나면 true
							else {
								success=false;//0이 아닌 값을 다시 만나면 실패한 스도쿠
							}
						}
					}
				}
			}
			
			//초기 입력값이 valid하다면
			if(success)success = rec(0);
			
			if(success) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						sb.append(map[i][j]);
					}sb.append('\n');
				}
			}
			else {
				sb.append("Could not complete this grid.\n");
			}sb.append('\n');
		}System.out.println(sb);
		
		
	}
	static boolean rec(int cur) {
		if(cur==81)return true;
		int x = cur/9;
		int y = cur%9;
		if(map[x][y]==0) {
			for (int i = 1; i <= 9; i++) {
				if(chk(x,y,(x/3)*3, (y/3)*3, i)) {
					rowChk[x][i]=true;
					colChk[y][i]=true;
					map[x][y]=i;
					
					if(rec(cur+1))return true;
					
					rowChk[x][i]=false;
					colChk[y][i]=false;
				}
			}
			map[x][y]=0;
		}
		else {
			//이미 뭔가 수가 있다
			return rec(cur+1);
		}
		return false;
	}
	
	static boolean chk(int row, int col, int x, int y, int val) {
		boolean ret=true;
		if(rowChk[row][val] || colChk[col][val])ret=false;
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				if(map[x+i][y+j]==val)ret=false;
		return ret;
	}
	
	static int pint(String s) {
		return Integer.parseInt(s);
	}
}