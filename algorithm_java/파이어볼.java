import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.StringTokenizer;

public class 파이어볼 {

    //파이어볼의 정보를 담을 클래스
    static class Ball {
        int r;
        int c;
        int m;
        int s;
        int d;

        public Ball(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }

    static ArrayList<Ball> balls;
    static ArrayList<Ball> map[][];
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int N, M, K;
    static boolean even,odd;
    //파이어 볼의 방향

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        balls = new ArrayList<>();


        map = new ArrayList[N + 1][N + 1];
        for (int i = 0; i < N+1; i++) {
            for (int j = 0; j < N+1; j++) {
                map[i][j] = new ArrayList<>();
            }
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            map[r][c].add(new Ball(r, c, m, s, d));
            balls.add(new Ball(r, c, m, s, d));

        }

        for (int k = 0; k < K; k++) {
            Clear();
            Command();
            MergeAndSpread();
            update();
        }


        int answer = 0;

        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N+1; j++) {
                if (map[i][j].size() > 0) {
                    for (Ball ball : map[i][j]) {
                        answer += ball.m;
                    }
                }
            }
        }
        System.out.println(answer);
    }

    public static void Clear() {
        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N+1; j++) {
                map[i][j].clear();
            }
        }
    }

    public static void Command() {

        for (int i = 0; i < balls.size(); i++) {

            //볼들이 이동할 위치 r,c
//            int nr=balls.get(i).r+dx[balls.get(i).d]* balls.get(i).s;
//            int nc=balls.get(i).c+dy[balls.get(i).d]* balls.get(i).s;

                balls.get(i).r = balls.get(i).r + dx[balls.get(i).d] * (balls.get(i).s) % N;
                balls.get(i).c = balls.get(i).c + dy[balls.get(i).d] * (balls.get(i).s) % N;


                if (balls.get(i).r > N) balls.get(i).r %= N;
                if (balls.get(i).r <= 0) balls.get(i).r = N - Math.abs(balls.get(i).r);
                if (balls.get(i).c > N) balls.get(i).c %= N;
                if (balls.get(i).c <= 0) balls.get(i).c = N - Math.abs(balls.get(i).c);


            //질량을 합치는 것도 필요함
            // map의 원소에 다른 원소들이 들어올때마다 합을 구하기는 너무 복잡함
            map[balls.get(i).r][balls.get(i).c].add(balls.get(i));
        }
        //m,s,d는 하나에 다 모였을때 구하는게 더 간단할듯
    }

    public static void MergeAndSpread() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j].size() > 1) {
//                    int[] ms = Merge(i, j);
//                    if (ms != null) {
//                        Spread(i, j, ms);
//                    }
                    Merge(i,j);
                }
            }
        }
    }
    public static void Merge(int r,int c) {
        int sumM = 0;
        int sumS = 0;
        int ballcnt = 0;
        even = true;
        odd = true;

        for (Ball ball : map[r][c]) {
            sumM += ball.m;
            sumS += ball.s;
            ballcnt++;

            if (ball.d % 2 == 0) {
                odd = false;
            } else even = false;
        }
        int totalM = sumM / 5;
        int totalS = sumS / ballcnt;

        map[r][c].clear(); //기존에 있던 볼들의 정보를 지움

        if (totalM <= 0)
            return;

        //두개를 다르게 하면 답이 달라짐...

        if (even || odd){  //모두 짝수 혹은 모두 홀수라면
            map[r][c].add(new Ball(r,c,totalM,totalS,0));
            map[r][c].add(new Ball(r,c,totalM,totalS,2));
            map[r][c].add(new Ball(r,c,totalM,totalS,4));
            map[r][c].add(new Ball(r,c,totalM,totalS,6));
        }
        else {
            map[r][c].add(new Ball(r,c,totalM,totalS,1));
            map[r][c].add(new Ball(r,c,totalM,totalS,3));
            map[r][c].add(new Ball(r,c,totalM,totalS,5));
            map[r][c].add(new Ball(r,c,totalM,totalS,7));
        }
    }
    public static void update(){
        balls.clear();
        for(int i=1; i<N+1; i++) {
            for(int j=1; j<N+1; j++) {
                if(map[i][j].size() > 0){
                    for(Ball ball : map[i][j]) {
                        balls.add(ball);
                    }
                }
            }
        }
    }
//    public static int[] Merge(int r,int c){
//        int sumM=0;
//        int sumS=0;
//        int ballcnt=0;
//         even=true;
//         odd=true;
//
//        for (Ball ball : map[r][c]) {
//            sumM+= ball.m;
//            sumS+= ball.s;
//            ballcnt++;
//
//            if (ball.d%2!=0){
//                even=false;
//            }
//            else odd=false;
//        }
//        int totalM=sumM/5;
//        int totalS=sumM/ballcnt;
//
//        if (totalM<=0)
//            return null;
//
//        return new int[]{totalM,totalS};
//
//
//    }
//    public static void Spread(int r, int c, int [] ms){
//        int totalM=ms[0];
//        int totalS=ms[1];
//
//
//        map[r][c]= new ArrayList<>();
//        if (even || odd){  //모두 짝수 혹은 모두 홀수라면
//            map[r][c].add(new Ball(r,c,totalM,totalS,0));
//            map[r][c].add(new Ball(r,c,totalM,totalS,2));
//            map[r][c].add(new Ball(r,c,totalM,totalS,4));
//            map[r][c].add(new Ball(r,c,totalM,totalS,6));
//        }
//        else {
//            map[r][c].add(new Ball(r,c,totalM,totalS,1));
//            map[r][c].add(new Ball(r,c,totalM,totalS,3));
//            map[r][c].add(new Ball(r,c,totalM,totalS,5));
//            map[r][c].add(new Ball(r,c,totalM,totalS,7));
//        }
//    }

}