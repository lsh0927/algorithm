/*
 * 실패+시간 초과 코드
 * import java.util.Scanner;
import java.util.*;
public class Main {
    static int call=0;
    static int call2=0;
    static int[][] DP;
    static int[][] M;
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        M=new int[N][N];
        DP=new int[N][N];
        for(int i=0;i<N;i++) {
            for (int j = 0; j < N; j++) {
                M[i][j]=in.nextInt();
            }
        }


        matrix_path(M,N);
        matrix_path2(M,N);
        System.out.println( call%1000000007);
        System.out.println( call2%1000000007);



    }

    static int matrix_path(int m[][],int n) {
        return matrix_path_rec(m,n-1,n-1);
    }
    static int matrix_path_rec(int m[][],int i ,int j){
        if(i==-1|| j==-1) {
            call++;
            return 0;
        }
        else
            return (m[i][j]+(Math.max(matrix_path_rec(m,i-1,j),matrix_path_rec(m,i,j-1))));
    }

    static int matrix_path2(int m[][], int n){
        for(int i=0;i<n;i++){
            call2++;
            DP[i][0]=0;
        }
        for(int j=1;j<n;j++){
            call2++;
            DP[0][j]=0;
        }
        for(int i=1;i<n;i++)
        {

            for(int j=1;j<n;j++){
                call2++;
                DP[i][j]=m[i][j]+Math.max(DP[i-1][j],DP[i][j-1]);
            }
        }
        return DP[n-1][n-1];
    }
}
 */