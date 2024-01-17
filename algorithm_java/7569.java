import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
    int h;
    int r;
    int c;

    public Node(int height, int row, int col){
        this.h = height;
        this.r = row;
        this.c = col;
    }
}

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int r[] = {-1, 0, 1, 0, 0, 0};
    static int c[] = {0, 1, 0, -1, 0, 0};
    static int z[] = {0, 0, 0, 0, 1, -1};
    static int m, n, h;
    static int arr[][][];
    static Queue<Node> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        arr = new int[h + 1][n + 1][m + 1];

        for(int i = 1; i <= h; i++){
            for(int j = 1; j <= n; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 1; k <= m; k++){
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                    if(arr[i][j][k] == 1) q.add(new Node(i, j, k));
                }
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        while (!q.isEmpty()){
            Node point = q.poll();

            int height = point.h;
            int row = point.r;
            int col = point.c;

            for(int i = 0 ; i < 6; i++){
                int moveHeight = height + z[i];
                int moveRow = row + r[i];
                int moveCol = col + c[i];
                if(checkPoint(moveHeight, moveRow, moveCol)){
                    q.add(new Node(moveHeight, moveRow, moveCol));
                    arr[moveHeight][moveRow][moveCol] = arr[height][row][col] + 1;
                }
            }
        }
        int result = Integer.MIN_VALUE;

        for(int i = 1; i <= h; i++){
            for(int j = 1; j <= n; j++){
                for(int k = 1; k <= m; k++){
                    if(arr[i][j][k] == 0) return -1;
                    result = Math.max(result, arr[i][j][k]);
                }
            }
        }
        if(result == 1) return 0;
        else return (result - 1);
    }

    private static boolean checkPoint(int height, int row, int col){
        if(height < 1 || height > h || row < 1 || row > n || col < 1 || col > m) return false;
        if(arr[height][row][col] == 0) return true;
        else return false;
    }
}