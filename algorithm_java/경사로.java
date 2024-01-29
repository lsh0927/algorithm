import java.io.*;
import java.util.*;

class Main {

    static int n,l;
    static int[][] map;
    public static void main(String args[]) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int L=Integer.parseInt(st.nextToken());

        n=N;
        l=L;
        int ans=0;

         map= new int[N][N];

        for (int i=0;i<N;i++){
            st= new StringTokenizer(br.readLine());
            for (int j=0;j<N;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++) {
            if(CheckRow(i)) ans++; //i번째 열 확인
            if(CheckCol(i)) ans++; //i번째 행 확인
        }

        System.out.println(ans);

    }
    public static boolean CheckRow(int row){

        boolean[] isVisited= new boolean[n];

        for (int i=0;i<n-1;i++)
        {
            int diff=map[row][i]- map[row][i+1];

            if (diff >1 || diff<-1) return false; //높이차 고려 (1이하만 가능)
            else if (diff==-1) {//다음 계단이 더 높은 경우
                for (int j=0;j<l;j++){ //경사로 설치 조건 따지기
                    if (i-j<0|| isVisited[i-j]) return false;
                    //경사로는 중복 될 수 없고, 연속하지 않는다..?
                    if (map[row][i] != map[row][i-j]) return false;
                    //경사로를 까는 낮은 계단의 높이는 동일해야함
                    isVisited[i-j]=true;
                }
            }
            else if (diff==1){ // 다음 계단이 더 낮은 경우
                for (int j=1; j<=l;j++){
                    if (i+j >= n || isVisited[i+j]) return false;
                    if (map[row][i]-1 != map[row][i+j]) return false;
                    isVisited[i+j]=true;
                }
            }
        }
        return true;
    }
    public static boolean CheckCol(int col){
        boolean[] isVisited= new boolean[n];

        for (int i=0;i<n-1;i++){
            int diff= map[i][col]-map[i+1][col]; //위치만 변경, 나머지는 그대로

            if (diff>1 || diff <-1) return false;
            else if(diff == -1) {
                for (int j=0;j<l;j++){
                    if (i-j<0 ||isVisited[i-j]) return false;
                    if (map[i][col]!=map[i-j][col]) return false;
                    isVisited[i-j]=true;
                }

            } else if (diff ==1) {

                for (int j=1;j<=l;j++){
                    if (i+j>=n || isVisited[i+j]) return false;
                    if (map[i][col]-1 != map[i+j][col]) return false;
                    isVisited[i+j]=true;
                }
            }
        }
        return true;
    }
}