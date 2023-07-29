import javax.management.relation.Role;
import java.util.Arrays;
import java.util.*;

public class Main {
    static int [][]sp;
    static int x,y,k;
    static int N,M;
    static int []role;
    public static void main(String[] args) {
       Scanner sc= new Scanner(System.in);
       N=sc.nextInt();
       M=sc.nextInt();
       x=sc.nextInt();
       y=sc.nextInt();
       k=sc.nextInt();
       int []cmd=new int[k];

       sp= new int[N][M];
       for(int i=0;i<N;i++)
       {
           for (int j=0; j<M;j++)
           {
               sp[i][j]=sc.nextInt();
           }
       }
        sp[x][y]=0;
       for(int q=0;q<k;q++) {cmd[q]= sc.nextInt();}

       role=new int[]{0,0,0,0,0,0};
       int i=0;
       int cnt=k;
       while(cnt>0)
       {
           cnt--;
           i++;
           rolling(sp,cmd[i],role);
            //밑면 교체까지 성공, 이제 복사 해야함. 그리고 방향 바꿨을때 그게 반영되나? 될걸?
       }
    }
    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
    public static void rolling(int[][]arr, int cmd, int []role)
    {
        if(cmd==1)
        {
            x++;
            if(x>=M || y>=N || x<0 || y<0){
                x--;
                return;
            }
            swap(role,2,4);
            swap(role,0,2);
            swap(role,2,5);
            if(sp[x][y]!=0) {
                role[2] =sp[x][y];
                sp[x][y]=0;
            }
            System.out.println(role[0]);
            return;

        } else if (cmd==2) {
            x--;
            if(x>=M || y>=N || x<0 || y<0) {
                x++;
                return;
            }
            swap(role,0,5);
            swap(role,2,5);
            swap(role,2,4);
            if(sp[x][y]!=0) {
                role[2] =sp[x][y];
                sp[x][y]=0;
            }
            System.out.println(role[0]);;
            return ;
        }
        else if(cmd==3)
        {
            y++;
            if(x>=M || y>=N || x<0 || y<0) {
                y--;
                return;
            }
            int tmp=role[0];
            role[0]=role[1];
            role[1]=role[2];
            role[2]=role[3];
            role[3]=tmp;
            if(sp[x][y]!=0) {
                role[2] =sp[x][y];
                sp[x][y]=0;
            }
            System.out.println(role[0]);;
            return ;
        }
        else if(cmd==4){
            y--;
            if(x>=M || y>=N || x<0 || y<0) {
                y++;
                return;
            }
            int tmp=role[3];
            role[3]=role[2];
            role[2]=role[1];
            role[1]=role[0];
            role[0]=tmp;
            if(sp[x][y]!=0) {
                role[2] =sp[x][y];
                sp[x][y]=0;
            }
            for(int a=0;a<6;a++)
            {System.out.println("1"+role[a]);}
            return;

        }
    }
}   

/*import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	//  1
	// 234
	//  5
	//  6
	static int[] dice = new int[7];
	static int n,m,x,y;
	static int[][] map;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		
		int k = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<k; i++) {
			int d = Integer.parseInt(st.nextToken());
			move(d);
		}
		
	}
	
	static void move(int d) {
		int nx = x + dx[d-1];
		int ny = y + dy[d-1];
		if(nx <0 || ny < 0 || nx > m-1 || ny > n-1) return;
		roll(d, nx, ny);
		x = nx; y = ny;
		
	}

	// 1 2 3 4 (동 서 남 북)
	static void roll(int d, int x, int y) {
		int tmp = dice[3];
		switch(d) {
		case 1:
			dice[3] = dice[4];
			dice[4] = dice[6];
			dice[6] = dice[2];
			dice[2] = tmp;
			break;
		case 2:
			dice[3] = dice[2];
			dice[2] = dice[6];
			dice[6] = dice[4];
			dice[4] = tmp;
			break;
		case 3:
			dice[3] = dice[5];
			dice[5] = dice[6];
			dice[6] = dice[1];
			dice[1] = tmp;
			break;
		case 4:
			dice[3] = dice[1];
			dice[1] = dice[6];
			dice[6] = dice[5];
			dice[5] = tmp;
			break;
		}
		if(map[y][x] == 0) {
			map[y][x] = dice[6];
		} else {
			dice[6] = map[y][x];
			map[y][x] =0;
		}
		System.out.println(dice[3]);
		
	}
} */