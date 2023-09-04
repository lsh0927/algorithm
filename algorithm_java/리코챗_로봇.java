// import java.io.BufferedReader;
// import java.io.BufferedWriter;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.io.OutputStreamWriter;
// import java.util.PriorityQueue;
// import java.util.StringTokenizer;

// public class Main {

//     public static void main(String[] args) throws IOException {
//         class Solution {
//             static int nowx,nowy,endX,endY;
//             static int len;
//             static int[][]map;
//             public class Node implements Comparable<Node>{
//                 int x,y,cnt;
//                 public Node(int x, int y) {
//                     this.x = x;
//                     this.y = y;
//                 }
//                 public int compareTo(Node o){
//                     return this.cnt-o.cnt;
//                 }
//             }
//             public int solution(String[] board) {
//                 len = board.length;
//                 for(int i=0;i<len;i++){
//                     for (int j=0;j<len;j++){
//                         if(i==0 || i==len-1 || j==0 ||j==len-1)
//                         {
//                             map[i][j]=1;
//                         }
//                         else {
//                             map[i][j] = 0;
//                         }
//                         if('R' == board[i].charAt(j)){
//                             nowx=i;
//                             nowy=j;
//                         }
//                         if('G' == board[i].charAt(j)){
//                             endX=i;
//                             endY=j;
//                         }
//                         if('D' == board[i].charAt(j)){
//                             map[i][j]=1;
//                         }
//                     }
//                 }
//                 bfs(nowx,nowy);
//                 return len;
//             }
//             private void bfs(int nowx, int nowy) {
//                 int[] dir={1,1,1,1};

//                 if(nowx==0) {dir[0]=0;}
//                 if(nowx==len) {dir[2]=0;}
//                 if(nowy==0){dir[1]=0;}
//                 if (nowy==len){dir[3]=0;}

//                 //중복 조건 검사? ㄴㄴ
//                 //종료 조건: 목적지에 다다랐을때?
//                 //뭔짓을해도 도달하지 못할때

//                 if( (map[endX][endY-1]==1 && map[endX-1][endY+1]==1 ||map[endX+1][endY+1]==1) ||
//                         (map[endX][endY+1]==1 && map[endX-1][endY-1]==1 ||map[endX+1][endY-1]==1)||
//                         (map[endX+1][endY]==1 && map[endX-1][endY+1]==1 ||map[endX-1][endY-1]==1) ||
//                         (map[endX-1][endY]==1 && map[endX+1][endY+1]==1 ||map[endX+1][endY-1]==1) ){

//                 }



//             }


//         }

//     }
// }

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.*;

 class Solution {
            static char[][]map;
            static Node start=null;
            static int answer=0;
            static int N,M;


            public  int solution(String[] board) {
                N= board.length;
                M=board[0].length();
                map= new char[N][M];

                for(int i=0;i<N;i++){
                    for(int j=0;j<M;j++){
                        map[i][j]=board[i].charAt(j);
                        if(map[i][j]=='R'){
                            start= new Node(i,j,0);
                        }
                    }
                }
                bfs();
                return answer==0 ? -1: answer;
            }

            public void bfs(){
                boolean[][]visited= new boolean[N][M];
                Queue<Node> q= new LinkedList<>();
                q.add(start);
                visited[start.i][start.j]=true;

                while (!q.isEmpty()){
                    Node cur= q.poll();
                    if(map[cur.i][cur.j]=='G'){
                        answer=cur.w;
                        break;
                    }
                    int x= cur.i;
                    int y= cur.j;

                    //좌
                    while (map[x][y]!='D'){
                        x--;
                        if(x<0){
                            x=0;
                            break;
                        }
                        if(map[x][y]=='D'){
                            x++;
                            break;
                        }

                    }
                    //sliding이 끝나고 다시 방향을 결정(노드 생성)
                    if(!visited[x][y]){
                        visited[x][y]=true;
                        q.add(new Node(x,y,cur.w+1));
                    }
                    x= cur.i;

                    // 우
                    while (map[x][y] != 'D') {
                        x++;
                        if (x == N) {
                            x = N - 1;
                            break;
                        }
                        if (map[x][y] == 'D') {
                            x--;
                            break;
                        }
                    }
                    if (!visited[x][y]) {
                        visited[x][y] = true;
                        q.add(new Node(x, y, cur.w + 1));
                    }
                    x = cur.i;

                    // 하
                    while (map[x][y] != 'D') {
                        y--;
                        if (y < 0) {
                            y = 0;
                            break;
                        }
                        if (map[x][y] == 'D') {
                            y++;
                            break;
                        }
                    }
                    if (!visited[x][y]) {
                        visited[x][y] = true;
                        q.add(new Node(x, y, cur.w + 1));
                    }
                    y = cur.j;
                    // 싱
                    while (true) {
                        y++;
                        if (y == M) {
                            y = M - 1;
                            break;
                        }
                        if (map[x][y] == 'D') {
                            y--;
                            break;
                        }
                    }
                    if (!visited[x][y]) {
                        visited[x][y] = true;
                        q.add(new Node(x, y, cur.w + 1));
                    }


                }
            }

            public class Node{
                int i,j,w;

                public Node(int i, int j, int w) {
                    this.i = i;
                    this.j = j;
                    this.w = w;
                }
            }
        }




public class Main {

    public static void main(String[] args) throws IOException {
        
class Solution {
    static int n, m, sx, sy, ex, ey;
    static char[][] map;
    static boolean[][] visit;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static int bfs(){
        Queue<int[]> q = new LinkedList<int[]>();
        visit[sx][sy] = true;
        q.add(new int[]{sx, sy, 0});

        while(!q.isEmpty()){
            int[] point = q.poll();

            int x = point[0];
            int y = point[1];
            int dist = point[2];

            if(x==ex && y==ey) return dist;

            for(int i=0;i<4;i++){
                int nextX = x;
                int nextY = y;

                for(int k=1;k<=Math.max(n, m);k++){
                    nextX+=dx[i];
                    nextY+=dy[i];

                    if(nextX<0 || nextX>=n || nextY<0 || nextY>=m || map[nextX][nextY] =='D') {
                        nextX-=dx[i];
                        nextY-=dy[i];
                        break;
                    }
                }

                if(visit[nextX][nextY]) continue;

                visit[nextX][nextY] = true;
                q.add(new int[]{nextX, nextY, dist+1});
            }
        }

        return -1;
    }

    public int solution(String[] board) {
        n = board.length;
        m = board[0].length();

        map = new char[n][m];
        visit = new boolean[n][m];

        for(int i=0;i<n;i++) {
            map[i] = board[i].toCharArray();
            for(int j=0;j<m;j++) {
                if(map[i][j] == 'R'){
                    sx = i;
                    sy = j;
                }
                else if(map[i][j] == 'G'){
                    ex = i;
                    ey = j;
                }
            }    
        }

        return bfs();
    }
}

    }
}