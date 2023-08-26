/*
 * import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Link implements Comparable<Link>
{
    int x,y;
    int loopy;
    public Link(int x, int y, int loopy) {
        this.x = x;
        this.y = y;
        this.loopy = loopy;
    }
    @Override
    public int compareTo(Link o){
        return loopy-o.loopy;
    }
}
public class Main {
    static int[][]map;
    static boolean[][] visit;
    static int[] dx={ -1,0,1,0};
    static int[] dy={0,1,0,-1};
    static int lost;
    public static void main(String[] args) throws Exception {
     BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
     StringTokenizer st;
        int input=Integer.parseInt(br.readLine());

        while(input!=0){
         map = new int[input][input];
         for(int i=0;i<input;i++) {
             st = new StringTokenizer(br.readLine());
             for (int j = 0; j < input; j++) {
                 map[i][j] = Integer.parseInt(st.nextToken());
             }
         }
         lost=bfs(0,0);
         System.out.println(lost);
         input=Integer.parseInt(br.readLine());
         if(input==0)
             break;
        }

    }
    static int bfs(int x,int y){
    Queue<Link> q= new LinkedList<>();
    q.offer(new Link(0,0,map[0][0]));
    int cx,cy;
    while(!q.isEmpty())
    {
        Link link=q.poll();
        if(link.x==map.length-1 &&link.y==map.length-1)
            return lost;

        for(int i=0;i<4;i++){
            cx= link.x+dx[i];
            cy= link.y+dy[i];

            if(cx<1 || cy <1 ||cx> map.length-1 || cy> map.length-1)
                continue;
            if (!visit[cx][cy] && map[cx][cy] == 1) {
                visit[cx][cy] = true;
                q.offer(new Link(cx, cy, link.loopy+map[cx][cy]));
            }
            lost=link.loopy;
        }

    }
        return lost;
    }
}

 */

 import java.util.*;
import java.io.*;

public class Main {
	static int dirX[] = {0, 0, -1, 1};
	static int dirY[] = {-1, 1, 0, 0};
	static boolean visit[][];
	static int map[][];
	static int size[][];

	private static final int INF = Integer.MAX_VALUE / 4;
	static int N, nowX, nowY;

	static class Node implements Comparable<Node> {
		int x;
		int y;
		int size;

		// (alt + shift + s) + o
		public Node(int x, int y, int size) {
			this.x = x;
			this.y = y;
			this.size = size;
		}

		@Override
		public int compareTo(Node o) {
			return size - o.size;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder(); 
		int count = 1;

		String temp = "";
		while( !(temp = br.readLine()).isEmpty()  ) {
			N = Integer.parseInt(temp);
			if(N == 0) {
				break;
			}

			map = new int[N][N];
			visit = new boolean[N][N];
			size = new int[N][N];

			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
		
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());	
					size[i][j] = INF;
				}
			}

			BFS(0, 0, map[0][0]);
			sb.append("Problem " + count + ": " + size[N-1][N-1]).append('\n');
			count++;
		}

		System.out.println(sb);

	} // End of main

	private static void BFS(int x, int y, int roopy) {
		PriorityQueue<Node> que = new PriorityQueue<>();
		visit[x][y] = true;
		que.offer(new Node(x, y, roopy));

		while( !que.isEmpty() ) {
	
			Node node = que.poll();

			for(int i=0; i<4; i++) {
				nowX = node.x + dirX[i];
				nowY = node.y + dirY[i];

				if( range_check() && !visit[nowX][nowY] && size[nowX][nowY] > (map[nowX][nowY] + node.size) ) {
					size[nowX][nowY] = map[nowX][nowY] + node.size;
					visit[nowX][nowY] = true;
					que.offer( new Node( nowX, nowY, size[nowX][nowY] ));
				}

			}
		}

	} // End of BFS

	private static boolean range_check() {
		return (nowX >= 0 && nowY >= 0 && nowX < N && nowY < N);
	} // End of range_check

} // End of main