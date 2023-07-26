import java.util.*;


public class Main {

    static int N;
    static int M;
    static int x;
    static int y;
    static int d;

    static int count=0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       N=sc.nextInt();
       M=sc.nextInt();   //방의 크기

        x= sc.nextInt()-1;
        y=sc.nextInt()-1;  //청소기의 x,y좌표

         d= sc.nextInt(); //청소기의 방향 0 북 1 동 2 남 3 서
        int [][]state= new int[N][M];

        for(int i=0; i<M-1;i++){
            for(int j=0;j<N-1;j++){
                state[i][j]=sc.nextInt();
            }
        }
        state[x][y]=2;
        count++;
        while(checkZeroExists(state)){
            if(state[x][y]==0)
                clean(state,x,y);
            if(check(state,x,y)){
                if(d>0)
                    d=d-1;
                else
                    d=3;
                gocheck(state,x,y,d);
                continue;
            }
            else{
                if(bcheck(state,x,y,d)){ //뒤로 갈수 있으면
                    bg(state,x,y,d); //가고
                    //청소진행
                    continue;
                }
                else
                    break;
            }
        }
        System.out.println(count);

    }
    public static boolean checkZeroExists(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 0) {
                    return true; // 0이 하나라도 존재하면 true 반환
                }
            }
        }
        return false; // 0이 하나도 존재하지 않으면 false 반환
    }
    public static boolean check(int[][]arr, int x, int y)
    {
        if(arr[x+1][y]==0 || arr[x-1][y] ==0 || arr[x][y+1]==0 || arr[x][y-1]==0)
            return true;
        else
            return false;
    }
    public static int[][] gocheck(int [][]arr, int x, int y,int d)
    {
        if(d==0) {
            if (arr[x][y + 1] == 0) {
                y++;

                return arr;
            }
            return arr;
        }
        else if(d==1) {
            if (arr[x + 1][y] == 0) {
                x++;

                return arr;
            }
            return arr;
        }
        else if (d==2) {
            if(arr[x][y-1]==0){
                y--;

                return arr;
            }
            return arr;
        }
        else if (d==3) {
            if(arr[x-1][y]==0)
            {
                x--;

                return arr;
            }
            return arr;
        }
        return arr;
    }
    public static int[][] clean( int arr[][],int x,int y) {
        arr[x][y]=2;
        count++;
        return arr;
    }
    public static boolean bcheck(int arr[][], int x, int y, int d){
        if(d==0) {
            if (arr[x][y - 1] != 1) {
               return true;
            }
            else
                return false;
        }
        else if(d==1){
            if(arr[x-1][y]!=1)
                return true;
            else
                return false;
        }
        else if(d==2){
            if(arr[x][y+1]!=1)
                return true;
            else
                return false;
        }
        else {
            if (arr[x + 1][y] != 1)
                return true;
            else
                return false;
        }
    }
    public static void bg(int arr[][], int x, int y, int d){
        if(d==0)
            y--;
        else if (d==1) {
            x--;
        } else if (d==2) {
            y++;
        }
        else x++;
    }
}


/*
 * import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;
public class Main {
    // BOJ / 14503번 / 로봇청소기 / 그래프 / 골5

    static int y,x,count;
    static int map[][];
    static int dy[] = {-1,0,1,0};  // 북동남서
    static int dx[] = {0,1,0,-1};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        y = Integer.parseInt(stk.nextToken());
        x = Integer.parseInt(stk.nextToken());
        map = new int[y][x];

        stk = new StringTokenizer(br.readLine(), " ");
        int r = Integer.parseInt(stk.nextToken());
        int c = Integer.parseInt(stk.nextToken());
        int d = Integer.parseInt(stk.nextToken()); // 방향 0북 , 1동, 2남, 3서
        count = 1;

        for(int i=0; i<y; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<x; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        dfs(r,c,d);
        System.out.println(count);
    }

    public static void dfs(int r, int c, int direction) {

        //현재 위치를 청소한다.
        map[r][c] = -1;

        //현재 위치에서 현재 방향을 기준으로 왼쪽방향부터 차례대로 탐색을 진행한다.
        for(int i=0; i<4; i++) {
            direction = (direction + 3) % 4; // 왼쪽 방향으로 변환 (북 -> 서 -> 남 -> 동)
            int ny = r + dy[direction];
            int nx = c + dx[direction];

            // 청소가 안된 곳이 있으면 count++,  dfs
            if(ny >=0 && ny < y && nx >= 0 && nx < x && map[ny][nx] == 0) {
                count++;
                dfs(ny,nx, direction);

                //여기서 return을 안하면 복귀하는 도중 뒤로가서 다른 곳을 청소할수가 있음.
                return;
            }
        }

        //네 방향 모두 청소가 이미 되어있거나 벽인 경우에는
        //뒤쪽 칸이 벽이 아니라는 전제 하에, 바라보는 방향을 유지한 채로 한 칸 후진.
        int back = (direction + 2) % 4;
        int by = r + dy[back];
        int bx = c + dx[back];

        if(by>=0 && by<y && bx>=0 && bx<x && map[by][bx] != 1) {
            dfs(by,bx,direction);
        }
    }
}
 */


 /*젤 맘에 드는 풀이
  * import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;
public class Main {
    static int n,m,r,c,d;
    static int [][] board;
    static int count= 1; //시작 시점은 바로 청소하므로
    static int [] dx={-1,0,1,0}; //북동남서 순, index가 되어 x좌표의 증감이 된다.
    static int [] dy={0,1,0,-1}; //북동남서 순

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n= sc.nextInt();
        m= sc.nextInt();
        r= sc.nextInt();
        c=sc.nextInt();
        d=sc.nextInt();

        board=new int[n][m];
        for(int i=0; i<n;i++){
            for(int j=0; j<m;j++){
                board[i][j]=sc.nextInt();
            }
        }

        dfs(r,c,d); //x,y,direction
        System.out.println(count);
    }
    public static void dfs(int x, int y, int dir){
        board[x][y]=2;

        for(int i=0; i<4;i++){
            dir-=1;
            if(dir==-1) dir=3;

            int nx=x+dx[dir];
            int ny=y+dy[dir];
            if(nx>=0 && ny>=0 &&nx<n &&ny<m){
                if(board[nx][ny]==0) //벽도 아니고 청소한 곳도 아니라면? 청소하러 이동
                { 
                    count++;
                    dfs(nx,ny,dir);
                //일반적인 dfs는 가다가 길이 막히면 다시 되돌아와서 해당 위치부터 계산
                //이 문제는 후진할 때만 길을 되돌아 가며 확인 할 수 있으므로
                //리턴을해서 다시 되돌아와도 더이상 움직이면 안됨
                return;
                }
            }
        }

        //반복문을 빠져나왔다? 주변에 청소할게 없다
        int d=(dir+2)%4;
        int bx=x+dx[d]; //후진
        int by=y+dy[d]; //후진
        if(bx>=0 &&  by>=0 &&bx<n&&by<m &&board[bx][by]!=1){
            dfs(bx,by,dir);
        }
    }
}
  */