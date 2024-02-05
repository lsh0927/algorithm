import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class 체스 {

    static int N, M;
    static char[][] map;

    static class Pos{
        int x; int y;
        public Pos(int x, int y) {
            this.x = x; this.y = y;
        }
    }

    static void checkQueen(int x, int y){

        int[] dx = {1, -1, 0, 0, 1, 1, -1, -1};
        int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};

        for(int i=0; i<8; i++){
            int next_x = x;
            int next_y = y;
            while(true) {
                next_x += dx[i];
                next_y += dy[i];

                if(next_x < 0 || next_x >= N || next_y < 0 || next_y >= M)
                    break;  // map 범위를 벗어나는 경우
                if(map[next_x][next_y] == 'K'
                        || map[next_x][next_y] == 'Q'
                        || map[next_x][next_y] == 'P' )
                    break;  // 말이 지나갈 수 없는 경우(K/P/Q)

                map[next_x][next_y] = 'o';
            }
        }
    }

    static void checkKnight(int x, int y){
        int[] dx = {2, 2, 1, 1, -1, -1, -2, -2};
        int[] dy = {1, -1, 2, -2, 2, -2, 1, -1};

        for(int i=0; i<8; i++){
            int next_x = x + dx[i];
            int next_y = y + dy[i];

            if(next_x >= 0 && next_x < N
                    && next_y >=0 && next_y < M){   // 배열 범위 내에 있으면서
                if(map[next_x][next_y] == '\u0000') // 빈칸일 경우
                    map[next_x][next_y] = 'o';
            }
        }
    }
    public static void main(String[] args) throws IOException{

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] input = in.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        map = new char[N][M];

        ArrayList<Pos> queen = new ArrayList<>();
        ArrayList<Pos> knight = new ArrayList<>();

        // input
        for(int i=0; i<3; i++){
            input = in.readLine().split(" ");
            int num = Integer.parseInt(input[0]);

            for(int j=1; j<=num; j++){
                //각 좌표 입력
                int x = Integer.parseInt(input[2*j-1]) - 1;
                int y = Integer.parseInt(input[2*j]) - 1;

                if(i==0){
                    queen.add(new Pos(x,y));
                    map[x][y] = 'Q';
                }else if(i==1){
                    knight.add(new Pos(x,y));
                    map[x][y] = 'K';
                }else{
                    map[x][y] = 'P';
                }
            }
        }

        // queen check
        for(int i=0; i<queen.size(); i++)
            checkQueen(queen.get(i).x, queen.get(i).y);

        // knight check
        for(int i=0; i<knight.size(); i++)
            checkKnight(knight.get(i).x, knight.get(i).y);

        int answer = 0;
        for(int i=0; i<N; i++)
            for(int j=0; j< M; j++)
                if(map[i][j] == '\u0000')
                    ++answer;
        //char의 초기값인 '\u0000'으로 확인

        System.out.println(answer);
    }
}